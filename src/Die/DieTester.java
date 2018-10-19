package Die;

import java.util.*;
import java.io.*;

/*
*/

public class DieTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		Die d1 = new Die();
		Random r = new Random();
		Die d2 = new Die(r.nextInt(9)+2);
		d1.roll();
		d2.roll();
		p.println("the value of the first die is " + d1.getValue());
		p.println("the value of the second die is " + d2.getValue());
		p.println("the sum of this is " + d1.addTwoDie(d2));
		Die d3 = new Die(r.nextInt(11)+3);
		d1.roll();
		d2.roll();
		d3.roll();
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("the value of the first die is " + d1.getValue());
		p.println("the value of the second die is " + d2.getValue());
		p.println("the value of the third die is " + d3.getValue());
		p.println("the sum of this is " + d1.addThreeDie(d2, d3));
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("there are " + Die.getNumberDice() + " dice currently in play");
		p.println("\n------------------------------------------------------------------------------\n");
		Die d4 = new Die();
		d1.roll();
		d2.roll();
		d3.roll();
		d4.roll();
		p.println("the value of the first die is " + d1.getValue());
		p.println("the value of the second die is " + d2.getValue());
		p.println("the value of the third die is " + d3.getValue());
		p.println("the value of the fourth die is " + d4.getValue());
		p.println("the sum of this is " + (d1.addTwoDie(d2) + d3.addTwoDie(d4)));
	}
}