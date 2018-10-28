public class Secondary {
	
	private static double _angelA;
	private static double _angelB;
	private static double _angelC;
	private static double _side1;
	private static double _side2;
	private static double _side3;
	private static double _info1;
	
	public Secondary (String type,
					  double info1,
					  double info2,
					  double info3) {
		if (type.equalsIgnoreCase("SSS")){
			this._side1 = info1;
			this._side2 = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("SAS")){
			this._side1 = info1;
			this._angelA = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("ASA")){
			this._angelA = info1;
			this._side1 = info2;
			this._angelB = info3;
		}else if (type.equalsIgnoreCase("SSA")){
			this._side1 = info1;
			this._side2 = info2;
			this._angelA = info3;
		}else if (type.equalsIgnoreCase("AAS")){
			this._angelA = info1;
			this._angelB= info2;
			this._side1 = info3;
		}
		
	}
	
	
	public static double perimeterCalc(double side1, double side2, double side3){
		double perimeter;
		perimeter = _side1 + _side2 + _side3;
		return perimeter;
	}
	
	public static double triangleTypeCalc(double side1, double side2, double side3){
		
		double typeTriangle1 = 1; //Iso
		double typeTriangle2 = 2; //Equal
		double typeTriangle3 = 3; //Squal
		
		if(side1 == side2 && side2 != side3 || side2 == side3 && side3 != side1 || side3 == side1 && side1 != side2){
			return typeTriangle1;
		}else if(side1 == side2 && side2 == side3){
			return typeTriangle2;
		}else if (side1 != side2 && side2 != side3 && side1 != side3){
			return typeTriangle3;
		}else
			
		return -1;
		
	}
    public static double getAngleA(double side1, double side2, double side3) {
		   return (double) Math.acos((Math.pow(side1, 2) - Math.pow(side2, 2) - Math.pow(side3, 2)) / (-2 * side2 * side3));
	}
	 
    public static double getAngleB(double side1, double side2, double side3) {
		   return (double) Math.acos((Math.pow(side2, 2) - Math.pow(side1, 2) - Math.pow(side3, 2)) / (-2 * side1 * side3));
	}

    public static double getAngleC(double side1, double side2, double side3) {
        return (double) Math.acos((Math.pow(side3, 2) - Math.pow(side1, 2) - Math.pow(side2, 2)) / (-2 * side2 * side1));
    }
    
    public static double getSideC(double angelA, double side1, double side2) {
      return (double) Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(angelA));
    }
    
    public static double semiPerimeter(double side1, double side2, double side3){
    	return (double) (side1 + side2 + side3)/2;
    }
    
    public static double heronFormula(double semi){
    	return (double) Math.sqrt(semi*(semi - _side1)*(semi - _side2)*(semi - _side3));
    }

    
    protected void isTriangleValid() {
		if (_side1 < _side2 + _side3 && _side2 < _side1 + _side3 && _side3 < _side1 + _side2){
			if (_side1 <= 0||_side2 <= 0||_side3 <= 0){
				System.out.println("In our universe we cannot have negative lengths, please enter in a positive side length.");
				System.exit(0);
			}
    }
    
}
}
