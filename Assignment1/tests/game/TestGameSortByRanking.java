package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameSortByRanking {

	@Test
	public void testSortPlayerByRankings() {
		Game g = new Game();
		Player p1 = new Player("Tyler");
		Player p2 = new Player("Tyler1");
		p1.giveHand(new Hand(new Card("AceSpades"), new Card("AceClubs"), new Card("AceDiamonds"), new Card("AceHearts"), new Card("KingSpades")));
		p2.giveHand(new Hand(new Card("TwoSpades"), new Card("ThreeDiamonds"), new Card("FourSpades"), new Card("FiveHearts"), new Card("AceHearts")));
		g.addPlayer(p1);
		g.addPlayer(p2);
		
		Player[] expected = { p1, p2 };
		
		assertArrayEquals(expected, g.getPlayersSorted());
	}

}
