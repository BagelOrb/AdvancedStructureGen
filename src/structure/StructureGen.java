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
		
		Roof.makeRoof(room, BlockFace.NORTH, TreeSpecies.BIRCH);
		Roof.makeRoofSide(room, BlockFace.NORTH, Material.SMOOTH_BRICK, true);
		Roof.makeRoofWindow(room, BlockFace.NORTH, Material.GLASS);
		
		room.wallNorth.setWallMat(Material.SMOOTH_BRICK);
		room.wallEast.setWallMat(Material.SMOOTH_BRICK);
		room.wallSouth.setWallMat(Material.SMOOTH_BRICK);
		room.wallWest.setWallMat(Material.SMOOTH_BRICK);
		
		room.wallNorth.createDoor(Material.WOOD_DOOR, Material.WOOD, 3);
		
		room.setWallCornersMat(Material.SMOOTH_BRICK);

		Roof.makeRoof(room, BlockFace.EAST, TreeSpecies.BIRCH);

	}
	
}
