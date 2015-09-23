package tests;

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
		h.setHand(new Card("Ten", "Hearts"), new Card("Jack", "Hearts"), new Card("Queen", "Hearts"), new Card("King", "Hearts"), new Card("Ace", "Hearts"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ diamonds
		h.setHand(new Card("Ten", "Diamonds"), new Card("Jack", "Diamonds"), new Card("Queen", "Diamonds"), new Card("King", "Diamonds"), new Card("Ace", "Diamonds"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ spades
		h.setHand(new Card("Ten", "Spades"), new Card("Jack", "Spades"), new Card("Queen", "Spades"), new Card("King", "Spades"), new Card("Ace", "Spades"));
		assertTrue(h.isRoyalFlush());
		//test for royal flush w/ clubs
		h.setHand(new Card("Ten", "Clubs"), new Card("Jack", "Clubs"), new Card("Queen", "Clubs"), new Card("King", "Clubs"), new Card("Ace", "Clubs"));
		assertTrue(h.isRoyalFlush());
		//test to see that this hand is NOT a royal flush
		h.setHand(new Card("One", "Clubs"), new Card("Two", "Diamonds"), new Card("Two", "Spades"), new Card("King", "Clubs"), new Card("Six", "Hearts"));
		assertFalse(h.isRoyalFlush());
	}

}
