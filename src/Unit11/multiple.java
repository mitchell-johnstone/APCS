package Unit11;

import java.awt.*;

public class multiple {
    public static void main(String[] args) {
        Canvas c = new Canvas("Combo", 800,800, Color.black);
        c.setInkColor(Color.green);
        c.setVisible(true);
        SerpTriangle.serpTriangle(c, 100,600,400,(int)(600-300*Math.sqrt(3)), 7);
        SquareThingy.squareThingy(c,3,600,100,600,-59);
        SnowFlake.flake(c,5,600,400,(int)(600-300*Math.sqrt(3)), 60);
        FourSquare.square(c,4,32, 0, 400,600-(int)(300/Math.sqrt(3)));
        Square2.square(c,0,0,125,5,1);
        Square2.square(c,800,0,125,5,2);
        Square2.square(c,800,800,125,5,3);
        Square2.square(c,0,800,125,5,4);
        Circles2.circle(c,400,650,50,6);
        Circles.circle(c,300,650,100,5);
    }
}