package Unit11;

import java.util.Scanner;

public class P3 {
    public static int BaseAndPower(int b, int p){
        if(p == 0 ) return 1;
        else return b*BaseAndPower(b,p-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("what base?");
        int b = in.nextInt();
        System.out.println("what power?");
        int p = in.nextInt();
        System.out.println(b +" to the power of " + p + " is "+ BaseAndPower(b,p));
    }
}
