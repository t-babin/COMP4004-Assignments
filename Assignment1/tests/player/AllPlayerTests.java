package tests.player;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPlayerHand.class, TestPlayerHandScore.class,
		TestPlayerName.class })
public class AllPlayerTests {

}
