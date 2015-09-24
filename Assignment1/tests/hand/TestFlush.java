package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFlush {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testFlush() {
		h.setHand(new Card("AceHearts"), new Card("TenHearts"), new Card("FiveHearts"), new Card("TwoHearts"), new Card("KingHearts"));
		assertTrue(h.isFlush());
		
		h.setHand(new Card("AceHearts"), new Card("TenClubs"), new Card("FourSpades"), new Card("TwoHearts"), new Card("KingHearts"));
		assertFalse(h.isFlush());
	}

}
