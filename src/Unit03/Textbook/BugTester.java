package Unit03.Textbook;

import java.io.*;

/*
*/

public class BugTester{
	public static void main(String[] args){
		PrintStream p = System.out;
		Bug ant = new Bug(7);
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.turn();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
		ant.turn();
		p.println("ant's position is " + ant.getPosition());
		ant.move();
		p.println("ant's position is " + ant.getPosition());
	}
}