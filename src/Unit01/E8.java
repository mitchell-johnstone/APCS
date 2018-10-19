package Unit01;

import java.util.*;
import javax.swing.JOptionPane;

/*
*/

public class E8{
	public static void main(String[] args){
		String name = JOptionPane.showInputDialog("what is your name?");
		System.out.printf("Hello, %s!", name);
		System.exit(0);
	}
}