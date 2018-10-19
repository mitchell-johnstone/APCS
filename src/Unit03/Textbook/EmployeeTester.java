package Unit03.Textbook;

import java.io.*;

/*
*/

public class EmployeeTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		Employee hank = new Employee("Hank", 50000);
		p.println(hank.getName() + "'s salary was: " + hank.getSalary());
		hank.raiseSalary(15);
		p.println(hank.getName() + "'s salary was given a 15% raise: " + hank.getSalary());
	}
}