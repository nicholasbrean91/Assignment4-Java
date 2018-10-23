
public class Secondary {
	
	public static double perimeterCalc(double side1, double side2, double side3){
		double perimeter;
		perimeter = side1 + side2 + side3;
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
    
    // get the length of side c given angle C and sides a and b
    public static double getSideC(double angelA, double side1, double side2) {
      return (double) Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(angelA));
    }
    
    public static double semiPerimeter(double side1, double side2, double side3){
    	return (double) (side1 + side2 + side3)/2;
    }
    
    public static double heronFormula(double side1, double side2, double side3, double semi){
    	return (double) Math.sqrt(semi*(semi - side1)*(semi - side2)*(semi - side3));
    }
    
    
}
