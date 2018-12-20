package Unit11;

import java.awt.*;
import java.util.Scanner;

public class SerpTriangle {
    public static void serpTriangle(Canvas c, int x1, int y1, int x2, int y2, int num){
        int x3 = x2 + (x2-x1);
        int y3 = y1;
        c.drawLine(x1,y1,x2,y2);
        c.drawLine(x1,y1,x3,y3);
        c.drawLine(x3,y3,x2,y2);
        if(num == 0 ){
            c.pause(5);
        } else {
            int xmid1 = (x1+x2)/2;
            int xmid2 = (x3+x2)/2;
            int ymid = (y1+y2)/2;
            serpTriangle(c,x1,y1, xmid1, ymid, num-1);
            serpTriangle(c,xmid1,ymid, x2, y2, num-1);
            serpTriangle(c,x2,y1, xmid2, ymid, num-1);
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("SerpTriangle", 800,800, Color.BLACK);
        c.setVisible(true);
        c.setInkColor(Color.RED);
        int l = 1;
//        System.out.println("Level?");
//        Scanner in = new Scanner(System.in);
//        l = in.nextInt();
        for(;l<7;l++) {
            c.pause(1000);
            c.erase();
            serpTriangle(c, 100, 700, 400, 300, l);
        }
    }
}
