package structure;


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

	

	public static void setRoofMat(Room room, Material mat) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				room.corner.getRelative(x, room.height - 1, z).setType(mat);
		
	}

	public static void setRoofCheckerBoard(Room room, Material mat1, Material mat2) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				room.corner.getRelative(x, room.height - 1, z).setType(((x+z) % 2 == 1)? mat1 : mat2);
		
	}
	
	
	public static void makeRoof(Room room, BlockFace direction, TreeSpecies species)
	{				
		Material stairs_mat = MatUtils.getStairs(species);
		switch (direction)
		{
		case NORTH:
		case SOUTH:
			for (int z = 1; z < room.depth - 1; z++)
			{
				for (int xy = 0; xy < room.width/2; xy++)
				{
					Block one = room.corner.getRelative(xy, room.height+xy, z); 
					one.setType(stairs_mat);
					BlockUtils.setStairsData(one, BlockFace.EAST, false);
					
					Block two = room.corner.getRelative(room.width - 1 - xy, room.height+xy, z); 
					two.setType(stairs_mat);
					BlockUtils.setStairsData(two, BlockFace.WEST, false);
					
					if (xy > 0)
					{
						Block one_below = one.getRelative(BlockFace.DOWN);
						one_below.setType(stairs_mat);
						BlockUtils.setStairsData(one_below, BlockFace.WEST, true);
						
						Block two_below = two.getRelative(BlockFace.DOWN);
						two_below.setType(stairs_mat);
						BlockUtils.setStairsData(two_below, BlockFace.EAST, true);
					}
					
				}
				
				if (room.width % 2 == 1)
				{
					Block top = room.corner.getRelative(room.width / 2, room.height + room.width / 2, z);
					top.setType(Material.WOOD_STEP);
					BlockState state = top.getState();
					state.setData(new WoodenStep(species, false));
					state.update();
					
					if (room.width > 1)
					{
						Block top_below = top.getRelative(BlockFace.DOWN);
						top_below.setType(stairs_mat);
						BlockUtils.setStairsData(top_below, direction, false);// TODO use block instead of stairs!
					}
				}
			}
			break;
		case EAST:
		case WEST:

			for (int x = 1; x < room.width - 1; x++)
			{
				for (int zy = 0; zy < room.depth/2; zy++)
				{
					Block one = room.corner.getRelative(x, room.height+zy, zy); 
					one.setType(stairs_mat);
					BlockUtils.setStairsData(one, BlockFace.SOUTH, false);


					Block two = room.corner.getRelative(x, room.height+zy, room.depth - 1 - zy); 
					two.setType(stairs_mat);
					BlockUtils.setStairsData(two, BlockFace.NORTH, false);
					if (zy > 0)
					{
						Block one_below = one.getRelative(BlockFace.DOWN);
						one_below.setType(stairs_mat);
						BlockUtils.setStairsData(one_below, BlockFace.NORTH, true);

						Block two_below = two.getRelative(BlockFace.DOWN);
						two_below.setType(stairs_mat);
						BlockUtils.setStairsData(two_below, BlockFace.SOUTH, true);
					}
					
				}
				
				if (room.depth % 2 == 1)
				{
					Block top = room.corner.getRelative(x, room.height + room.depth / 2, room.depth / 2); 
					top.setType(Material.WOOD_STEP);
					BlockState state = top.getState();
					state.setData(new WoodenStep(species, false));
					state.update();

					if (room.depth > 1)
					{
						Block top_below = top.getRelative(BlockFace.DOWN);
						top_below.setType(stairs_mat);
						BlockUtils.setStairsData(top_below, direction, false);// TODO use block instead of stairs!
					}
				}
			}
			break;
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}

	private static BlockFace maybeFlip(BlockFace dir, boolean flip) {
		if (flip) return dir.getOppositeFace();
		else return dir;
	}

	public static void makeRoofSide(Room room, BlockFace direction, Material blockType, boolean flipStairs)
	{				
		Material stairs_mat = MatUtils.getStairs(blockType);
		switch (direction)
		{
		case NORTH:
		case SOUTH:
		{
			int z;
			if (direction == BlockFace.NORTH) z = 0;
			else z = room.depth - 1;
			for (int xy = 0; xy < room.width/2; xy++)
			{
				Block one = room.corner.getRelative(xy, room.height+xy, z); 
				one.setType(stairs_mat);
				BlockUtils.setStairsData(one, maybeFlip(BlockFace.EAST, flipStairs), false);
				
				for (int x = xy + 1; x < room.width - 1 - xy; x++)
					room.corner.getRelative(x, room.height + xy, z).setType(blockType);
				
				Block two = room.corner.getRelative(room.width - 1 - xy, room.height+xy, z); 
				two.setType(stairs_mat);
				BlockUtils.setStairsData(two, maybeFlip(BlockFace.WEST, flipStairs), false);
				
			}
			
			if (room.width % 2 == 1)
			{
				Block top = room.corner.getRelative(room.width / 2, room.height + room.width / 2, z);
				top.setType(blockType);
			}
			break;
		}
		case EAST:
		case WEST:
		{
			int x;
			if (direction == BlockFace.WEST) x = 0;
			else x = room.width - 1;
			for (int zy = 0; zy < room.depth/2; zy++)
			{
				Block one = room.corner.getRelative(x, room.height+zy, zy); 
				one.setType(stairs_mat);
				BlockUtils.setStairsData(one, maybeFlip(BlockFace.SOUTH, flipStairs), false);

				for (int z = zy + 1; z < room.depth - 1 - zy; z++)
					room.corner.getRelative(x, room.height + zy, z).setType(blockType);
				
				Block two = room.corner.getRelative(x, room.height+zy, room.depth - 1 - zy); 
				two.setType(stairs_mat);
				BlockUtils.setStairsData(two, maybeFlip(BlockFace.NORTH, flipStairs), false);
				
			}
			
			if (room.depth % 2 == 1)
			{
				Block top = room.corner.getRelative(x, room.height + room.depth / 2, room.depth / 2); 
				top.setType(blockType);
			}
			break;
		}
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
	public static void makeRoofWindow(Room room, BlockFace direction, Material blockType)
	{
		switch (direction)
		{
		case NORTH:
		case SOUTH:
		{
			if (room.width / 2 < 3) return;
			int z;
			if (direction == BlockFace.NORTH) z = 0;
			else z = room.depth - 1;
			
			if (room.width % 2 == 1)
			{
				room.corner.getRelative(room.width / 2, room.height + room.width / 4, z).setType(blockType);
			}
			else {
				room.corner.getRelative(room.width / 2, room.height + room.width / 4 - 1, z).setType(blockType);
				room.corner.getRelative(room.width / 2 - 1, room.height + room.width / 4 - 1, z).setType(blockType);
			}
			break;
		}
		case EAST:
		case WEST:
		{
			if (room.depth / 2 < 3) return;
			int x;
			if (direction == BlockFace.WEST) x = 0;
			else x = room.width - 1;
			
			if (room.depth % 2 == 1)
			{
				room.corner.getRelative(x, room.height + room.depth / 4, room.depth / 2).setType(blockType);
			}
			else {
				room.corner.getRelative(x, room.height + room.depth / 4 - 1, room.depth / 2).setType(blockType);
				room.corner.getRelative(x, room.height + room.depth / 4 - 1, room.depth / 2 - 1).setType(blockType);
			}
			break;
		}
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
}
