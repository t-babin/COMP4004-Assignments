package tests.hand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.*;
//TODO refactor all this to use a test suite
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
		assertEquals(10.143209f, h.getHandScore(), 0.0f);
	}
	
	@Test
	public void testStraightFlushScore() {
		h.setHand(new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"), new Card("KingHearts"));
		assertEquals(9500, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"), new Card("QueenHearts"));
		assertEquals(9450, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"), new Card("JackHearts"));
		assertEquals(9400, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"), new Card("TenHearts"));
		assertEquals(9350, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"), new Card("NineHearts"));
		assertEquals(9300, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"), new Card("EightHearts"));
		assertEquals(9250, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"), new Card("SevenHearts"));
		assertEquals(9200, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("SixHearts"));
		assertEquals(9150, h.getHandScore(), 0.0f);
		
		h.setHand(new Card("TwoHearts"), new Card("ThreeHearts"), new Card("FourHearts"), new Card("FiveHearts"), new Card("AceHearts"));
		assertEquals(9100, h.getHandScore(), 0.0f);
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
				float expectedScore = 8.0f;
				float tmp = 0.0f;
				tmp += h.getCards().get(4).getCardIntValue() * 0.01f;
				tmp += h.getCards().get(3).getCardIntValue() * 0.001f;
				tmp += h.getCards().get(2).getCardIntValue() * 0.0001f;
				tmp += h.getCards().get(1).getCardIntValue() * 0.00001f;
				tmp += h.getCards().get(0).getCardIntValue() * 0.000001f;
				expectedScore += tmp;
				assertEquals(h.toString(), expectedScore, h.getHandScore(), 0.0f);
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
				float expectedScore = 7.0f;
				float tmp = 0.0f;
				tmp += h.getCards().get(4).getCardIntValue() * 0.01f;
				tmp += h.getCards().get(3).getCardIntValue() * 0.001f;
				tmp += h.getCards().get(2).getCardIntValue() * 0.0001f;
				tmp += h.getCards().get(1).getCardIntValue() * 0.00001f;
				tmp += h.getCards().get(0).getCardIntValue() * 0.000001f;
				expectedScore += tmp;
				assertEquals(h.toString(), expectedScore, h.getHandScore(), 0.0f);
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
	
	@Test
	public void testStraightScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("FiveHearts"), new Card("AceDiamonds"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("FiveHearts"), new Card("SixDiamonds"));
		
		assertTrue(h1.getHandScore() < h2.getHandScore());
	}
	
	@Test
	public void testThreeOfAKindScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("FiveHearts"), new Card("AceDiamonds"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("QueenHearts"), new Card("KingDiamonds"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
		
		Hand h3 = new Hand(new Card("ThreeClubs"), new Card("ThreeDiamonds"), new Card("ThreeSpades"), new Card("TwoClubs"), new Card("FiveSpades"));
		
		assertTrue(h3.getHandScore() > h1.getHandScore());
	}
	
	@Test
	public void testTwoPairScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("FourHearts"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("SevenHearts"));
		
		assertTrue(h2.getHandScore() > h1.getHandScore());
		
		Hand h3 = new Hand(new Card("TwoClubs"), new Card("SevenSpades"), new Card("ThreeSpades"), new Card("ThreeDiamonds"), new Card("SevenHearts"));
		
		assertTrue(h3.getHandScore() > h2.getHandScore());
	}
	
	@Test
	public void testPairScore() {
		Hand h1 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("NineHearts"));
		Hand h2 = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeSpades"), new Card("FiveDiamonds"), new Card("EightHearts"));
		
		assertTrue(h1.getHandScore() > h2.getHandScore());
	}

}
