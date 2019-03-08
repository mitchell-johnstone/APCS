package Unit11;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class InputGibberish {
    public static void main(String[] args) {
        //Scanner for user input
        Scanner in = new Scanner(System.in);

        String check = " ";

        try {
            //way to write to a file
            File f = new File("src/Unit11/out.txt");
            PrintStream p =new PrintStream(f);

            //Get random phrases
            System.out.println("Enter \"out\" to stop input.");
            do {
                p.print(check + "\n");
                check = in.nextLine();
            }while (!check.equalsIgnoreCase("out"));

            p.close();

            //call Gibberish method to code file
            Gibberish.Gib("out");
        } catch(IOException io){
            io.printStackTrace();
            System.out.println("Sorry, something went wrong with the file handling");
        }

    }
}
