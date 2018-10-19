package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class NumberSort{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Scanner in = new Scanner(System.in);
		p.println("please enter 3 numbers:");
		double tmp1 = in.nextDouble();
		double tmp2 = in.nextDouble();
		double tmp3 = in.nextDouble();
		p.println("the inputs in sorted order are: ");
		double small;
		double med; 
		double lar;
		
		if(tmp1<tmp2){
			if(tmp1<tmp3){
				small = tmp1;
				if(tmp3<tmp2){
					med = tmp3;
					lar = tmp2;
				} else {
					med = tmp2;
					lar = tmp3;
				}
			} else {
				small = tmp3;
				med = tmp1;
				lar = tmp2;
			}
		} else {
			if(tmp2<tmp3){
				small = tmp2;
				if(tmp3<tmp1){
					med = tmp3;
					lar = tmp1;
				} else {
					med = tmp1;
					lar = tmp3;
				}
			} else {
				small = tmp3;
				med = tmp2;
				lar = tmp1;
			}
		}
		p.println(small);
		p.println(med);
		p.println(lar);
	}
}