package tests.hand;

import static org.junit.Assert.*;

import org.junit.Test;
import poker.*;

public class TestHandDuplicateCards {

	@Test
	public void testHandWithDuplicates() {
		Hand h = new Hand(new Card("TwoHearts"), new Card("TwoHearts"), new Card("ThreeClubs"), new Card("ThreeClubs"), new Card("SixDiamonds"));
		assertFalse(h.noDuplicates());
	}
	
	public void testHandNoDuplicates() {
		Hand h = new Hand(new Card("TwoDiamonds"), new Card("SixSpades"), new Card("NineClubs"), new Card("KingClubs"), new Card("SevenHearts"));
		assertTrue(h.noDuplicates());
	}

}
