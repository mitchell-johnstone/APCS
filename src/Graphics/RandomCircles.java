package Graphics;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import javax.swing.JOptionPane;
/*
*/
public class RandomCircles{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 800;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		p.println("How many circles?");
		Canvas c = new Canvas("Random Circles", WIDTH,HEIGHT,Color.BLACK);
		c.setVisible(true);
		int n = in.nextInt();
		p.println("How fast?");
		int time = in.nextInt();
		for(int i = 0; i!=n; i++){
			drawCircle(c);
			c.pause(time);
		}
	}
	
	public static Color[] colors = {Color.BLACK, Color.BLUE, Color.WHITE,Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.MAGENTA};
	
	public static void drawCircle(Canvas c){
		int w = r.nextInt(WIDTH);
		int h = r.nextInt(HEIGHT);
		int x=r.nextInt(WIDTH-w);
		int y = r.nextInt(HEIGHT-h);
		int cc = r.nextInt(8);
		c.setInkColor(colors[cc]);
		c.drawOval(x,y,w,h);
	}
}