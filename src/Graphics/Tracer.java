package Graphics;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import javax.swing.JOptionPane;
/*
*/

public class Tracer{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		int r = 255;
		int g = 0;
		int b = 0;
		Color rainbow = new Color(r,g,b);
		Canvas c = new Canvas("Path Tracer TEST", 800,800,Color.BLACK);
		c.setVisible(true);
		c.setInkColor(Color.WHITE);
		Point past ;
		Point current;
		current = c.hoverPoint();
		
		while(true)
		{
			past = current;
			current = c.hoverPoint();
			c.drawLine(past, current);
			rainbow= new Color(r,g,b);
			
		}
	}
}