package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestRoyalFlush {
	
	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@Test
	public void testRoyalFlush() {
		//Test for royal flush w/ hearts
		h.setHand(new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"), new Card("AceHearts"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ diamonds
		h.setHand(new Card("TenDiamonds"), new Card("JackDiamonds"), new Card("QueenDiamonds"), new Card("KingDiamonds"), new Card("AceDiamonds"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ spades
		h.setHand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ clubs
		h.setHand(new Card("TenClubs"), new Card("JackClubs"), new Card("QueenClubs"), new Card("KingClubs"), new Card("AceClubs"));
		assertTrue(h.isRoyalFlush());
		//test to see that this hand is NOT a royal flush
		h.setHand(new Card("AceClubs"), new Card("TwoDiamonds"), new Card("TwoSpades"), new Card("KingClubs"), new Card("SixHearts"));
		assertFalse(h.isRoyalFlush());
	}

}
