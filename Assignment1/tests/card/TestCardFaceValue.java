package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardFaceValue {

	@Test
	public void testInputContainsFaceValue() {
		assertTrue(Card.isValidInput("TwoHearts"));
	}
	
	@Test
	public void testInputDoesNotContainFaceValue() {
		assertFalse(Card.isValidInput("TtwoHearts"));
	}

}
