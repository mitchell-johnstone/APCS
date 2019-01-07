package Unit11;

import java.awt.*;

public class FourSquare {
    public static void square(Canvas c, int level, int length, int corner, int x, int y){
        c.drawRectangle(x-length/2, y-length/2, length,length);
        if(level == 0){
            c.pause(5);
        } else{
            length/=2;
            level--;
            if(corner==0){
                square(c,level,length, 1, x-3*length/2, y-3*length/2);
                square(c,level,length, 2, x+3*length/2, y-3*length/2);
                square(c,level,length, 3, x+3*length/2, y+3*length/2);
                square(c,level,length, 4, x-3*length/2, y+3*length/2);
            } else if(corner==1){
                square(c,level,length, 1, x-3*length/2, y-3*length/2);
                square(c,level,length, 2, x+3*length/2, y-3*length/2);
                square(c,level,length, 4, x-3*length/2, y+3*length/2);
            } else if(corner==2){
                square(c,level,length, 1, x-3*length/2, y-3*length/2);
                square(c,level,length, 2, x+3*length/2, y-3*length/2);
                square(c,level,length, 3, x+3*length/2, y+3*length/2);
            } else if(corner==3){
                square(c,level,length, 2, x+3*length/2, y-3*length/2);
                square(c,level,length, 3, x+3*length/2, y+3*length/2);
                square(c,level,length, 4, x-3*length/2, y+3*length/2);
            } else if(corner==4){
                square(c,level,length, 1, x-3*length/2, y-3*length/2);
                square(c,level,length, 3, x+3*length/2, y+3*length/2);
                square(c,level,length, 4, x-3*length/2, y+3*length/2);
            }
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("Square Stuff", 800,800, Color.black);
        c.setVisible(true);
        c.setInkColor(Color.green);
        for (int i = 0; i < 8; i++) {
            c.pause(1000);
            c.erase();
            square(c,i,256,0,400,400);
        }
    }
}
