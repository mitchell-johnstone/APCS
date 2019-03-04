package Unit11;

//ask user for doubles
//when it's not a number, give them second chance
//if not taken, quit reading
//add all values, print sum

import java.util.Scanner;

public class P11 {
    public static void main(String[] args) {
        //double to hold the input sum
        double sum = 0;

        //Scanner to read the vals
        Scanner in = new Scanner(System.in);

        //booleans for giving them a chance
        boolean firstChance = true;
        boolean secondChance = true;

        do{
            System.out.print("What value to add?  ");
            //get value as a string
            String tmp = in.next();
            //check if it is a double
            double n=0;
            try {
                n = Double.parseDouble(tmp);
                firstChance = true;
                sum+=n;
            } catch(NumberFormatException e){
                if(!firstChance) {
                    secondChance = false;
                } else {
                    System.out.println("That's not a double! try again?");
                    firstChance = false;
                }
            }
        } while(secondChance);

        System.out.println("Sum of the inputs: " + sum);
    }
}
