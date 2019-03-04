package Unit11;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Gibberish {
    public static void main(String[] args) {

        // get the scanner set up to use for user input
        Scanner in = new Scanner(System.in);

        // ask user for a file for giberish
        System.out.print("What file to turn into gibberish? ");
        String name = in.next();

        Gib(name);
    }

    public static void Gib(String name){
        Scanner in = new Scanner(System.in);
        //make the file for gibberish
        File f = new File("src/Unit11/" + name + ".txt");

        // make list of infixes
        String[] infixes = {"ithieg","idig","uddag","uvug","uthug"};

        // Set up random to randomly select an infix
        Random r = new Random();

        // convert scanner to scan the file
        try{
            in = new Scanner(f);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // go through the file, line by line.
        // on every line, split the line into words
        // go through every word, and when there is a vowel,
        // insert the infix into the word
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] words = line.split(" ");
            int i;
            for (String word : words) {
                boolean changed = false;
                for (i = 0; i < word.length(); i++) {
                    switch (word.charAt(i)) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                        case 'y':
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                        case 'Y':
                            changed = true;
                            int n = r.nextInt(5);
                            if(i == 0 && n == 0) word = word.charAt(0) + "thieg" + word;
                            else word = word.substring(0,i) + infixes[n] + word.substring(i);
                    }
                    if(changed) i =10000;
                }
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
