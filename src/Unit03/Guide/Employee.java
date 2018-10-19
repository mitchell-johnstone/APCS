package Unit03.Guide;

import java.util.*;
import java.io.*;

/*
*/

public class Employee{
	public Employee(){
		myFirstName = "";
		myLastName = "";
		mySalary = 45000;
	}
	
	public Employee(String first, String last, double sal){
		myFirstName = first;
		myLastName = last;
		mySalary = sal;
	}
	
	public double getSalary(){
		return mySalary;
	}
	
	public void raiseSalary(double byPercent){
		mySalary += mySalary *byPercent*.01;
	}
	
	public double calculateBonusAmount(double byPercent){
		return mySalary*byPercent*.01;
	}
	
	private String myFirstName;
	private String myLastName;
	private double mySalary;
}