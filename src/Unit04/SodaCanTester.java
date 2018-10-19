package Unit04;

import java.io.*;

/*
*/

public class SodaCanTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		SodaCan coke = new SodaCan();
		SodaCan pepsi = new SodaCan(3,5);
		p.println("coke can surface area = " + coke.getSurfaceArea());
		p.println("coke can volume = " + coke.getVolume());
		p.println("pepsi can surface area = " + pepsi.getSurfaceArea());
		p.println("pepsi can volume = " + pepsi.getVolume());
	}
}