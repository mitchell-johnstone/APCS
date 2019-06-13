package FinalProject;

import java.awt.*;

public class Alien implements Collidable{
    private Canvas c;
    private int x;
    private int y;
    private int vel;
    private Color color;
    private boolean alive;

    public Alien(Canvas c, int x, int y, int vel, Color color) {
        this.c = c;
        this.x = x;
        this.y = y;
        this.vel = vel;
        this.color = color;
        alive = true;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public void move(){
        x+=vel;
    }

    public void shiftDown(int amt){
        y+=amt;
    }

    public void changeDirection(){
        vel*=-1;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean collidesWith(Collidable obj){
        if(obj.getX()> this.x-25 && obj.getX()<this.x+25){
            if(obj.getY()>this.y-25 && obj.getY()<this.y+25){
                return true;
            }
        }
        return false;
    }

    public int getVel(){
        return vel;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill(){
        alive = false;
    }

    public void draw(){
        c.setInkColor(color);
        c.drawFilledOval(x-25,y-25,50,50);
    }

}
