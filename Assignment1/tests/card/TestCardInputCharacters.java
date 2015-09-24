package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardInputCharacters {

	@Test
	public void testInputStartsWithUpper() {
		Card c = new Card("TwoHearts");
		assertTrue(c.isValidInput());
	}
	
	@Test
	public void testInputStartsWithLower() {
		Card c = new Card("twoHearts");
		assertFalse(c.isValidInput());
	}

}
