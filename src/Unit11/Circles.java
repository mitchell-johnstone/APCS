package Unit11;

import Unit10.Circle;

import java.awt.*;

public class Circles {
    public static void circle(Canvas c, int x, int y, int d, int m){
        if(d<1){
            c.pause(5);
        } else {
            c.drawOval(x,y-d/2,d,d);
            circle(c,x+m,y,d-m, m);
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("Circles 1.0", 800,800, Color.black);
        c.setVisible(true);
        c.setInkColor(Color.orange);
        circle(c,0,400,800,10);
    }
}
