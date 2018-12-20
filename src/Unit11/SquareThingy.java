package Unit11;

import java.awt.*;

public class SquareThingy {
    public static void squareThingy(Canvas c, int level, int length, int x, int y, int startingAngle){

        if(level == 0) {
            c.drawLine(x,y,x+(int)(length*Math.cos(Math.toRadians(startingAngle))), y+(int)(length*Math.sin(Math.toRadians(startingAngle))));
            c.pause(5);
        } else {
            length/=3;
            squareThingy(c, level-1, length, x,y,startingAngle);
            int x_ = (int)(x+length*Math.cos(Math.toRadians(startingAngle)));
            int y_ = (int)(y+length*Math.sin(Math.toRadians(startingAngle)));
            squareThingy(c,level-1,length,x_,y_,startingAngle-90);
            x_ = (int)(x_+length*Math.cos(Math.toRadians(startingAngle-90)));
            y_ = (int)(y_+length*Math.sin(Math.toRadians(startingAngle-90)));
            squareThingy(c,level-1,length,x_,y_,startingAngle);
            x_ = (int)(x_+length*Math.cos(Math.toRadians(startingAngle)));
            y_ = (int)(y_+length*Math.sin(Math.toRadians(startingAngle)));
            squareThingy(c,level-1,length,x_,y_,startingAngle+90);
            x_ = (int)(x_+length*Math.cos(Math.toRadians(startingAngle+90)));
            y_ = (int)(y_+length*Math.sin(Math.toRadians(startingAngle+90)));
            squareThingy(c,level-1,length,x_,y_,startingAngle);
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("Square Thingy", 800,800, Color.black);
        c.setVisible(true);
        c.setInkColor(Color.YELLOW);
        for (int i = 0; i < 6; i++) {
            c.pause(1000);
            c.erase();
            squareThingy(c,i,600,0,400,0);
        }
    }
}
