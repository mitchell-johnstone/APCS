package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class FactorPrinter{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		p.print("Please enter a number to factor: ");
		FactorGenerator f = new FactorGenerator(in.nextInt());
		while(f.hasMoreFactors()){
			p.println(f.nextFactor());
		}
	}
}