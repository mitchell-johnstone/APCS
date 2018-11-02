package PartnerProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FlatScreenDriver {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1(){
        FlatScreen[] screens = new FlatScreen[5];
        Random r = new Random();
        int largest  = -1, smallest = 1000;
        int largestIndex = -1, smallestIndex = -1;
        for (int i = 0; i < screens.length; i++) {
            screens[i] = new FlatScreen(r.nextInt(50), "screen "+i);
            if(screens[i].getDiagonal()>largest){
                largest=screens[i].getDiagonal();
                largestIndex=i;
            }
            if(screens[i].getDiagonal()<smallest){
                smallest=screens[i].getDiagonal();
                smallestIndex=i;
            }
        }

        System.out.println(Arrays.toString(screens));

        FlatScreen tmp = screens[largestIndex];
        screens[largestIndex] = screens[smallestIndex];
        screens[smallestIndex] = tmp;

        System.out.println(Arrays.toString(screens));
    }

    private static void part2(){
        Random r = new Random();
        ArrayList<FlatScreen> arr = new ArrayList <>();
        for (int i=0; i<6;i++){
            arr.add(new FlatScreen(r.nextInt(25),"Naruto"+i));
        }
        for (int i=0;i<2;i++){
            arr.set(r.nextInt(6),new FlatScreen(32,"twins"+i));
        }



    }
}
