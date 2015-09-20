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
		return false;
	}

	public void setHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		cards[0] = card1;
		cards[1] = card2;
		cards[2] = card3;
		cards[3] = card4;
		cards[4] = card5;
	}
	
}
