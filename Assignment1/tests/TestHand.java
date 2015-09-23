package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestHand {
	
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
	
	@Test
	public void testFourOfAKind() {
		h.setHand(new Card("Ace", "Hearts"), new Card("Ace", "Diamonds"), new Card("Ace", "Spades"), new Card("Ace", "Clubs"), new Card("Six", "Clubs"));
		assertTrue(h.isFourOfAKind());
		
		h.setHand(new Card("Ace", "Hearts"), new Card("King", "Diamonds"), new Card("King", "Clubs"), new Card("King", "Hearts"), new Card("Six", "Hearts"));
		assertFalse(h.isFourOfAKind());
		
		h.setHand(new Card("Six", "Hearts"), new Card("Six", "Diamonds"), new Card("Six", "Spades"), new Card("Six", "Clubs"), new Card("Ace", "Clubs"));
		assertTrue(h.isFourOfAKind());
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
	
	@Test
	public void testFlush() {
		h.setHand(new Card("Ace", "Hearts"), new Card("Ten", "Hearts"), new Card("Five", "Hearts"), new Card("Two", "Hearts"), new Card("King", "Hearts"));
		assertTrue(h.isFlush());
		
		h.setHand(new Card("Ace", "Hearts"), new Card("Ten", "Clubs"), new Card("Four", "Spades"), new Card("Two", "Hearts"), new Card("King", "Hearts"));
		assertFalse(h.isFlush());
	}
	
	@Test
	public void testStraight() {
		h.setHand(new Card("Two", "Clubs"), new Card("Three", "Hearts"), new Card("Four", "Diamonds"), new Card("Five", "Spades"), new Card("Six", "Hearts"));
		assertTrue(h.isStraight());
		
		h.setHand(new Card("Nine", "Clubs"), new Card("Three", "Hearts"), new Card("Four", "Diamonds"), new Card("Five", "Spades"), new Card("Six", "Hearts"));
		assertFalse(h.isStraight());
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
