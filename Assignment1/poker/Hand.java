package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private ArrayList<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}

	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
	}

	/*
	 * Method to check whether a hand is a royal flush or not.
	 * (1) Check to see all the cards are the same suit
	 * (2) Check to see all the cards are within the range of Ten - Ace
	 */
	public boolean isRoyalFlush() {
		if (isFlush())
			return cardsWithinRange(9, 13);
		else
			return false;
	}
	
	/*
	 * Method to check whether a hand is a straight flush or not.
	 * (1) Check to see all the cards are the same suit
	 * (2) Check to see all the cards are within a 5 value range
	 */
	public boolean isStraightFlush() {
		if (isFlush())
			return isStraight();
		else
			return false;
	}
	
	/*
	 * Method to check whether a hand is a four of a kind or not.
	 */
	public boolean isFourOfAKind() {
		sortByCardValue();
		int faceValue = cards.get(0).getCardIntValue();
		int counter = 1;
		//case where cards 1-4 have the same face value
		for (int i = 1; i < 4; i++) {
			if (cards.get(i).getCardIntValue() == faceValue)
				counter++;
			else
				break;
		}
		if (counter == 4)
			return true;
		//case where cards 2-5 have the same face value
		else {
			faceValue = cards.get(1).getCardIntValue();
			counter = 1;
			for (int i = 2; i < 5; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;
			}
			if (counter == 4)
				return true;
			else
				return false;
		}		
	}
	
	/*
	 * Method to check whether a hand is a full house or not.
	 */
	public boolean isFullHouse() {
		sortByCardValue();
		int faceValue = cards.get(0).getCardIntValue();
		int counter = 1;
		for (int i = 1; i < 5; i++) {
			if (cards.get(i).getCardIntValue() == faceValue)
				counter++;
		}
		if (counter == 3) {
			faceValue = cards.get(3).getCardIntValue();
			counter = 1;
			for (int i = 4; i < 5; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;;
			}
			if (counter == 2)
				return true;
			else
				return false;
		}
		else if (counter == 2) {
			faceValue = cards.get(2).getCardIntValue();
			counter = 1;
			for (int i = 3; i < 5; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;;
			}
			if (counter == 3)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	/*
	 * Method to determine whether a hand is a flush or not.
	 */
	public boolean isFlush() {
		String tmpSuit = cards.get(0).getCardSuit();
		//check that the remaining 4 cards in the hand are the same suit as the first card.
		for (int i = 1; i < 5; i++) {
			if (!cards.get(i).getCardSuit().equals(tmpSuit)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Method to determine whether a hand contains a straight or not.
	 */
	public boolean isStraight() {
		sortByCardValue();
		for (int i = 0; i < 4; i++) {
			int first = cards.get(i).getCardIntValue();
			int second = cards.get(i+1).getCardIntValue();
			if ((second - first) != 1) {
				if ((second - first) == 9) {
					//This should only happen in the case where the straight is A,2,3,4,5
					if (!(second == 13) && !(first == 13))
						return false;
				}
				else
					return false;
			}
		}
		return true;
	}
	
	/*
	 * Checks whether a hand is a three of a kind or not.
	 */
	public boolean isThreeOfAKind() {
		sortByCardValue();
		int faceValue = cards.get(0).getCardIntValue();
		int counter = 1;
		//Case where cards 1-3 are the same
		for (int i = 1; i < 3; i++) {
			if (cards.get(i).getCardIntValue() == faceValue) {
				counter++;
			}
		}
		if (counter == 3)
			return true;
		else {
			faceValue = cards.get(1).getCardIntValue();
			counter = 1;
			//case where cards 2-4 are the same
			for (int i = 2; i < 4; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;
			}
			if (counter == 3) 
				return true;
			else {
				//case where cards 3-5 are the same
				faceValue = cards.get(2).getCardIntValue();
				counter = 1;
				for (int i = 3; i < 5; i++) {
					if (cards.get(i).getCardIntValue() == faceValue)
						counter++;
					//no need to check any further
					else
						return false;
				}
				if (counter == 3)
					return true;
				else
					return false;
			}
		}
	}
	
	/*
	 * Checks whether a hand has two pairs or not.
	 */
	public boolean isTwoPair() {
		sortByCardValue();
		//case 1: cards 1,2 form a pair; cards 3,4 form a second pair.
		if (cards.get(0).getCardIntValue() == cards.get(1).getCardIntValue()) {
			if (cards.get(2).getCardIntValue() == cards.get(3).getCardIntValue())
				return true;
			//case 2: cards 1,2 form a pair; cards 4,5 form a second pair.
			else {
				if (cards.get(3).getCardIntValue() == cards.get(4).getCardIntValue())
					return true;
				else 
					return false;
			}
		}
		//case 3: cards 2,3 form a pair; cards 4,5 form a second pair.
		else {
			if (cards.get(1).getCardIntValue() == cards.get(2).getCardIntValue()) {
				if (cards.get(3).getCardIntValue() == cards.get(4).getCardIntValue())
					return true;
				else
					return false;
			}
			else 
				return false;
		}
	}
	
	/*
	 * Checks if the list of cards have face values within a certain range.
	 */
	private boolean cardsWithinRange(int lowCard, int highCard) {
		for (int i = 0; i < 5; i++) {
			int tmpCardVal = cards.get(i).getCardIntValue();
			if (!(tmpCardVal >= lowCard && tmpCardVal <= highCard)) 
				return false;
		}
		return true;
	}
	
	/*
	 * Method to determine if a hand contains a straight.
	 * The difference in value between cards in increasing order should be either 1 or 9.
	 */
	

	public void setHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		if (cards.size() != 0) {
			cards.set(0, card1);
			cards.set(1, card2);
			cards.set(2, card3);
			cards.set(3, card4);
			cards.set(4, card5);
		}
		else {
			cards.add(card1);
			cards.add(card2);
			cards.add(card3);
			cards.add(card4);
			cards.add(card5);
		}
	}
	
	/*
	 * Sorts the hand in order from lowest face value to highest.
	 * Useful for finding straights, pairs, etc.
	 */
	private void sortByCardValue() { 
		Collections.sort(cards, new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				return Integer.valueOf(c1.getCardIntValue()).compareTo(c2.getCardIntValue());
			}
		});
	}
	
	public String getHand() {
		String s = "";
		for (Card c : cards) {
			s += c.toString() + ",";
		}
		
		s = s.substring(0, s.length()-1);
		
		return s;
	}
}
