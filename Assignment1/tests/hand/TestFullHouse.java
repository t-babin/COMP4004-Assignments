package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestFullHouse {

	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}
	
	@Test
	public void testFullHouse() {
		h.setHand(new Card("AceHearts"), new Card("AceDiamonds"), new Card("AceSpades"), new Card("KingClubs"), new Card("KingDiamonds"));
		assertTrue(h.isFullHouse());
		
		h.setHand(new Card("AceHearts"), new Card("AceDiamonds"), new Card("KingSpades"), new Card("KingClubs"), new Card("KingDiamonds"));
		assertTrue(h.isFullHouse());
		
		h.setHand(new Card("TenHearts"), new Card("AceDiamonds"), new Card("AceSpades"), new Card("KingClubs"), new Card("KingDiamonds"));
		assertFalse(h.isFullHouse());
	}

}
