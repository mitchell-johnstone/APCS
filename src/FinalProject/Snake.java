package FinalProject;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private static int[] direction = new int[2];
    private static LinkedList<SnakeBit> snack;
    private static Canvas c;
    public static void main(String[] args) {
        c = new Canvas("Bloop",800,800,Color.black);
        c.setVisible(true);
        reset();
        while(alive()){
            move();
            drawAll();
            c.pause(50);
            c.erase();
        }
    }

    public static boolean alive(){
        int x = snack.peek().getX();
        int y = snack.peek().getY();

        //if snake hit wall
        if((x<0 || x>=800) || (y<0 || y>=800))
            return false;

        //if snake hit itself
        SnakeBit tmp = snack.removeFirst();
        for(SnakeBit s : snack)
            if(tmp.equals(s))
                return false;

        snack.addFirst(tmp);
        return true;
    }

    private static void reset(){
        snack = new LinkedList<>();
        snack.add(new SnakeBit(60,30,10, c, Color.white));
        snack.add(new SnakeBit(45,30,10, c, Color.white));
        snack.add(new SnakeBit(30,30,10, c, Color.white));
        snack.add(new SnakeBit(15,30,10, c, Color.white));

        // 0 is x direction
        // 1 is y direction
        direction[0] = 15;
        direction[1] = 0;
    }

    private static void move(){
        //take the last to put in front
        SnakeBit tmp = snack.removeLast();

        //line up w/ current front bit
        tmp.setX(snack.peek().getX());
        tmp.setY(snack.peek().getY());

        //check the keys for movement
        if(c.getUp()){
            direction[0] = 0;
            direction[1] = -15;
        } else if(c.getRight()){
            direction[0] = 15;
            direction[1] = 0;
        } else if(c.getLeft()){
            direction[0] = -15;
            direction[1] = 0;
        } else if(c.getDown()){
            direction[0] = 0;
            direction[1] = 15;
        }

        tmp.addX(direction[0]);
        tmp.addY(direction[1]);

        snack.addFirst(tmp);
    }

    private static void drawAll(){
        for(SnakeBit s: snack)
            s.draw();
    }


}
