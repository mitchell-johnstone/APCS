package Unit10;

import java.awt.*;

public class Truck extends Vehicle{
    private int x;
    private int y;

    public Truck(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int val) {
        this.x+=val;
    }

    public void draw(Canvas c) {
        c.setInkColor(Color.RED);
        c.drawFilledRectangle(x,y,200,100);
        c.drawFilledRectangle(x+210,y+36,40,64);
        c.setInkColor(Color.white);
        c.drawFilledOval(x+10,y+100,50,50);
        c.drawFilledOval(x+160,y+100,50,50);
    }
}
