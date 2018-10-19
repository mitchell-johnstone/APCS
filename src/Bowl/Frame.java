package Bowl;

import java.awt.*;

public class Frame{
	public int x = 0;
	public int y = 0;
	public int slots = 0;
	public int curSlot = 0;
	public int first = 0;
	public int second = 0;
	public int total = 0;
	public Canvas c;
	
	public Frame(int slot, int xVal, int yVal, Canvas can){
		x=xVal;
		y=yVal;
		c=can;
		slots = slot;
	}
	
	public void draw(){
		c.setInkColor(Color.BLUE);
		if(slots == 3){
			c.drawRectangle(x,y,75,75);
			c.drawRectangle(x,y,25,25);
			c.drawRectangle(x+25,y,25,25);
			c.drawRectangle(x+50,y,25,25);
		} else{
			c.drawRectangle(x,y,50,75);
			c.drawRectangle(x,y,25,25);
			c.drawRectangle(x+25,y,25,25);
		}
	}
	
	public void erase(){
		c.setInkColor(Color.BLACK);
		c.drawFilledRectangle(x,y,50,75);
		c.drawRectangle(x,y,25,25);
		c.drawRectangle(x+25,y,25,25);
	}
	
	public void big(int val){
		total = val;
		c.drawString(Integer.toString(val), x+20,y+50);
	}
	
	public void update(int val){
		curSlot++;
		c.setInkColor(Color.BLUE);
		if(val<10){
			if (first+val == 10){
				c.drawLine(x+25,y,x+50,y+25);
			} else {
				if(curSlot == 1){
					first=val;
					c.drawString(Integer.toString(val), x+10,y+15);
				} else if (curSlot == 3){
					c.drawString(Integer.toString(val), x+60,y+15);
				} else {
					c.drawString(Integer.toString(val), x+35,y+15);
				}
			}
		} else{
			c.drawLine(x,y,x+25, y+25);
			c.drawLine(x+25,y,x,y+25);
		}
	}
}