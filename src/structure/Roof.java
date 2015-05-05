package structure;

import main.Debug;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import utils.BlockUtils;

public class Roof {

	public static void makeRoof(Room room, BlockFace direction)
	{
//		ns = z
//		ew = x
		switch (direction)
		{
		case NORTH:
		case SOUTH:
			for (int z = 1; z < room.depth; z++)
			{
				for (int xy = 0; xy < room.width/2; xy++)
				{
					room.corner.getRelative(xy, room.height+xy, z).setType(Material.WOOD_STAIRS);
					BlockUtils.setStairsData(room.corner.getRelative(xy, room.height+xy, z), BlockFace.EAST, false);

					room.corner.getRelative(room.width - 1 - xy, room.height+xy, z).setType(Material.WOOD_STAIRS);
					BlockUtils.setStairsData(room.corner.getRelative(room.width - 1 - xy, room.height+xy, z), BlockFace.WEST, false);
					
				}
				
				if (room.width % 2 == 1)
				{
					room.corner.getRelative(room.width / 2 + 1, room.height+room.width / 2 + 1, z).setType(Material.WOOD);
				}
			}
			break;
		case EAST:
		case WEST:
			
			break;
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
}
