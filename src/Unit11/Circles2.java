package Unit11;

import java.awt.*;

public class Circles2 {
    public static void circle(Canvas c, int x, int y, int r, int level){
        if(level == 0){
            c.pause(5);
        } else {
            c.drawOval(x,y-r, r*2,r*2);
            circle(c,x,y,r/2,level-1);
            circle(c,x+r,y,r/2,level-1);
        }
    }
    public static void main(String[] args) {
        Canvas c = new Canvas("Circle thingy", 800,800, Color.black);
        c.setVisible(true);
        c.setInkColor(Color.green);
        circle(c,0,400,400,8);
    }
}
