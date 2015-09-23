package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFlush.class, TestFourOfAKind.class, TestFullHouse.class, TestPair.class, TestRoyalFlush.class,
		TestStraight.class, TestStraightFlush.class, TestThreeOfAKind.class, TestTwoPair.class })
public class AllHandTests {

}
