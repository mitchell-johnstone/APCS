package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class Employee{
	public Employee(String n, double s){
		name = n;
		salary = s;
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public void raiseSalary(double byPercent){
		salary += salary*byPercent/100;
	}
	
	private String name;
	private double salary;
}