package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameDuplicatePlayers2 {

	@Test
	public void testDuplicatePlayers2Same() {
		Game g = new Game();
		g.takeInput("Tyler AceSpades KingSpades QueenSpades JackSpades TenSpades");
		
		assertFalse(g.uniquePlayers());	
	}
	
	@Test
	public void testDuplicatePlayers2Diff() {
		Game g1 = new Game();
		g1.addPlayer(new Player("Player1"));
		g1.addPlayer(new Player("Player2"));
		assertTrue(g1.uniquePlayers());
	}
}
