package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestTwoPairScore {

	@Test
	public void testTwoPairScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("FourHearts"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("SevenHearts"));
		
		assertTrue(h2.getHandScore() > h1.getHandScore());
		
		Hand h3 = new Hand(new Card("TwoClubs"), new Card("SevenSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("SevenHearts"));
		
		assertTrue(h3.getHandScore() > h2.getHandScore());
	}

}
