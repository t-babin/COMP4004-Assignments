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
		
		String expectedOutput = "Tyler TenClubs JackClubs QueenClubs KingClubs AceClubs 1\nTyler1 TwoClubs TwoDiamonds TwoSpades TwoHearts TenClubs 2";
		System.out.println("EXPECTED\n" + expectedOutput);
		
		assertEquals(expectedOutput, g.getOutputString());
	}

}
