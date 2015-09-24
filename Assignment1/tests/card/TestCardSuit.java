package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardSuit {

	@Test
	public void testInputContainsSuit() {
		Card c = new Card("TwoHearts");
		assertTrue(c.isValidInput());
	}
	
	@Test
	public void testInputDoesNotContainSuit() {
		Card c = new Card("TwoShovels");
		assertFalse(c.isValidInput());
	}

}
