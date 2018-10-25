package Arrays;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        //set up
        String [] words = new String[8];
        Scanner in = new Scanner(System.in);
        String[] vowels = {"a", "e", "i","o","u"};
        //load array
        for (int i = 0; i < words.length; i++) {
            words[i] = in.next();
        }
        //print original
        for(String aWord : words)
            System.out.print(aWord + " ");
        System.out.println();
        for(String aWord : words)
            if(aWord.length()>3)
                System.out.print(aWord + " ");
        System.out.println();
        for(String aWord : words) {
            String test = aWord.substring(0,1);
            for (int i = 0; i < vowels.length; i++) {
                if(test.equalsIgnoreCase(vowels[i])) {
                    System.out.print(aWord + " ");
                    i+=100;
                }
            }
        }
        System.out.println();
        for(String aWord : words)
            if(aWord.substring(0,1).toUpperCase().equals(aWord.substring(0,1)))
                System.out.print(aWord + " ");
        System.out.println();
        //search program
        boolean done = false;
        while(!done) {
            System.out.println("What word to search? 0 to exit");
            String test = in.next();
            if(test.equals("0")){
                done = true;
            } else {
                for (int i = 0; i < words.length; i++) {
                    if(test.equalsIgnoreCase(words[i])){
                        System.out.println("Found string at index " + (i+1));
                        i+=190;
                    }
                }
            }
            System.out.println();
        }
    }
}
