package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFourOfAKind {
	
	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@Test
	public void testFourOfAKind() {
		h.setHand(new Card("AceHearts"), new Card("AceDiamonds"), new Card("AceSpades"), new Card("AceClubs"), new Card("SixClubs"));
		assertTrue(h.isFourOfAKind());
		
		h.setHand(new Card("AceHearts"), new Card("KingDiamonds"), new Card("KingClubs"), new Card("KingHearts"), new Card("SixHearts"));
		assertFalse(h.isFourOfAKind());
		
		h.setHand(new Card("SixHearts"), new Card("SixDiamonds"), new Card("SixSpades"), new Card("SixClubs"), new Card("AceClubs"));
		assertTrue(h.isFourOfAKind());
	}

}
