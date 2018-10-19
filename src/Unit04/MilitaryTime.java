package Unit04;

import java.util.*;
import java.io.*;

/*
*/

public class MilitaryTime{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		int t1,  t2, difference;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first time: ");
		t1 = in.nextInt();
		System.out.print("Enter second time: ");
		t2 = in.nextInt();
		
		if(t1<t2){
			difference=t2-t1;
		}else {
			difference = (2360-t1)+t2;
		}
		if(difference%100 == 60){
			difference +=100;
			difference = difference/100*100;
		}
		System.out.println(difference/100 + "hours, " + difference%100 + "minutes");
	}
}