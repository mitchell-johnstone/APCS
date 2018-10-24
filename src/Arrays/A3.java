package Arrays;

import java.util.Random;

public class A3 {
    public static void main(String[] args) {
        //array holding random values
        int [] arr = new int[25];
        //random
        Random r = new Random();
        //fill array & track where they belong
        int [] groups = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(50)+1;
            if(arr[i] < 11){
                groups[0]++;
            } else if (arr[i] <21){
                groups[1]++;
            } else if (arr[i] < 31){
                groups[2]++;
            } else if (arr[i] < 41){
                groups[3]++;
            } else {
                groups[4]++;
            }
        }
        //checks how many times it occurred.
        for (int i = 1; i <= 50; i++) {
            System.out.print(i +"occurred " );
            int occurrence = 0;
            for (int anArr : arr) {
                if (i == anArr)
                    occurrence++;
            }
            System.out.println(occurrence + " times");
        }
        //prints histogram
        for (int i = 11; i < 60; i+=10) {
            System.out.print((i-10) +" - " + (i-1) + "\t");
            for (int j = 0; j < groups[i/10-1]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
