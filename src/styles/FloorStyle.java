package styles;

import utils.MatState;

public class FloorStyle {

	public enum FloorFillType { Normal, CheckerBoard };
	
	public FloorFillType floorFillType;
	public MatState mat;
	public MatState mat2;
	
	public FloorStyle(MatState mat)
	{
		this.floorFillType = FloorFillType.Normal;
		this.mat =  mat;
	}
	public FloorStyle(MatState mat, MatState mat2)
	{
		this.floorFillType = FloorFillType.CheckerBoard;
		this.mat =  mat;
		this.mat2 = mat2;
	}
	
}
