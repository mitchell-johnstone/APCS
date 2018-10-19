package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class GradeTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Scanner in = new Scanner(System.in);
		p.println("please enter a grade:");
		String input = in.next();
		Grade g = new Grade(input);
		p.println("your gpa is: " + g.getNumericGrade());
	}
}