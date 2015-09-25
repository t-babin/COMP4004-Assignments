package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.card.AllCardTests;
import tests.game.AllGameTests;
import tests.hand.AllHandTests;
import tests.player.TestPlayerName;

@RunWith(Suite.class)
@SuiteClasses({ AllHandTests.class, AllCardTests.class, AllGameTests.class, TestPlayerName.class })
public class AllTests {

}
