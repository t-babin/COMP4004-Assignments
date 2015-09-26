package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameInitialization {

	@Test
	public void testPlayerAmount() {
		Game g = new Game();
		g.addPlayer(new Player());
		assertFalse(g.setPlayerAmount(1));
		
		Game g1 = new Game();
		g1.addPlayer(new Player());
		g1.addPlayer(new Player());
		assertEquals(2, g1.amountOfPlayers());
		
		Game g2 = new Game();
		g2.addPlayer(new Player());
		g2.addPlayer(new Player());
		g2.addPlayer(new Player());
		assertEquals(3, g2.amountOfPlayers());

		Game g3 = new Game();
		g3.addPlayer(new Player());
		g3.addPlayer(new Player());
		g3.addPlayer(new Player());
		g3.addPlayer(new Player());
		assertEquals(4, g3.amountOfPlayers());
		
		g3.addPlayer(new Player());
		assertFalse(g3.setPlayerAmount(5));
	}

}
