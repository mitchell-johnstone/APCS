package StackyQues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MovieLine {
    public static void main(String[] args) {
        Random r = new Random();
        Queue<Customer> line = new LinkedList <>();
        line.add(new Customer(1,"Customer0"));


        boolean print = false;
        int sumWait = 0;
        int currentTime = 1;
        int currentCustomer = 1;
        while(line.size()>0){
            if(print) {
                System.out.println("\n------------------------------------");
                System.out.println("LINE: ");
            }
            System.out.println(line);
            if(print)
                System.out.println("------------------------------------\n");
            if(r.nextInt()<r.nextInt()){
                line.add(new Customer(currentTime,"Customer" + currentCustomer));
                if(print) {
                    System.out.println();
                    System.out.println("Customer" + currentCustomer + " entered line");
                    System.out.println();
                }
                currentCustomer++;
            }
            if(r.nextInt()<r.nextInt() ){
                Customer c = line.remove();
                int wait = currentTime - c.getStartTime();
                sumWait+=wait;
                if(print) {
                    System.out.println();
                    System.out.println(c + " exited line");
                    System.out.println("they waited for " + wait + " minutes");
                    System.out.println();
                }
            }
            currentTime++;
        }
        System.out.println();
        System.out.println("Total time passed: " + currentTime + " min");
        System.out.println("Average wait time: " + (sumWait*1.0/currentCustomer) + " min");
    }
}
