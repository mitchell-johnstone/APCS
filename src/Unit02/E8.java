package Unit02;

import java.util.*;

/*
*/

public class E8 {
	public static void main(String[] args){
		System.out.println("Hey, you. \nWant a really cool list of numbers that could possibly give you a ton of money? \nTake this. It will help you on your journey.");
		Random r = new Random();
		for(int i = 0; i<6; i++){
			System.out.print(r.nextInt(50) + " ");
		}
		System.out.println();
	}
}