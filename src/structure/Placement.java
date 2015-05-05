package structure;

import org.bukkit.block.Block;

public class Placement {

	
	public static int getStructureLift(Room room)
	{
		for (int lift = 0; lift < 10; lift++)
		{
			if (isFree(room.corner.getRelative(0, lift, 0), room.width, room.height, room.depth)) return lift;
		
		}
		
		return -1;
	}
	
	static boolean isFree(Block cornerLocation, int width, int height, int depth)
	{
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				for (int z = 0; z < depth; z++)
					if (cornerLocation.getRelative(x, y, z).getType().isSolid()) return false;
		return true;
		
	}
}
