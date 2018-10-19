package Graphics;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import javax.swing.JOptionPane;
/*
*/

public class CheckerBoard{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	
	public static final int HEIGHT = 800;
	public static final int WIDTH = 800;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		Canvas c = new Canvas("Checker Board", WIDTH,HEIGHT,Color.BLACK);
		c.setVisible(true);
		for(int x = 0; x<8; x++){
			for (int y = 0; y<8; y++){
				if((x+y)%2==0)c.setInkColor(Color.BLACK);
				else c.setInkColor(Color.RED);
				c.drawFilledRectangle(x*100,y*100,100,100);
			}
		}
	}
}