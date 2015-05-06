package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Room {
	public int width, height, depth;
	public Block corner;
	public Wall wallNorth, wallEast, wallSouth, wallWest;
	public Room(Block cornerBlock, int w, int h, int d) { 
			width = w; height = h; depth = d; corner = cornerBlock; 
			
			clear_inside(); 
			
			wallNorth = new Wall(this, BlockFace.NORTH);
			wallEast = new Wall(this, BlockFace.EAST);
			wallSouth = new Wall(this, BlockFace.SOUTH);
			wallWest = new Wall(this, BlockFace.WEST);
		
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
	
}
