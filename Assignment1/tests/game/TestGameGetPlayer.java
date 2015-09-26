package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameGetPlayer {

	@Test
	public void testGetPlayer() {
		Game g = new Game();
		Player p1 = new Player("Player1");
		p1.giveHand(new Hand(new Card("TwoClubs"), new Card("ThreeClubs"), new Card("SixHearts"), new Card("SixSpades"), new Card("AceSpades")));
		Player p2 = new Player("Player2");
		p1.giveHand(new Hand(new Card("SevenClubs"), new Card("ThreeHearts"), new Card("KingHearts"), new Card("SixSpades"), new Card("QueenSpades")));
		g.addPlayer(p1);
		g.addPlayer(p2);
		
		assertEquals(p1, g.getPlayer(0));
		assertEquals(p2, g.getPlayer(1));
	}

}
