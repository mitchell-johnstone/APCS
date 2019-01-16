package Unit14;

import java.util.ArrayList;
import java.util.Scanner;

public class Review2{
    public static void main(String[] args) {
        ArrayList<String> goodFood = new ArrayList <>();
        goodFood.add("Broccoli");
        goodFood.add("Peach");
        goodFood.add("Carrot");
        goodFood.add("Apple");
        goodFood.add("Banana");
        boolean end = false;
        Scanner in = new Scanner(System.in);
        while (!end) {
            System.out.println(goodFood);
            System.out.println("What two foods should be swapped?");
            String t1 = in.next();
            String t2 = in.next();
            if(!t1.equalsIgnoreCase(t2)) {
                int b1 = -1, b2 = -1;
                for (int i = 0; i < goodFood.size(); i++) {
                    if(t1.equalsIgnoreCase(goodFood.get(i))) b1 = i;
                    if(t2.equalsIgnoreCase(goodFood.get(i))) b2 = i;
                }
                if(b1>-1 && b2>-1){
                    end = true;
                    String t = goodFood.get(b1);
                    goodFood.set(b1, goodFood.get(b2));
                    goodFood.set(b2, t);
                }
            } else {
                System.out.println("Sorry, those are the same.");
            }
        }
        System.out.println("As you wish.");
        System.out.println(goodFood);
        int indexOfFirstAlphabeticleString = 0;
        int indexOfLastAlphabeticleString = 0;
        for (int i = 1; i < goodFood.size(); i++) {
            if(goodFood.get(i).compareTo(goodFood.get(indexOfFirstAlphabeticleString))>0) indexOfFirstAlphabeticleString=i;
            if(goodFood.get(i).compareTo(goodFood.get(indexOfLastAlphabeticleString))<0) indexOfLastAlphabeticleString=i;
        }
        String t = goodFood.get(indexOfFirstAlphabeticleString);
        goodFood.set(indexOfFirstAlphabeticleString, goodFood.get(indexOfLastAlphabeticleString));
        goodFood.set(indexOfLastAlphabeticleString, t);
        System.out.println();
        System.out.println("Swapped the first and last alphabetical strings");
        System.out.println(goodFood);
        int indexOfLongest = 0;
        int indexOfShortest = 0;
        for (int i = 0; i < goodFood.size(); i++) {
            if(goodFood.get(indexOfLongest).length()<goodFood.get(i).length()) indexOfLongest = i;
            if(goodFood.get(indexOfShortest).length()>goodFood.get(i).length()) indexOfShortest = i;
        }
        t = goodFood.get(indexOfLongest);
        goodFood.set(indexOfLongest, goodFood.get(indexOfShortest));
        goodFood.set(indexOfShortest, t);
        System.out.println();
        System.out.println("Swapped the longest and shortest words.");
        System.out.println(goodFood);
        ArrayList<String> a1 = new ArrayList <>(goodFood.size()/2);
        for (int i = 0; i < goodFood.size()/2; i++) {
            a1.add(goodFood.get(i));
        }
        ArrayList<String> a2 = new ArrayList <>();
        for (int i = a1.size(); i < goodFood.size(); i++) {
            a2.add(goodFood.get(i));
        }
        System.out.println();
        System.out.println("here are 2 seperate arrays:");
        System.out.println(a1);
        System.out.println(a2);

    }
}