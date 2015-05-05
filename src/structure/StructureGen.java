package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class StructureGen {

	public static void generate(Block location) {
		int w=5, h=5, d=5;
		Room room = new Room(location, w, h, d);
		Placement.liftStructure(room);
		Floor.setFloorMat(room, Material.WOOD);
		
		Roof.makeRoof(room, BlockFace.NORTH);
	}
	
}
