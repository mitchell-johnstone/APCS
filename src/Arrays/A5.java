package Arrays;


import java.awt.*;

public class A5 {
    public static void main(String[] args) {
        Canvas c = new Canvas("A5", 1000,800,Color.black);
        c.setVisible(true);
        int[]xValuesConcave = {0,-1,0,1,0,-1,0};
        int[]yValuesConcave = {0,1,1,0,-1,-1,0};
        for (int i = 0; i < xValuesConcave.length; i++) {
            xValuesConcave[i]*=200;
            xValuesConcave[i]+=200;
        }
        for (int i = 0; i < yValuesConcave.length; i++) {
            yValuesConcave[i]*=200;
            yValuesConcave[i]+=200;
        }
        c.setInkColor(Color.BLUE);
        c.drawFilledPolygon(xValuesConcave,yValuesConcave,xValuesConcave.length);

        int[]xValuesConvex = {-1,0,1,2,1,0,-1};
        int[]yValuesConvex = {0,1,1,0,-1,-1,0};
        for (int i = 0; i < xValuesConvex.length; i++) {
            xValuesConvex[i]*=200;
            xValuesConvex[i]+=200;
        }
        for (int i = 0; i < yValuesConvex.length; i++) {
            yValuesConvex[i]*=200;
            yValuesConvex[i]+=600;
        }
        for (int i = 0; i < 400; i++) {
            c.setInkColor(Color.BLACK);
            c.drawFilledPolygon(xValuesConvex,yValuesConvex,xValuesConvex.length);
            for (int j = 0; j < xValuesConvex.length; j++) {
                xValuesConvex[j]++;
            }
            c.setInkColor(Color.YELLOW);
            c.drawFilledPolygon(xValuesConvex,yValuesConvex,xValuesConvex.length);
            c.pause(10);
        }
        for (int i = 0; i < 200; i++) {
            c.setInkColor(Color.BLACK);
            c.drawFilledPolygon(xValuesConvex,yValuesConvex,xValuesConvex.length);
            c.setInkColor(Color.BLACK);
            c.drawFilledPolygon(xValuesConcave,yValuesConcave,xValuesConcave.length);
            for (int j = 0; j < xValuesConvex.length; j++) {
                yValuesConvex[j]--;
                yValuesConcave[j]++;
            }
            c.setInkColor(Color.YELLOW);
            c.drawFilledPolygon(xValuesConvex,yValuesConvex,xValuesConvex.length);
            c.setInkColor(Color.BLUE);
            c.drawFilledPolygon(xValuesConcave,yValuesConcave,xValuesConcave.length);

            c.pause(10);
        }
        c.setInkColor(Color.WHITE);
        c.drawFilledOval(800,300,50,50);
        c.setInkColor(Color.BLACK);
        c.drawFilledOval(825,313,25,25);
    }
}
