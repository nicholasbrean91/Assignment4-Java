public class Secondary {
	
	public static double _angle1;
	private static double _angle2;
	private static double _angle3;
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
			this._angle2 = info2;
			this._side3 = info3;
		}else if (type.equalsIgnoreCase("ASA")){
			this._angle1 = info1;
			this._side3 = info2;
			this._angle2 = info3;
		}else if (type.equalsIgnoreCase("SSA")){
			this._side1 = info1;
			this._side2 = info2;
			this._angle1 = info3;
		}else if (type.equalsIgnoreCase("AAS")){
			this._angle1 = info1;
			this._angle2= info2;
			this._side1 = info3;
		}
		
	}
	
	public static void side2sin(){
		_side2 = (_side3 / (Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle2))));
		System.out.println(_side2 + " this is side 2");
	}
	
	public static void side1sin() {
		_side1 = (_side3/(Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle1))));
		System.out.println(_side1 + "This is side 1");
	}
	
	public static void missingAngle(){
		int totalDegrees = 180;
		_angle3 = totalDegrees - _angle1 -_angle2;
		System.out.println("the missing angle is " +  _angle3);
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
    
    public static void getSide2cos() {
        //_side2 = Math.sqrt((_side1 * _side1) + (_side3 * _side3) - (2 * _side1 * _side3 * _angelA));
    	_side2 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side3, 2) - (2 * _side1 * _side3 * Math.cos(Math.toRadians(_angle2))));
    }
    
    public static void getSide3cos() {
        _side3 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side2, 2) - 2 * _side1 * _side2 * Math.cos(Math.toRadians(_angle3)));
        System.out.println("Side length 3 is " + _side3);
      }
    
    public static double semiPerimeter(){
    	return (double) (_side1 + _side2 + _side3)/2;
    }
    
    public static double heronFormula(double semi){
    	return (double) Math.sqrt(semi*(semi - _side1)*(semi - _side2)*(semi - _side3));
    }

    
    protected void isTriangleValid() {
		if (_side1 >= _side2 + _side3 || _side2 >= _side1 + _side3 || _side3 >= _side1 + _side2){
			System.out.println("\nIn our universe we cannot have that triangle, please try again.");
			System.exit(0);
		}else{
			System.out.println("\nThis is a real Triangle");
    }

}
}
