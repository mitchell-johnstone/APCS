package Unit10;

import java.awt.*;

public class MilleniumFalcon extends Vehicle{
    private int x;
    private int y;
    private int r;

    public MilleniumFalcon(int x, int y) {
        this.x = x;
        this.y = y;
        r=90;
    }

    @Override
    public void move(int val) {
        this.x+=val;
        r+=val;
    }

    //code for draw v1:
    //        c.setInkColor(Color.cyan);
    //        c.drawFilledOval(x-10,y,200-20,200);
    //        c.setInkColor(Color.blue);
    //        c.drawFilledOval(x-5,y,200-20,200);
    //        c.setInkColor(Color.white);
    //        c.drawFilledOval(x,y,200,200);
    //        int[] arrx = {x+100,x+300,x+100, x+100};
    //        int[] arry = {y,    y+50, y+50,  y};
    //        c.drawFilledPolygon(arrx,arry,4);
    //        arry[0] = y+200;
    //        arry[3] = y+200;
    //        arry[1] = y+150;
    //        arry[2] = y+150;
    //        c.drawFilledPolygon(arrx,arry,4);
    //        c.drawFilledRectangle(x+100,y+50,200,25);
    //        c.drawFilledRectangle(x+100,y+125,200,25);
    //
    @Override
    public void draw(Canvas c) {
        c.setInkColor(Color.cyan);
        c.drawFilledOval(x-10,y,200-20,200);
        c.setInkColor(Color.blue);
        c.drawFilledOval(x-5,y,200-20,200);
        c.setInkColor(Color.white);
        c.drawFilledOval(x,y,200,200);
        int[] arrx = {x+100,x+300,x+300, x+100, x+100};
        int[] arry = {y,    y+50, y+75, y+75,  y};
        c.drawFilledPolygon(arrx,arry,5);
        arry[0] = y+200;
        arry[4] = y+200;
        arry[1] = y+150;
        arry[2] = y+125;
        arry[3] = y+125;
        c.drawFilledPolygon(arrx,arry,5);

//        c.setInkColor(Color.cyan);
//        c.drawFilledOval(x-10,(int)(y+100-100*Math.abs(Math.sin(Math.toRadians(r)))), 200-20, 2*(int)(Math.abs(100*Math.sin(Math.toRadians(r)))));
//        c.setInkColor(Color.blue);
//        c.drawFilledOval(x-5,(int)(y+100-100*Math.abs(Math.sin(Math.toRadians(r)))), 200-20, 2*(int)(Math.abs(100*Math.sin(Math.toRadians(r)))));
//        c.setInkColor(Color.white);
//        c.drawFilledOval(x,(int)(y+100-100*Math.abs(Math.sin(Math.toRadians(r)))), 200, 2*(int)(Math.abs(100*Math.sin(Math.toRadians(r)))));
//        int[] arrx = {x+100,x+300, x+300,x+100, x+100};
//        int[] arry = {(int)(y+100*Math.abs(Math.sin(Math.toRadians(r)))),
//                (int)(y+50-50*Math.abs(Math.sin(Math.toRadians(r)))),
//                (int)(y+75-25*Math.abs(Math.sin(Math.toRadians(r)))),
//                (int)(y+75-25*Math.abs(Math.sin(Math.toRadians(r)))),
//                (int)(y+100*Math.abs(Math.sin(Math.toRadians(r))))};
//        c.drawFilledPolygon(arrx,arry,5);
//        arry[0] = (int)(y+200+100*Math.abs(Math.sin(Math.toRadians(r))));
//        arry[4] = (int)(y+200+100*Math.abs(Math.sin(Math.toRadians(r))));
//        arry[1] = (int)(y+150+50*Math.abs(Math.sin(Math.toRadians(r))));
//        arry[2] = (int)(y+125+25*Math.abs(Math.sin(Math.toRadians(r))));
//        arry[3] = (int)(y+125+25*Math.abs(Math.sin(Math.toRadians(r))));
//        c.drawFilledPolygon(arrx,arry,4);
    }
}
