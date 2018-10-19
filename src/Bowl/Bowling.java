package Bowl;

import java.util.*;
import java.awt.*;

public class Bowling{
	public static void main(String[] args){
		int first=0;
		int second=0;
		int total = 0;
		int highest =0;
		Canvas c = new Canvas("Bowling");
		c.setVisible(true);
		c.setSize(525, 1100);
		c.fillBackground(Color.BLACK);
		Pin[][] pins = new Pin[4][4];
		boolean[][] knocked = new boolean [4][4];
		Frame[] card = new Frame[10];
		boolean again = true;
		while(again){
			boolean spare = false;
			boolean strike = false;
			c.fillBackground(Color.BLACK);
			reset(pins, knocked, c);
			cards(card, c);
			c.setInkColor(Color.GREEN);
			c.drawString("HIGH SCORE: " + Integer.toString(highest), 210,500);
			c.setInkColor(Color.YELLOW);
			c.drawFilledRectangle(50,850, 400, 100);
			c.setInkColor(Color.BLACK);
			c.drawString("Click to Roll", 220,900);
			int special=0;
			for(int x=0; x<10; x++){
				first=0;
				second=0;
				total=0;
				for(int y = 0; y<2; y++){
					Point pix = c.waitForClick ();
					if(pix.getX() > 50 && pix.getX() < 450 && pix.getY() > 850 &&  pix.getY() < 950){
						int temp = roll(pins, knocked);
						if(y==-1){
							special += temp;
							card[x].update(temp);
							card[x].big(special + 10 +card[x-1].total);
							y+=100;
							x+=100;
						} else if(y==-2){
							special += temp;
							card[x].update(temp);
						} else if(y==0){
							first = temp;
							card[x].update(first);
							if(strike){
								total += first;
							}
							if(spare){
								if(x!=1){
									card[x-1].big(first + 10+card[x-2].total);
									spare = false;
								} else{
									card[x-1].big(first + 10);
									spare = false;
								}
							}
						} else{
							second = temp;
							if(strike){
								total+=second;
								if(x!=1){
									card[x-1].big(total+10+card[x-2].total);
									strike = false;
								} else {
									card[x-1].big(total+10);
									strike = false;
								}
							}
							card[x].update(second);
							if(!strike && first+second!=10){
								if(x==0){
									card[x].big(first+second);
								} else if(x==9){
									card[x].big(first+second+card[x-1].total);
								} else {
									card[x].big(first+second+card[x-1].total);
								}
							}
						}
					} else {
						y--;
					}
					if(check(knocked)){
						if(y==0){
							strike = true;
						} else {
							spare = true;
						}
						if(x!=9){
							y+=10;
						} else{
							if(spare){
								y-=3;
							} else{
								y-=3;
							}
							reset(pins,knocked,c);
						}
					}
				}
				c.pause(500);
				reset(pins, knocked, c);
			}
			c.setInkColor(Color.YELLOW);
			c.drawFilledRectangle(50,850, 400, 100);
			c.setInkColor(Color.BLACK);
			c.drawString("Play Again??????????", 220,900);
			if(card[9].total > highest){
				highest = card[9].total;
			}
			boolean start = false;
			while(!start){
				Point pix = c.waitForClick ();
				if(pix.getX() > 50 && pix.getX() < 450 && pix.getY() > 850 &&  pix.getY() < 950){
					start = true;	
				}
			}
		}
	}
	
	public static void cards(Frame[] card, Canvas c){
		for(int x =0; x<10; x++){
			if(x==9){
				card[x] = new Frame(3, 50*x, 650, c);
			} else{
				card[x] = new Frame(2, 50*x, 650, c);
			}
			card[x].erase();
			card[x].draw();
		}
	}
	
	public static void reset(Pin[][] pins, boolean[][] knocked, Canvas c){
		for(int x = 0; x<4; x++){
			for (int y = 0; y<4; y++){
				knocked[x][y] = false;
			}
		}
		for(int x = 0; x<4; x++){
			for(int y = 0; y<(4-x); y++){
				pins[x][y] = new Pin(x*125+25+(y*62), y*100+25, c);
				pins[x][y].draw();
				knocked[x][y] = true;
			}
		}
	}
	
	public static boolean check(boolean[][] knocked){
		for(int x = 0; x<4; x++){
			for(int y = 0; y<(4-x); y++){
				if(knocked[x][y]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int roll(Pin[][] pins, boolean[][] knocked){
		int count = 0;
		Random r = new Random();
		for(int x = 0; x<4; x++){
			for(int y = 0; y<(4-x); y++){
				int temp = r.nextInt(2);
				if(temp == 0 && knocked[x][y]){
					knocked[x][y] = false;
					pins[x][y].erase();
					count++;
				}
			}
		}
		return count;
	}
}