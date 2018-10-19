package Unit06;

import java.util.*;
import java.io.*;

/*
*/

public class DataSet{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		boolean done = false;
		double sum = 0;
		double sumOfSquares = 0;
		double times = 0;
		while(!done){
			p.print("Enter a double. Or enter Q to quit:");
			String input = in.next();
			if(input.equalsIgnoreCase("Q")){
				done = true;
			}else {
				try{
					sum+=Double.parseDouble(input);
					sumOfSquares +=Double.parseDouble(input)*Double.parseDouble(input);
					times++;
				}catch(Exception E){
					p.println("Sorry, not a double or Q. Try Again.");
				}
			}
		}
		double ave = sum/times;
		p.println("average is: " +ave);
		double deviation = Math.sqrt((sumOfSquares-1/times*(Math.pow(sum,2)))/(times-1));
		p.println("The standard Deviation is: " + deviation);
	}
}