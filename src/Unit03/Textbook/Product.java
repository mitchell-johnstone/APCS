package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class Product{
	public Product(String n, double p){
		name = n;
		price = p;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void reducePrice(double reduction){
		price -= reduction;
	}

	private String name;
	private double price;
}