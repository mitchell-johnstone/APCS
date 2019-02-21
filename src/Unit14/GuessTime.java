package Unit14;
import java.util.*;
import java.awt.*;

public class GuessTime{
	public static void main(String[] args){
		Canvas c = new Canvas("Clock",800,800,Color.black);
		c.setVisible(true);
		int hour;
		int minute=0;
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		int hg;
		int mg;
		//full hours
		clockInit(c);
//		drawClock(c,3,23);
		//level one, all full hours.
		int correct = 0;
		while(correct<5){
			hour = r.nextInt(12)+1;
			drawClock(c,hour,0);
			System.out.println("What hour is is?");
			hg = in.nextInt();
			System.out.println("How many minutes?");
			mg = in.nextInt();
			if(hour==hg && minute == mg) {
				correct++;
				System.out.println("Correct!\n");
			} else {
				System.out.println("False, try again!\n");
			}
		}
		//level two, quarter hours too
		correct = 0;
		while(correct<5){
			hour = r.nextInt(12)+1;
			minute = 15*(r.nextInt(4));
			drawClock(c,hour,minute);
			System.out.println("What hour is is?");
			hg = in.nextInt();
			System.out.println("How many minutes?");
			mg = in.nextInt();
			if(hour==hg && minute == mg) {
				correct++;
				System.out.println("Correct!\n");
			} else {
				System.out.println("False, try again!\n");
			}
		}
		//level three, five minutes
		correct = 0;
		while(correct<5){
			hour = r.nextInt(12)+1;
			minute = 5*(r.nextInt(12));
			drawClock(c,hour,minute);
			System.out.println("What hour is is?");
			hg = in.nextInt();
			System.out.println("How many minutes?");
			mg = in.nextInt();
			if(hour==hg && minute == mg) {
				correct++;
				System.out.println("Correct!\n");
			} else {
				System.out.println("False, try again!\n");
			}
		}
		//last level, any number of minutes
		correct = 0;
		while(correct<5){
			hour = r.nextInt(12)+1;
			minute = r.nextInt(60);
			drawClock(c,hour,minute);
			System.out.println("What hour is is?");
			hg = in.nextInt();
			System.out.println("How many minutes?");
			mg = in.nextInt();
			if(hour==hg && minute == mg) {
				correct++;
				System.out.println("Correct!\n");
			} else {
				System.out.println("False, try again!\n");
			}
		}
		System.out.println("Contrats! You know how to read a clock!");
	}

	public static void clockInit(Canvas c){
		c.erase();
		c.setInkColor(Color.white);
		c.drawOval(0,0,800,800);
		for(int i = 0; i<60; i++){
			int rad = 375;
			if(i%5==0) rad = 350;
			int x1 = (int) (400+rad*Math.cos(Math.toRadians(i*6)));
			int y1 =  (int)(400 + rad * Math.sin(Math.toRadians(i*6)));
			rad = 400;
			int x2 =  (int)(400+rad*Math.cos(Math.toRadians(i*6)));
			int y2 =  (int)(400 + rad * Math.sin(Math.toRadians(i*6)));
			c.drawLine(x1,y1,x2,y2);
//			try {
//				c.wait(50);
//			} catch(Exception e){
//				e.printStackTrace();
//			}
		}
	}

	public static void drawClock(Canvas c, int hour, int min){
		c.setInkColor(Color.black);
		int r = 350;
		c.drawFilledOval(400-r,400-r,2*r,2*r);
		c.setInkColor(Color.white);
		int x1 = 400;
		int y1 = 400;
		int x2 =  (int) (400+200*Math.cos(Math.toRadians(-90+30*hour + .5*min)));
		int y2 =  (int) (400+200*Math.sin(Math.toRadians(-90+30*hour + .5*min)));
		c.drawLine(x1,y1,x2,y2);
		x2 = (int)(400+300*Math.cos(Math.toRadians(-90+6*min)));
		y2 = (int)(400+300*Math.sin(Math.toRadians(-90+6*min)));
		c.drawLine(x1,y1,x2,y2);
	}
}
