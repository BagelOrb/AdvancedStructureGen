package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class StructureGen {

	public static void generate(Block location) {
		int w=5, h=5, d=5;
		int lift = Placement.getStructureLift(location, w, h, d);
		makeFloor(location.getRelative(0, lift, 0), w, h, d);
	}
	
	public static void makeFloor(Block block, int width, int height, int depth) {

		int y = 0;
		for (int x = 0; x < width; x++)
				for (int z = 0; z < depth; z++)
					block.getRelative(x, y, z).setType(Material.BEDROCK);
		
	}
}
