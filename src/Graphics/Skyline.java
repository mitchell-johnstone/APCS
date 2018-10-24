package Graphics;

import java.util.*;
import java.io.*;
import java.awt.*;

/*
*/
public class Skyline{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 825;
	private static final int STARS = 1000;
	private static final int R = 2;
	private static final int BNUM = 10;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		Canvas c = new Canvas("Skyline", WIDTH,HEIGHT,Color.BLACK);
		c.setVisible(true);
		while(true){
			c.setInkColor(Color.white);
			for (int i = 0; i < STARS; i++) {
				int x = r.nextInt(WIDTH);
				int y = r.nextInt(HEIGHT);
				c.drawFilledOval(x,y,R,R);
			}

			for(int i = 0; i<BNUM; i++){
				int t = r.nextInt(HEIGHT/75)*75;
				int x = r.nextInt(WIDTH-80);
				int w = r.nextInt(WIDTH-x-20)+20;
				Building b1 = new Building(c,t,w,x, HEIGHT-t);
				b1.draw();
			}
			c.pause(5000);
			c.erase();
		}
	}
}