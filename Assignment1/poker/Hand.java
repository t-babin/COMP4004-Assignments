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
		String tmpSuit = cards.get(0).getCardSuit();
		for (int i = 1; i < 5; i++) {
			if (!cards.get(i).getCardSuit().equals(tmpSuit)) {
				return false;
			}
		}
		return cardsWithinRange(8, 14);
	}
	
	/*
	 * Checks if the list of cards have face values within a certain range.
	 */
	private boolean cardsWithinRange(int lowCard, int highCard) {
		for (int i = 0; i < 5; i++) {
			int tmpCardVal = cards.get(i).getCardIntValue();
			if (!(tmpCardVal > lowCard && tmpCardVal < highCard)) 
				return false;
		}
		return true;
	}

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
	 * Will probably be used for checking straights/straight flushes.
	 */
	private void sortByCardValue(ArrayList<Card> cards) { 
		Collections.sort(cards, new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				return Integer.valueOf(c1.getCardIntValue()).compareTo(c2.getCardIntValue());
			}
		});
	}
	
}
