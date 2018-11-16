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
	private static final Star [] STARS = new Star[100];
	private static final Building [] BUILDINGS = new Building[3];
	private static final int R = 1;
	
	private static Canvas c;
	public static void main(String[] args){
		p.println("\n------------------------------------------------------------------------------\n");
		Color black = new Color(0,0,0);
		c = new Canvas("Skyline", WIDTH,HEIGHT,black);
		c.setVisible(true);
		c.setInkColor(Color.white);
		for (int i = 0; i < STARS.length; i++) {
			STARS[i] = new Star(c);
			STARS[i].start();
		}
		while(true) {
			drawBUILDINGS();
			c.setInkColor(Color.white);
			try {
				Thread.sleep(300);
			} catch(Exception e){
			}
			c.erase();
		}
	}
	/*public static void drawSTARS(){
		c.setInkColor(Color.white);
		for (int i = 0; i < STARS.length; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			Point p = new Point(x,y);
			STARS[i] = p;
			c.drawFilledRectangle((int)STARS[i].getX(),(int)STARS[i].getY(),R,R);
		}
	}

	private static void moveSTARS(){
		for (int i = 0; i < STARS.length; i++) {
			double x = STARS[i].getX()+1;
			if(x>WIDTH) x = 0;
			double y = STARS[i].getY();
			Color tmp = c.getPixelColor((int)x,(int)y);
			if(tmp.equals(Color.black)) {
				c.setInkColor(Color.black);
				c.drawFilledRectangle((int)STARS[i].getX(),(int)STARS[i].getY(),R,R);
				STARS[i].setLocation(x,y);
				c.setInkColor(Color.white);
				c.drawFilledRectangle((int) STARS[i].getX(), (int) STARS[i].getY(), R, R);
			}else {STARS[i].setLocation(x,y);}
		}
	}*/

	private static void drawBUILDINGS(){
		for(int i = 0; i<BUILDINGS.length; i++){
			if(BUILDINGS[BUILDINGS.length-1] == null) {
				int t = r.nextInt(HEIGHT / 75) * 75;
				int x = r.nextInt(WIDTH - 80);
				int w = r.nextInt(WIDTH - x - 20) + 20;
				BUILDINGS[i] = new Building(c, t, w, x, HEIGHT - t);
			}
			BUILDINGS[i].draw();
		}
	}
}