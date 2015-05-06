package room;

import java.util.ArrayList;

import main.Debug;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Wall {

	public Room room;
	public BlockFace direction;
	public ArrayList<Block> doorBlocks = new ArrayList<Block>();
	public ArrayList<Block> windowBlocks = new ArrayList<Block>();
	
	public Wall(Room room, BlockFace wallDirection) {
		this.room = room;
		this.direction = wallDirection;
	}

	public void createDoubleDoor(Material doorMaterial, Material floorMaterial, int offSet)
	{
		createDoor(doorMaterial, floorMaterial, offSet, (this.direction==BlockFace.NORTH || this.direction==BlockFace.EAST));
		createDoor(doorMaterial, floorMaterial, offSet + 1, (this.direction==BlockFace.SOUTH || this.direction==BlockFace.WEST));
	}
	
	public void createDoor(Material doorMaterial, Material floorMaterial, int offSet)
	{
		createDoor(doorMaterial, floorMaterial, offSet, false);
	}
	
	public void generateWindows(Material windowMaterial)
	{
		int widthOrDepth = 0;
		switch (this.direction) {
		
		case NORTH:
		case SOUTH:
			Debug.msg("NORTH or SOUTH!");
			widthOrDepth = room.width;
			break;
			
		case EAST:		
		case WEST:
			Debug.msg("EAST or WEST!");
			widthOrDepth = room.depth;	
			break;
			
		default:
			Debug.err("Cannot make windows in direction "+ this.direction);	
			break;
		}
		
		Debug.msg("widthOrDepth: " + widthOrDepth);
		
		if(widthOrDepth <= 4) return;
		if(room.height <= 4) return;
		
		for(int xory = 1; xory < widthOrDepth / 2 - 1; xory = xory+2)
		{			
			createWindow(windowMaterial, xory);
			createWindow(windowMaterial, widthOrDepth - xory - 3);	
		}
		
		if(widthOrDepth == 5 || (widthOrDepth % 2 == 1 && widthOrDepth % 3 == 0)) // Uneven en deelbaar door 3
		{
			createWindow(windowMaterial, widthOrDepth / 2 - 1); 
		}

	}
	
	private void createWindow(Material windowMaterial, int offSet)
	{
		createWindow(windowMaterial, offSet, 2);
	}
	
	private void createWindow(Material windowMaterial, int offSet, int height)
	{
		offSet = offSet + 1;
		
		Block windowBlock = null;
		
		switch (this.direction) {
		
		case NORTH:

			windowBlock = room.corner.getRelative(offSet, height, 0);
			break;
			
		case EAST:

			windowBlock = room.corner.getRelative(room.width -1, height, offSet);	
			break;
			
		case SOUTH:

			windowBlock = room.corner.getRelative(offSet, height, room.depth -1);
			break;	
		
		case WEST:

			windowBlock = room.corner.getRelative(0, height, offSet);	
			break;
			
		default:
			Debug.err("Cannot make window in direction "+ this.direction);	
			break;
		}
		
		windowBlock.setType(windowMaterial);
		this.windowBlocks.add(windowBlock);
		
	}
	
	@SuppressWarnings("deprecation")
	private void createDoor(Material doorMaterial, Material floorMaterial, int offSet, boolean hingeRight)
	{
		Block doorTop = null;
		Block doorBottom = null;
		offSet = offSet + 1;
		
		switch (this.direction) {
		
		case NORTH:
			room.corner.getRelative(offSet, 0, 0).setType(floorMaterial);
			doorBottom = room.corner.getRelative(offSet, 1, 0);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 1);
			doorTop = room.corner.getRelative(offSet, 2, 0);
			break;
			
		case EAST:
			room.corner.getRelative(room.width -1, 0, offSet).setType(floorMaterial);
			doorBottom = room.corner.getRelative(room.width -1, 1, offSet);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 2);
			doorTop = room.corner.getRelative(room.width -1, 2, offSet);	
			break;
			
		case SOUTH:
			room.corner.getRelative(offSet, 0, room.depth -1).setType(floorMaterial);
			doorBottom = room.corner.getRelative(offSet, 1, room.depth -1);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 3);
			doorTop = room.corner.getRelative(offSet, 2, room.depth -1);
			break;	
		
		case WEST:
			room.corner.getRelative(0, 0, offSet).setType(floorMaterial);
			doorBottom = room.corner.getRelative(0, 1, offSet);
			doorBottom.setType(doorMaterial);
			doorBottom.setData((byte) 0);
			doorTop = room.corner.getRelative(0, 2, offSet);	
			break;
			
		default:
			Debug.err("Cannot make door in direction "+ this.direction);	
			break;
		}
		
		doorTop.setType(doorMaterial);
		if(hingeRight)
			doorTop.setData((byte) 9);		
		else
			doorTop.setData((byte) 8);
		
		this.doorBlocks.add(doorBottom);
		
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
			Debug.err("Cannot make wall in direction "+ this.direction);	
			break;
		}
		
	}

}
