package tests;

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
		h.setHand(new Card("Two", "Spades"), new Card("Two", "Clubs"), new Card("Two", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("Two", "Spades"), new Card("Three", "Clubs"), new Card("Three", "Diamonds"), new Card("Three", "Clubs"), new Card("Four", "Spades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("Two", "Spades"), new Card("Three", "Clubs"), new Card("Five", "Diamonds"), new Card("Five", "Clubs"), new Card("Five", "Spades"));
		assertTrue(h.isThreeOfAKind());
		
		h.setHand(new Card("Nine", "Spades"), new Card("Two", "Clubs"), new Card("Two", "Diamonds"), new Card("Ace", "Clubs"), new Card("Four", "Spades"));
		assertFalse(h.isThreeOfAKind());
	}

}
