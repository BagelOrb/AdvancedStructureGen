package structure;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

public class Wall {

	public static void setWallMat(Room room, BlockFace direction, Material mat) {
		switch (direction) {
		
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
	
	public static void setWallCornersMat(Room room, Material mat) {

		for (int y = 0; y < room.height; y++)
			room.corner.getRelative(0, y, 0).setType(mat);	
		
		for (int y = 0; y < room.height; y++)
			room.corner.getRelative(room.width -1, y, 0).setType(mat);
		
		for (int y = 0; y < room.height; y++)
			room.corner.getRelative(0, y, room.depth -1).setType(mat);
		
		for (int y = 0; y < room.height; y++)
			room.corner.getRelative(room.width -1, y, room.depth -1).setType(mat);
		
	}
}
