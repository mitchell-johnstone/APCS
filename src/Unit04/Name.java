package Unit04;

import java.util.*;
import java.io.*;

/*
*/

public class Name{
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("\n------------------------------------------------------------------------------\n");
		String s = "Leighton";
		p.println(s.charAt(0));
		p.println(s.charAt(s.length()-1));
		p.println(s.substring(1));
		p.println(s.substring(0,s.length()-1));
	}
}