package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;

public class TestCards {
	private static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static String[] faceValues = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCard() {
		for (int i = 0; i < faceValues.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				Card c = new Card(faceValues[i] + suits[j]);
				System.out.println(c);
				assertEquals(faceValues[i], c.getCardValue());
				assertEquals(i+1, c.getCardIntValue());
				assertEquals(suits[j], c.getCardSuit());
			}
		}		
	}

}
