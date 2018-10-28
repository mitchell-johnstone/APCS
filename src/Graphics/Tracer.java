package Graphics;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import javax.swing.JOptionPane;
/*
 */

public class Tracer {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream p = System.out;
    public static Random random = new Random();

    //Add an erase when the button is clicked

    public static void main(String[] args) {
        p.println("\n------------------------------------------------------------------------------\n");
        int r = 255;
        int g = 0;
        int b = 0;
        Color rainbow;
        Canvas c = new Canvas("Path Tracer TEST", 800, 800, Color.BLACK);
        c.setVisible(true);
        ArrayList<Color> colors = new ArrayList <>(0);
        ArrayList<Point> points = new ArrayList <>(0);
        Point current;
        current = c.hoverPoint();
        points.add(current);
        colors.add(new Color(255,0,0));
        int i = 0;
        boolean red = true, green = false, done = true;
        int colorChanger = 15;
        while (done) {
            if (c.getHoverPoint() != null) {
                if (red) {
                    r -= colorChanger;
                    g += colorChanger;
                    if (r == 0) {
                        red = false;
                        green = true;
                    }
                } else if (green) {
                    g -= colorChanger;
                    b += colorChanger;
                    if (g == 0) {
                        green = false;
                    }
                } else {
                    b -= colorChanger;
                    r += colorChanger;
                    if (b == 0) {
                        red = true;
                    }
                }

                //not necessary, but ide complains that it never ends
                if (r == 0 && g == 0 && b == 0) done = false;



                rainbow = new Color(r, g, b);
                c.setInkColor(rainbow);
                colors.add(rainbow);

                current = c.getHoverPoint();
                points.add(current);

                c.nullifyHoverPoint();
                c.drawLine(points.get(i), points.get(i+1));
                i++;
            }

            if(c.getClickedPoint()!=null){
                i=0;
                int radius = 30;
                for (int j = 0; points.size() != 1;) {
                    for (int k = 0; k < points.size()-2; k++) {
                        c.setInkColor(colors.get(k));
                        c.drawLine(points.get(k),points.get(k+1));
                    }
                    c.setInkColor(Color.white);
                    for (int k = 0; k < 20; k++) {
                        int x = (int) (random.nextDouble()*2*radius-radius);
                        int y = (int) (random.nextDouble()*2*radius-radius); //Math.sqrt((double)radius*radius-x*x);
                        y=random.nextInt(2)==1?y:-y;
                        int x_ = (int)points.get(j).getX();
                        int y_ = (int)points.get(j).getY();
                        c.drawLine(x_+x,y_+y,x_,y_);
                    }
                    colors.remove(0);
                    points.remove(0);
                    c.pause(15);
                    c.setInkColor(Color.black);
                    c.drawFilledRectangle(0,0,800,800);
                }

                /*c.setInkColor(Color.BLACK);
                c.drawFilledRectangle(0,0,800,800);*/
                c.nullifyClickedPoint();
            }
        }
    }
}