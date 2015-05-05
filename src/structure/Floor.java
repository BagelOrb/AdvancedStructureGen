package structure;

import org.bukkit.Material;

public class Floor {

	public static void setFloor(Room room, Material mat) {
		for (int x = 0 ; x < room.width; x++)
			for (int z = 0; z < room.depth; z++)
				room.corner.getRelative(x, 0, z).setType(mat);
		
	}
}
