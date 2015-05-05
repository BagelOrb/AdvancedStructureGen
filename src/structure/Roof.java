package structure;

import java.util.function.Function;

import main.Debug;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.WoodenStep;

import utils.BlockUtils;
import utils.MatUtils;

public class Roof {

	public static void makeRoof(Room room, BlockFace direction, TreeSpecies species)
	{				
		Material stair_mat = MatUtils.getStairs(species);
//		ns = z
//		ew = x
		switch (direction)
		{
		case NORTH:
		case SOUTH:
			for (int z = 1; z < room.depth - 1; z++)
			{
				for (int xy = 0; xy < room.width/2; xy++)
				{
					Block one = room.corner.getRelative(xy, room.height+xy, z); 
					one.setType(stair_mat);
					BlockUtils.setStairsData(one, BlockFace.EAST, false);

					Block two = room.corner.getRelative(room.width - 1 - xy, room.height+xy, z); 
					two.setType(stair_mat);
					BlockUtils.setStairsData(two, BlockFace.WEST, false);
					
				}
				
				if (room.width % 2 == 1)
				{
					Block top = room.corner.getRelative(room.width / 2, room.height + room.width / 2, z);
					top.setType(Material.WOOD_STEP);
					BlockState state = top.getState();
					state.setData(new WoodenStep(species, false));
					state.update();
				}
			}
			break;
		case EAST:
		case WEST:

			for (int x = 1; x < room.width - 1; x++)
			{
				for (int zy = 0; zy < room.width/2; zy++)
				{
					Block one = room.corner.getRelative(x, room.height+zy, zy); 
					one.setType(stair_mat);
					BlockUtils.setStairsData(one, BlockFace.SOUTH, false);

					Block two = room.corner.getRelative(x, room.height+zy, room.width - 1 - zy); 
					two.setType(stair_mat);
					BlockUtils.setStairsData(two, BlockFace.NORTH, false);
					
				}
				
				if (room.width % 2 == 1)
				{
					Block top = room.corner.getRelative(x, room.height + room.width / 2, room.width / 2); 
					top.setType(Material.WOOD_STEP);
					BlockState state = top.getState();
					state.setData(new WoodenStep(species, false));
					state.update();
				}
			}
			break;
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
}
