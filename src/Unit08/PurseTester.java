package Unit08;

import java.util.Scanner;

public class PurseTester {
    public static void main(String[] args) {
        Purse myPurse = new Purse();
        Scanner in = new Scanner(System.in);
        String s = "";
        do{
            s=s.toLowerCase();
            Coin c = null;
            switch (s){
                case "quarter":
                    c = new Coin(.25, "Quarter");
                    break;
                case "dime":
                    c = new Coin(.10, "Dime");
                    break;
                case "nickel":
                    c = new Coin(.05, "Nickel");
                    break;
                case "penny":
                    c = new Coin(.01, "Penny");
                    break;
            }
            if(c!=null){
                myPurse.add(c);
            }
            System.out.println("\nwhat coin should be added to purse?");
            System.out.println("(type \"n\" to exit)");
            s=in.next();
        } while (!s.equalsIgnoreCase("n"));
        /*Coin quarter = new Coin(.25, "Quarter");
        Coin dime = new Coin(.10, "Dime");
        for (int i = 0; i < 3; i++) {
            myPurse.add(quarter);
        }
        myPurse.add(dime);*/
        System.out.println("\n\nTotal of all coins: " + myPurse.getTotal());
        System.out.println("Average Coin Value = " + myPurse.getAverage());
    }
}
