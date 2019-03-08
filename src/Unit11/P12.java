package Unit11;

import java.util.Scanner;

public class P12 {
    public static void main(String[] args) {
        //double to hold the input sum
        double sum = 0;

        //Scanner to read the vals
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("What value to add?  ");
            //get value as a string
            String tmp = in.nextLine();
            //check if it is a double
            double n = 0;
            try {
                n = Double.parseDouble(tmp);
                sum += n;
            } catch (NumberFormatException e) {
                if(tmp.equalsIgnoreCase("")) break;
            }
        } while(true);

        System.out.println("Sum of the inputs: "+sum);
}
}
