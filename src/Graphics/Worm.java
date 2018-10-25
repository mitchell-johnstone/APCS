package Graphics;

import java.awt.*;
import java.util.Scanner;

public class Worm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What length?");
        int n = in.nextInt();

        Canvas c = new Canvas("Worm TEST", 800, 800, Color.BLACK);
        int r = 100;
        c.setVisible(true);
        Point[] p = new Point[n];

        boolean done = false;
        while(!done){
            c.setInkColor(Color.BLACK);
            if(p[0]!=null)c.drawFilledOval(p[0].x - r / 2-1, p[0].y - r / 2-1, r+2, r+2);
            System.arraycopy(p, 1, p, 0, p.length - 1);

            p[p.length-1]=c.hoverPoint();
            c.setInkColor(Color.cyan);
            for (int i = p.length-1; i >=0; i--) {
                if(p[i]!=null) {
                    c.drawFilledOval(p[i].x-r/2,p[i].y-r/2,r,r);
                }
            }

            if(p[p.length-1] == null)done=true;

//            for (int i = 0; i < p.length-1; i++) {
//                if(p[i+1]!=null) {
//                    if(p[i]!=null)
//                        c.drawFilledOval(p[i].x - r / 2, p[i].y - r / 2, r, r);
//                    p[i] = p[i + 1];
//                }
//            }
//            c.pause(50);
        }
    }
}
