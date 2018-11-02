package Arrays;

import java.awt.*;
import java.util.Random;

public class TicTacToe {
    public static int player = 1;
    public static boolean won = false;
    static Color p1Tmp = new Color(255,0,0,20);
    static Color p1 = new Color(255,0,0,255);
    static Color p2Tmp = new Color(0,0,255,50);
    static Color p2 = new Color(0,0,255,255);
    static Point point1 = null; static Point point2=null;
    public static void main(String[] args) {
        Canvas c = new Canvas("TicTacToe", 600,600, Color.black);
        c.setVisible(true);
        int[][] board = new int[3][3];
        //main game function
        boolean done = false;
        c.setInkColor(Color.white);
        c.drawLine(300,0,300,600);
        c.drawString("P vs C", 100,300);
        c.drawString("P vs P", 400,300);
        Point tmp = c.waitForClick();
        boolean pvp = ((int)tmp.getX())/300==1;
        while (!done) {
            player = 1;
            point1=null;
            point2=null;
            resetBoard(board, c);
            won = false;
            while (!won) {
                //hovering for temporary placement
                Point hover = c.getHoverPoint();
                hoverAnimation(board,c,hover);

                //when clicked, real point
                Point clicked = c.getClickedPoint();
                if(!pvp) {
                    if (player == -1) {
                        clicked = CompCheck(board, point1, point2, -1);
                        if (clicked == null) clicked = CompCheck(board, point1, point2, 1);
                    }
                }
                register(board,c,clicked);
                c.pause(100);
            }
            c.pause(2000);
            resetBoard(board, c);
            c.setInkColor(Color.WHITE);
            player *= -1;
            if (player == -1) player += 3;
            c.drawString("Win Player " + player, 270, 300);
            System.out.println("Click to play again");
            c.waitForClick();
        }
    }
    public static void register (int[][]board, Canvas c, Point clicked){
        if (clicked != null) {
            if(player==1){
                if(point1 == null){
                    point1 = clicked;
                }else {
                    if(point2 == null)point2 = clicked;
                }
            }
            //update array, check if win
            int x = ((int) clicked.getX()) / 200;
            int y = ((int) clicked.getY()) / 200;
            if (board[x][y] == 0) {
                c.setInkColor(Color.BLACK);
                c.drawFilledRectangle(x * 200 + 1, y * 200 + 1, 199, 199);
                if (player == 1) {
                    //draw a vibrant X, this one permanent
                    c.setInkColor(p1);
                    for (int i = 1; i < 191; i += 1) {
                        c.drawFilledRectangle(x * 200 + i, y * 200 + i, 10, 10);
                    }
                    for (int i = 1; i < 191; i += 1) {
                        c.drawFilledRectangle(x * 200 + i, y * 200 + (191 - i), 10, 10);
                    }
                } else {
                    //draw a vibrant blue O, permanent
                    c.setInkColor(p2);
                    c.drawFilledOval(x * 200 + 1, y * 200 + 1, 200 - 2, 200 - 2);
                    c.setInkColor(Color.BLACK);
                    c.drawFilledOval(x * 200 + 25 + 1, y * 200 + 25 + 1, 150 - 2, 150 - 2);
                }
                //update the board to make spot permanent
                board[x][y] = player;

                //change player
                player *= -1;

                //checks the board
                if (check(board, c) == 1) {
                    won = true;
                    System.out.println("Good job, player 1!");
                } else if (check(board, c) == -1) {
                    won = true;
                    System.out.println("Good job, player 2!");
                }
            }
            c.nullifyClickedPoint();
        }
    }

    public static void hoverAnimation (int[][] board, Canvas c, Point hover){
        if (hover != null) {
            int x = ((int) hover.getX()) / 200;
            int y = ((int) hover.getY()) / 200;
            if (board[x][y] == 0) {
                /*
                 * sweeper
                 * fills a black square in any non-permanent tile
                 */
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 0) {
                            c.setInkColor(Color.BLACK);
                            c.drawFilledRectangle(i * 200 + 1, j * 200 + 1, 199, 199);
                        }
                    }
                }
                if (player == 1) {
                    //draw a full X, but see through, temporary
                    c.setInkColor(p1Tmp);
                    for (int i = 1; i < 191; i += 1) {
                        c.drawFilledRectangle(x * 200 + i, y * 200 + i, 10, 10);
                    }
                    for (int i = 1; i < 191; i += 1) {
                        c.drawFilledRectangle(x * 200 + i, y * 200 + (191 - i), 10, 10);
                    }
                } else {
                    c.setInkColor(p2Tmp);
                    c.drawFilledOval(x * 200 + 1, y * 200 + 1, 200 - 2, 200 - 2);
                    c.setInkColor(Color.BLACK);
                    c.drawFilledOval(x * 200 + 25 + 1, y * 200 + 25 + 1, 150 - 2, 150 - 2);
                }
            }
            //resets the hover point so it clears the current hover point
            c.nullifyHoverPoint();
        }
    }

    public static void resetBoard(int[][]board, Canvas c){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=0;
            }
        }

        c.setInkColor(Color.BLACK);
        c.drawFilledRectangle(0,0,600,600);
        c.setInkColor(Color.white);
        c.drawLine(200,0,200,600);
        c.drawLine(400,0,400,600);
        c.drawLine(0,200,600,200);
        c.drawLine(0,400,600,400);
    }

    public static Point CompCheck(int [][] board,Point p1, Point p2, int m){
        Random r = new Random();
        if(p1==null){
            int x = 50+200*(r.nextInt(2)==0?0:2);
            int y = 50+200*(r.nextInt(2)==0?0:2);
            return new Point(x,y);
        }else {
            if(p2 == null){
                int x = 50+200*(r.nextInt(2)==0?0:2);
                int y = 50+200*(r.nextInt(2)==0?0:2);
                return new Point(x,y);
            } else {
                //first, check if there's a place to win
                for (int i = 0; i < 3; i++) {
                    if(board[0][i] + board[1][i] + board[2][i] ==2*m){
                        int x = 50+200*r.nextInt(3);
                        int y = 50+200*i;
                        return new Point(x,y);
                    }
                    if(board[i][0] + board[i][1] + board[i][2] ==2*m){
                        int x = 50+200*i;
                        int y = 50+200*r.nextInt(3);
                        return new Point(x,y);
                    }
                }
                if(board[0][0] + board[1][1] + board[2][2] == 2*m){
                    int x = 50+200*r.nextInt(3);
                    int y = x;
                    return new Point(x,y);
                }
                if(board[0][2] + board[1][1] + board[2][0] == 2*m){
                    int x = 50+200*r.nextInt(3);
                    int y = 600-x;
                    return new Point(x,y);
                }
            }
        }
        if(m==1) {
            int x = r.nextInt(600);
            int y = r.nextInt(600);
            return new Point(x, y);
        }
        return null;
    }


    public static int check(int[][] board, Canvas c){
        //yellow to draw line
        c.setInkColor(new Color(255,255,0));
        //side to side
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum+=board[i][j];
            }
            if(sum==3){
                for (int j = 0; j < 600; j++) {
                    c.drawFilledRectangle(i*200+95,j, 10,10);
                }
                return 1;
            } else if(sum==-3){
                for (int j = 0; j < 600; j++) {
                    c.drawFilledRectangle(i*200+95,j, 10,10);
                }
                return -1;
            }
        }
        //up down
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum+=board[j][i];
            }
            if(sum==3){
                for (int j = 0; j < 600; j++) {
                    c.drawFilledRectangle(j,i*200+95,10,10);
                }
                return 1;
            } else if(sum==-3){
                for (int j = 0; j < 600; j++) {
                    c.drawFilledRectangle(j,i*200+95,10,10);
                }
                return -1;
            }
        }

        //diagonal
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum+=board[i][i];
        }
        if(sum==3){
            for (int i = 0; i < 600; i++) {
                c.drawFilledRectangle(i,i,10,10);
            }
            return 1;
        } else if(sum==-3){
            for (int i = 0; i < 600; i++) {
                c.drawFilledRectangle(i,i,10,10);
            }
            return -1;
        }
        //diagonal 2
        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum+=board[2-i][i];
        }
        if(sum==3){
            for (int i = 0; i < 600; i++) {
                c.drawFilledRectangle(600-i, i-10, 10,10);
            }
            return 1;
        } else if(sum==-3){
            for (int i = 0; i < 600; i++) {
                c.drawFilledRectangle(600-i, i-10, 10,10);
            }
            return -1;
        }

        //check in case of a cat'sgame
        sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum+=(board[i][j]*board[i][j]);
            }
        }
        if(sum==9) {
            c.pause(1000);
            resetBoard(board,c);
            System.out.println("Cat's game. Sorry. tie");
            c.drawString("Cat's game. Sorry. tie", 250,300);
        }
        c.nullifyClickedPoint();
        return 0;
    }
}