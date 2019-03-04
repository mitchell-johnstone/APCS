package Unit11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputGibberish {
    public static void main(String[] args) {
        //Scanner for user input
        Scanner in = new Scanner(System.in);

        String check = " ";

        try {
            //way to write to a file
            FileWriter fileWriter = new FileWriter("src/Unit11/out.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //Get random phrases
            System.out.println("Enter \"out\" to stop input.");
            while (!check.equalsIgnoreCase("out")) {
                check = in.nextLine();
                printWriter.print(check + "\n");
            }
            Gibberish.Gib("out");
        } catch(IOException io){
            io.printStackTrace();
        }

    }
}
