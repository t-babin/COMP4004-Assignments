package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameDuplicatePlayers {

	@Test
	public void test() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		
		assertFalse(g.uniquePlayers());
	}

}
