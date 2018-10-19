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
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 825;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		Canvas c = new Canvas("Skyline", WIDTH,HEIGHT,Color.BLACK);
		c.setVisible(true);
		while(true){
			for(int i = 0; i*50<WIDTH; i++){
				int t = r.nextInt(HEIGHT/50)*50;
				Building b1 = new Building(c,t,i*50, HEIGHT-t);
				b1.draw();
			}
			c.pause(5000);
			c.erase();
		}
	}
}