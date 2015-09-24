package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestHandScore {

	@Test
	public void testRoyalFlushScore() {
		Hand h = new Hand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertEquals(10550, h.getHandScore());
	}
	
	@Test
	public void testStraightFlushScore() {
		Hand h = new Hand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertEquals(9500, h.getHandScore());
		
		h.setHand(new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"));
		assertEquals(9450, h.getHandScore());
		
		h.setHand(new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"));
		assertEquals(9400, h.getHandScore());
		
		h.setHand(new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"));
		assertEquals(9350, h.getHandScore());
		
		h.setHand(new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"));
		assertEquals(9300, h.getHandScore());
		
		h.setHand(new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"));
		assertEquals(9250, h.getHandScore());
		
		h.setHand(new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"));
		assertEquals(9200, h.getHandScore());
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"));
		assertEquals(9150, h.getHandScore());
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("AceHearts"));
		assertEquals(9100, h.getHandScore());
	}

}
