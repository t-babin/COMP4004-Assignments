package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameHandRankings {

	@Test
	public void testGameHandRankingsEqual() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.getPlayer(0).giveHand(new Hand(new Card("AceHearts"), new Card("KingHearts"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		g.addPlayer(new Player("Player2"));
		g.getPlayer(1).giveHand(new Hand(new Card("AceClubs"), new Card("KingClubs"), new Card("QueenClubs"), new Card("JackClubs"), new Card("TenClubs")));
		
		assertEquals(g.getPlayerRank(g.getPlayer(0)), g.getPlayerRank(g.getPlayer(1)));
	}
	
	@Test
	public void testGameHandRankingsDifferentTwoPlayer() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.getPlayer(0).giveHand(new Hand(new Card("AceHearts"), new Card("KingHearts"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		g.addPlayer(new Player("Player2"));
		g.getPlayer(1).giveHand(new Hand(new Card("AceHearts"), new Card("KingDiamonds"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		assertEquals(1, g.getPlayerRank(g.getPlayer(0)));
		assertEquals(2, g.getPlayerRank(g.getPlayer(1)));
	}
	
	@Test
	public void testGameHandRankingsDifferentThreePlayer() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.getPlayer(0).giveHand(new Hand(new Card("AceHearts"), new Card("KingHearts"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		g.addPlayer(new Player("Player2"));
		g.getPlayer(1).giveHand(new Hand(new Card("AceSpades"), new Card("KingDiamonds"), new Card("QueenClubs"), new Card("JackDiamonds"), new Card("TenClubs")));
		
		g.addPlayer(new Player("Player3"));
		g.getPlayer(2).giveHand(new Hand(new Card("AceDiamonds"), new Card("KingSpades"), new Card("QueenSpades"), new Card("JackClubs"), new Card("TenSpades")));
		
		assertEquals(1, g.getPlayerRank(g.getPlayer(0)));
		assertEquals(2, g.getPlayerRank(g.getPlayer(1)));
		assertEquals(2, g.getPlayerRank(g.getPlayer(2)));
	}
	
	@Test
	public void testGameHandRankingsDifferentFourPlayer() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.getPlayer(0).giveHand(new Hand(new Card("AceHearts"), new Card("KingHearts"), new Card("QueenHearts"), new Card("JackHearts"), new Card("TenHearts")));
		
		g.addPlayer(new Player("Player2"));
		g.getPlayer(1).giveHand(new Hand(new Card("AceSpades"), new Card("KingDiamonds"), new Card("QueenClubs"), new Card("JackDiamonds"), new Card("TenClubs")));
		
		g.addPlayer(new Player("Player3"));
		g.getPlayer(2).giveHand(new Hand(new Card("AceDiamonds"), new Card("KingSpades"), new Card("QueenSpades"), new Card("JackClubs"), new Card("TenSpades")));

		g.addPlayer(new Player("Player4"));
		g.getPlayer(3).giveHand(new Hand(new Card("TwoDiamonds"), new Card("TwoSpades"), new Card("TwoSpades"), new Card("ThreeClubs"), new Card("NineSpades")));
		
		assertEquals(1, g.getPlayerRank(g.getPlayer(0)));
		assertEquals(2, g.getPlayerRank(g.getPlayer(1)));
		assertEquals(2, g.getPlayerRank(g.getPlayer(2)));
		assertEquals(4, g.getPlayerRank(g.getPlayer(3)));
	}

}
