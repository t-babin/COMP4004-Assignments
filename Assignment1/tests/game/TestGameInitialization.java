package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameInitialization {

	@Test
	public void testPlayerAmount() {
		Game g = new Game(new Player(), new Player());
		assertEquals(2, g.amountOfPlayers());
	}

}
