package structure;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class StructureGen {

	public static void generate(Block location) {
		int w=8, h=4, d=6;
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Roof.makeRoof(room, BlockFace.EAST, TreeSpecies.BIRCH);
		Roof.makeRoofSide(room, BlockFace.EAST, Material.SMOOTH_BRICK, true);
		Roof.makeRoofWindow(room, BlockFace.EAST, Material.FENCE);
		Roof.makeRoofSide(room, BlockFace.WEST, Material.SMOOTH_BRICK, true);
		Roof.makeRoofWindow(room, BlockFace.WEST, Material.FENCE);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

	}
	
}
