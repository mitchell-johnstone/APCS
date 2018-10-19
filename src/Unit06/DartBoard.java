package Unit06;

import java.util.*;
import java.io.*;
import java.math.*;
/*
*/

public class DartBoard{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("enter the test sample: ");
		int n = in.nextInt();
		p.println("\n------------------------------------------------------------------------------\n");
		double hits = 0;
		double tries;
		for(tries = 0; tries<n; tries++){
			double x = r.nextDouble()*2-1;
			double y = r.nextDouble()*2-1;
			double maxY = Math.sqrt(1-x*x);
			if(maxY>y && maxY*-1<y){
				hits++;
			}
		}
		p.println(hits);
		p.println(tries);
		
		p.println(hits/tries*4);
	}
}