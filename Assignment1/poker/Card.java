package poker;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	private String cardValue; //The Card's Face Value
	private int cardIntValue; //The Card's Face Value as an integer from 1-13, Two being the lowest and Ace being the highest.
	private String cardSuit; // The Card's Suit
	private ArrayList<String> validCardVals = new ArrayList<String>(Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"));

	public Card(String value, String suit) {
		cardValue = value;
		cardSuit = suit;
		cardIntValue = validCardVals.indexOf(cardValue) + 1;
	}

	public Card(String input) {
		// TODO Auto-generated constructor stub
	}

	public int getCardIntValue() { return cardIntValue; }

	public String getCardValue() { return cardValue; }

	public void setCardValue(String cardValue) { this.cardValue = cardValue; }

	public String getCardSuit() { return cardSuit; }

	public void setCardSuit(String cardSuit) { this.cardSuit = cardSuit; }

	public String toString() { return cardValue + cardSuit + "(" + cardIntValue + ")"; }
}
