package Unit03.Textbook;

import java.io.*;

/*
*/

public class CarTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		Car myHybrid = new Car(25);
		myHybrid.addGas(20);
		myHybrid.drive(150);
		p.println("The car was loaded with 20 gallons and drove from 150 miles at 25mpg. \nThe remaining gas is: " + myHybrid.getGasInTank());
	}
}