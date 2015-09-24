package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestThreeOfAKind {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testThreeOfAKind() {
		h.setHand(new Card("TwoSpades"), new Card("TwoClubs"), new Card("TwoDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("TwoSpades"), new Card("ThreeClubs"), new Card("ThreeDiamonds"), new Card("ThreeClubs"), new Card("FourSpades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("TwoSpades"), new Card("ThreeClubs"), new Card("FiveDiamonds"), new Card("FiveClubs"), new Card("FiveSpades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("NineSpades"), new Card("TwoClubs"), new Card("TwoDiamonds"), new Card("AceClubs"), new Card("FourSpades"));
		assertFalse(h.isThreeOfAKind());
	}

}
