package Graphics;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import javax.swing.JOptionPane;
/*
*/

public class Building{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	private final int WIDTH = 50;
	private int height;
	private Canvas c;
	private int x_;
	private int y_;
	public Building(Canvas c, int height, int x, int y){
		this.height = height;
		this.c = c;
		y_=y;
		x_=x;
	}
	public static Color[] colors = { Color.BLUE, Color.WHITE,Color.RED, Color.GREEN, Color.MAGENTA};
	
	public void draw(){
		c.setInkColor(colors[r.nextInt(colors.length)]);
		c.drawFilledRectangle(x_,y_,WIDTH, height);
		int tmp = height;
		for(int i =1; 825-i*21-6>y_;i++){
			int y=825-i*21-3;
			if(r.nextInt(4)==1)
				c.setInkColor(Color.YELLOW);
			else 
				c.setInkColor(Color.BLACK);
			c.drawFilledRectangle(x_+6, y,15,15);
			if(r.nextInt(4)==1)
				c.setInkColor(Color.YELLOW);
			else 
				c.setInkColor(Color.BLACK);
			c.drawFilledRectangle(x_+WIDTH-21, y,15,15);
		}
	}
}