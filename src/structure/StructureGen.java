package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import utils.MatState;
import utils.MatStateUtils;
import utils.MatStateUtils.MatType;

public class StructureGen {

	public static void generate(Block location, int w, int h, int d, BlockFace roofDir) {
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Roof.makeRoof(room, roofDir, MatType.Birch);
		Roof.makeRoofSide(room, roofDir, MatType.StoneBricks, true);
		Roof.makeRoofWindow(room, roofDir, new MatState(Material.FENCE, 0));
		Roof.makeRoofSide(room, roofDir.getOppositeFace(), MatType.StoneBricks, true);
		Roof.makeRoofWindow(room, roofDir.getOppositeFace(), new MatState(Material.FENCE, 0));
		//Roof.setRoofCheckerBoard(room, Material.GOLD_BLOCK, Material.LAPIS_BLOCK);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

	}
	public static void generate2(Block location, int w, int h, int d, BlockFace roofDir) {
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Roof.setRoofCheckerBoard(room, Material.GOLD_BLOCK, Material.LAPIS_BLOCK);
		Roof.kantelen(room, MatStateUtils.MatType.StoneBricks);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.wallNorth.createDoor(Material.WOODEN_DOOR, Material.WOOD, 2);
		room.wallEast.createDoubleDoor(Material.WOODEN_DOOR, Material.WOOD, 1);
		room.wallSouth.createDoor(Material.WOODEN_DOOR, Material.WOOD, 2);
		room.wallWest.createDoubleDoor(Material.WOODEN_DOOR, Material.WOOD, 1);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

	}
	
}
