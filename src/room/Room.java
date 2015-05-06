package room;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import styles.Style;
import utils.MatStateUtils.MatType;

public class Room {
	public Style style;
	BlockFace roofDir;
	
	public int width, height, depth;
	public Block corner;
	public Wall wallNorth, wallEast, wallSouth, wallWest;
	public Room(Block cornerBlock, int w, int h, int d) { 
			width = w; height = h; depth = d; corner = cornerBlock; 
			
			
			wallNorth = new Wall(this, BlockFace.NORTH);
			wallEast = new Wall(this, BlockFace.EAST);
			wallSouth = new Wall(this, BlockFace.SOUTH);
			wallWest = new Wall(this, BlockFace.WEST);
		
			roofDir = BlockFace.NORTH; // TODO change!
		}
	public Room(int w, int h, int d) { width = w; height = h; depth = d; }
	
	public void clear() {
		for (int x = 0; x < width; x++)
			for (int y = 0 ; y < height; y++)
				for (int z = 0; z < depth; z++)
					corner.getRelative(x, y, z).setType(Material.AIR);
	}
	
	public void clear_inside() {
		for (int x = 1; x < width - 1; x++)
			for (int y = 1; y < height - 1; y++)
				for (int z = 1; z < depth - 1; z++)
					corner.getRelative(x, y, z).setType(Material.AIR);
	}
	
	public void setWallCornersMat(Material mat) {

		for (int y = 0; y < this.height; y++)
			this.corner.getRelative(0, y, 0).setType(mat);	
		
		for (int y = 0; y < this.height; y++)
			this.corner.getRelative(this.width -1, y, 0).setType(mat);
		
		for (int y = 0; y < this.height; y++)
			this.corner.getRelative(0, y, this.depth -1).setType(mat);
		
		for (int y = 0; y < this.height; y++)
			this.corner.getRelative(this.width -1, y, this.depth -1).setType(mat);
		
	}
	
	public void make()
	{
		clear_inside(); 
		
		switch (style.floorStyle.floorFillType) 
		{
		case CheckerBoard:
			Floor.setFloorCheckerBoard(this, style.floorStyle.mat, style.floorStyle.mat2);
		case Normal:
			Floor.setFloorMat(this, style.floorStyle.mat);
		}
		
		if (roofDir != BlockFace.DOWN)
		{
			Roof.makeRoof(this, roofDir, MatType.Birch);
			
			switch (style.roofStyle.roofType) {
			case HouseStyle:
				Roof.makeRoofSide(this, roofDir, style.wallStyle.basicMat, true);
				Roof.makeRoofWindow(this, roofDir, style.wallStyle.windowMat);
				Roof.makeRoofSide(this, roofDir.getOppositeFace(), style.wallStyle.basicMat, true);
				Roof.makeRoofWindow(this, roofDir.getOppositeFace(), style.wallStyle.windowMat);
				break;
			case Kantelen:
				Roof.setRoofMat(this, style.floorStyle.mat); // TODO separatew flat roof mat in style!
				Roof.kantelen(this, style.wallStyle.basicMat);
				break;
			}
		}
		
		wallNorth.setWallMat(Material.SMOOTH_BRICK);
		wallEast.setWallMat(Material.SMOOTH_BRICK);
		wallSouth.setWallMat(Material.SMOOTH_BRICK);
		wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		setWallCornersMat(style.wallStyle.cornerBlocks.mat); // TODO: make function accept MatState instead of Material
		
	}
	
}
