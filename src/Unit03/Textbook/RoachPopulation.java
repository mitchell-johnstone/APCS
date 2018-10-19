package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class RoachPopulation{
	public RoachPopulation(double initial){
		population = initial;
	}
	
	public void breed(){
		population *=2;
	}
	
	public void spray(){
		population *=.9;
	}
	
	public double getPopulation(){
		return population;
	}
	
	private double population;
}