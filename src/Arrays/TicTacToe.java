package Arrays;

import java.awt.*;

public class TicTacToe {
    public static void main(String[] args) {
        Canvas c = new Canvas("TicTacToe", 600,600, Color.black);
        c.setVisible(true);
        int[][] board = new int[3][3];
        boolean won = false;
        //main game function
        int player = 1;
        Color p1Tmp = new Color(255,0,0,20);
        Color p1 = new Color(255,0,0,255);
        Color p2Tmp = new Color(0,0,255,50);
        Color p2 = new Color(0,0,255,255);
        boolean done = false;

        while(!done) {
            player=1;
            resetBoard(board, c);
            won = false;
            while (!won) {
                Point hover = c.getHoverPoint();
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
                                    c.drawFilledRectangle(i * 200+1, j * 200+1, 199, 199);
                                }
                            }
                        }
                        if (player == 1) {
                            //draw a full X, but see through, temporary
                            c.setInkColor(p1Tmp);
                            for (int i = 1; i < 191; i+=1) {
                                c.drawFilledRectangle(x*200+i, y*200+i,10,10);
                            }
                            for (int i = 1; i < 191; i+=1) {
                                c.drawFilledRectangle(x*200+i, y*200+(191-i),10,10);
                            }
                        } else {
                            //draw 2 circles, one smaller and black, to create a blue O, but only temporary
                            c.setInkColor(p2Tmp);
                            c.drawFilledOval(x * 200+1, y * 200+1, 200-2, 200-2);
                            c.setInkColor(Color.BLACK);
                            c.drawFilledOval(x * 200 + 25+1, y * 200 + 25+1, 150-2, 150-2);
                        }
                    }
                    //resets the hover point so it clears the current hover point
                    c.nullifyHoverPoint();
                }

                //when clicked, real point
                Point clicked = c.getClickedPoint();
                if (clicked != null) {
                    //update array, check if win
                    int x = ((int) clicked.getX()) / 200;
                    int y = ((int) clicked.getY()) / 200;
                    if (board[x][y] == 0) {
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

                c.pause(100);
            }
            c.pause(2000);
            resetBoard(board,c);
            c.setInkColor(Color.WHITE);
            player *= -1;
            if (player == -1) player += 3;
            c.drawString("Win Player " + player, 270, 300);
            System.out.println("Click to play again");
            c.waitForClick();
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




    public static int check(int[][] board, Canvas c){
        c.setInkColor(new Color(255,255,0));
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

        //other diaganol
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

        //diaganols
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
                c.drawFilledRectangle(600-i, i, 10,10);
            }
            return -1;
        }

        //incase of a cat'sgame
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
