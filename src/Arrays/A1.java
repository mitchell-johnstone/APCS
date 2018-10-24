package Arrays;

import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        System.out.println("Insert 6 integers:");
        Scanner in = new Scanner(System.in);
        int [] arr = new int[6];
        int sum = 0;
        int highest = -1000;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
            sum+=arr[i];
            if(arr[i]>highest)
                highest = arr[i];
        }
        for (int i : arr)
            System.out.print(i);
        System.out.println();
        for (int i = arr.length-1; i >=0; i--)
            System.out.print(arr[i]);
        System.out.println();
        System.out.println("sum: " + sum);
        System.out.println("average: " + (sum/(double)arr.length));
        System.out.println("highest: " + highest);
    }
}
