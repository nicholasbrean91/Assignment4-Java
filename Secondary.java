public class Secondary {
	
	public static double _angel1;
	private static double _angel2;
	private static double _angel3;
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
			this._angel1 = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("ASA")){
			this._angel1 = info1;
			this._side1 = info2;
			this._angel2 = info3;
		}else if (type.equalsIgnoreCase("SSA")){
			this._side1 = info1;
			this._side2 = info2;
			this._angel1 = info3;
		}else if (type.equalsIgnoreCase("AAS")){
			this._angel1 = info1;
			this._angel2= info2;
			this._side1 = info3;
		}
		
	}
	
	public static void missingAngle(){
		int totalDegrees = 180;
		_angel3 = totalDegrees - _angel1 -_angel2;
	}
	
	public static double perimeterCalc(){
		double perimeter;
		perimeter = _side1 + _side2 + _side3;
		return perimeter;
	}
	
	public static double triangleTypeCalc(){
		double typeTriangle1 = 1; //Iso
		double typeTriangle2 = 2; //Equal
		double typeTriangle3 = 3; //Squal
		
		if(_side1 == _side2 && _side2 != _side3 || _side2 == _side3 && _side3 != _side1 || _side3 == _side1 && _side1 != _side2){
			return typeTriangle1;
			
		}else if(_side1 == _side2 && _side2 == _side3){
			return typeTriangle2;
		}else if (_side1 != _side2 && _side2 != _side3 && _side1 != _side3){
			return typeTriangle3;
		}else
		return -1;
	}
    public static double getAngle1() {
		   return (double) Math.acos((Math.pow(_side1, 2) - Math.pow(_side2, 2) - Math.pow(_side3, 2)) / (-2 * _side2 * _side3));
	}
	 
    public static double getAngle2() {
		   return (double) Math.acos((Math.pow(_side2, 2) - Math.pow(_side1, 2) - Math.pow(_side3, 2)) / (-2 * _side1 * _side3));
	}

    public static double getAngle3() {
        return (double) Math.acos((Math.pow(_side3, 2) - Math.pow(_side1, 2) - Math.pow(_side2, 2)) / (-2 * _side2 * _side1));
    }
    
    public static void getSide2() {
        //_side2 = Math.sqrt((_side1 * _side1) + (_side3 * _side3) - (2 * _side1 * _side3 * _angelA));
    	_side2 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side3, 2) - (2 * _side1 * _side3 * Math.cos(Math.toRadians(_angel1))));

    }
    
    public static double semiPerimeter(){
    	return (double) (_side1 + _side2 + _side3)/2;
    }
    
    public static double heronFormula(double semi){
    	return (double) Math.sqrt(semi*(semi - _side1)*(semi - _side2)*(semi - _side3));
    }

    
    protected void isTriangleValid() {
		if (_side1 >= _side2 + _side3 || _side2 >= _side1 + _side3 || _side3 >= _side1 + _side2){
			System.out.println("In our universe we cannot have negative lengths, please enter in a positive side length.");
			System.exit(0);
		}else{
			
			System.out.println("\nThis is a real Triangle");
    }

}
}
