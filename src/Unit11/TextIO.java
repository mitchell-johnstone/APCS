package Unit11;

/**
 *   Short example to input from File
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;      // input from File
import java.io.IOException;     // Exceptions to Input/Output
import java.io.PrintWriter;

public class TextIO
{
    public static void main (String[] args) throws IOException
    {
        FileReader reader = new FileReader( "C:\\Users\\Admin\\Documents\\Coding\\APCS\\src\\Unit11\\Seuss.txt");

//        File reader = new File("C:\\Users\\Admin\\Documents\\Coding\\APCS\\src\\Unit11\\Suess.txt");
        Scanner in = new Scanner (reader);

        // file must be located in project/package
        int count = 0;
        while (in.hasNext() )          // read from input file if there is another String
        {
            System.out.print( in.next()+ " ") ;   // print each new string
            count++;
            if (count % 10 == 0)
                System.out.println();
        }

        System.out.println( "\nString count " + count );

        Scanner another = new Scanner( System.in);

        in.close();    // close scanner and filereader used to access file
        reader.close();
    }
}
