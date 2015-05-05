package structure;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Wall {

	public Room room;
	public BlockFace direction;
	public ArrayList<Block> doorBlocks;
	
	public Wall(Room room, BlockFace wallDirection) {
		this.room = room;
		this.direction = wallDirection;
	}
	
	public void createDoor(Material doorMaterial, Material floorMaterial, int offSet)
	{
		switch (this.direction) {
		
		case NORTH:
			room.corner.getRelative(offSet, 0, 0).setType(floorMaterial);
			room.corner.getRelative(offSet, 1, 0).setType(doorMaterial);
			room.corner.getRelative(offSet, 2, 0).setType(doorMaterial);
			break;
			
		case EAST:
	
			break;
			
		case SOUTH:

			break;	
		
		case WEST:
		
			break;
			
		default:
			break;
		}
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
