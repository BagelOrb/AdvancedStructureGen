package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import room.Floor;
import room.Placement;
import room.Roof;
import room.Room;
import styles.PrefabStyles;
import utils.MatState;
import utils.MatStateUtils;
import utils.MatStateUtils.*;

public class StructureGen {

	public static void generate(Block location, int w, int h, int d, BlockFace roofDir) {
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		room.style = PrefabStyles.demacianStyle();
		room.make();
	}
	public static void generate2(Block location, int w, int h, int d, BlockFace roofDir) {
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		
		Floor.setFloorMat(room, new MatShape(MatType.Birch, Shape.Block).getMatState());
		
		Roof.setRoofCheckerBoard(room, new MatState(Material.GOLD_BLOCK), new MatState(Material.LAPIS_BLOCK));
		Roof.kantelen(room, MatStateUtils.MatType.StoneBricks);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
	
		room.wallNorth.generateWindows(Material.FENCE);
		room.wallEast.generateWindows(Material.FENCE);
		room.wallSouth.generateWindows(Material.FENCE);
		room.wallWest.generateWindows(Material.FENCE);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

	}
	public static void generate3(Block location, int w, int h, int d, BlockFace roofDir) {
		generate2(location, w, h, d, roofDir);
		generate(location.getRelative(0, h, 0), w, h, d, roofDir);
	}
	
}
