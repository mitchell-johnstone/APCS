package Unit11;

import java.awt.*;

public class Square2 {
    public static void square(Canvas c, int x, int y, int side, int incrementer, int corner){
        if(side<1);
        else {
            c.pause(5);
            if(corner==1){
                c.drawRectangle(x,y,side,side);
            }else if(corner==2){
                c.drawRectangle(x-side,y,side,side);
            }else if(corner==3){
                c.drawRectangle(x-side,y-side,side,side);
            }else if(corner==4){
                c.drawRectangle(x,y-side,side,side);
            }
            square(c, x, y, side - incrementer,incrementer, corner);
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas("Square thing", 800,800, Color.black);
        c.setInkColor(Color.WHITE);
        c.setVisible(true);
        square(c,100,700,600, 20, 4);
    }
}
