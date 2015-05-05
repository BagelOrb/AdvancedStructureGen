package utils;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;

public class MatUtils {

	public static String prettyPrint(Material mat) {
		if (mat==null)
			return "Empty";
		
		switch (mat) {
		case WORKBENCH:
			return "Crafting Table";
		case LOG:
			return "Wood";
		case LOG_2:
			return "Wood";
		case WOOD:
			return "Wood Planks";
		default:
			String str = mat.name();
			str = str.replace('_', ' ').toLowerCase();
			str = WordUtils.capitalize(str);
			return str;
		}
	}
	
	public static Material getStairs(TreeSpecies species) {
		switch (species) {
		case ACACIA: return Material.ACACIA_STAIRS;
		case BIRCH: return Material.BIRCH_WOOD_STAIRS;
		case DARK_OAK: return Material.DARK_OAK_STAIRS;
		case GENERIC: return Material.WOOD_STAIRS;
		case JUNGLE: return Material.JUNGLE_WOOD_STAIRS;
		case REDWOOD: return Material.SPRUCE_WOOD_STAIRS;
		}
		return Material.WOOD_STAIRS;
	}
	
	public static void main(String[] args) {
		System.out.println(prettyPrint(Material.BAKED_POTATO));
	}
	
	public static enum MatType {
//		ORE(new SetMat(null, this));
//		
//		private Mat mat;
//
//		MatType(Mat mat) {
//			this.mat = mat;
//		}
	}
	

}
