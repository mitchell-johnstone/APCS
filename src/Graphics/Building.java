package Graphics;

import java.util.*;
import java.io.*;
import java.awt.*;
/*
*/

public class Building{
	public static Scanner in = new Scanner(System.in);
	public static PrintStream p = System.out;
	public static Random r = new Random();
	private int width;
	private int height;
	private Canvas c;
	private int x_;
	private int y_;
	private	int windowWidth = 15;
	private int windowHeight = 15;
	private int beginningX;
	private int beginningY;
	private Color color;
	private boolean [][] windows;
	Building(Canvas c, int height, int width, int x, int y){
		this.height = height;
		this.width = width;
		this.c = c;
		y_=y;
		x_=x;
		color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),200);
		windows = new boolean[height/(windowHeight+5)][width/(windowWidth+5)];
		beginningX = (width%(windowWidth+5))/2;
		beginningY = (height%(windowHeight+5))/2;

		for (int i = 0; i < height/(windowHeight+5); i++) {
			for (int j = 0; j < width/(windowWidth+5); j++) {
				windows[i][j] = r.nextInt(4)==1;
			}
		}
	}
	
	void draw(){
		c.setInkColor(color);
		c.drawFilledRectangle(x_,y_,width, height);

		//draw windows
        Color yellow = new Color(255,215,0, 200);
        Color black = new Color(1,1,1,200);

        for (int i = 0; i < height/(windowHeight+5); i++) {
            for (int j = 0; j < width/(windowWidth+5); j++) {
                if(windows[i][j])
                    c.setInkColor(yellow);
                else
                    c.setInkColor(black);
                c.drawFilledRectangle(x_+beginningX+(windowWidth+5)*j, y_+beginningY+(windowHeight+5)*i,windowWidth,windowHeight);
            }
        }
	}
}