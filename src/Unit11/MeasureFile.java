package Unit11;

import java.io.File;
import java.util.Scanner;

public class MeasureFile {
    public static void main(String[] args) {
        //scanner to get user input
        Scanner in = new Scanner(System.in);
        //read the filename given by the user
        System.out.println("What file to measure?");
        String fileName = in.next();
        //make the file
        File f = new File("src/Unit11/" + fileName + ".txt");
        //connect scanner to file
        try {
            in = new Scanner(f);
        } catch(Exception e){
            e.printStackTrace();
        }
        int sumOfLines=0;
        int sumOfWords=0;
        int sumOfChars=0;
        while(in.hasNextLine()){
            sumOfLines++;
            String line = in.nextLine();
            sumOfChars+=line.length();
            sumOfWords+=line.split(" ").length;
        }
        System.out.println("Number of lines: " + sumOfLines);
        System.out.println("Number of words: " + sumOfWords);
        System.out.println("Number of chars: " + sumOfChars);

    }
}
