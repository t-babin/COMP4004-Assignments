package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraight {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testStraight() {
		h.setHand(new Card("Two", "Clubs"), new Card("Three", "Hearts"), new Card("Four", "Diamonds"), new Card("Five", "Spades"), new Card("Six", "Hearts"));
		assertTrue(h.isStraight());
		
		h.setHand(new Card("Nine", "Clubs"), new Card("Three", "Hearts"), new Card("Four", "Diamonds"), new Card("Five", "Spades"), new Card("Six", "Hearts"));
		assertFalse(h.isStraight());
	}

}
