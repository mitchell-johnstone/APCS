package Unit03.Textbook;

import java.util.*;
import java.io.*;

/*
*/

public class Bug{
	public Bug(int initialPosition){
		position = initialPosition;
		movement = 1;
	}
	
	public void turn(){
		movement *=-1;
	}
	
	public void move(){
		position +=movement;
	}
	
	public int getPosition(){
		return position;
	}
	
	private int position;
	private int movement;
}