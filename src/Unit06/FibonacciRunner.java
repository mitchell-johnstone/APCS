package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class FibonacciRunner{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		
		p.print("Enter n: ");
		int n = in.nextInt();
		p.println("\n------------------------------------------------------------------------------\n");
		
		FibonacciGenerator fg = new FibonacciGenerator();
		
		for(int i = 0; i<n; i++){
			p.println(fg.nextNumber());
		}
	}
}