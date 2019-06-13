package FinalProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//main Driver program
public class SpaceInvader {
    private static Alien[][] invaders;
    private static ArrayList<Lazer> lazers;
    private static Player player;
    private static Canvas c;
    private static int invaderVel = 1;
    private static int playerVel = 3;
    private static int lazerVel = 3;

    /**
     * Player uses the keyboard arrows to move
     * Left moves left, Right moves right,
     * Up shoots a lazer
     * Goal: kill all aliens before they get to the end
     * @param args
     */
    public static void main(String[] args) {
        c = new Canvas("Space Invader",800,800, Color.black);
        c.fillBackground(Color.black);
        c.setVisible(true);
        reset();
        while(aliensLeft() && alive()){
            play();
            drawAll();
            c.pause(7);
            c.erase();
        }

        if(alive())
            winScreen();
        else
            loseScreen();
    }

    public static boolean alive(){
        return player.isAlive();
    }

    public static boolean aliensLeft(){
        for (Alien[] alienRow: invaders){
            for(Alien alien: alienRow){
                if(alien.isAlive()){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean reset(){
        lazers = new ArrayList <>();
        invaders = new Alien[9][5];
        for (int i = 0; i < invaders.length; i++) {
            for (int j = 0; j < invaders[0].length; j++) {
                invaders[i][j] = new Alien(c, 50+i*75, 50+j*75,invaderVel,Color.GREEN);
            }
        }
        player = new Player(c,400,700,Color.white);
        return true;
    }

    public static void play(){
        moveAliens();
        movePlayer();
        moveLazers();
        checkCollision();
    }

    public static void movePlayer(){
        int v = 0;
        if(c.getLeft()){
            v = -playerVel;
        }
        if(c.getRight()){
            v = playerVel;
        }
        if(c.getKey().contains("up")){
            lazers.add(new Lazer(c,player.getX(), player.getY(), -lazerVel,true,player.getColor()));
        }
        player.move(v);
    }


    public static void moveAliens(){
        System.out.println(getLargestX() + ", " + getLeastX());
        if((getLeastX() <= 30 && invaders[0][0].getVel() < 0)||
                (getLargestX() >= 770 && invaders[0][0].getVel()>0)){
            for (Alien[] alienRow : invaders) {
                for (Alien alien : alienRow) {
                    alien.shiftDown(25);
                    alien.changeDirection();
                }
            }
        } else{
            for (Alien[] alienRow : invaders) {
                for (Alien alien : alienRow) {
                    alien.move();
                }
            }
        }

        Random r = new Random();
        for (Alien[] alienRow : invaders) {
            for (Alien alien : alienRow) {
                if(alien.isAlive() && r.nextInt(10000)==1){
                    lazers.add(new Lazer(c,alien.getX(),alien.getY(),lazerVel,false,alien.getColor()));
                }
            }
        }
    }

    public static void moveLazers(){
        for (Lazer l : lazers)
            if(l != null)
                l.move();
    }

    public static int getLowestY(){
        for(int i = 0; i<invaders.length; i++){
            for(int j = invaders[0].length-1; j>=0; j--){
                if(invaders[i][j].isAlive()){
//                    System.out.println(invaders[i][j].getY());
                    return invaders[i][j].getY();
                }
            }
        }
        return 0;
    }

    public static int getLeastX(){
        for (int i = invaders[0].length-1; i >=0 ; i--) {
            for (int j = 0; j < invaders.length; j++) {
                if(invaders[j][i].isAlive()){
                    return invaders[j][i].getX();
                }
            }
        }
        return 0;
    }

    public static int getLargestX(){
        for (int i = 0; i < invaders[0].length; i++) {
            for (int j = invaders.length-1; j >=0; j--) {
                if(invaders[j][i].isAlive()){
                    return invaders[j][i].getX();
                }
            }
        }
        return 0;
    }

    public static void checkCollision(){
        if(getLowestY() >= 700){
            player.kill();
            return;
        }
        for (int i = 0; i < lazers.size(); i++) {
            Lazer l = lazers.get(i);
            if(l!= null){
                if(l.getY()<0 || l.getY() > 800) {
                    lazers.remove(i);
                }else if(l.getAlliance()){
                    //player's lazer
                    for (Alien[] alienRow : invaders) {
                        for (Alien alien : alienRow) {
                            if(alien.isAlive()){
                                if(alien.collidesWith(l)){
                                    alien.kill();
                                    lazers.remove(i);
                                }
                            }
                        }
                    }
                } else {
                    //alien lazer
                    if(player.collidesWith(l)){
                        player.kill();
                        lazers.remove(i);
                    }
                }
            }
        }
    }

    public static void drawAll(){
        for (Alien[] alienRow: invaders){
            for(Alien alien: alienRow){
                if(alien.isAlive())
                    alien.draw();
            }
        }
        player.draw();
        for(Lazer l : lazers)
            if(l != null)
                l.draw();
    }

    public static void winScreen(){
        c.erase();
        c.setInkColor(Color.blue);
        c.setFontSize(70);
        c.drawString("Player, you won!", 100,300);
    }

    public static void loseScreen(){
        c.erase();
        c.setInkColor(Color.red);
        c.setFontSize(70);
        c.drawString("The aliens invaded!", 100,300);

    }
}
