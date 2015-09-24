package tests.player;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Player;

public class TestPlayerName {

	@Test
	public void testPlayerName() {
		Player p = new Player();
		assertTrue(p.setName("Player1"));
		
		assertFalse(p.setName("Player 1"));
		
		assertFalse(p.setName("P!layer1"));
	}

}
