package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poker.Hand;

public class TestHand {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRoyalFlushHearts() {
		Hand h = new Hand("TenHearts", "JackHearts", "QueenHearts", "KingHearts", "AceHearts");
		assertTrue(h.isRoyalFlush());
	}

}
