package Unit02;

import java.util.*;
import java.io.*;

/*
*/

public class ReplaceTester{
	public static void main(String[] args){
		PrintStream printer = new PrintStream(System.out);
		printer.println();
		String word = "Mississippi";
		System.out.println(word);
		word = word.replace("i", "!");
		word = word.replace("s", "$");
		System.out.println(word);
	}
}