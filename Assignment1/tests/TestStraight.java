package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraight {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testStraight() {
		h.setHand(new Card("TwoClubs"), new Card("ThreeHearts"), new Card("FourDiamonds"), new Card("FiveSpades"), new Card("SixHearts"));
		assertTrue(h.isStraight());
		
		h.setHand(new Card("NineClubs"), new Card("ThreeHearts"), new Card("FourDiamonds"), new Card("FiveSpades"), new Card("SixHearts"));
		assertFalse(h.isStraight());
	}

}
