package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestHandScore {

	@Test
	public void testRoyalFlushScore() {
		Hand h = new Hand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertEquals(1000, h.getHandScore());
	}

}
