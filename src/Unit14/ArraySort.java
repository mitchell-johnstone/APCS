package Unit14;

import java.util.Arrays;
// Example using sort method of Arrays class
// Develop method that determines the &#39;median&#39; value of Array
// ( make sure it handles both &#39;even&#39; and &#39;odd&#39; array length)
public class ArraySort
{
    public static void main (String[] args)
    {
        int [] arrayOne = new int [5]; // Array
        arrayOne[0] = 19;
        arrayOne[1] = 14;
        arrayOne[2] = 32;
        arrayOne[3] = 27;
        arrayOne[4] = 20;
        int sumOne = 0;
        for ( int y = 0; y< arrayOne.length ; y++ ) // print out array and sum
        {System.out.print ( arrayOne[y] + " " );
            sumOne = sumOne + arrayOne[y]; }
        System.out.println(" Sum = " + sumOne);
        System.out.println();
        Arrays.sort(arrayOne); // call SORT method of Arrays class
        for ( int h = 0; h< arrayOne.length ; h++ ) // print out sorted array
        {System.out.print ( arrayOne[h] + " " );}
        System.out.println();
// print sorted array using default toString format
        System.out.println(Arrays.toString(arrayOne));

        int starting = 0;
        int ending = arrayOne.length-1;
        while(starting+1<ending){
            starting++;
            ending--;
        }
        double median = (arrayOne[starting]+arrayOne[ending])/2.0;
        System.out.println(median);
    }
}