package room;

import utils.MatState;

public class Floor {

	public static void setFloorMat(Room room, MatState mat) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				mat.setBlock(room.corner.getRelative(x, 0, z));
		
	}

	public static void setFloorCheckerBoard(Room room, MatState mat1, MatState mat2) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				if ((x+z) % 2 == 1)
					mat1.setBlock(room.corner.getRelative(x, 0, z));
				else 
					mat2.setBlock(room.corner.getRelative(x, 0, z));
		
	}
}
