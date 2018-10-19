package Unit03.Guide;

import java.util.*;
import java.io.*;

/*
*/

public class Book{
	public Book(){
		title = "";
		author = "";
		price = 0.0;
	}
	
	public Book(String t, String a, double p){
		title = t;
		author = a;
		price = p;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void giveDiscount(double byPercent){
		price = price * byPercent*.01;
	}
	
	private String title;
	private String author;
	private double price;
}