package room;


import main.Debug;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import utils.MatState;
import utils.MatStateUtils;
import utils.MatStateUtils.MatShape;
import utils.MatStateUtils.MatType;
import utils.MatStateUtils.Shape;

public class Roof {

	public static void setRoofMat(Room room, MatState mat) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				mat.setBlock(room.corner.getRelative(x, room.height - 1, z));
		
	}

	public static void setRoofCheckerBoard(Room room, MatState mat1, MatState mat2) {
		for (int x = 1 ; x < room.width - 1; x++)
			for (int z = 1; z < room.depth - 1; z++)
				if ((x+z) % 2 == 1)
					mat1.setBlock(room.corner.getRelative(x, room.height - 1, z));
				else 
					mat2.setBlock(room.corner.getRelative(x, room.height - 1, z));
		
	}

	
	public static void kantelen(Room room, MatStateUtils.MatType matType) {
		
		kantelen_NS(room.corner.getRelative(0, room.height, 0), room.depth, matType);
		kantelen_NS(room.corner.getRelative(room.width - 1, room.height, 0), room.depth, matType);
		
		kantelen_EW(room.corner.getRelative(0, room.height, 0), room.width, matType);
		kantelen_EW(room.corner.getRelative(0, room.height, room.depth - 1), room.width, matType);
		
	}
	public static void kantelen_NS(Block rel, int length, MatStateUtils.MatType mat) {
		MatShape stairs = new MatShape(mat, Shape.Stairs);
		MatShape block = new MatShape(mat, Shape.Block);
		
		block.getMatState().setBlock(rel.getRelative(0, 0, 0));
		block.getMatState().setBlock(rel.getRelative(0, 0, length - 1));
		
		for (int z = 1; z < length / 2; z++)
		{
			stairs.getMatState(BlockFace.SOUTH, false).setBlock(rel.getRelative(0, 0, z));

			stairs.getMatState(BlockFace.NORTH, false).setBlock(rel.getRelative(0, 0, length - 1 - z));
		}
		if (length % 2 == 1)
		{
			block.getMatState().setBlock(rel.getRelative(0, 0, length / 2));
		}
	}

	public static void kantelen_EW(Block rel, int length, MatStateUtils.MatType mat) {
		MatShape stairs = new MatShape(mat, Shape.Stairs);
		MatShape block = new MatShape(mat, Shape.Block);
		
		block.getMatState().setBlock(rel.getRelative(0, 0, 0));
		block.getMatState().setBlock(rel.getRelative(length - 1, 0, 0));
		
		for (int x = 1; x < length / 2; x++)
		{
			stairs.getMatState(BlockFace.EAST, false).setBlock(rel.getRelative(x, 0, 0));

			stairs.getMatState(BlockFace.WEST, false).setBlock(rel.getRelative(length - 1 - x, 0, 0));
		}
		if (length % 2 == 1)
		{
			block.getMatState().setBlock(rel.getRelative(length / 2, 0, 0));
		}
	}
	

	public static void makeRoof(Room room, BlockFace direction, MatType mat)
	{				
		MatShape stairs = new MatShape(mat, Shape.Stairs);
		MatShape step = new MatShape(mat, Shape.Step);
		MatShape block = new MatShape(mat, Shape.Block);
		switch (direction)
		{
		case NORTH:
		case SOUTH:
			for (int z = 1; z < room.depth - 1; z++)
			{
				for (int xy = 0; xy < room.width/2; xy++)
				{
					Block heen = room.corner.getRelative(xy, room.height+xy, z);
					stairs.getMatState(BlockFace.EAST, false).setBlock(heen);
					Block terug = room.corner.getRelative(room.width - 1 - xy, room.height+xy, z);
					stairs.getMatState(BlockFace.WEST, false).setBlock(terug);
					
					if (xy > 0)
					{
						stairs.getMatState(BlockFace.WEST, true).setBlock(heen.getRelative(BlockFace.DOWN));
						stairs.getMatState(BlockFace.EAST, true).setBlock(terug.getRelative(BlockFace.DOWN));
					}
					
				}
				
				if (room.width % 2 == 1)
				{
					Block top = room.corner.getRelative(room.width / 2, room.height + room.width / 2, z);
					step.getMatState(false).setBlock(top);
					if (room.width > 1)
					{
						block.getMatState().setBlock(top.getRelative(BlockFace.DOWN));
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
					Block heen = room.corner.getRelative(x, room.height+zy, zy); 
					stairs.getMatState(BlockFace.SOUTH, false).setBlock(heen);

					Block terug = room.corner.getRelative(x, room.height+zy, room.depth - 1 - zy);
					stairs.getMatState(BlockFace.NORTH, false).setBlock(terug);
					if (zy > 0)
					{
						stairs.getMatState(BlockFace.NORTH, true).setBlock(heen.getRelative(BlockFace.DOWN));
						stairs.getMatState(BlockFace.SOUTH, true).setBlock(terug.getRelative(BlockFace.DOWN));
					}
					
				}
				
				if (room.depth % 2 == 1)
				{
					Block top = room.corner.getRelative(x, room.height + room.depth / 2, room.depth / 2); 
					step.getMatState(false).setBlock(top);

					if (room.depth > 1)
					{
						block.getMatState().setBlock(top.getRelative(BlockFace.DOWN));
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

	public static void makeRoofSide(Room room, BlockFace direction, MatType mat, boolean flipStairs)
	{				
		MatShape stairs = new MatShape(mat, Shape.Stairs);
		MatShape block = new MatShape(mat, Shape.Block);
		
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
				stairs.getMatState(maybeFlip(BlockFace.EAST, flipStairs), false).setBlock(one);
				
				for (int x = xy + 1; x < room.width - 1 - xy; x++)
					block.getMatState().setBlock(room.corner.getRelative(x, room.height + xy, z));
					
				
				Block two = room.corner.getRelative(room.width - 1 - xy, room.height+xy, z); 
				stairs.getMatState(maybeFlip(BlockFace.WEST, flipStairs), false).setBlock(two);
				
			}
			
			if (room.width % 2 == 1)
			{
				Block top = room.corner.getRelative(room.width / 2, room.height + room.width / 2, z);
				block.getMatState().setBlock(top);
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
				stairs.getMatState(maybeFlip(BlockFace.SOUTH, flipStairs), false).setBlock(one);

				for (int z = zy + 1; z < room.depth - 1 - zy; z++)
					block.getMatState().setBlock(room.corner.getRelative(x, room.height + zy, z));
				
				Block two = room.corner.getRelative(x, room.height+zy, room.depth - 1 - zy); 
				stairs.getMatState(maybeFlip(BlockFace.NORTH, flipStairs), false).setBlock(two);
			}
			
			if (room.depth % 2 == 1)
			{
				Block top = room.corner.getRelative(x, room.height + room.depth / 2, room.depth / 2);
				block.getMatState().setBlock(top);
			}
			break;
		}
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
	public static void makeRoofWindow(Room room, BlockFace direction, MatState matState)
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
				matState.setBlock(room.corner.getRelative(room.width / 2, room.height + room.width / 4, z));
			}
			else {
				matState.setBlock(room.corner.getRelative(room.width / 2, room.height + room.width / 4 - 1, z));
				matState.setBlock(room.corner.getRelative(room.width / 2 - 1, room.height + room.width / 4 - 1, z));
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
				matState.setBlock(room.corner.getRelative(x, room.height + room.depth / 4, room.depth / 2));
			}
			else {
				matState.setBlock(room.corner.getRelative(x, room.height + room.depth / 4 - 1, room.depth / 2));
				matState.setBlock(room.corner.getRelative(x, room.height + room.depth / 4 - 1, room.depth / 2 - 1));
			}
			break;
		}
		default:
			Debug.err("Cannot make roof in direction "+ direction);	
		}
		
	}
}
