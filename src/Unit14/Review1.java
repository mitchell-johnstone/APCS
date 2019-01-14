package Unit14;
import java.util.*;

public class Review1{
    public static void main(String[] args){
        Random r = new Random();
        int[] a = new int[10];
        System.out.println("Original array:");
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = 100+ r.nextInt(900);
            System.out.print(a[i]+", ");
            sum += a[i];
        }
        System.out.println();
        int average = sum/10;
        System.out.println("Average is "+ average);
        System.out.println("All values over average is :");
        for (int i = 0; i < a.length; i++) {
            if(a[i]>average) System.out.print(a[i]+", ");
        }
        System.out.println();
        int highestVal = 0;
        int lowestVal = 10000;
        int highestIndex = -1;
        int lowestIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<lowestVal){
                lowestIndex = i;
                lowestVal = a[i];
            }
            if(a[i]>highestVal){
                highestVal = a[i];
                highestIndex = i;
            }
        }
        int t = a[lowestIndex];
        a[lowestIndex] = a[highestIndex];
        a[highestIndex] = t;
        System.out.println("Swapped smallest and largest values:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        int tmpHigh = highestVal;
        int tmpLow = lowestVal;
        lowestIndex=-1;
        highestIndex=-1;
        lowestVal=10000;
        highestVal=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<lowestVal && a[i] != tmpLow){
                lowestIndex = i;
                lowestVal = a[i];
            }
            if(a[i]>highestVal && a[i] != tmpHigh){
                highestVal = a[i];
                highestIndex = i;
            }
        }
        t = a[lowestIndex];
        a[lowestIndex] = a[highestIndex];
        a[highestIndex] = t;
        System.out.println("Swapped second smallest and second largest values:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        int [] a1 = new int[5];
        int [] a2 = new int[5];
        for (int i = 0; i < a.length/2; i++) {
            a1[i] =a[i];
            a2[i] = a[i+5];
        }
        System.out.println("array 1:");
        for (int i = 0; i < 5; i++) {
            System.out.print(a1[i]+", ");
        }
        System.out.println();
        System.out.println("array 2:");
        for (int i = 0; i < 5; i++) {
            System.out.print(a2[i]+", ");
        }
    }
}