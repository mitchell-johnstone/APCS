package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class PrimeTester{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		p.print("What  value to go up to?");
		int end = in.nextInt();
		boolean done = false;
		PrimeGenerator g = new PrimeGenerator();
		while(!done){
			int i = g.nextPrime();
			if(i<=end){
				p.println(i);
			}else {
				done = true;
			}
		}
	}
}