package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameHandRankings {

	@Test
	public void testGameHandRankings() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.getPlayer(0).giveHand(new Hand(new Card("AceHearts"), new Card("KingHearts"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		g.addPlayer(new Player("Player2"));
		g.getPlayer(1).giveHand(new Hand(new Card("AceClubs"), new Card("KingClubs"), new Card("QueenClubs"), new Card("JackClubs"), new Card("TenClubs")));
		
		assertEquals(g.getPlayerRank(g.getPlayer(0)), g.getPlayerRank(g.getPlayer(1)));
	}

}
