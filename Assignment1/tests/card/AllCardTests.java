package tests.card;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestCardInputLength.class, TestCardValues.class, TestCardInputCharacters.class })
public class AllCardTests {

}
