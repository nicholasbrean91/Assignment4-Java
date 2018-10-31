//Site the source: https://gist.github.com/brysonian/116503 
//I used his formulas for calculating Cosine.

import java.text.DecimalFormat;
public class Secondary {
	
	static DecimalFormat f = new DecimalFormat("##.00");
	private static double area;
	private static double semiPerm;
	private static int totalDegrees = 180;
	private static double _angle1;
	private static double _angle2;
	private static double _angle3;
	private static double _side1;
	private static double _side2;
	private static double _side3;
	private static double _info1;
	private static double _altAngle;
	private static double _altAngle1;
	private static double _side1alt;
	private static double _height3;
	private static double _height2;
	private static double _height1;
	
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
			this._side2 = info1;
			this._side3 = info2;
			this._angle2 = info3;
		}else if (type.equalsIgnoreCase("AAS")){
			this._angle1 = info1;
			this._angle3 = info2;
			this._side3 = info3;
		}
		
	}
	
	public static void heightAngle3(){
		_height3 = (area * 2) / _side3;
		System.out.println("\n" + f.format(_height3) + " This is the height of Angle 3.");
	}
	
	public static void heightAngle2(){
		_height2 = (area * 2) / _side2;
		System.out.println(f.format(_height2) + " This is the height of Angle 2.");
	}
	
	public static void heightAngle1(){
		_height1 = (area * 2) / _side1;
		System.out.println(f.format(_height1) + " This is the height of Angle 1.");
	}
	
	public static void LASfindC(){
		double HofS = (_side3 * (Math.sin(Math.toRadians(_angle2))) / _side2);
		double angleInRadians  = (Math.asin(HofS));
		_angle3 = angleInRadians / Math.PI * 180;
		//System.out.println("This is angle 3 " + _angle3);
	}
	
	public static void side1sinAAS(){
		_side1 = (_side3 * (Math.sin(Math.toRadians(_angle1)))) /(Math.sin(Math.toRadians(_angle3)));
		//System.out.println(_side1 + "This is side 1");
	}
	
	public static void side2sinAAS(){
		_side2 = (_side3 * (Math.sin(Math.toRadians(_angle2)))) / (Math.sin(Math.toRadians(_angle3)));
		//System.out.println(_side2 + "This is side 2");
	}
	
	public static void side2sin(){
		_side2 = (_side3 / (Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle2))));
		//System.out.println(_side2 + " this is side 2");
	}
	
	public static void side1sin() {
		_side1 = (_side3/(Math.sin(Math.toRadians(_angle3)))) * ((Math.sin(Math.toRadians(_angle1))));
		//System.out.println(_side1 + "This is side 1");
	}
	
	public static void missingAngle1(){
		_angle1 = totalDegrees - _angle3 - _angle2;
	}
	
	
	public static void missingAngle3(){
		_angle3 = totalDegrees - _angle1 -_angle2;
		//System.out.println("the missing angle is " +  _angle3);
	}
	
	public static void missingAngle2(){
		_angle2 = totalDegrees - _angle1 -_angle3;
		//System.out.println("the missing angle is " +  _angle2);
	}
	
	public static void perimeterCalc(){
		double perimeter = _side1 + _side2 + _side3;
		System.out.println("The Perimeter of the triangle is " + f.format(perimeter) + " units^2");
	}
	
	public static void GetName(){
		
		if(_side1 == _side2 && _side2 != _side3 || _side2 == _side3 && _side3 != _side1 || _side3 == _side1 && _side1 != _side2){
			
			if(_angle1 < 90 && _angle2 < 90 && _angle3 < 90){
				System.out.println("This triangle is an Acute Isosceles triangle");
			}else{
				System.out.println("This triangle is an Obtuse Isosceles triangle");
				}
		}else if(_side1 == _side2 && _side2 == _side3){
				System.out.println("This triangle is an Equilateral triangle");
		
		}else if (_side1 != _side2 && _side2 != _side3 && _side1 != _side3){
			
			if(_angle1 < 90 && _angle2 < 90 && _angle3 <90){
				System.out.println("This triangle is an Acute Squalene triangle");
				
			}else{
				System.out.println("This triangle is an Obtuse Squalene triangle");
				}
		}else{
			System.out.println("You should not be here.");
		}
	}
    
    public static void getSide2cos() {
        //_side2 = Math.sqrt((_side1 * _side1) + (_side3 * _side3) - (2 * _side1 * _side3 * _angelA));
    	_side2 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side3, 2) - (2 * _side1 * _side3 * Math.cos(Math.toRadians(_angle2))));
    }
    
    public static void getSide3cos() {
        _side3 = Math.sqrt(Math.pow(_side1, 2) + Math.pow(_side2, 2) - 2 * _side1 * _side2 * Math.cos(Math.toRadians(_angle3)));
        //System.out.println("Side length 3 is " + _side3);
    }
    
    public static void semiPerimeter(){
    semiPerm = (_side1 + _side2 + _side3)/2;
    }
    
    public static void heronFormula(){
    area = Math.sqrt(semiPerm*(semiPerm - _side1)*(semiPerm - _side2)*(semiPerm - _side3));
    System.out.println("The Area of the triangle is " + f.format(area) + " units^2");
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
