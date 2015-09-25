package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
	private ArrayList<Card> cards;
	public ArrayList<Card> getCards() {
		return cards;
	}

	private boolean lowStraight = false;
	private static final float ROYAL_FLUSH = 10.0f;
	private static final float STRAIGHT_FLUSH = 9.0f;
	private static final float FOUR_OF_A_KIND = 8.0f;
	private static final float FULL_HOUSE = 7.0f;
	private static final float FLUSH = 6.0f;
	private static final float STRAIGHT = 5.0f;
	private static final float THREE_OF_A_KIND = 4.0f;
	private static final float TWO_PAIR = 3.0f;
	private static final float PAIR = 2.0f;
	private float totalScore = 0;	
	
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
		//case where first three cards have the same face value
		if (counter == 3) {
			faceValue = cards.get(3).getCardIntValue();
			counter = 1;
			for (int i = 4; i < 5; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;;
			}
			//next two cards have the same face value
			if (counter == 2)
				return true;
			else
				return false;
		}
		//case where the first two cards have the same face value
		else if (counter == 2) {
			faceValue = cards.get(2).getCardIntValue();
			counter = 1;
			for (int i = 3; i < 5; i++) {
				if (cards.get(i).getCardIntValue() == faceValue)
					counter++;;
			}
			//next three cards have the same face value
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
					else
						lowStraight = true;
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
	 * Method to check whether any two cards in a hand are a pair.
	 */
	public boolean isPair() {
		sortByCardValue();
		//case 1: cards 1,2 form a pair.
		if (cards.get(0).getCardIntValue() == cards.get(1).getCardIntValue())
			return true;
		//case 2: cards 2,3 form a pair.
		else if (cards.get(1).getCardIntValue() == cards.get(2).getCardIntValue())
			return true;
		//case 3: cards 3,4 form a pair.
		else if (cards.get(2).getCardIntValue() == cards.get(3).getCardIntValue())
			return true;
		//case 4: cards 4,5 form a pair.
		else if (cards.get(3).getCardIntValue() == cards.get(4).getCardIntValue())
			return true;
		//no pair found.
		else
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
		sortByCardValue();
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
	
	/*
	 * Sorts the card list by card frequency. Useful for pair, three of a kind, 2 pair
	 */
	private ArrayList<Integer> sortByCardFrequency() {
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		sortByCardValue();
		for (int i = 0; i < cards.size(); i++) {
			if (!freq.containsKey(cards.get(i).getCardIntValue()))
				freq.put(cards.get(i).getCardIntValue(), 1);
			else {
				int tmp = freq.get(cards.get(i).getCardIntValue());
				tmp++;
				freq.put(cards.get(i).getCardIntValue(), tmp);
			}
		}
		
		List<Map.Entry<Integer, Integer>> l = new ArrayList<Map.Entry<Integer, Integer>>(freq.entrySet());
		
		Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
				return c2.getValue().compareTo(c1.getValue());
			}
		});		
		
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		ArrayList<Integer> nonDuplicates = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> e : l) {
			if (e.getValue() > 1) {
				for (int i = 0; i < e.getValue(); i++)
					toReturn.add(e.getKey());
			}
			else {
				nonDuplicates.add(e.getKey());
			}
		}
		Collections.reverse(nonDuplicates);
		Collections.reverse(toReturn);
		toReturn.addAll(nonDuplicates);
		Collections.reverse(toReturn);
		System.out.println(toReturn);
		return toReturn;
	}

	/*
	 * Method to check if a hand contains duplicate cards.
	 */
	public boolean noDuplicates() {
		sortByCardValue();
		for (int i = 1; i < 5; i++) {
			if (cards.get(i).equals(cards.get(0)))
				return false;
		}
		for (int i = 2; i < 5; i++) {
			if (cards.get(i).equals(cards.get(1)))
				return false;
		}
		for (int i = 3; i < 5; i++) {
			if (cards.get(i).equals(cards.get(2)))
				return false;
		}
		if (cards.get(4).equals(cards.get(3)))
			return false;
		return true;
	}

	/*
	 * Method to get the "score" of a hand. Used for determining rankings.
	 */
	public float getHandScore() {
		
		if (isRoyalFlush()) {
			totalScore = ROYAL_FLUSH + addToScore();
			return totalScore;
		}
		else if (isStraightFlush()) {
			totalScore = STRAIGHT_FLUSH + addToScore();
			if (lowStraight)
				totalScore -= 0.13;
			return totalScore;
		}
		else if (isFourOfAKind()) {
			totalScore = FOUR_OF_A_KIND + addToScore();
			return totalScore;
		}
		else if (isFullHouse()) {
			totalScore = FULL_HOUSE + addToScore();
			return totalScore;
		}
		else if (isFlush()) {
			sortByCardValue();
			totalScore = FLUSH + addToScore();
			return totalScore;
		}
		else if (isStraight()) {
			sortByCardValue();
			totalScore = STRAIGHT + addToScore();
			if (lowStraight)
				totalScore -= 0.13;
			return totalScore;
		}
		else if (isThreeOfAKind()) {		
			totalScore = THREE_OF_A_KIND + addToScore(sortByCardFrequency());
			return totalScore;
		}
		else if (isTwoPair()) {
			totalScore = TWO_PAIR + addToScore(sortByCardFrequency());
			return totalScore;
		}
		else if (isPair()) {
			totalScore = PAIR + addToScore(sortByCardFrequency());
			System.out.println(totalScore);
			return totalScore;
		}
		else {
			totalScore = addToScore();
			return totalScore;
		}
	}
	
	private float addToScore() {
		float score = 0.0f;
		score += cards.get(4).getCardIntValue() * 0.01f;
		score += cards.get(3).getCardIntValue() * 0.001f;
		score += cards.get(2).getCardIntValue() * 0.0001f;
		score += cards.get(1).getCardIntValue() * 0.00001f;
		score += cards.get(0).getCardIntValue() * 0.000001f;
		return score;
	}
	
	private float addToScore(ArrayList<Integer> list) {
		float score = 0.0f;
		score += list.get(4) * 0.01f;
		score += list.get(3) * 0.001f;
		score += list.get(2) * 0.0001f;
		score += list.get(1) * 0.00001f;
		score += list.get(0) * 0.000001f;
		return score;
	}
	
	public String toString() {
		String str = "";		
		for (Card c : cards)
			str += c + ",";
		str = str.substring(0, str.length()-1);
		return str;
	}

	//eclipse-generated method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	//eclipse-generated method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}
}
