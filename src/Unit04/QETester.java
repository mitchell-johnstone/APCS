package Unit04;

import java.io.*;

/*
*/

public class QETester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		QE problem1 = new QE(1,-6,9);
		QE problem2 = new QE(1,4,0);
		QE problem3 = new QE(1,-1,1);
		if(problem1.isSolveable()){
			p.println("problem1 answers: " + problem1.getSolution1() + " , " + problem1.getSolution2());
		} else {
			p.println("No solution");
		}
		
		if(problem1.isSolveable()){
			p.println("problem2 answers: " + problem2.getSolution1() + " , " + problem2.getSolution2());
		} else {
			p.println("No solution");
		}
		
		if(problem1.isSolveable()){
			p.println("problem3 answers: " + problem3.getSolution1() + " , " + problem3.getSolution2());
		} else {
			p.println("No solution");
		}
	}
}