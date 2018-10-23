//Created by: Nicholas Brean
//Created on: October 2018
//Created to Calculate Area Perimeter and Type of any triangle input, (SSS, SAS, ASA, SSA, AAS)

import java.util.Scanner;
public class main {
	public static void main(String args[]){
		int presetChosen;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Choose One of the below options.\n \n 1) SSS for 3 Sides.\n 2) SAS for 1 Side then 1 Angel and 1 Side (angel is in between two sides).\n 3) ASA for 1 Angle 1 Side and 1 Angle.\n 4) SSA for 1 Side 1 Side and 1 Angle (not an angle between the sides).\n 5) AAS 2 Angles and 1 Side.\n");
		System.out.print("Enter a number for the preset option you want: ");
		presetChosen = userInput.nextInt();
		
		if (presetChosen == 1){
			Secondary SSS = new Secondary();
			System.out.print("Enter The first side length: ");
			double Side1 = userInput.nextInt();
			System.out.print("Enter The first side length: ");
			double Side2 = userInput.nextInt();
			System.out.print("Enter The first side length: ");
			double Side3 = userInput.nextInt();
			
			//Check Side Lengths
			if (Side1 < Side2 + Side3 && Side2 < Side1 + Side3 && Side3 < Side1 + Side2){
				if (Side1 <= 0||Side2 <= 0||Side3 <= 0){
					System.out.println("In our universe we cannot have negative lengths, please enter in a positive side length.");
					System.exit(0);
				}
				//Find Angels
				double angelA = SSS.getAngleA(Side1, Side2, Side3);
				double angelB = SSS.getAngleB(Side1, Side2, Side3);
				double angelC = SSS.getAngleC(Side1, Side2, Side3);
				
				double triangleType = SSS.triangleTypeCalc(Side1, Side2, Side3);
				
				if (triangleType == 1){
					if(angelA < 90 && angelB < 90 && angelC <90){
						System.out.println("This triangle is an Acute Isosceles triangle");
					}else{
						System.out.println("This triangle is an Obtuse Isosceles triangle");
					}
					
				}else if(triangleType == 2){
					System.out.println("This triangle is an Equilateral triangle");
				
				}else if(triangleType == 3){
					if(angelA < 90 && angelB < 90 && angelC <90){
						System.out.println("This triangle is an Acute Squalene triangle");
					}else{
						System.out.println("This triangle is an Obtuse Squalene triangle");
				}
				//Perimeter
				double totalperm = SSS.perimeterCalc(Side1, Side2, Side3);
				System.out.println("The total Perimeter is " + totalperm + "cm" );
				
				//Area
				double semi = SSS.semiPerimeter(Side1, Side2, Side3);
				double area = SSS.heronFormula(Side1, Side2, Side3, semi);
				System.out.println("The area of the triangle is " + area + "cm^2");
				
			}else{
				System.out.println("Enter a correct Triangle.");	
			}
			
		}
		}else if(presetChosen == 2){
			System.out.print("You chose #2");
		
	}

}
}
