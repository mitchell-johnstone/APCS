package LoopingReview;

import java.util.*;
import java.io.*;

/*
*/

public class SquareTester{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		SquareSymbol s1 = new SquareSymbol();
		SquareSymbol s2 = new SquareSymbol();
		SquareSymbol s3 = new SquareSymbol();
		
		s1.PrintSquare(4,'h');
		s2.PrintSquare(9,'+');
		s3.PrintSquare(2,'%');
		
		s1.PrintSquare(4, 'h', false);
		s2.PrintSquare(8, '+', true);
		s3.PrintSquare(6,'*', false);
		
		SquareSymbol s4 = new SquareSymbol();
		s4.PrintSquare(3,'X', true);
	}
}