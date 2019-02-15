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
        //first stage
        //add
        correct=0;
        while(correct!=3){
            if(!Add()) correct++;
        }
        //second stage
        //subtract
        correct=0;
        while(correct!=3){
            if(!Sub()) correct++;
        }
        //third stage
        //multiply and divide
        correct=0;
        while(correct!=3){
            if(r.nextDouble()<.5) {
                if (Mul()) correct++;
            }else {
                if (Mul()) correct++;
            }

        }
        //fourth stage
        //random

    }
    public static boolean Add(){
        int firstNum = r.nextInt(10);
        int secondNum = r.nextInt(10);
        return false;
    }
    public static boolean Sub(){
        return false;
    }
    public static boolean Mul(){
        return false;
    }
    public static boolean Div(){
        return false;
    }

}
