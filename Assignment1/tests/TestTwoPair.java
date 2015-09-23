package tests;

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
		h.setHand(new Card("Two", "Spades"), new Card("Two", "Clubs"), new Card("Four", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Two", "Clubs"), new Card("Ace", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Four", "Clubs"), new Card("Ace", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isTwoPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Five", "Clubs"), new Card("Jack", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertFalse(h.isTwoPair());
	}

}
