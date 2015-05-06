package styles;

import org.bukkit.Material;

import styles.RoofStyle.RoofSideType;
import utils.MatState;
import utils.MatStateUtils.*;

public class PrefabStyles {

	public static Style demacianStyle()
	{
		Style ret = new Style();
		ret.floorStyle = new FloorStyle(new MatShape(MatType.Birch, Shape.Block).getMatState());
		ret.wallStyle = new WallStyle(
				MatType.StoneBricks, 
				new MatShape(MatType.StoneBricks, Shape.Block).getMatState(), 
				new MatState(Material.FENCE), 
				Material.WOODEN_DOOR, 
				Material.DOUBLE_STONE_SLAB2);
		ret.roofStyle = new RoofStyle(MatType.Birch, true, new MatState(Material.FENCE), RoofSideType.Kantelen);
		return ret;
	}
}
