package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardSuit {

	@Test
	public void testInputContainsSuit() {
		assertTrue(Card.isValidInput("TwoHearts"));
	}
	
	@Test
	public void testInputDoesNotContainSuit() {
		assertFalse(Card.isValidInput("TwoShovels"));
	}

}
