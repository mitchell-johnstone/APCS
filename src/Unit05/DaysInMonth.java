package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class DaysInMonth{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Scanner in = new Scanner(System.in);
		p.println("please enter a month (1-12) : ");
		
	int month = in.nextInt();
	
		Month m = new Month (month);
		p.println(m.getDays() + " days");
	}
}