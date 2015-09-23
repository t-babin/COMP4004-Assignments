package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFullHouse {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testFullHouse() {
		h.setHand(new Card("Ace", "Hearts"), new Card("Ace", "Diamonds"), new Card("Ace", "Spades"), new Card("King", "Clubs"), new Card("King", "Diamonds"));
		assertTrue(h.isFullHouse());
		
		h.setHand(new Card("Ace", "Hearts"), new Card("Ace", "Diamonds"), new Card("King", "Spades"), new Card("King", "Clubs"), new Card("King", "Diamonds"));
		assertTrue(h.isFullHouse());
		
		h.setHand(new Card("Ten", "Hearts"), new Card("Ace", "Diamonds"), new Card("Ace", "Spades"), new Card("King", "Clubs"), new Card("King", "Diamonds"));
		assertFalse(h.isFullHouse());
	}

}
