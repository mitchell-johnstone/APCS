package Unit04;

import java.util.*;
import java.io.*;
import java.lang.*;
/*
*/

public class SodaCan{
	private double height;
	private double diameter;
	
	public SodaCan(){
		height = 2;
		diameter = 2;
	}
	
	public SodaCan(double h, double d){
		height = h;
		diameter = d;
	}
	
	public double getVolume(){
		return height*((diameter/2)*(diameter/2) * Math.PI);
	}
	
	public double getSurfaceArea(){
		return 2*((diameter/2)*(diameter/2) * Math.PI) + diameter*Math.PI*height;
	}
}