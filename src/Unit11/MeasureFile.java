package Unit11;

import java.io.File;
import java.util.Scanner;

public class MeasureFile {
    public static void main(String[] args) {
        //vars for total counts
        int totalLines = 0;
        int totalWords = 0;
        int totalChars = 0;

        //boolean to hold whether or not the file is found
        boolean fileFound = true;

        do {
            //scanner to get user input
            Scanner in = new Scanner(System.in);

            //read the filename given by the user
            System.out.println("\nWhat file to measure?");
            String fileName = in.next();

            //make the file
            File f = new File("src/Unit11/" + fileName + ".txt");

            //connect scanner to file
            try {
                in = new Scanner(f);
            } catch (Exception e) {
                fileFound = false;
            }
            if(fileFound) {
                int sumOfLines = 0;
                int sumOfWords = 0;
                int sumOfChars = 0;
                while (in.hasNextLine()) {
                    sumOfLines++;
                    String line = in.nextLine();
                    sumOfChars += line.length();
                    sumOfWords += line.split(" ").length;
                }
                System.out.println();
                System.out.println("Number of lines: " + sumOfLines);
                System.out.println("Number of words: " + sumOfWords);
                System.out.println("Number of chars: " + sumOfChars);

                //add current numbers to the totals
                totalLines += sumOfLines;
                totalWords += sumOfWords;
                totalChars += sumOfChars;
            }
        }while (fileFound);

        //print totals
        System.out.println();
        System.out.println("total lines: " + totalLines);
        System.out.println("total words: " + totalWords);
        System.out.println("total chars: " + totalChars);
    }
}
