package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;
import poker.Player;

public class TestGameDuplicatePlayers {

	@Test
	public void testDuplicatePlayers2Player() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		
		assertFalse(g.uniquePlayers());
		
		Game g1 = new Game();
		g1.addPlayer(new Player("Player1"));
		g1.addPlayer(new Player("Player2"));
		assertTrue(g1.uniquePlayers());
	}
	
	@Test
	public void testDuplicatePlayers3Player() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		
		assertFalse(g.uniquePlayers());
		
		Game g1 = new Game();
		g1.addPlayer(new Player("Player1"));
		g1.addPlayer(new Player("Player2"));
		g1.addPlayer(new Player("Player3"));
		
		assertTrue(g1.uniquePlayers());
		
		Game g2 = new Game();
		g2.addPlayer(new Player("Player1"));
		g2.addPlayer(new Player("Player2"));
		g2.addPlayer(new Player("Player1"));
		
		assertFalse(g2.uniquePlayers());
		
		Game g3 = new Game();
		g3.addPlayer(new Player("Player1"));
		g3.addPlayer(new Player("Player2"));
		g3.addPlayer(new Player("Player2"));
		
		assertFalse(g3.uniquePlayers());
	}
	
	@Test
	public void testDuplicatePlayers4Player() {
		Game g = new Game();
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		g.addPlayer(new Player("Player1"));
		
		assertFalse(g.uniquePlayers());
		
		Game g1 = new Game();
		g1.addPlayer(new Player("Player1"));
		g1.addPlayer(new Player("Player2"));
		g1.addPlayer(new Player("Player3"));
		g1.addPlayer(new Player("Player4"));
		
		assertTrue(g1.uniquePlayers());
		
		Game g2 = new Game();
		g2.addPlayer(new Player("Player1"));
		g2.addPlayer(new Player("Player2"));
		g2.addPlayer(new Player("Player1"));
		g2.addPlayer(new Player("Player4"));
		
		assertFalse(g2.uniquePlayers());
		
		Game g3 = new Game();
		g3.addPlayer(new Player("Player1"));
		g3.addPlayer(new Player("Player2"));
		g3.addPlayer(new Player("Player3"));
		g3.addPlayer(new Player("Player1"));
		
		assertFalse(g3.uniquePlayers());
		
		Game g4 = new Game();
		g4.addPlayer(new Player("Player1"));
		g4.addPlayer(new Player("Player2"));
		g4.addPlayer(new Player("Player2"));
		g4.addPlayer(new Player("Player4"));
		
		assertFalse(g4.uniquePlayers());
		
		Game g5 = new Game();
		g5.addPlayer(new Player("Player1"));
		g5.addPlayer(new Player("Player2"));
		g5.addPlayer(new Player("Player3"));
		g5.addPlayer(new Player("Player2"));
		
		assertFalse(g5.uniquePlayers());
		
		Game g6 = new Game();
		g6.addPlayer(new Player("Player1"));
		g6.addPlayer(new Player("Player2"));
		g6.addPlayer(new Player("Player3"));
		g6.addPlayer(new Player("Player3"));
		
		assertFalse(g6.uniquePlayers());
	}

}
