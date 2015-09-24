package tests.card;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class TestCardFaceValue {

	@Test
	public void testInputContainsFaceValue() {
		Card c = new Card("TwoHearts");
		assertTrue(c.isValidInput());
	}
	
	@Test
	public void testInputDoesNotContainFaceValue() {
		Card c = new Card("TtwoHearts");
		assertFalse(c.isValidInput());
	}

}
