package Graphics;

import java.awt.*;
import java.util.Random;

public class Star extends Thread{
    Random r = new Random();
    int x;
    int y;
    Canvas c;
    public Star(Canvas c){
      this.x=r.nextInt(1600);
      this.y=r.nextInt(800);
      this.c = c;
    }

    public void run(){
        try{
            while(true) {
                x += 1;
                if (x > 1600) x = 0;
                c.drawFilledRectangle(x, y, 4, 4);
                Thread.sleep(100);
            }
        }catch(Exception e){

        }
    }
}
