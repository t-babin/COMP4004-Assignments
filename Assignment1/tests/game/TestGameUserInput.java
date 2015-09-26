package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.*;

public class TestGameUserInput {

	@Test
	public void testValidInput() {
		Game g = new Game(2);
		String input = "Tyler AceSpades KingSpades QueenSpades JackSpades TenSpades";
		assertTrue(g.takeInput(input));
	}
	
	@Test
	public void testInvalidNameInput() {
		Game g = new Game(2);
		String input = "Tyler! AceSpades KingSpades QueenSpades JackSpades TenSpades";
		assertFalse(g.takeInput(input));
	}

}
