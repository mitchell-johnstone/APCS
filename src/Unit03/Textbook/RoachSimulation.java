package Unit03.Textbook;

import java.io.*;

/*
*/

public class RoachSimulation{
	public static void main(String[] args){
		PrintStream p = System.out;
		RoachPopulation colony = new RoachPopulation(10);
		p.println(colony.getPopulation());
		colony.breed();
		colony.spray();
		p.println(colony.getPopulation());
		colony.breed();
		colony.spray();
		p.println(colony.getPopulation());
		colony.breed();
		colony.spray();
		p.println(colony.getPopulation());
		colony.breed();
		colony.spray();
		p.println(colony.getPopulation());
	}
}