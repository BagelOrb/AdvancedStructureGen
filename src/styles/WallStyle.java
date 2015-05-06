package styles;

import org.bukkit.Material;

import utils.MatState;
import utils.MatStateUtils.MatType;

public class WallStyle {
	public MatType basicMat;
	public MatState cornerBlocks;
	public MatState windowMat;
	public Material doorMat;
	public Material doorStepMat;
	public WallStyle (
		MatType basicMat,
		MatState cornerBlocks,
		MatState windowMat,
		Material doorMat,
		Material doorStepMat)
	{
		this.basicMat = basicMat;
		this.cornerBlocks = cornerBlocks;
		this.windowMat = windowMat;
		this.doorMat = doorMat;
		this.doorStepMat = doorStepMat;
	}
}
