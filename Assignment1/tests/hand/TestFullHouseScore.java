package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFullHouseScore {
	private static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static String[] faceValues = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

	@Test
	public void testFullHouseScore() {
		Hand h = new Hand();
		for (int i = 12; i >=0 ; i--) {
			for (int j = 12; j >= 0; j--) {
				Card c1 = new Card(faceValues[i] + suits[0]);
				Card c2 = new Card(faceValues[i] + suits[1]);
				Card c3 = new Card(faceValues[i] + suits[2]);
				Card c4 = new Card(faceValues[j] + suits[0]);
				Card c5 = new Card(faceValues[j] + suits[1]);
				if (j == i) {
					if (j == 0)
						break;
					else {
						j = j-1;
						c4 = new Card(faceValues[j] + suits[0]);
						c5 = new Card(faceValues[j] + suits[1]);
					}
				}
				h.setHand(c1, c2, c3, c4, c5);
				float expectedScore = 7.0f;
				float tmp = 0.0f;
				tmp += h.getCards().get(4).getCardIntValue() * 0.01f;
				tmp += h.getCards().get(3).getCardIntValue() * 0.001f;
				tmp += h.getCards().get(2).getCardIntValue() * 0.0001f;
				tmp += h.getCards().get(1).getCardIntValue() * 0.00001f;
				tmp += h.getCards().get(0).getCardIntValue() * 0.000001f;
				expectedScore += tmp;
				assertEquals(h.toString(), expectedScore, h.getHandScore(), 0.0f);
			}
		}
	}

}
