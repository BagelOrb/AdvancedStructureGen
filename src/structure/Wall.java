package structure;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Wall {

	public Room room;
	public BlockFace direction;
	public ArrayList<Block> doorBlocks = new ArrayList<Block>();
	
	public Wall(Room room, BlockFace wallDirection) {
		this.room = room;
		this.direction = wallDirection;
	}
	
	@SuppressWarnings("deprecation")
	public void createDoor(Material doorMaterial, Material floorMaterial, int offSet, boolean hingeRight)
	{
		Block doorTop = null;
		Block doorBottom = null;
		offSet = offSet + 1;
		
		switch (this.direction) {
		
		case NORTH:
			room.corner.getRelative(offSet, 0, 0).setType(floorMaterial);
			doorBottom = room.corner.getRelative(offSet, 1, 0);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 1);
			doorTop = room.corner.getRelative(offSet, 2, 0);
			break;
			
		case EAST:
			room.corner.getRelative(room.width -1, 0, offSet).setType(floorMaterial);
			doorBottom = room.corner.getRelative(room.width -1, 1, offSet);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 2);
			doorTop = room.corner.getRelative(room.width -1, 2, offSet);	
			break;
			
		case SOUTH:
			room.corner.getRelative(offSet, 0, room.depth -1).setType(floorMaterial);
			doorBottom = room.corner.getRelative(offSet, 1, room.depth -1);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 3);
			doorTop = room.corner.getRelative(offSet, 2, room.depth -1);
			break;	
		
		case WEST:
			room.corner.getRelative(0, 0, offSet).setType(floorMaterial);
			doorBottom = room.corner.getRelative(0, 1, offSet);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 0);
			doorTop = room.corner.getRelative(0, 2, offSet);	
			break;
			
		default:
			break;
		}
		
		doorTop.setType(doorMaterial);
		if(hingeRight)
			doorTop.setData((byte) 9);		
		else
			doorTop.setData((byte) 8);
		
		this.doorBlocks.add(doorBottom);
		
	}
	
	public void setWallMat(Material mat) {
		switch (this.direction) {
		
		case NORTH:
			for (int x = 1 ; x < room.width -1; x++)
				for (int y = 0; y < room.height; y++)
					room.corner.getRelative(x, y, 0).setType(mat);
			break;
			
		case EAST:
			for (int z = 1 ; z < room.depth -1; z++)
				for (int y = 0; y < room.height; y++)
					room.corner.getRelative(room.width -1, y, z).setType(mat);			
			break;
			
		case SOUTH:
			for (int x = 1 ; x < room.width -1; x++)
				for (int y = 0; y < room.height; y++)
					room.corner.getRelative(x, y, room.depth -1).setType(mat);
			break;	
		
		case WEST:
			for (int z = 1 ; z < room.depth -1; z++)
				for (int y = 0; y < room.height; y++)
					room.corner.getRelative(0, y, z).setType(mat);			
			break;
			
		default:
			break;
		}
		
	}

}
