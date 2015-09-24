package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraightFlush {
	
	private Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@Test
	public void testStraightFlush() {
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"), new Card("AceHearts"));
		assertTrue(h.isStraightFlush());
		assertTrue(h.isRoyalFlush());
		h.setHand(new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"), new Card("AceHearts"), new Card("TwoHearts"));
		assertFalse(h.isStraightFlush());
		assertFalse(h.isRoyalFlush());
		h.setHand(new Card("QueenHearts"), new Card("KingHearts"), new Card("AceHearts"), new Card("TwoHearts"), new Card("ThreeHearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("KingHearts"), new Card("AceHearts"), new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("AceHearts"), new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"));
		assertTrue(h.isStraightFlush());
		h.setHand(new Card("AceHearts"), new Card("SevenHearts"), new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"));
		assertFalse(h.isStraightFlush());
		h.setHand(new Card("TwoHearts"), new Card("FourClubs"), new Card("FourHearts"), new Card("NineSpades"), new Card("FourDiamonds"));
		assertFalse(h.isStraightFlush());
	}

}
