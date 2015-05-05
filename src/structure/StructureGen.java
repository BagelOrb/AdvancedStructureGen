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
		
		Roof.makeRoof(room, BlockFace.EAST, TreeSpecies.BIRCH);
		
		Wall.setWallMat(room, BlockFace.NORTH, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.EAST, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.SOUTH, Material.COBBLESTONE);
		Wall.setWallMat(room, BlockFace.WEST, Material.COBBLESTONE);
		Wall.setWallCornersMat(room, Material.LOG);
		
	}
	
}
