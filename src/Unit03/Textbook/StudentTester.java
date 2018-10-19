package Unit03.Textbook;

import java.io.*;

/*
*/

public class StudentTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		Student s = new Student();
		p.println("The student's name is "+ s.getName());
		s.addQuiz(81);
		s.addQuiz(100);
		s.addQuiz(50);
		p.println(s.getName() + " took 3 tests. \nthe total of all the scores is: "+ s.getTotalScore() + "\nThe average score is: " + s.getAverageScore());
	}
}