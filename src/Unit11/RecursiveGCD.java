package Unit11;
/**
 * Recursion example for GCD
 * "uncomment" lines to view reverse of recursive solution
 */
import java.util.Scanner; 
public class RecursiveGCD
{
    
 public static int gcd (int a, int b)
 {
   if (b==0)    // 'base' case, b is factor of a
     {
     System.out.println (a);
     return a;
    }
   else
     {
     int next = gcd (b, a % b);   // recursive method
     
     if (b!=0) System.out.println ( b + " " +  (a % b) );
     else System.out.println (b);
   
     return next;
    }
 } 
 
 public static void main (String[] args )
    {
     Scanner in = new Scanner(System.in);
     System.out.println ("Greatest Common Divisor");
     System.out.print("   Enter two integers ");
     int x= in.nextInt(); 
     int y= in.nextInt();   
     System.out.println ( "GCD of " + x + " and " + y + " = " + gcd (x,y) );
    }  
}