package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Hand;

public class TestSampleHandScoring {

	@Test
	public void testSampleHandScoring() {
		Hand rF = new Hand(new Card("AceSpades"), new Card("KingSpades"), new Card("QueenSpades"), new Card("JackSpades"), new Card("TenSpades"));
		Hand sF = new Hand(new Card("TwoClubs"), new Card("ThreeClubs"), new Card("FourClubs"), new Card("FiveClubs"), new Card("SixClubs"));
		Hand fK = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("TwoHearts"), new Card("ThreeSpades"));
		Hand fH = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("ThreeClubs"), new Card("ThreeDiamonds"));
		Hand f = new Hand(new Card("AceDiamonds"), new Card("ThreeDiamonds"), new Card("NineDiamonds"), new Card("JackDiamonds"), new Card("KingDiamonds"));
		Hand s = new Hand(new Card("AceClubs"), new Card("TwoDiamonds"), new Card("ThreeSpades"), new Card("FourClubs"), new Card("FiveSpades"));
		Hand tK = new Hand(new Card("TwoSpades"), new Card("TwoDiamonds"), new Card("TwoClubs"), new Card("FourDiamonds"), new Card("ThreeClubs"));
		Hand tP = new Hand(new Card("TwoClubs"), new Card("TwoSpades"), new Card("ThreeClubs"), new Card("ThreeSpades"), new Card("FourDiamonds"));
		Hand p = new Hand(new Card("TwoClubs"), new Card("TwoHearts"), new Card("ThreeSpades"), new Card("FourDiamonds"), new Card("FiveClubs"));
		Hand none = new Hand(new Card("TwoDiamonds"), new Card("NineClubs"), new Card("SevenHearts"), new Card("AceClubs"), new Card("FiveHearts"));
		
		assertTrue(rF.getHandScore() > sF.getHandScore());
		assertTrue(sF.getHandScore() > fK.getHandScore());
		assertTrue(fK.getHandScore() > fH.getHandScore());
		assertTrue(fH.getHandScore() > f.getHandScore());
		assertTrue(f.getHandScore() > s.getHandScore());
		assertTrue(s.getHandScore() > tK.getHandScore());
		assertTrue(tK.getHandScore() > tP.getHandScore());
		assertTrue(tP.getHandScore() > p.getHandScore());
		assertTrue(p.getHandScore() > none.getHandScore());		
	}

}
