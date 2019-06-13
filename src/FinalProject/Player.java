package FinalProject;

import java.awt.*;

public class Player implements Collidable{
    private Canvas c;
    private int x;
    private int y;
    private Color color;
    private boolean alive;

    public Player(Canvas c, int x, int y, Color color) {
        this.c = c;
        this.x = x;
        this.y = y;
        this.color = color;
        alive = true;
    }

    public void kill(){
        alive = false;
    }

    public boolean isAlive(){
        return alive;
    }

    public boolean collidesWith(Collidable obj){
        if(obj.getX()> this.x-25 && obj.getX()<this.x+25){
            if(obj.getY()>this.y && obj.getY()<this.y+50){
                return true;
            }
        }
        return false;
    }

    public void move(int vel){
        x+=vel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void draw(){
        c.setInkColor(color);
        c.drawFilledRectangle(x-25,y,50,50);
    }

}
