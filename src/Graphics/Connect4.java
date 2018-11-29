package Graphics;

import java.awt.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;

public class Connect4{
	//set up objects here
	static Canvas myCan = new Canvas();
	static int board[][] = new int[7][6];
	
	public static void main(String[] args){
		//set up variables here
		boolean win = false;
		boolean p1 = false;
		
		//set up of board and array
		setup();
		
		do{
			p1 = !p1;
			play(p1);
			win = check();
		} while(!win);
		
		myCan.setInkColor(Color.black);
		myCan.drawFilledRectangle(290,30,320,50);
		
		if (p1){
			myCan.setInkColor(Color.white);
			myCan.drawString("P1 WIN!!", 300, 50);
		} else {
			myCan.setInkColor(Color.white);
			myCan.drawString("P2 WIN!!", 300, 50);
		}
		
		if (p1){
			System.out.println("CONGRATS Player 1 / Blue!");
		} else {
			System.out.println("CONGRATS Player 2 / Red!");
		}
		
		
		
		System.out.println("Thanks for playing!");
	}
	
	public static void play(boolean p1){
		myCan.setInkColor(Color.black);
		myCan.drawFilledRectangle(290,30,30,50);
		if (p1){
			myCan.setInkColor(Color.white);
			myCan.drawString("P1's turn ", 300, 50);
			myCan.setInkColor(Color.blue);
		} else {
			myCan.setInkColor(Color.white);
			myCan.drawString("P2's turn ", 300, 50);
			myCan.setInkColor(Color.red);
		}
		int column, row;
		Point pix;
		boolean p = true;
		do{
            pix = myCan.waitForClick();
            column = ((int) pix.getX()) / 100;
            row = 0;
            for (int i = 0; i < 6; i++) {
                if(board[column][i]==0){
                    p = false;
                }
            }
        }while(p);
        while (true){
			if (row == 6 || board[column][row]!=0){
				row--;
				if (p1){
					board[column][row] = 1;
				} else{
					board[column][row] = -1;
				}
				myCan.drawFilledOval(column*100 + 25/2, row*100+100+25/2, 75,75);
				break;
			}
			row++;
		}
	}
	
	public static boolean check(){
		for (int x=0; x<6; x++){
			for (int y = 0; y<4; y++){
				if (board[y][x] + board[y+1][x] + board[y+2][x] + board[y+3][x] == 4 ||
				    board[y][x] + board[y+1][x] + board[y+2][x] + board[y+3][x] == -4){
					return true;
				}
			}
		}
		for (int x=0; x<3; x++){
			for (int y = 0; y<7; y++){
				if (board[y][x] + board[y][x+1] + board[y][x+2] + board[y][x+3] == 4 ||
				    board[y][x] + board[y][x+1] + board[y][x+2] + board[y][x+3] == -4){
					return true;
				}
			}
		}
		for (int x=0; x<3; x++){
			for (int y = 0; y<4; y++){
				if (board[y][x] + board[y+1][x+1] + board[y+2][x+2] + board[y+3][x+3] == 4 ||
				    board[y][x] + board[y+1][x+1] + board[y+2][x+2] + board[y+3][x+3] == -4){
					return true;
				}
			}
		}
		for (int x=0; x<3; x++){
			for (int y = 3; y<7; y++){
				if (board[y][x] + board[y-1][x+1] + board[y-2][x+2] + board[y-3][x+3] == 4 ||
				    board[y][x] + board[y-1][x+1] + board[y-2][x+2] + board[y-3][x+3] == -4){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void setup(){
		myCan.setSize(700,700);
		myCan.erase();
		
		myCan.setVisible(true);
		Color black = new Color(0, 0, 0);
		myCan.fillBackground(black);
		
		myCan.setInkColor(Color.white);
		myCan.drawString("P1 ", 20, 50);
		myCan.setInkColor(Color.blue);
		myCan.drawFilledOval(40,30,20,20);
		
		myCan.setInkColor(Color.white);
		myCan.drawString("P2 ", 620, 50);
		myCan.setInkColor(Color.red);
		myCan.drawFilledOval(640,30,20,20);
		
		
		myCan.setInkColor(Color.yellow);
		myCan.drawFilledRectangle(0, 100, 700, 600);
		
		myCan.setInkColor(Color.black);
		for (int x = 0; x<6; x++){
			for (int y = 0; y<7; y++){
				myCan.drawLine(0,(100*x+200),800,(100*x+200));
				myCan.drawLine((100*x),0, (100*x),800);
				myCan.drawFilledOval(((100*y)+25/2),((100*x)+100+25/2), 75, 75);
				board[y][x] = 0;
			}
		}
		myCan.drawLine(600,0,600,800);
	}
}