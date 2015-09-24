package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.card.AllCardTests;
import tests.hand.AllHandTests;

@RunWith(Suite.class)
@SuiteClasses({ AllHandTests.class, AllCardTests.class })
public class AllTests {

}
