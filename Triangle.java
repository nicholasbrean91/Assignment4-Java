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
		int info1;
		int info2;
		int info3;
		
		System.out.println("Choose One of the below options.\n \n 1) SSS for 3 Sides.\n 2) SAS for 1 Side then 1 Angel and 1 Side (angel is in between two sides).\n 3) ASA for 1 Angle 1 Side and 1 Angle.\n 4) SSA for 1 Side 1 Side and 1 Angle (not an angle between the sides).\n 5) AAS 2 Angles and 1 Side.\n");
		System.out.print("Enter one of the abberivations for selection. (Ex.'SSS' for Side Side Side): ");
		type = userInput.nextLine(); //What you're solving for
		System.out.print("Enter in the first part of information for the your preset " + type + " : ");
		info1 = userInput.nextInt(); 
		System.out.print("Enter in the first part of information for the your preset " + type + " : ");
		info2 = userInput.nextInt();
		System.out.print("Enter in the first part of information for the your preset " + type + " : ");
		info3 = userInput.nextInt();
		
		if (type.equalsIgnoreCase("SSS")){
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
					if(angel1 < 90 && angel2 < 90 && angel3 <90){
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
			Secondary obj = new Secondary(type, info1, info2, info3);
			obj.getSide2();
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
			Secondary obj = new Secondary(type, info1, info2, info3);
		}
	 }
  }
