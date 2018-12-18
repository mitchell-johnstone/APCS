package Unit11;

import java.util.Scanner;

public class P2 {
    public static boolean show=true;
    public static int Fibonacci(int a, int b, int numberOfTimes){
        if(show) System.out.println(a);
        if(numberOfTimes==0) return a;
        else return Fibonacci(b, b+a, numberOfTimes-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Show? 1 = yes, 0 = no");
        int temp = in.nextInt();
        show = temp==1;
        System.out.println("which index in the fibonacci number?");
        int n = in.nextInt();
        System.out.println("\n"+Fibonacci(0, 1, n-1));
    }
}
