package Elevens;

import java.util.List;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen",
			"king" };

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal. In Elevens,
	 * the legal groups are (1) a pair of non-face cards whose values add to 11, and
	 * (2) a group of three cards consisting of a jack, a queen, and a king in some
	 * order.
	 * 
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal; false
	 *         otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if(selectedCards.size() == 2) return findPairSum11(selectedCards)[0] != -1;
		if(selectedCards.size() == 3){
			int[] JQK = findJQK(selectedCards);
			boolean found = true;
			for (int i : JQK) if(i==-1) found = false;
			return found;
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board. In Elevens, there
	 * is a legal play if the board contains (1) a pair of non-face cards whose
	 * values add to 11, or (2) a group of three cards consisting of a jack, a
	 * queen, and a king in some order.
	 * 
	 * @return true if there is a legal play left on the board; false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cards = cardIndexes();
		int[] JQK = findJQK(cards);
		boolean found = true;
		for (int i : JQK) if(i==-1) found = false;
		return found || findPairSum11(cards)[0] != -1;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * 
	 * @param selectedCards selects a subset of this board. It is list of indexes
	 *                      into this board that are searched to find an 11-pair.
	 * @return true if the board entries in selectedCards contain an 11-pair; false
	 *         otherwise.
	 */
	private int[] findPairSum11(List<Integer> selectedCards) {
		int[] arr = new int[2];
		arr[0] = -1;
		for (int i = 0; i < selectedCards.size(); i++) {
			for (int j = i + 1; j < selectedCards.size(); j++) {
				if (super.cardAt(selectedCards.get(i)).pointValue() + super.cardAt(selectedCards.get(j)).pointValue() == 11) {
					arr[0] = i;
					arr[1] = j;
					return arr;
				}
			}
		}
		return arr;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * 
	 * @param selectedCards selects a subset of this board. It is list of indexes
	 *                      into this board that are searched to find a JQK group.
	 * @return true if the board entries in selectedCards include a jack, a queen,
	 *         and a king; false otherwise.
	 */
	private int[] findJQK(List<Integer> selectedCards) {
		int[] JQK = new int[3];
		for(int i = 0; i<3; i++)
			JQK[i] = -1;
		for (int index : selectedCards) {
			if (super.cardAt(index).rank().equals("jack"))
				JQK[0] = index;
			if (super.cardAt(index).rank().equals("queen"))
				JQK[1] = index;
			if (super.cardAt(index).rank().equals("king"))
				JQK[2] = index;
		}
		return JQK;
	}


	/**
	 * looks for a 11-pair and replaces it if found
	 * return true if replaced an 11 pair
	 */
	public boolean playPairSum11IfPossible(){

		return false;
	}

	/**
	 * Looks for a JQK triplet and replaces it if found
	 * @return true if replaces an JQK triplet
	 */
	public boolean playJQKIfPossible(){

		return false;
	}
	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		if(anotherPlayIsPossible()){

			return true;
		}
		return false; // REPLACE !
	}
}
