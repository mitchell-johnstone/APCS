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
        int tmp = 0;
        for (int i=0;i<2;i++){
            int nhut = r.nextInt(6);
            if(i==0){
                tmp = nhut;
            } else {
                do{
                    tmp = r.nextInt(6);
                } while (tmp == nhut);
            }
            arr.set(tmp,new FlatScreen(32,"twins"));
        }
        System.out.println(Arrays.deepToString(arr.toArray()));
        for (int i = 0; i<arr.size();i++){
            for (int j=i+1;j<arr.size();j++){
                if ((arr.get(i)).equals(arr.get(j))){
                    arr.set(i,new FlatScreen(99, "Vizio FlatScreen"));
                    arr.remove(j);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr.toArray()));

    }
}
