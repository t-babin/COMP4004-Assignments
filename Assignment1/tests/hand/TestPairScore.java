package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestPairScore {

	@Test
	public void testPairScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("QueenSpades"), new Card("KingDiamonds"), new Card("AceHearts"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("FiveDiamonds"), new Card("EightHearts"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
		
		Hand h3 = new Hand(new Card("ThreeClubs"), new Card("ThreeSpades"), new Card("TwoSpades"), new Card("FourDiamonds"), new Card("FiveHearts"));
		
		assertTrue(h3.getHandScore() > h1.getHandScore());
	}

}
