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
    public static Random r = new Random();

    public static void main(String[] args){
        p.println("\n------------------------------------------------------------------------------\n");
        int r = 255;
        int g = 0;
        int b = 0;
        Color rainbow;
        Canvas c = new Canvas("Path Tracer TEST", 800, 800, Color.BLACK);
        c.setVisible(true);
        Point past;
        Point current;
        current = c.hoverPoint();
        boolean red = true, green = false, done = true;
        while (done) {
            if (red) {
                r -= 3;
                g += 3;
                if (r == 0) {
                    red = false;
                    green = true;
                }
            } else if (green) {
                g -= 3;
                b += 3;
                if (g == 0) {
                    green = false;
                }
            } else {
                b -= 3;
                r += 3;
                if (b == 0) {
                    red = true;
                }
            }

            if(r==0 && g==0 && b ==0)done=false;
            rainbow = new Color(r, g, b);
            c.setInkColor(rainbow);
            past = current;
            current = c.hoverPoint();
            c.drawLine(past, current);
        }
    }
}