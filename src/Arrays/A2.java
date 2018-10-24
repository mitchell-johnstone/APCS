package Arrays;

import java.util.Random;

public class A2 {
    public static void main(String[] args) {
        Random r = new Random();
        int [] numberArray = new int[10];
        int sum = 0;
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i]=r.nextInt(41)-20;
            sum+=numberArray[i];
        }
        for(int i : numberArray)
            System.out.print(i + " ");
        double average = sum/(double)numberArray.length;
        System.out.print("average: " + average);
        for(int i: numberArray)
            if(i<average) {
                System.out.print(i);
            }
        for(int i: numberArray)
            if(i<0)
                System.out.print(i);
        for(int i: numberArray)
            if(i%2==1)
                System.out.print(i);

    }
}
