package LoopingReview;

import java.util.*;
import java.io.*;

/*
*/

public class Loops {
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopA:");
		loopA();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopB:");
		loopB();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopC:");
		loopC();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopD:");
		loopD();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopE:");
		loopE();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopF:");
		loopF();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("LoopG:");
		loopG();
	}
	
	public static void loopA(){
		int i = 3;
		int sum = 0;
		while(i<=25){
			p.print(i + " ");
			sum+=i;
			i++;
		}
		p.println("\n"+sum);
	}
	
	public static void loopB(){
		int i = 2;
		do{
			p.print(i+ " ");
			i+=2;
		}while(i<=34);
		p.println();
	}
	
	public static void loopC(){
		int i = 29;
		do{
			p.print(i+ " ");
			i-=2;
		}while(i>=1);
		p.println();
	}
	
	public static void loopD(){
		p.println("please enter two characters, and then an integer");
		String c1 = in.next();
		String c2 = in.next();
		int i = in.nextInt();
		for(int j = 0; j<i; j++){
			p.print(c1);	
		}
		p.println();
		for(int j = 0; j<i; j++){
			p.println(c2);
		}
	}
	
	public static void loopE(){
		p.println("please enter 4 integers:");
		int highest= 0;
		int sum = 0;
		int x = 0;
		while(x<4){
			int n = in.nextInt();
			if(n>highest)
				highest = n;
			sum+=n;
			x++;
		}
		p.println("highest number is " + highest);
		p.println("sum of all numbers is " + sum);
	}
	
	public static void loopF(){
		p.println("Please enter some numbers with digits. \nprogram ends when 0 is entered.");
		double min = 10000000;
		double sum = 0;
		double times = 0;
		double cur = in.nextDouble();
		while(cur != 0){
			sum+=cur;
			if(cur<min)
				min = cur;
			times++;
			cur = in.nextDouble();
		}
		p.println("minimum value is " + min);
		p.println("average value is " + (sum/times));
	}
	
	public static void loopG(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<5; j++){
				p.print("$");
			}
			p.println();
		}
	}
}