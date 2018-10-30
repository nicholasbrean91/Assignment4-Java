//Created by: Nicholas Brean
//Created on: October 2018
//Created to Calculate Area Perimeter and Type of any triangle input, (SSS, SAS, ASA, SSA, AAS)

import java.text.DecimalFormat;
import java.util.Scanner;
public class Triangle {
	public static void main(String args[]){
		Scanner userInput = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("##.00");
		String type;
		int info1 = 0;
		int info2 = 0;
		int info3 = 0;
		
		System.out.println("Choose One of the below options.\n \n 1) SSS for 3 Sides.\n 2) SAS for 1 Side then 1 Angel and 1 Side (angel is in between two sides).\n 3) ASA for 1 Angle 1 Side and 1 Angle.\n 4) SSA for 1 Side 1 Side and 1 Angle (not an angle between the sides).\n 5) AAS 2 Angles and 1 Side.\n");
		System.out.print("Enter one of the abberivations for selection. (Ex.'SSS' for Side Side Side): ");
		type = userInput.nextLine(); //What you're solving for

		
		if (type.equalsIgnoreCase("SSS")){
			System.out.println("\n'SSS' is when you have 3 sides of a Triangle.\n");
			
			System.out.print("Enter in side 1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in side 2 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			
				obj.isTriangleValid();
			
				//Find Angels
				double angel1 = obj.getAngle1();
				double angel2 = obj.getAngle2();
				double angel3 = obj.getAngle3();
				

				double triangleType = Secondary.triangleTypeCalc();

				
				if (triangleType == 1){
					if(angel1 < 90 && angel2 < 90 && angel3 < 90){
						System.out.println("This triangle is an Acute Isosceles triangle");
					}else{
						System.out.println("This triangle is an Obtuse Isosceles triangle");
					}
				}else if(triangleType == 2){
					System.out.println("This triangle is an Equilateral triangle");
				
				}else if(triangleType == 3){
					if(angel1 < 90 && angel2 < 90 && angel3 < 90){
						System.out.println("This triangle is an Acute Squalene triangle");
					}else{
						System.out.println("This triangle is an Obtuse Squalene triangle");
				}
				//Perimeter
				double totalperm = obj.perimeterCalc();
				System.out.println("The total Perimeter is " + totalperm + "cm" );
				
				//Area
				double semi = obj.semiPerimeter();
				double area = obj.heronFormula(semi);
				
				System.out.println("The area of the triangle is " + area + "cm^2");
				
			}else{
				System.out.println("Enter a correct Triangle.");	
			}	
				
		}else if(type.equalsIgnoreCase("SAS")){
			System.out.println("\n'SAS' is when we know two sides and the angle between them.\n");
			System.out.print("Enter in side 1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in angle2 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side 3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			obj.getSide2cos();
			obj.isTriangleValid();
			double angel1 = obj.getAngle1();
			double angel2 = obj.getAngle2();
			double angel3 = obj.getAngle3();
			double triangleType = Secondary.triangleTypeCalc();

			if (triangleType == 1){
				if(angel1 < 90 && angel2 < 90 && angel3 < 90){
					System.out.println("This triangle is an Acute Isosceles triangle");
				}else{
					System.out.println("This triangle is an Obtuse Isosceles triangle");
				}
			}else if(triangleType == 2){
				System.out.println("This triangle is an Equilateral triangle");
			}else if(triangleType == 3){
				if(angel1 < 90 && angel2 < 90 && angel3 <90){
					System.out.println("This triangle is an Acute Squalene triangle");
				}else{
					System.out.println("This triangle is an Obtuse Squalene triangle");
			}
			//Perimeter	
			double totalperm = obj.perimeterCalc();
			System.out.println("The Permiter of the triangle is " + f.format(totalperm) + " cm" );
			//double roundedperm = Math.round(totalperm * 100.0) / 100.0;
			//System.out.println("The total Perimeter is " + totalperm + "cm" );
			
			//Area
			double semi = obj.semiPerimeter();
			double area = obj.heronFormula(semi);
			System.out.println("The Area of the triangle is " + f.format(area) + " cm^2" );
			
			}
		}else if(type.equalsIgnoreCase("ASA")){
			System.out.println("\nASA Triangle is when we know two angles and a side between the angles.\n ");
			System.out.print("Enter in angle1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in side2 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in angle3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			obj.missingAngle3(); //Find Missing Angle
			obj.side1sin(); //Fine side1
			obj.side2sin();
			
			obj.isTriangleValid();
			double angel1 = obj.getAngle1();
			double angel2 = obj.getAngle2();
			double angel3 = obj.getAngle3();
			double triangleType = Secondary.triangleTypeCalc();

			if (triangleType == 1){
				if(angel1 < 90 && angel2 < 90 && angel3 < 90){
					System.out.println("This triangle is an Acute Isosceles triangle");
				}else{
					System.out.println("This triangle is an Obtuse Isosceles triangle");
				}
			}else if(triangleType == 2){
				System.out.println("This triangle is an Equilateral triangle");
			}else if(triangleType == 3){
				if(angel1 < 90 && angel2 < 90 && angel3 <90){
					System.out.println("This triangle is an Acute Squalene triangle");
				}else{
					System.out.println("This triangle is an Obtuse Squalene triangle");
			}
				
			//Perimeter	
			double totalperm = obj.perimeterCalc();
			System.out.println("The Permiter of the triangle is " + f.format(totalperm) + " cm" );
			//double roundedperm = Math.round(totalperm * 100.0) / 100.0;
			//System.out.println("The total Perimeter is " + totalperm + "cm" );
			
			//Area
			double semi = obj.semiPerimeter();
			double area = obj.heronFormula(semi);
			System.out.println("The Area of the triangle is " + f.format(area) + " cm^2" );
			}
			
		}else if (type.equalsIgnoreCase("AAS")) {
			System.out.println("\n"  + 	"\"AAS\" is when we know two angles and one side (which is not between the angles).\n ");
			System.out.print("Enter in angle1 according to this preset " + type + " : ");
			info1 = userInput.nextInt(); 
			System.out.print("Enter in angle3 according to this preset " + type + " : ");
			info2 = userInput.nextInt();
			System.out.print("Enter in side3 according to this preset " + type + " : ");
			info3 = userInput.nextInt();
			Secondary obj = new Secondary(type, info1, info2, info3);
			obj.missingAngle2();
			obj.side1sinAAS();
			obj.side2sinAAS();
			
			obj.isTriangleValid();
			double angel1 = obj.getAngle1();
			double angel2 = obj.getAngle2();
			double angel3 = obj.getAngle3();
			double triangleType = Secondary.triangleTypeCalc();

			if (triangleType == 1){
				if(angel1 < 90 && angel2 < 90 && angel3 < 90){
					System.out.println("This triangle is an Acute Isosceles triangle");
				}else{
					System.out.println("This triangle is an Obtuse Isosceles triangle");
				}
			}else if(triangleType == 2){
				System.out.println("This triangle is an Equilateral triangle");
			}else if(triangleType == 3){
				if(angel1 < 90 && angel2 < 90 && angel3 <90){
					System.out.println("This triangle is an Acute Squalene triangle");
				}else{
					System.out.println("This triangle is an Obtuse Squalene triangle");
				}
			}
			//Perimeter	
			double totalperm = obj.perimeterCalc();
			System.out.println("The Permiter of the triangle is " + f.format(totalperm) + " cm" );
			//double roundedperm = Math.round(totalperm * 100.0) / 100.0;
			//System.out.println("The total Perimeter is " + totalperm + "cm" );
			
			//Area
			double semi = obj.semiPerimeter();
			double area = obj.heronFormula(semi);
			System.out.println("The Area of the triangle is " + f.format(area) + " cm^2" );
		}else if(type.equalsIgnoreCase("SSA")){
			
		}
	}
 }
