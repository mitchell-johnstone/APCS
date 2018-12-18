package Unit11;

import java.util.Scanner;

public class P1 {
    private static int RecursiveFactorial(int n){
        if(n<0) return 0;
        else if (n==1 || n==0) return 1;
        else return n*RecursiveFactorial(n-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the number to factorial:");
        int original = in.nextInt();
        int total = 1;
        for (int n = original; n >0 ; n--) {
            total*=n;
        }
        System.out.println("with iterative");
        System.out.println(total);
        System.out.println("with recursion");
        System.out.println(RecursiveFactorial(original));
    }
}
