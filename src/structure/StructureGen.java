package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class StructureGen {

	public static void generate(Block location) {
		int w=6, h=3, d=8;
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Wall.setWallMat(room, BlockFace.NORTH, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.EAST, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.SOUTH, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.WEST, Material.COBBLESTONE);
		Wall.setWallCornersMat(room, Material.LOG);
		
		Roof.makeRoof(room, BlockFace.NORTH);
	}
	
}
