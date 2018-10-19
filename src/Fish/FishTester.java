package Fish;

import java.util.*;

/*
*/

public class FishTester{
	public static void main(String[] args){
		Fish fish1 = new Fish();
		System.out.println(fish1.getWeight());
		fish1.eatMinnow();
		fish1.eatWorms(3);
		System.out.println(fish1.getWeight());
		
		Fish harry = new Fish(2.5, "Harry");
		System.out.println("Harry " + harry.getWeight() + "lbs.");
		harry.eatPlankton();
		System.out.println("Harry " + harry.getWeight() + "lbs.");
		
		Fish carp = new Fish();
		System.out.println("\nCarp " + carp.getWeight() + "lbs.");
		System.out.println("Carp " + carp.getScales() + " scales");
		carp.eatPlankton();
		carp.eatWorms(25);
		System.out.println("\nthe carp ate some stuff...");
		System.out.println("\nCarp " + carp.getWeight() + "lbs.");
		System.out.println("Carp " + carp.getScales() + " scales");
		carp.eatMinnow();
		carp.sharkBite();
		System.out.println("\nThe carp was bitten by a shark!!");
		System.out.println("\nCarp " + carp.getWeight() + "lbs.");
		System.out.println("Carp " + carp.getScales() + " scales");
		
		Scanner in = new Scanner(System.in);
		System.out.println("What weight of new fish?");
		int w = in.nextInt();
		System.out.println("What name of new fish?");
		String n = in.next();
		Fish tmp = new Fish(w, n);
		System.out.println("\n"+ n  + tmp.getWeight() + "lbs.");
		System.out.println(n + " "+tmp.getScales() + " scales");
		tmp.eatPlankton();
		tmp.eatWorms(25);
		System.out.println("\n" + n + " ate some stuff...");
		System.out.println("\n"+n +" "+ tmp.getWeight() + "lbs.");
		System.out.println(n + tmp.getScales() + " scales");
	}
}