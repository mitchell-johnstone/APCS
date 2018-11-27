package Graphics;

import java.awt.*;
import java.util.Random;

public class PerlinNoiseTest {
    public static void main(String[] args) {
        int scale = 1;
        PerlinNoise p = new PerlinNoise(255,scale);
        Canvas c = new Canvas("Perlin Noise", 255*scale,255*scale, Color.black);
        c.setVisible(true);
        Random r = new Random();
        //loops through every point on the canvas
        int min = 10000;
        int max = 0;
        int sum = 0;
        int count = 0;
        for (int x = 1; x < 256*scale; x++) {
            for (int y = 1; y < 256*scale; y++) {
                //gets a random distance away from x and y
                double xoff = x+r.nextDouble();
                double yoff = y+r.nextDouble();
                double f = 255*(p.getValue(yoff, xoff));
                //makes f positive
                f = f<0?-1*f:f;
                f*= 255.0/180;
//                System.out.print((int)f + " ");
                //creates a grayscale of color f
//                Color color = new Color((int)f,(int)f,(int)f);
//                c.setInkColor(color);
//                c.drawFilledRectangle((x-scale),(y-scale),scale,scale);
                if (f<min) min = (int)f;
                if (f>max) max = (int)f;

                if(y%5==0 && x%5==0){
                    int ave = sum/count;
                    Color color = new Color(ave, ave, ave);
                    c.setInkColor(color);
                    c.drawFilledRectangle((x-5),(y-5),5,5);
                    sum = 0;
                    count=0;
                } else {
                    sum += (int)f;
                    count++;
                }
            }
//            System.out.println();
        }
        System.out.println(min);
        System.out.println(max);
    }
}
