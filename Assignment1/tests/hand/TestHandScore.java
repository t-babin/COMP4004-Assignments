package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.*;

public class TestHandScore {
	
	private Hand h;
	private static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static String[] faceValues = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	
	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@Test
	public void testRoyalFlushScore() {
		h.setHand(new Card("TenSpades"), new Card("JackSpades"), new Card("QueenSpades"), new Card("KingSpades"), new Card("AceSpades"));
		assertEquals(10550, h.getHandScore(), 0.0);
	}
	
	@Test
	public void testStraightFlushScore() {
		h.setHand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertEquals(9500, h.getHandScore(), 0.0);
		
		h.setHand(new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"));
		assertEquals(9450, h.getHandScore(), 0.0);
		
		h.setHand(new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"));
		assertEquals(9400, h.getHandScore(), 0.0);
		
		h.setHand(new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"));
		assertEquals(9350, h.getHandScore(), 0.0);
		
		h.setHand(new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"));
		assertEquals(9300, h.getHandScore(), 0.0);
		
		h.setHand(new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"));
		assertEquals(9250, h.getHandScore(), 0.0);
		
		h.setHand(new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"));
		assertEquals(9200, h.getHandScore(), 0.0);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"));
		assertEquals(9150, h.getHandScore(), 0.0);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("AceHearts"));
		assertEquals(9100, h.getHandScore(), 0.0);
	}
	
	@Test
	public void testFourOfAKindScore() {
		for (int i = 12; i >=0 ; i--) {
			for (int j = 12; j >= 0; j--) {
				Card c1 = new Card(faceValues[i] + suits[0]);
				Card c2 = new Card(faceValues[i] + suits[1]);
				Card c3 = new Card(faceValues[i] + suits[2]);
				Card c4 = new Card(faceValues[i] + suits[3]);
				Card c5 = new Card(faceValues[j] + suits[0]);
				if (j == i) {
					if (j == 0)
						break;
					else {
						j = j-1;
						c5 = new Card(faceValues[j] + suits[0]);
					}
				}
				h.setHand(c1, c2, c3, c4, c5);
				int expectedScore = 8000;
				for (Card c : h.getCards())
					expectedScore += c.getCardIntValue() * 10;
				assertEquals(h.toString(), expectedScore, h.getHandScore(), 0.0);
			}			
		}
	}
	
	@Test
	public void testFullHouseScore() {
		for (int i = 12; i >=0 ; i--) {
			for (int j = 12; j >= 0; j--) {
				Card c1 = new Card(faceValues[i] + suits[0]);
				Card c2 = new Card(faceValues[i] + suits[1]);
				Card c3 = new Card(faceValues[i] + suits[2]);
				Card c4 = new Card(faceValues[j] + suits[0]);
				Card c5 = new Card(faceValues[j] + suits[1]);
				if (j == i) {
					if (j == 0)
						break;
					else {
						j = j-1;
						c4 = new Card(faceValues[j] + suits[0]);
						c5 = new Card(faceValues[j] + suits[1]);
					}
				}
				h.setHand(c1, c2, c3, c4, c5);
				int expectedScore = 7000;
				for (Card c : h.getCards())
					expectedScore += c.getCardIntValue() * 10;
				assertEquals(h.toString(), expectedScore, h.getHandScore(), 0.0);
			}			
		}
	}
	
	@Test
	public void testFlushScore() {
		Hand h1 = new Hand(new Card("AceSpades"), new Card("KingSpades"), new Card("FourSpades"), new Card("ThreeSpades"), new Card("TwoSpades"));
		System.out.println(h1.getHandScore() + "[" + h1.toString() + "]");
		Hand h2 = new Hand(new Card("AceSpades"), new Card("QueenSpades"), new Card("JackSpades"), new Card("TenSpades"), new Card("NineSpades"));
		System.out.println(h2.getHandScore() + "[" + h2.toString() + "]");
		
		assertTrue(h1.getHandScore() > h2.getHandScore());		
	}

}
