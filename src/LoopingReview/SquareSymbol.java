package LoopingReview;

import java.util.*;
import java.io.*;

/*
*/

public class SquareSymbol{
	int rows;
	
	public SquareSymbol(){
	}
	
	public void PrintSquare(int p, char s){
		this.PrintSquare(p,s,true);
	}
	
	public void PrintSquare(int p, char s, boolean fill){
		rows = p;
		if(fill){
			for(int i = 0; i<rows; i++){
				for (int j = 0; j<rows; j++){
					System.out.print(s);
				}
				System.out.println();
			}
		} else {
			for(int i = 0; i<rows; i++){
				for (int j = 0; j<rows; j++){
					if(i==0 || i==rows-1 || j==0 || j==rows-1){
						System.out.print(s);
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}