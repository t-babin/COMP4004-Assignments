package tests.player;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Player;

public class TestPlayerName {

	@Test
	public void testPlayerName() {
		Player p = new Player();
		assertTrue(p.validName("Player1"));
		
		assertFalse(p.validName("Player 1"));
		
		assertFalse(p.validName("P!layer1"));
	}

}
