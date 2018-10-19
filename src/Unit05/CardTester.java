package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class CardTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		while(true){
		p.println("\nEnter your card: \n(type \"exit\" to exit the program)");
			String c = in.next();
			if(c.equals("exit")){
				break;
			}
			Card card = new Card(c);
			p.println(card.getDescription());
		}
	}
}