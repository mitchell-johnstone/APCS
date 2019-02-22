package Graphics;

import java.awt.*;
import java.util.Random;

public class ImprovedNoiseTest {
    public static void main(String[] args) {
        int scale = 1;
        ImprovedNoise IN = new ImprovedNoise();
        Random r = new Random();
        Canvas c = new Canvas("Perlin Noise", 255,255, Color.black);
        c.setVisible(true);
        for (int x = 1; x < 256; x++) {
            for (int y = 1; y < 256; y++) {

                //gets a random distance away from x and y
                double xoff = x + r.nextDouble();
                double yoff = y + r.nextDouble();
                double f = 255*(ImprovedNoise.noise(xoff, yoff,0)+1)/2;
                Color color = new Color((int)f, (int)f, (int)f);
                c.setInkColor(color);
                c.drawFilledRectangle(x*scale,y*scale,scale,scale);
            }
        }
    }
}
