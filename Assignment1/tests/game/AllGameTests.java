package tests.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGameInitialization.class, TestGameGetPlayer.class, TestGameHandRankings.class,
			TestGameInitialization.class, TestGameSortByRanking.class, TestGameUserInput.class })
public class AllGameTests {

}
