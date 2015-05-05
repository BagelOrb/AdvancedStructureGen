package structure;

import org.bukkit.Material;

public class Floor {

	public static void setFloorMat(Room room, Material mat) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				room.corner.getRelative(x, 0, z).setType(mat);
		
	}

	public static void setFloorCheckerBoard(Room room, Material mat1, Material mat2) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				room.corner.getRelative(x, 0, z).setType(((x+z) % 2 == 1)? mat1 : mat2);
		
	}
}
