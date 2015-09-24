package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestTwoPair {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testTwoPair() {
		h.setHand(new Card("TwoSpades"), new Card("TwoClubs"), new Card("FourDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("TwoSpades"), new Card("TwoClubs"), new Card("AceDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("TwoSpades"), new Card("FourClubs"), new Card("AceDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("TwoSpades"), new Card("FiveClubs"), new Card("JackDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertFalse(h.isTwoPair());
	}

}
