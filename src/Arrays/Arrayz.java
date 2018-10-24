package Arrays;

import java.util.Scanner;
import java.io.File;            // input from File
import java.io.IOException;     // Exceptions to Input/Output

/**
 * class Arrayz
 *   Various examples for initializing and accessing Arrays
 */


public class Arrayz
{
    public static void main (String[] args) throws IOException
    {
        int [] arrayOne = new int [4];   // Array of size 4..."INDEX" values from 0 to 3
        arrayOne[0] = 12;
        arrayOne[1] = 14;
        arrayOne[2] = 19;
        arrayOne[3] = 27;

        int sumOne = 0;
        for (int anArrayOne : arrayOne) {
            System.out.print(anArrayOne + " ");
            sumOne = sumOne + anArrayOne;
        }
        System.out.println("  Sum = " + sumOne);
        System.out.println();

        int [] arrayTwo = { 13, 15, 28, 34 };  // assign values directly

        int sumTwo = 0;                  // enhanced for loop
        for (int value : arrayTwo)       // use each 'value' in arrayTwo
        {System.out.print ( value + " ");
            sumTwo = sumTwo + value;  }
        System.out.println(" Sum = " + sumTwo);
        System.out.println();


        String [] stringZ = new String [6];    // create array of Strings
        Scanner in = new Scanner ( new File ("StringFile.txt") );
        // file must be located in project/package

        int w=0;
        while (in.hasNext() )         // read from input file if there is another String
        {stringZ[w] = in.next();    // assign next string to array index
            w++;}
        in.close();

        for (String aStringZ : stringZ) System.out.print(aStringZ + " ");
        System.out.println();
        System.out.println();

        Scanner getNum = new Scanner (System.in);  // create scanner for user input
        double [] numbers = new double [5];
        for ( int q = 0; q < numbers.length ; q++ )
        {System.out.print ( "enter a decimal: ");
//input prompt, assign to current index
            numbers[q] = getNum.nextDouble();}

        for ( int a = numbers.length - 1 ; a >= 0 ; a-- )  // print in reverse order
            System.out.print( numbers[a] + " ");
        System.out.println();
        System.out.println();


        Chair [] diningRoom = new Chair [3];       // Array of Chair object references
        for ( int b = 0; b < diningRoom.length ; b++ )
        { diningRoom[b] = new Chair(9.5 + b,"Chair 2");
            // create a Chair object for each index
            System.out.println ( "chair " + b + ": "+ diningRoom[b].getHeight() ); }
        // access Chair methods
        diningRoom[2].sawLegs();
        System.out.println( "chair 2: " + diningRoom[2].getHeight() );
        System.out.println();


        int [][] table = new int [2][5];       // create 2-D array:  2 rows, 5 columns
        table [0][3] = 45;     // assign value to location row0, column3
        table [1][2] = 67;
        for (int r = 0; r< 2; r++)             //  print out 2-D array
        {for ( int c=0; c<5 ; c++)
            System.out.print( table[r][c] + " " );
            System.out.println();
        }

    }
}
