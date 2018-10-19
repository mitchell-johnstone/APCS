package Die;

import java.util.*;

/*
*/

public class Die{
	public static final int NUMBER_SIDES = 6;
	public static int numDiceInPlay = 0;
	
	private int numberFaces;
	private int valueOnTop;

	public Die(){
		numberFaces = NUMBER_SIDES;
		numDiceInPlay++;
	}
	
	public Die(int faces){
		numberFaces = faces;
		numDiceInPlay++;
	}
	
	public void roll(){
		Random r = new Random();
		valueOnTop = r.nextInt(numberFaces)+1;
	}
	
	public int getValue(){
		return valueOnTop;
	}
	
	public static int getNumberDice(){
		return numDiceInPlay;
	}
	
	public int addTwoDie(Die otherDie){
		return this.getValue() + otherDie.getValue();
	}
	
	public int addThreeDie(Die secondDie, Die thirdDie){
		return this.getValue() + (secondDie.addTwoDie(thirdDie));
	}
}