package tests.hand;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFlushScore.class, TestFourOfAKindScore.class,
		TestFullHouseScore.class, TestHighCardScore.class, TestPairScore.class,
		TestRoyalFlushScore.class, TestStraightFlushScore.class,
		TestStraightScore.class, TestThreeOfAKindScore.class,
		TestTwoPairScore.class, TestSampleHandScoring.class })
public class AllHandScoreTests {

}
