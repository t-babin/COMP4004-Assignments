package poker;

public class Hand {
	private Card[] cards;
	
	public Hand() {
		
	}

	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		cards = new Card[5];
		cards[0] = card1;
		cards[1] = card2;
		cards[2] = card3;
		cards[3] = card4;
		cards[4] = card5;
	}

	public boolean isRoyalFlush() {
		String tmpSuit = cards[0].getCardSuit();
		for (int i = 1; i < 5; i++) {
			if (!cards[i].getCardSuit().equals(tmpSuit)) {
				return false;
			}
		}
		for (int i = 0; i < 5; i++) {
			String tmpCardVal = cards[i].getCardValue();
			if (!(tmpCardVal.equals("Ten") || tmpCardVal.equals("Jack") || tmpCardVal.equals("Queen") || tmpCardVal.equals("King") || tmpCardVal.equals("Ace")))
				return false;
		}
		return true;
	}

	public void setHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		cards[0] = card1;
		cards[1] = card2;
		cards[2] = card3;
		cards[3] = card4;
		cards[4] = card5;
	}
	
}
