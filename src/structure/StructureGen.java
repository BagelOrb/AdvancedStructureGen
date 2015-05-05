package structure;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class StructureGen {

	public static void generate(Block location) {
		int w=7, h=7, d=9;
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

		Roof.makeRoof(room, BlockFace.EAST, TreeSpecies.BIRCH);

	}
	
}
