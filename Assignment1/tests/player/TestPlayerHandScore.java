package tests.player;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestPlayerHandScore {

	@Test
	public void testPlayerHandScore() {
		Player p = new Player("Tyler");
		Hand h = new Hand(new Card("AceSpades"), new Card("KingSpades"), new Card("QueenSpades"), new Card("JackSpades"), new Card("TenSpades"));
		p.giveHand(h);
		
		assertEquals(h.getHandScore(), p.getHandScore(), 0.0f);
	}

}
