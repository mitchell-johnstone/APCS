package Unit05;

import java.util.*;
import java.io.*;

/*
*/

public class Card{
	private String c;
	private String number;
	private String suit;
	
	public Card(String tmp){
		c=tmp;
	}
	
	public String getDescription(){
		
		if(c.length() == 3){
			number = c.substring(0,2);
			suit = c.substring(2);
		} else {
			number = c.substring(0,1);
			suit = c.substring(1);
		}
		
		switch(number){
			case"a":
			case "A":
				number = "Ace";
				break;
			case "2":
				number = "Two";
				break;
			case "3":
				number = "Three";
				break;
			case "4":
				number = "Four";
				break;
			case "5":
				number = "Five";
				break;
			case "6":
				number = "Six";
				break;
			case "7":
				number = "Seven";
				break;
			case "8":
				number = "Eight";
				break;
			case "9":
				number = "Nine";
				break;
			case "10":
				number = "Ten";
				break;
			case "j":
			case "J":
				number = "Jack";
				break;
			case "q":
			case "Q":
				number = "Queen";
				break;
			case "k":
			case "K":
				number = "King";
				break;
			default:
				number = "the type";
				suit = "card isn't found.";
				break;
		}
		
		switch(suit){
			case "s":
			case "S":
				suit = "Spades";
				break;
			case "c":
			case "C":
				suit = "Clubs";
				break;
			case "d":
			case "D":
				suit = "Diamonds";
				break;
			case "h":
			case "H":
				suit = "Hearts";
				break;
			default:
				number = "the type";
				suit = "card isn't found.";
				break;
		}
		
		return number + " of " + suit;
	}
}