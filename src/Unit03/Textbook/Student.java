package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class Student{
	public Student(){
		name = "Moonie";
		numOfQuizes = 0;
		sumOfQuizes = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void addQuiz(double score){
		sumOfQuizes += score;
		numOfQuizes++;
	}
	
	public double getTotalScore(){
		return sumOfQuizes;
	}
	
	public double getAverageScore(){
		return sumOfQuizes/numOfQuizes;
	}
		
	private String name;
	private double numOfQuizes;
	private double sumOfQuizes;
}