package Unit03.Textbook;

import java.io.*;

/*
*/

public class ProductTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		Product p1 = new Product("Toaster", 29.99);
		Product p2 = new Product("Computer", 259.00);
		p.println(p1.getName() + ": " + p1.getPrice());
		p.println(p2.getName() + ": " + p2.getPrice());
		p1.reducePrice(5);
		p2.reducePrice(5);
		p.println();
		p.println(p1.getName() + ": " + p1.getPrice());
		p.println(p2.getName() + ": " + p2.getPrice());
	}
}