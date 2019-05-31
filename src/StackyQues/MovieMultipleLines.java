package StackyQues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MovieMultipleLines {
    public static void main(String[] args) {
        Queue[] lines = {new LinkedList <Customer>(),new LinkedList <Customer>(),new LinkedList <Customer>()};
        Random r = new Random();

        int sumWait = 0;
        int currentTime = 0;
        int currentCustomer = 1;
        boolean start = true;
        while(start || (lines[0].size()>0 && lines[1].size()>0 && lines[2].size()>0)){

            //adding customers
            while(r.nextInt() < r.nextInt()){
                start = false;
            }

            //removing customers
            while(r.nextInt() < r.nextInt()){

            }

            //printing
            for(int i = 0; i<lines.length; i++){
                System.out.println("QUEUE " + i + ": " + lines[i]);
            }
            System.out.println();

            currentTime++;
        }
    }
}
