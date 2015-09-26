package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestRoyalFlushScore {	

	@Test
	public void testRoyalFlushScore() {
		Hand spades = new Hand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertTrue(spades.isRoyalFlush());
		
		Hand hearts = new Hand(new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"), new Card("AceHearts"));
		assertTrue(hearts.isRoyalFlush());
		
		Hand diamonds = new Hand(new Card("TenDiamonds"), new Card("JackDiamonds"), new Card("QueenDiamonds"), new Card("KingDiamonds"), new Card("AceDiamonds"));
		assertTrue(diamonds.isRoyalFlush());
		
		Hand clubs = new Hand(new Card("TenClubs"), new Card("JackClubs"), new Card("QueenClubs"), new Card("KingClubs"), new Card("AceClubs"));
		assertTrue(clubs.isRoyalFlush());
		
		assertEquals(10.143209f, spades.getHandScore(), 0.0f);
		assertEquals(10.143209f, hearts.getHandScore(), 0.0f);
		assertEquals(10.143209f, diamonds.getHandScore(), 0.0f);
		assertEquals(10.143209f, clubs.getHandScore(), 0.0f);
	}

}
