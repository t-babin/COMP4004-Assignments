package tests.game;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Game;

public class TestGameOutput {

	@Test
	public void test() {
		Game g = new Game();
		g.takeInput("Tyler AceClubs KingClubs QueenClubs JackClubs TenClubs");
		g.takeInput("Tyler1 TwoClubs TwoDiamonds TwoSpades TwoHearts TenClubs");
		
		String expectedOutput = "Tyler AceClubs KingClubs QueenClubs JackClubs TenClubs 1\nTyler1 TwoClubs TwoDiamonds TwoSpades TwoHearts TenClubs 2";
		
		assertEquals(expectedOutput, g.getOutputString());
	}

}
