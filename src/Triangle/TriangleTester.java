package Triangle;

import java.util.*;
import java.io.*;

/*
*/

public class TriangleTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Scanner in = new Scanner(System.in);
		double [][] points = new double[3][2];
		for(int i = 0; i<3; i++){
			for(int j = 0; j<2; j++){
				if(j==0){
					p.print("X");
				}else {
					p.print("Y");
				}
				p.print(i+ "?  :  ");
				points[i][j] = in.nextDouble();
			}
		}
		p.println();
		Triangle t1 = new Triangle(points);
		p.println(t1);
	}
}