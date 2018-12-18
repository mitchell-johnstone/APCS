package Unit11;

import java.util.ArrayList;
import java.util.Scanner;

public class ImprovedP1 {
    public static ArrayList<Integer> multiply(ArrayList<Integer> a, int x){
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
        }
        if(x==2) return a;
        else return multiply(a,x-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList <>(0);
        a.add(1);
        Scanner in = new Scanner(System.in);
        System.out.println("What factorial?");
        int x = in.nextInt();
        a = multiply(a,x);
        for (int i = 0; i <a.size(); i++) {
            System.out.print(a.get(i));
        }
        System.out.println();
    }
}
