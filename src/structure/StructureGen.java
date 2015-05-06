package structure;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class StructureGen {

	public static void generate(Block location, int w, int h, int d, BlockFace roofDir) {
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Roof.makeRoof(room, roofDir, TreeSpecies.BIRCH);
		Roof.makeRoofSide(room, roofDir, Material.SMOOTH_BRICK, true);
		Roof.makeRoofWindow(room, roofDir, Material.FENCE);
		Roof.makeRoofSide(room, roofDir.getOppositeFace(), Material.SMOOTH_BRICK, true);
		Roof.makeRoofWindow(room, roofDir.getOppositeFace(), Material.FENCE);
		//Roof.setRoofCheckerBoard(room, Material.GOLD_BLOCK, Material.LAPIS_BLOCK);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

	}
	
}
