package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;

public class TestCardInputLength {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCardInputLength() {
		Card c = new Card("Two");
		assertFalse(c.isValidInput());
	}

}
