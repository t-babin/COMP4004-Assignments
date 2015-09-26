package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameSortByRanking {

	@Test
	public void testSortPlayerByRankings2Player() {
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
	
	@Test
	public void testSortPlayerByRankings3Player() {
		Game g = new Game();
		Player p1 = new Player("Tyler");
		Player p2 = new Player("Tyler1");
		Player p3 = new Player("Tyler2");
		p1.giveHand(new Hand(new Card("AceSpades"), new Card("AceClubs"), new Card("AceDiamonds"), new Card("AceHearts"), new Card("KingSpades")));
		p2.giveHand(new Hand(new Card("TwoSpades"), new Card("ThreeDiamonds"), new Card("FourSpades"), new Card("FiveHearts"), new Card("AceHearts")));
		p3.giveHand(new Hand(new Card("TwoSpades"), new Card("ThreeSpades"), new Card("FourSpades"), new Card("FiveSpades"), new Card("AceSpades")));
		g.addPlayer(p1);
		g.addPlayer(p2);
		g.addPlayer(p3);
		
		Player[] expected = { p3, p1, p2 };
		
		assertArrayEquals(expected, g.getPlayersSorted());
	}

}
