package Bowl;

import java.awt.*;

public class Pin{
	public int x = 0;
	public int y = 0;
	public Canvas c;
	
	public Pin(int xVal, int yVal, Canvas can){
		x=xVal;
		y=yVal;
		c=can;
	}
	
	public void draw(){
		c.setInkColor(Color.YELLOW);
		c.drawFilledOval(x,y,75,75);
	}
	
	public void erase(){
		c.setInkColor(Color.BLACK);
		c.drawFilledOval(x,y,75,75);
	}
}