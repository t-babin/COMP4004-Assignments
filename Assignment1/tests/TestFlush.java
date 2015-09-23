package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFlush {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testFlush() {
		h.setHand(new Card("Ace", "Hearts"), new Card("Ten", "Hearts"), new Card("Five", "Hearts"), new Card("Two", "Hearts"), new Card("King", "Hearts"));
		assertTrue(h.isFlush());
		
		h.setHand(new Card("Ace", "Hearts"), new Card("Ten", "Clubs"), new Card("Four", "Spades"), new Card("Two", "Hearts"), new Card("King", "Hearts"));
		assertFalse(h.isFlush());
	}

}
