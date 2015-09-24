package poker;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	private String cardValue; //The Card's Face Value
	private int cardIntValue; //The Card's Face Value as an integer from 1-13, Two being the lowest and Ace being the highest.
	private String cardSuit; // The Card's Suit
	private ArrayList<String> validCardVals = new ArrayList<String>(Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"));
	private ArrayList<String> validCardSuits = new ArrayList<String>(Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"));
	private String tmpInput;
	private final int MIN_INPUT_VALUE = 8;

	public Card(String input) {
		tmpInput = input;
		if (isValidInput()) {
			
		}
	}

	public int getCardIntValue() { return cardIntValue; }

	public String getCardValue() { return cardValue; }

	public void setCardValue(String cardValue) { this.cardValue = cardValue; }

	public String getCardSuit() { return cardSuit; }

	public void setCardSuit(String cardSuit) { this.cardSuit = cardSuit; }

	public String toString() { return cardValue + cardSuit + "(" + cardIntValue + ")"; }

	public boolean isValidInput() {
		if (tmpInput.length() < MIN_INPUT_VALUE)
			return false;
		return true;
	}
}
