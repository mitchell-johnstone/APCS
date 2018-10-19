package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class Grade {
	private String grade;
	private String gpa;
	
	public Grade(String g){
		grade = g;
		calculateGrade();
	}
	
	private void calculateGrade(){
		double tmp = 0;
		char letter;
		if(grade.length() >0){
			letter = grade.charAt(0);
			if(letter == 'a' || letter == 'A'){
				tmp = 4;
			} else if(letter == 'b' || letter == 'B'){
				tmp = 3;
			} else if(letter == 'c' || letter == 'C'){
				tmp = 2;
			} else if(letter == 'd' || letter == 'D'){
				tmp = 1;
			} else if(letter == 'f' || letter == 'F'){
				tmp = 0;
			} else {
				tmp = -1;
			}
			if (grade.length() == 2){
				char sign = grade.charAt(1);
				if(sign == '+'){
					tmp +=.3;
				} else if(sign == '-'){
					tmp -=.3;
				} else {
					tmp = -1;
				}
			}
			if(tmp >4.0){
				tmp = 4.0;
			} 
			if (tmp == .3 || tmp == -.3){
				tmp = 0;
			}
			gpa = Double.toString(tmp);
			if(tmp == -1){
				gpa = "Letter grade not applicable";
			}
		}else {
			gpa = "Letter grade not applicable";
		}
	}
	
	public String getNumericGrade(){
		return gpa;
	}
}