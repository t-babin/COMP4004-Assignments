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
		return cardsWithinRange(9, 13);
	}
	
	/*
	 * Method to check whether a hand is a straight flush or not.
	 * (1) Check to see all the cards are the same suit
	 * (2) Check to see all the cards are within a 5 value range
	 */
	public boolean isStraightFlush() {
		String tmpSuit = cards.get(0).getCardSuit();
		for (int i = 1; i < 5; i++) {
			if (!cards.get(i).getCardSuit().equals(tmpSuit))
				return false;
		}
		sortByCardValue(cards);
				
		return checkForStraight();
	}
	
	public boolean isFourOfAKind() {
		return false;
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
	private boolean checkForStraight() {
//		System.out.println(cards);
		for (int i = 0; i < 4; i++) {
			int first = cards.get(i).getCardIntValue();
			int second = cards.get(i+1).getCardIntValue();
//			System.out.println(second + "-" + first + "=" + (second - first));
			if ((second - first) != 1) {
				if ((second - first) == 9) {
					if (!(second == 13) && !(first == 13))
						return false;
				}
				else
					return false;
			}
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
	
	public String getHand() {
		String s = "";
		for (Card c : cards) {
			s += c.toString() + ",";
		}
		
		s = s.substring(0, s.length()-1);
		
		return s;
	}	
}
