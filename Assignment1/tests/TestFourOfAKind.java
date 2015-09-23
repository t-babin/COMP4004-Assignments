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
		h.setHand(new Card("Ace", "Hearts"), new Card("Ace", "Diamonds"), new Card("Ace", "Spades"), new Card("Ace", "Clubs"), new Card("Six", "Clubs"));
		assertTrue(h.isFourOfAKind());
		
		h.setHand(new Card("Ace", "Hearts"), new Card("King", "Diamonds"), new Card("King", "Clubs"), new Card("King", "Hearts"), new Card("Six", "Hearts"));
		assertFalse(h.isFourOfAKind());
		
		h.setHand(new Card("Six", "Hearts"), new Card("Six", "Diamonds"), new Card("Six", "Spades"), new Card("Six", "Clubs"), new Card("Ace", "Clubs"));
		assertTrue(h.isFourOfAKind());
	}

}
