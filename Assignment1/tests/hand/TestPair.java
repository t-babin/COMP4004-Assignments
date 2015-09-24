package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestPair {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testPair() {
		h.setHand(new Card("TwoSpades"), new Card("TwoClubs"), new Card("ThreeDiamonds"), new Card("AceClubs"), new Card("TenSpades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("TwoSpades"), new Card("NineClubs"), new Card("FourDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("TwoSpades"), new Card("NineClubs"), new Card("FourDiamonds"), new Card("AceClubs"), new Card("NineSpades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("TwoSpades"), new Card("SevenClubs"), new Card("AceDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("TwoSpades"), new Card("FourClubs"), new Card("SixDiamonds"), new Card("AceClubs"), new Card("EightSpades"));
		assertFalse(h.isPair());
	}

}
