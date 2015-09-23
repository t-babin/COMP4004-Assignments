package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraightFlush {
	
	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@Test
	public void testStraightFlush() {
		h.setHand(new Card("Two", "Hearts"), new Card("Three", "Hearts"), new Card("Four", "Hearts"), new Card("Five", "Hearts"), new Card("Six", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Three", "Hearts"), new Card("Four", "Hearts"), new Card("Five", "Hearts"), new Card("Six", "Hearts"), new Card("Seven", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Four", "Hearts"), new Card("Five", "Hearts"), new Card("Six", "Hearts"), new Card("Seven", "Hearts"), new Card("Eight", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Five", "Hearts"), new Card("Six", "Hearts"), new Card("Seven", "Hearts"), new Card("Eight", "Hearts"), new Card("Nine", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Six", "Hearts"), new Card("Seven", "Hearts"), new Card("Eight", "Hearts"), new Card("Nine", "Hearts"), new Card("Ten", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Seven", "Hearts"), new Card("Eight", "Hearts"), new Card("Nine", "Hearts"), new Card("Ten", "Hearts"), new Card("Jack", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Eight", "Hearts"), new Card("Nine", "Hearts"), new Card("Ten", "Hearts"), new Card("Jack", "Hearts"), new Card("Queen", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Nine", "Hearts"), new Card("Ten", "Hearts"), new Card("Jack", "Hearts"), new Card("Queen", "Hearts"), new Card("King", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Ten", "Hearts"), new Card("Jack", "Hearts"), new Card("Queen", "Hearts"), new Card("King", "Hearts"), new Card("Ace", "Hearts"));
		assertTrue(h.isStraightFlush());
		assertTrue(h.isRoyalFlush());
		h.setHand(new Card("Jack", "Hearts"), new Card("Queen", "Hearts"), new Card("King", "Hearts"), new Card("Ace", "Hearts"), new Card("Two", "Hearts"));
		assertFalse(h.isStraightFlush());
		assertFalse(h.isRoyalFlush());
		h.setHand(new Card("Queen", "Hearts"), new Card("King", "Hearts"), new Card("Ace", "Hearts"), new Card("Two", "Hearts"), new Card("Three", "Hearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("King", "Hearts"), new Card("Ace", "Hearts"), new Card("Two", "Hearts"), new Card("Three", "Hearts"), new Card("Four", "Hearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("Ace", "Hearts"), new Card("Two", "Hearts"), new Card("Three", "Hearts"), new Card("Four", "Hearts"), new Card("Five", "Hearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("Ace", "Hearts"), new Card("Seven", "Hearts"), new Card("Two", "Hearts"), new Card("Three", "Hearts"), new Card("Four", "Hearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("Two", "Hearts"), new Card("Four", "Clubs"), new Card("Four", "Hearts"), new Card("Nine", "Spades"), new Card("Four", "Diamonds"));
		assertFalse(h.isStraightFlush());
	}

}
