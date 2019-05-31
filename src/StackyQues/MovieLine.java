package StackyQues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MovieLine {
    public static void main(String[] args) {
        Random r = new Random();
        Queue<Customer> line = new LinkedList <>();
//        line.add(new Customer(0,"Customer1"));

        boolean start = true;
        boolean print = false;
        int sumSize = 0;
        int sumWait = 0;
        int currentTime = 0;
        int currentCustomer = 1;
        int longest = 0;
        int mostWait = 0;
        while(line.size()>0 || start){
            if(print) {
                System.out.println("\n------------------------------------");
                System.out.println("LINE: ");
            }
            System.out.println(line);
            if(print)
                System.out.println("------------------------------------\n");

            //removing from the line
            if(r.nextInt()<r.nextInt() && line.size()>0){
                Customer c = line.remove();
                int wait = currentTime - c.getStartTime();
                if(mostWait < wait) mostWait = wait;
                sumWait+=wait;
                if(print) {
                    System.out.println();
                    System.out.println(c + " exited line");
                    System.out.println("they waited for " + wait + " minutes");
                    System.out.println();
                }
            }

            //adding to the line
            if(r.nextInt()<r.nextInt()){
                line.add(new Customer(currentTime,"Customer" + currentCustomer++));
                start = false;
                if(print) {
                    System.out.println();
                    System.out.println("Customer" + currentCustomer + " entered line");
                    System.out.println();
                }
            }

            //update variables
            sumSize+=line.size();
            currentTime++;
            if(line.size() > longest) longest = line.size();
        }
        System.out.println();
        System.out.println("Total time passed: " + currentTime + " min");
        System.out.println("Longest line made: " + longest + " people");
        System.out.println("Longest wait time: " + mostWait + " min");
        System.out.println("Average wait time: " + (sumWait*1.0/(currentCustomer-1)) + " min");
        System.out.println("Average line length: " + (sumSize*1.0/(currentTime-1)) + " people");
    }
}
