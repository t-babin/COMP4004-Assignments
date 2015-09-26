package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraightScore {

	@Test
	public void testStraightScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("FiveHearts"), new Card("AceDiamonds"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("FiveHearts"), new Card("SixDiamonds"));
		
		assertTrue(h1.getHandScore() < h2.getHandScore());
	}

}
