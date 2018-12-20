package Unit11;

//maximum number this can get the factorial of is 1695

import java.util.ArrayList;
import java.util.Scanner;

public class ImprovedP1 {
    private static boolean show;
    private static boolean recursive = false;
    private static ArrayList<Integer> multiply(ArrayList<Integer> a, int x){
        int carry = 0;
        for (int i = a.size()-1; i>=0;i--) {
            a.set(i, a.get(i)*x);
            a.set(i, a.get(i)+carry);
            carry = 0;
            if(a.get(i)>9){
                if(i==0){
                    a.add(0,0);
                    i++;
                }
                carry = a.get(i)/10;
                a.set(i,a.get(i)%10);
            }
            if(show)
            System.out.print(a.get(i));
        }
        if(show)
        System.out.println();
        if(recursive) {
            if (x == 2) return a;
            else return multiply(a, x - 1);
        }else {
            return a;
        }
    }

    public static void main(String[] args) {
        while(true){
            ArrayList<Integer> a = new ArrayList <>(0);
            a.add(1);
            Scanner in = new Scanner(System.in);
            System.out.println("What factorial?");
            int x = in.nextInt();
            System.out.println("Recursively? 1 yes, 0 no");
            recursive = in.nextInt()==1;
            System.out.println("Show or not?");
            int tmp = in.nextInt();
            show = tmp==1;
            long first = System.currentTimeMillis();
            if(recursive)a = multiply(a,x);
            else {
                for(; x>=1; x--){
                    a= multiply(a, x);
                }
            }
            for (int i : a) {
                System.out.print(i);
            }
            long last = System.currentTimeMillis();
            System.out.println();
            System.out.println("the process took " + (last - first) + " milliseconds");
            System.out.println();
            System.out.println("There are " + a.size() + " digits");
        }
    }
}
