package structure;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class StructureGen {

	public static void generate(Block location) {
		int w=5, h=5, d=5;
		Room room = new Room(w, h, d);
		int lift = Placement.getStructureLift(room);
		Block corner = location.getRelative(0, lift, 0);
		room.corner = corner;
		Floor.setFloorMat(room, Material.STONE);
	}
	
}
