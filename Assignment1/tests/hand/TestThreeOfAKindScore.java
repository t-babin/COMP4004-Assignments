package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestThreeOfAKindScore {

	@Test
	public void testThreeOfAKindScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("FiveHearts"), new Card("AceDiamonds"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("QueenHearts"), new Card("KingDiamonds"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
		
		Hand h3 = new Hand(new Card("ThreeClubs"), new Card("ThreeDiamonds"), new Card("ThreeSpades"), new Card("TwoClubs"), new Card("FiveSpades"));
		
		assertTrue(h3.getHandScore() > h1.getHandScore());
	}

}
