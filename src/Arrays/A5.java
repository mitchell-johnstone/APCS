package Arrays;


import java.awt.*;

public class A5 {
    public static void main(String[] args) {
        Canvas c = new Canvas("A5", 800,800,Color.black);
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
        c.setInkColor(Color.YELLOW);
        c.drawFilledPolygon(xValuesConvex,yValuesConvex,xValuesConvex.length);
    }
}
