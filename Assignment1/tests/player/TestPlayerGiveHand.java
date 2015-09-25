package tests.player;

import static org.junit.Assert.*;

import org.junit.Test;
import poker.*;

public class TestPlayerGiveHand {

	@Test
	public void testGiveHand() {
		Player p = new Player("Player1");
		Hand h = new Hand(new Card("TwoSpades"), new Card("ThreeSpades"), new Card("FourSpades"), new Card("FiveSpades"), new Card("SixSpades"));
		p.giveHand(h);
		
		assertEquals(h, p.getHand());
	}
}
