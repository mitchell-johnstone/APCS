package Graphics;

import java.awt.*;
import java.util.Scanner;

public class Worm {
    private static Point[] p;
    public static Canvas c;
    public static int r = 0;
    public static boolean done;

    public static void draw(){
        c.setInkColor(Color.BLACK);
        if(p[0]!=null)
            c.drawFilledOval(p[0].x - r / 2-1, p[0].y - r / 2-1, r+2, r+2);

        System.arraycopy(p, 1, p, 0, p.length - 1);

        p[p.length-1]=c.hoverPoint();
        c.setInkColor(Color.cyan);
        for (int i = p.length-1; i >=0; i--) {
            if(p[i]!=null) {
                c.drawFilledOval(p[i].x-r/2,p[i].y-r/2 ,r,r);
            }
        }

        if(p[p.length-1] == null)done=true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What length?");
        int n = in.nextInt();

        c = new Canvas("Worm TEST", 800, 800, Color.BLACK);
        r = 100;
        c.setVisible(true);
        p = new Point[n];

        done = false;
        while(!done){
            draw();
        }
    }
}
