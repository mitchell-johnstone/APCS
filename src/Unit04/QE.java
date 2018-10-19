package Unit04;

import java.util.*;
import java.io.*;
import java.lang.*;
/*
*/

public class QE{
	public double a, b, c;
	
	public QE (){
		a=1;
		b=2;
		c=1;
	}
	public QE(double aVal, double bVal, double cVal){
		a = aVal;
		b = bVal;
		c = cVal;
	}
	
	public boolean isSolveable(){
        return !(0 > b * b - 4 * a * c);
    }
	public String getSolution1(){
		double temp = b*b-4*a*c;
		if(temp<0){
			return "N/A";
		} else {
			double temp2 = -1*b+Math.sqrt(temp);
			return Double.toString(temp2/(2*a));
		}
	}
	public String getSolution2(){
		double temp = b*b-4*a*c;
		if(temp<0){
			return "N/A";
		} else {
			double temp2 = -1*b-Math.sqrt(temp);
			return Double.toString(temp2/(2*a));
		}
	}
}