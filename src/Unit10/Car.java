package Unit10;


import java.awt.*;

public class Car extends Vehicle{
    private int x;
    private int y;

    public Car(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int val) {
        this.x+=val;
    }

    public void draw(Canvas c) {
        c.setInkColor(Color.blue);
        c.drawFilledRectangle(x,y,100,50);
        c.setInkColor(Color.blue);
        c.drawFilledRectangle(x-50,y+50,200,50);
        c.setInkColor(Color.white);
        c.drawFilledOval(x-25,y+100,50,50);
        c.drawFilledOval(x+75,y+100,50,50);
    }
}
