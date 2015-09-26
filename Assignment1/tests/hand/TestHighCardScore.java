package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestHighCardScore {

	@Test
	public void testHighCardScore() {
		Hand h1 = new Hand(new Card("AceDiamonds"), new Card("TwoSpades"), new Card("FiveClubs"), new Card("NineHearts"), new Card("FourClubs"));
		Hand h2 = new Hand(new Card("KingDiamonds"), new Card("QueenSpades"), new Card("TenClubs"), new Card("NineHearts"), new Card("EightDiamonds"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
	}

}
