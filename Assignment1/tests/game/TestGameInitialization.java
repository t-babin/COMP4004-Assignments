package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
//import poker.Player;

public class TestGameInitialization {

	@Test
	public void testPlayerAmount() {
		Game g1 = new Game();
		g1.setPlayerAmount(2);
		assertEquals(2, g1.amountOfPlayers());
		
		Game g2 = new Game();
		g2.setPlayerAmount(3);
		assertEquals(3, g2.amountOfPlayers());

		Game g3 = new Game();
		g3.setPlayerAmount(4);
		assertEquals(4, g3.amountOfPlayers());
	}

}
