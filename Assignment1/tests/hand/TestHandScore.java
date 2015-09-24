package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestHandScore {

	@Test
	public void testRoyalFlushScore() {
		Hand h = new Hand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertEquals(1550, h.getHandScore());
	}
	
	@Test
	public void testStraightFlushScore() {
		Hand h = new Hand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertEquals(1400, h.getHandScore());
	}

}
