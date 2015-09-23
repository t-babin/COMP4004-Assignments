package tests;

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
		h.setHand(new Card("Two", "Spades"), new Card("Two", "Clubs"), new Card("Three", "Diamonds"), new Card("Ace", "Clubs"), new Card("Ten", "Spades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Nine", "Clubs"), new Card("Four", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Nine", "Clubs"), new Card("Four", "Diamonds"), new Card("Ace", "Clubs"), new Card("Nine", "Spades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Seven", "Clubs"), new Card("Ace", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isPair());
		
		h.setHand(new Card("Two", "Spades"), new Card("Four", "Clubs"), new Card("Six", "Diamonds"), new Card("Ace", "Clubs"), new Card("Eight", "Spades"));
		assertFalse(h.isPair());
	}

}
