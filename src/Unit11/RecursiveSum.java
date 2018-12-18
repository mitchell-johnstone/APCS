package Unit11;
/**
 * Simple example of Recursion:  Cumulative Sum
 * Remove // in 2 lines of recursive method and 1 in main to 'view' 'unwinding'
 */
import java.util.Scanner; 
public class RecursiveSum
{
    public static int sum (int num)     // recursive method
    {   int result;
        if ( num ==1 )      // 'base' case,  when only one value left....."1"
            result = 1;
        else
            result = num + sum (num - 1 );  //use current value and add sum from 1 to (n-1)
             
            if (num > 1) System.out.println ( num + " + sum ( " + (num-1) + ") " );
            if (num == 1) System.out.println (num );
        return result;
    }

    public static void main (String[] args )
    {
     Scanner in = new Scanner(System.in); 
     System.out.print("   Enter an integer ");
     int x= in.nextInt();   
     System.out.println ( " Undoing the recursive process " );
     System.out.println ( "Sum of the numbers from 1 to " + x + " is " + sum (x) );
    }  
        
}