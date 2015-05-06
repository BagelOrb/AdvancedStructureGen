package styles;

import utils.MatState;
import utils.MatStateUtils.MatType;

public class RoofStyle {

	public enum RoofType { HouseStyle, Kantelen };
	
	public enum RoofSideType { Kantelen, Diagonal };
	
	public RoofType roofType;
	
	// for house style
	public MatType midRoofMat;
	public boolean hasWindow;
	public MatState windowMat;
	public RoofSideType roofSideType;
	
	//for kantelen
	// ...
	// no params
	
	public RoofStyle (MatType midRoofMat,
		boolean hasWindow,
		MatState windowMat,
		RoofSideType roofSideType)
	{
		this.roofType = RoofType.HouseStyle;
		this.midRoofMat = midRoofMat;
		this.hasWindow = hasWindow;
		this.windowMat = windowMat;
		this.roofSideType = roofSideType;
	}
	
	public RoofStyle()
	{
		roofType = RoofType.Kantelen;
	}
}
