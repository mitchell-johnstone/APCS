package Arrays;

import java.util.Scanner;

public class A7 {
    public static void main(String[] args) {
        System.out.println("Please enter a percentage");
        Scanner in = new Scanner(System.in);
        double input = in.nextDouble();
        //first method: 2 parrallel arrays
        int[]cutoff = {93,90,87,83,80,77,73,70,67,63,60};
        String[]grade = {"A", "A-","B+","B","B-","C+","C","C-","D+","D","D-"};
        boolean done = false;
        int i;
        for (i = 0; i < cutoff.length && !done; i++) {
            if(cutoff[i]<=input)
                done=true;
        }
        if(done)
            System.out.println(grade[i-1]);
        else
            System.out.println("F");

        //second method: one 2x11 array

    }
}
