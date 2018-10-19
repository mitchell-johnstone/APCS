package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class StringSort{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Scanner in = new Scanner(System.in);
		p.println("please enter 3 names:");
		String tmp1 = in.next();
		String tmp2 = in.next();
		String tmp3 = in.next();
		p.println("the inputs in sorted order are: ");
		String small;
		String med; 
		String lar;
		
		if(0>tmp1.compareTo(tmp2)){
			if(0>tmp1.compareTo(tmp3)){
				small = tmp1;
				if(0>tmp3.compareTo(tmp2)){
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
			if(0>tmp2.compareTo(tmp3)){
				small = tmp2;
				if(0>tmp3.compareTo(tmp1)){
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