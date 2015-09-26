package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameDuplicatePlayers3 {
//TODO separate into cases 
	@Test
	public void testDuplicatePlayers3Player() {
		Game g = new Game(3);
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		
		assertFalse(g.uniquePlayers());
		
		Game g1 = new Game(3);
		g1.addPlayer(new Player("Player1"));
		g1.addPlayer(new Player("Player2"));
		g1.addPlayer(new Player("Player3"));
		
		assertTrue(g1.uniquePlayers());
		
		Game g2 = new Game(3);
		g2.addPlayer(new Player("Player1"));
		g2.addPlayer(new Player("Player2"));
		g2.addPlayer(new Player("Player1"));
		
		assertFalse(g2.uniquePlayers());
		
		Game g3 = new Game(3);
		g3.addPlayer(new Player("Player1"));
		g3.addPlayer(new Player("Player2"));
		g3.addPlayer(new Player("Player2"));
		
		assertFalse(g3.uniquePlayers());
	}

}
