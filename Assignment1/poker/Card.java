package poker;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	private String cardValue; //The Card's Face Value
	private int cardIntValue; //The Card's Face Value as an integer from 1-13, Two being the lowest and Ace being the highest.
	private String cardSuit; // The Card's Suit
	private static ArrayList<String> validCardVals = new ArrayList<String>(Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"));
	private static ArrayList<String> validCardSuits = new ArrayList<String>(Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"));
//	private String tmpInput;
	private static final int MIN_INPUT_LENGTH = 8;
	private static final int MAX_INPUT_VALUE = 13;

	public Card(String input) {
		extractCard(input);
	}

	public int getCardIntValue() { return cardIntValue; }

	public String getCardValue() { return cardValue; }

	public void setCardValue(String cardValue) { this.cardValue = cardValue; }

	public String getCardSuit() { return cardSuit; }

	public void setCardSuit(String cardSuit) { this.cardSuit = cardSuit; }

	public String toString() { return cardValue + cardSuit; }
	
	private void extractCard(String in) {
		int index = 1;
		while (!Character.isUpperCase(in.charAt(index)))
			index++;
		String faceValue = in.substring(0, index);
		
		cardValue = faceValue;
		cardIntValue = validCardVals.indexOf(cardValue) + 1;
		
		String suit = in.substring(index, in.length());
		cardSuit = suit;
	}

	public static boolean isValidInput(String tmpInput) {
		if (tmpInput.length() < MIN_INPUT_LENGTH || tmpInput.length() > MAX_INPUT_VALUE)
			return false;
		if (!Character.isUpperCase(tmpInput.charAt(0)))
			return false;
		int index = 1;
		while (!Character.isUpperCase(tmpInput.charAt(index))) {
			if (index < tmpInput.length()-1)
				index++;
			else
				return false;
		}
		String faceValue = tmpInput.substring(0, index);
		if (!validCardVals.contains(faceValue))
			return false;
		
		String suit = tmpInput.substring(index, tmpInput.length());
		if (!Character.isUpperCase(suit.charAt(0)))
			return false;
		else if (!validCardSuits.contains(suit))
			return false;
		
		return true;
	}

	//eclipse generated hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardSuit == null) ? 0 : cardSuit.hashCode());
		result = prime * result
				+ ((cardValue == null) ? 0 : cardValue.hashCode());
		return result;
	}

	//eclipse generated equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardSuit == null) {
			if (other.cardSuit != null)
				return false;
		} else if (!cardSuit.equals(other.cardSuit))
			return false;
		if (cardValue == null) {
			if (other.cardValue != null)
				return false;
		} else if (!cardValue.equals(other.cardValue))
			return false;
		return true;
	}
	
	
}
