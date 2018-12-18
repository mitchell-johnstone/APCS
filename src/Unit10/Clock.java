package Unit10;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    public static void main(String[] args) {
        Canvas c = new Canvas("Clock", 800,800, Color.black);
        c.setVisible(true);
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        c.setInkColor(Color.white);
        c.drawOval(0,0,800,800);
        int fullRadius = 400;
        int hourRadius = 200;
        int minRadius = 300;
        int secRadius = 349;
        int centerX = 400;
        int centerY = 400;

        int x1, x2, y1, y2 = 0;

        for (int i = 0; i < 360; i+=6) {
            int rad = secRadius + 40;
            if(i%30==0) rad = secRadius;
            x1 = centerX+(int)(rad*Math.cos(Math.toRadians(i)));
            x2 = centerX+(int)(fullRadius*Math.cos(Math.toRadians(i)));
            y1 = centerY+(int)(rad*Math.sin(Math.toRadians(i)));
            y2 = centerY+(int)(fullRadius*Math.sin(Math.toRadians(i)));
            c.drawLine(x1,y1,x2,y2);
        }
//        c.drawLine(400,400,150,150);
        int fudge = -90;
        while(true) {
            Date d = new Date();
            String time = f.format(d);
            time = time.substring(time.length() - 8);

            int hours = Integer.parseInt(time.substring(0,2));
            hours=hours%12;
            int min = Integer.parseInt(time.substring(3,5));
            int sec = Integer.parseInt(time.substring(6));
            x1 = centerX;
            y1 = centerY;

            x2 = centerX + (int)(hourRadius*Math.cos(Math.toRadians(fudge+hours*30+min/2.0)));
            y2 = centerY + (int)(hourRadius*Math.sin(Math.toRadians(fudge+hours*30+min/2.0)));
            c.drawLine(x1,y1,x2,y2);

            x2 = centerX + (int)(minRadius*Math.cos(Math.toRadians(fudge+min*6+sec/10.0)));
            y2 = centerY + (int)(minRadius*Math.sin(Math.toRadians(fudge+min*6+sec/10.0)));
            c.drawLine(x1,y1,x2,y2);

            x2 = centerX + (int)(secRadius*Math.cos(Math.toRadians(fudge+sec*6)));
            y2 = centerY + (int)(secRadius*Math.sin(Math.toRadians(fudge+sec*6)));
            c.drawLine(x1,y1,x2,y2);
            c.pause(500);

            c.setInkColor(Color.black);
            c.drawFilledOval(fullRadius-secRadius, fullRadius-secRadius, secRadius*2,secRadius*2);
            c.setInkColor(Color.white);
        }
    }
}
