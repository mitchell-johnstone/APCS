package Arrays;

import java.awt.*;
import java.util.Random;

public class TicTacToe {
    private static int player = 1;
    private static boolean won = false;
    private static Color p1Tmp = new Color(255,0,0,20);
    private static Color p1 = new Color(255,0,0,255);
    private static Color p2Tmp = new Color(0,0,255,50);
    private static Color p2 = new Color(0,0,255,255);
    private static int playNumber = 0;

    public static void main(String[] args) {
        Canvas c = new Canvas("TicTacToe", 600,600, Color.black);
        c.setVisible(true);
        int[][] board = new int[3][3];
        //main game function
        boolean done = false;
        c.setInkColor(Color.white);
        c.drawLine(200,0,200,600);
        c.drawLine(400,0,400,600);
        c.drawString("C vs C", 100,300);
        c.drawString("P vs C", 300,300);
        c.drawString("P vs P", 500,300);
        Point tmp = c.waitForClick();
        int gameType = ((int)tmp.getX())/200;
        while (!done) {
            player = 1;
            resetBoard(board, c);
            won = false;
            while (!won) {
                //hovering for temporary placement
                Point hover = c.getHoverPoint();
                hoverAnimation(board,c,hover);

                //when clicked, real point
                Point clicked = c.getClickedPoint();
                if(gameType==1) {
                    if (player == -1) {
                        clicked = CompCheck(board);
                    }
                } else if(gameType==0){
                    clicked = CompCheck(board);
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
            if(gameType!=0)c.waitForClick();
            else done=true;
        }
    }

    private static void register (int[][]board, Canvas c, Point clicked){
        if (clicked != null) {
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
            playNumber++;
        }
    }

    private static void hoverAnimation (int[][] board, Canvas c, Point hover){
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

    private static void resetBoard(int[][]board, Canvas c){
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
        playNumber = -1;
    }

    private static Point CompCheck(int [][] board){
        Random r = new Random();

        //first, check if there's a place to win
        for (int k = 1; k > -2; k-=2) {
            for (int i = 0; i < 3; i++) {
                if (board[0][i] + board[1][i] + board[2][i] == 2*player*k) {
                    int x = 50 + 200 * r.nextInt(3);
                    int y = 50 + 200 * i;
                    return new Point(x, y);
                }
                if (board[i][0] + board[i][1] + board[i][2] == 2*player*k) {
                    int x = 50 + 200 * i;
                    int y = 50 + 200 * r.nextInt(3);
                    return new Point(x, y);
                }
            }
            if (board[0][0] + board[1][1] + board[2][2] == 2*player*k) {
                int tmp = 50 + 200 * r.nextInt(3);
                return new Point(tmp, tmp);
            }
            if (board[0][2] + board[1][1] + board[2][0] == 2*player*k) {
                int x = 50 + 200 * r.nextInt(3);
                int y = 600 - x;
                return new Point(x, y);
            }
        }
        //then optimal plays
        if(playNumber==-1) System.out.println("Error: play# -1");
        if(playNumber==0){
            int x = 50+200*(r.nextInt(2)==0?0:2);
            int y = 50+200*(r.nextInt(2)==0?0:2);
            return new Point(x,y);
        }else if(playNumber==1){
            int sum = 0;
            for (int i = 0; i < 3; i+=2) {
                for (int j = 0; j < 3; j+=2) {
                    sum+=board[i][j];
                }
            }
            if(sum==1) {
                return new Point(300, 300);
            } else if(board[1][1] == 1){
                int x = 50+200*(r.nextInt(2)==0?0:2);
                int y = 50+200*(r.nextInt(2)==0?0:2);
                return new Point(x,y);
            } else {
                return new Point(300, 300);
            }
        } else if(playNumber == 2){
            if(board[1][1]==0){
                return new Point(300,300);
            }
            int x = 50+200*(r.nextInt(2)==0?0:2);
            int y = 50+200*(r.nextInt(2)==0?0:2);
            return new Point(x,y);
        }else if(playNumber==3){
            if(board[0][0] + board[2][2] == -2*player && board[1][1] == player){
                int x = r.nextInt(600);
                int y = (x>200 && x<400)?(r.nextInt(2)==0?100:500):300;
                return new Point(x,y);
            }
            if(board[0][2] + board[2][0] == -2*player && board[1][1] == player){
                int x = r.nextInt(600);
                int y = (x>200 && x<400)?(r.nextInt(2)==0?100:500):300;
                return new Point(x,y);
            }
        }
        int x = r.nextInt(600);
        int y = r.nextInt(600);
        return new Point(x, y);
    }

    private static int check(int[][] board, Canvas c){
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