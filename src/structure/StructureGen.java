package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class StructureGen {

	public static void generate(Block location) {
		int w=6, h=3, d=8;
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);
		
		//Roof.makeRoof(room, BlockFace.NORTH);
	}
	
}
