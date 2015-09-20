package poker;

public class Card {
	private String cardValue;
	private String cardSuit;

	public Card(String value, String suit) {
		cardValue = value;
		cardSuit = suit;
	}

	public String getCardValue() {
		return cardValue;
	}

	public void setCardValue(String cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

}
