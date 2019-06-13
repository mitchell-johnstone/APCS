package FinalProject;

import java.awt.*;

public class Lazer implements Collidable{
    private Canvas c;
    private int x;
    private int y;
    private int l = 15;
    private int w = 4;
    private int vel;
    private Color color;
    private boolean playerLazer;

    public Lazer(Canvas c, int x, int y, int vel, boolean playerLazer, Color color) {
        this.c = c;
        this.x = x;
        this.y = y;
        this.vel = vel;
        this.playerLazer = playerLazer;
        this.color = color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean collidesWith(Collidable obj){
        if(obj.getX()> this.x-w/2 && obj.getX()<this.x+w/2){
            if(obj.getY()>this.y && obj.getY()<this.y+l){
                return true;
            }
        }
        return false;
    }

    public void move(){
        y += vel;
    }

    public boolean getAlliance(){
        return playerLazer;
    }

    public void draw(){
        c.setInkColor(color);
        c.drawFilledRectangle(x-w/2,y,w,l);
    }
}
