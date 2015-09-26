package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestStraightFlushScore {

	@Test
	public void testStraightFlushScore() {
		Hand h = new Hand();
		h.setHand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"));
		assertEquals(addToScore(h), h.getHandScore(), 0.0f);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("AceHearts"));
		assertEquals(addToScore(h)-0.13f, h.getHandScore(), 0.0f);
	}
	
	private float addToScore(Hand h) {
		float score = 0.0f;
		score += h.getCards().get(4).getCardIntValue() * 0.01f;
		score += h.getCards().get(3).getCardIntValue() * 0.001f;
		score += h.getCards().get(2).getCardIntValue() * 0.0001f;
		score += h.getCards().get(1).getCardIntValue() * 0.00001f;
		score += h.getCards().get(0).getCardIntValue() * 0.000001f;
		return score + 9.0f;
	}

}
