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
	
	@Test
	public void testDuplicateNameInput() {
		Game g = new Game(2);
		String input1 = "Tyler AceSpades KingSpades QueenSpades JackSpades TenSpades";
		String input2 = "Tyler AceClubs KingClubs QueenClubs JackClubs TenClubs";
		assertTrue(g.takeInput(input1));
		assertFalse(g.takeInput(input2));
	}
	
	@Test
	public void testDuplicateHandInput() {
		Game g = new Game(2);
		String input1 = "Tyler AceSpades KingSpades QueenSpades JackSpades TenSpades";
		String input2 = "Tyler1 AceSpades KingSpades QueenSpades JackSpades TenSpades";
		assertTrue(g.takeInput(input1));
		assertFalse(g.takeInput(input2));
	}

}
