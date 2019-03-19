package Elevens;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A","B","C"};
		String[] suits = {"Giraffe", "Lion"};
		int[] pointValues = {2,1,3};
		Deck d = new Deck(ranks,suits,pointValues);

		System.out.println(d);

		String[] ranks2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits2 = {"Hearts", "Diamonds", "Spades", "Clubs"};
		int[] pointValues2 = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		d = new Deck(ranks2,suits2,pointValues2);

		System.out.println(d);

		d.shuffle();

		System.out.println(d);
	}
}
