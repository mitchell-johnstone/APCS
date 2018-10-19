package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class Car{
	
	public Car(double milesPerGallon){
		gallons = 0;
		mpg = milesPerGallon;
	}
	
	public void addGas(double gas){
		gallons += gas;
	}
	
	public void drive(double miles){
		gallons -= miles/mpg;
	}
	
	public double getGasInTank(){
		return gallons;
	}
	
	private double mpg;
	private double gallons;
}