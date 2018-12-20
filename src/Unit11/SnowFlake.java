package Unit11;

import java.awt.*;

public class SnowFlake {
    public static void flake(Canvas c, int level, int length, int x, int y, int startingAngle){
        if(level == 0) {
            c.drawLine(x,y,x+(int)(length*Math.cos(Math.toRadians(startingAngle))), y+(int)(length*Math.sin(Math.toRadians(startingAngle))));
            c.pause(5);
        } else {
            flake(c, level-1, length/3, x,y,startingAngle);
            int x2 = (int)(x+length/3*Math.cos(Math.toRadians(startingAngle)));
            int y2 = (int)(y+length/3*Math.sin(Math.toRadians(startingAngle)));
            flake(c, level-1, length/3, x2, y2,startingAngle - 60);
            int x3 = (int)(x2+length/3*Math.cos(Math.toRadians(startingAngle-60)));
            int y3 = (int)(y2+length/3*Math.sin(Math.toRadians(startingAngle-60)));
            flake(c, level-1, length/3, x3, y3,startingAngle + 60);
            flake(c, level-1, length/3,
                    (int)(x+2*length/3*Math.cos(Math.toRadians(startingAngle))),
                    (int)(y+2*length/3*Math.sin(Math.toRadians(startingAngle))),startingAngle);
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("SnowFlake", 1000,1000, Color.black);
        c.setVisible(true);
        c.setInkColor(Color.blue);

        int length = 600;
        int level = 0;
        int x = 200;
        int y = 200;
        for(;level<6; level++) {
            c.pause(1000);
            c.erase();
            flake(c, level, length, x, y, 0);
            flake(c, level, length, x + length, y, 120);
            flake(c, level, length, x + length / 2, (int) (y + length / 2 * Math.sqrt(3)), 240);
        }
    }
}
