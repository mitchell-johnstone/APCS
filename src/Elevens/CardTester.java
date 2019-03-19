package Elevens;
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c1 = new Card("Jack", "Heart", 11);
		Card c2 = new Card("Ace", "Spades", 1);
		Card c3 = new Card("Queen", "Spades", 26);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		System.out.println("\n"+ c1.matches(c2));

		System.out.println("\n" + c3.rank());
		System.out.println("\n" + c3.suit());
		System.out.println("\n" + c3.pointValue());
	}
}
