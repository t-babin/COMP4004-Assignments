package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardInputCharacters {

	@Test
	public void testInputStartsWithUpper() {
		assertTrue(Card.isValidInput("TwoHearts"));
	}
	
	@Test
	public void testInputStartsWithLower() {
		assertFalse(Card.isValidInput("twoHearts"));
	}

}
