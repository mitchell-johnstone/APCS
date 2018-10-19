package Triangle;

import java.util.*;
import java.io.*;
import java.lang.*;

/*
*/

public class Triangle{
	private double [] []  points = new double[3][2];
							//[point] [x or y]
	private double [] angles = new double[3]; 
							//a, b, c
	private double [] sides = new double[3];
							//A, B, C
	
	public Triangle(double[][] p){
		points = p;
		
		for (int i = 0; i<3; i++){
			double [][]tmp = new double[2][2];
			for(int j = 0; j<2; j++){
				for(int h = 0; h<2; h++){
					tmp[h][j] = p[h][j];
				}
			}
			sides[i] = getSideLength(tmp);
			i++;
			for(int j = 0; j<2; j++){
				for(int h = 0; h<2; h++){
					tmp[h][j] = p[h+1][j];
				}
			}
			sides[i] = getSideLength(tmp);
			i++;
			for(int j = 0; j<2; j++){
				for(int h = 0; h<2; h++){
					int a = 2;
					if(h ==0 ){
						tmp[h][j] = p[2][j];
					}else{
						tmp[h][j] = p[h-1][j];
					}
				}
			}
			sides[i] = getSideLength(tmp);
		}
		getAngles();
	}
	
	//a * a = b*b + c*c - 2*b*c * cos(A)
	public void getAngles(){
		angles[0] = Math.toDegrees(Math.acos((Math.pow(sides[0], 2) - Math.pow(sides[1], 2) - Math.pow(sides[2], 2))/(-2*sides[1] * sides[2])));
		angles[1] = Math.toDegrees(Math.acos((Math.pow(sides[1], 2) - Math.pow(sides[2], 2) - Math.pow(sides[0], 2))/(-2*sides[2] * sides[0])));
		angles[2] = Math.toDegrees(Math.acos((Math.pow(sides[2], 2) - Math.pow(sides[0], 2) - Math.pow(sides[1], 2))/(-2*sides[0] * sides[1])));
	}
	
	public double getSideLength(double [] [] p){
		return Math.sqrt(Math.pow(p[0][0]-p[1][0],2) + Math.pow(p[0][1] - p[1][1],2));
	}
	
	public String toString(){
		return "This sides of this triangle are " + sides[0] + " , "+ sides[1] + " , "+ sides[2] +
					"\nthe angles of this triangle are " + angles[0] + " , " + angles[1] + " , " + angles[2]; 
	}
}