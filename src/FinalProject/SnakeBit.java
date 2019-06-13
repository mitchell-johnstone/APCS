package FinalProject;

import java.awt.*;
import java.util.Objects;

public class SnakeBit {
    int x;
    int y;
    int l;
    Canvas c;
    Color color;

    public SnakeBit(int x, int y, int l, Canvas c, Color color) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.c = c;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addY(int amt){
        y += amt;
    }


    public void addX(int amt){
        x += amt;
    }

    public void draw(){
        c.setInkColor(color);
        c.drawFilledRectangle(x,y,l,l);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeBit snakeBit = (SnakeBit) o;
        return x == snakeBit.x &&
                y == snakeBit.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
