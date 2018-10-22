package Graphics;

import java.awt.*;
import java.util.Random;

public class PerlinNoiseTest {
    public static void main(String[] args) {
        //PerlinNoise p = new PerlinNoise();
        int scale = 3;
        Canvas c = new Canvas("Perlin Noise", 255*scale,255*scale, Color.black);
        c.setVisible(true);
        Random r = new Random();
        for (int x = 1; x < 256*scale; x++) {
            for (int y = 1; y < 256*scale; y++) {
                double xoff = x+r.nextDouble();
                double yoff = y+r.nextDouble();
                double f = 0; //255*(p.noise(yoff, xoff)+1)/2;
                Color color = new Color((int)f,(int)f,(int)f);
                c.setInkColor(color);
                c.drawFilledRectangle((x-1),(y-1),1,1);
            }
        }
    }
}
