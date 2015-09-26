package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFlushScore {

	@Test
	public void testFlushScore() {
		Hand h1 = new Hand(new Card("AceSpades"), new Card("KingSpades"), new Card("FourSpades"), new Card("ThreeSpades"), new Card("TwoSpades"));
		Hand h2 = new Hand(new Card("AceSpades"), new Card("QueenSpades"), new Card("JackSpades"), new Card("TenSpades"), new Card("NineSpades"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
		
		Hand h3 = new Hand(new Card("AceDiamonds"), new Card("KingDiamonds"), new Card("FourDiamonds"), new Card("ThreeDiamonds"), new Card("TwoDiamonds"));
		assertEquals(h1.getHandScore(), h3.getHandScore(), 0.0f);
	}

}
