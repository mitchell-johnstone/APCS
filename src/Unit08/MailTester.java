package Unit08;

import java.util.Scanner;

public class MailTester {
    public static void main(String[] args) {
        String test = "";
        Scanner in = new Scanner(System.in);
        Digit[] digits = new Digit[6];
        do{
            for (int i = 0; i < digits.length; i++) {
                digits[i] = null;
            }
            if(test.length()==32) {
                test = test.substring(1,test.length()-1);
                for (int i = 0; i < 6; i++) {
                    digits[i] = new Digit(test.substring(0, 5));
                    test = test.substring(5);
                }
            } else if (test.length() == 5){
                try{
                    int x = Integer.parseInt(test);
                    int total = 0;
                    for (int i = 4; i >= 0; i--) {
                        digits[i] = new Digit(Integer.toString(x%10));
                        total+=x%10;
                        x/=10;
                    }
                    digits[5] = new Digit(Integer.toString(10-total%10));
                } catch(NumberFormatException e){
                    System.out.println("Sorry, input not recognized");
                }
            }
            if(digits[0] != null){
                System.out.print("|");
                for (int i = 0; i < 6; i++) {
                    System.out.print(digits[i].getBarcode());
                }
                System.out.println("|");
                for (int i = 0; i < 6; i++) {
                    System.out.print(digits[i].getNumber());
                }
                System.out.println();
            }
            System.out.println("\nEnter \"Q\" to exit program");
            System.out.print("Enter a barcode or a zip code: ");
            test = in.next();
        } while(!test.equalsIgnoreCase("Q"));
    }
}
