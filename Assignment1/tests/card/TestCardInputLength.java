package tests.card;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;

public class TestCardInputLength {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCardInputLengthShort() {
		assertFalse(Card.isValidInput("Two"));
	}
	
	@Test
	public void testCardInputLengthLong() {
		assertFalse(Card.isValidInput("Twothreefourfivesix"));
	}

}
