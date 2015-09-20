package poker;

public class Hand {
	private String[] cards;
	
	public Hand() {
		
	}

	public Hand(String card1, String card2, String card3, String card4, String card5) {
		cards = new String[5];
		cards[0] = card1;
		cards[1] = card2;
		cards[2] = card3;
		cards[3] = card4;
		cards[4] = card5;
	}

	public boolean isRoyalFlush() {
		return false;
	}
	
}
