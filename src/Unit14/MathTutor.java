package Unit14;

import java.util.Random;
import java.util.Scanner;

public class MathTutor {
    public static int correct;
    public static Random r;
    public static Scanner in;
    public static void main(String[] args){
        r = new Random();
        in = new Scanner(System.in);
	System.out.println("First test, addition!");
        //first stage
        //add
        correct=0;
        while(correct!=3){
            if(Add()){
		 correct++;
		 System.out.println("Correct!");
	    } else {
		 System.out.println("Sorry, incorrect");
	    }
        }
	System.out.println("Second test, Subtraction!");  
        //second stage
        //subtract
        correct=0;
        while(correct!=3){
            if(Sub()){
		    correct++;
		    System.out.println("Correct!");
	    } else {
		 System.out.println("Sorry, incorrect");
	    }
        }
        //third stage
        //multiply and divide
	System.out.println("Next test, multiplication and division!");
        correct=0;
        while(correct!=3){
            if(r.nextDouble()<.5) {
                if (Mul()) {
			correct++;
			System.out.println("Correct!");
		}else{
			System.out.println("Sorry, incorrect");
		}
            }else {
                if (Div())  {
			correct++;
			System.out.println("Correct!");
		}else{
			System.out.println("Sorry, incorrect");
		}
            }

        }
	System.out.println("final test, RANDOM!");
        //fourth stage
        //random
	correct = 0;
	while(correct != 3){
		double probability = r.nextDouble();
		boolean passed = false;
		if(probability <.25){
			passed = Add();
		} else if(probability < .5){
			passed = Sub();
		} else if(probability < .75){
			passed = Mul();
		} else {
			passed = Div();
		}
		if(passed){
			System.out.println("Correct!");
			correct++;
		}else{
			System.out.println("Sorry, incorrect");
		}
	}
	System.out.println("congrats! YOU PASSED!! \n wish you all the best!");
    }
    public static boolean Add(){
        int firstNum = r.nextInt(10);
        int secondNum = r.nextInt(10);
	    System.out.print(firstNum + " + " + secondNum + " = ? ");
	    int guess = in.nextInt();
	    System.out.println();
        return guess == firstNum + secondNum;
    }
    public static boolean Sub(){
	    int firstNum = r.nextInt(10);
	    int secondNum = r.nextInt(10);
	    System.out.print( firstNum + " - " + secondNum + " = ? ");
	    int guess = in.nextInt();
	    System.out.println();
        return guess == firstNum - secondNum;
    }
    public static boolean Mul(){
        int firstNum = r.nextInt(10);
        int secondNum = r.nextInt(10);
	    System.out.print(firstNum + " * " + secondNum + " = ? ");
	    int guess = in.nextInt();
	    System.out.println();
        return guess == firstNum * secondNum;
    }
    public static boolean Div(){
        int firstNum = r.nextInt(10);
        int secondNum = r.nextInt(10);
	while(firstNum%secondNum!=0){
		secondNum = r.nextInt(10);
	}
	    System.out.print(firstNum + " / " + secondNum + " = ? ");
	    int guess = in.nextInt();
	    System.out.println();
        return guess == firstNum / secondNum;
    }

}
