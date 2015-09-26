Name: Tyler Babin
Student ID: 100863154
GitHub ID: t-babin
Link to Repository: https://github.com/t-babin/COMP4004-Assignments

Running the Code
----------------
 1) Download the repository as a zip, from the link above.
 2) Open Eclipse
 3) In Eclipse, select File->Import->General->Existing Projects Into Workspace
 4) Set Select root directory to the directory in which you extracted the source code into.
 5) Run assignment.Main.java as a Java Application


Tests
-----
The tests.hand.AllHandTests.java test suite contains all of the tests for checking the rank of any given hand.
These test files include: 
- tests.hand.TestRoyalFlush.java
- tests.hand.TestStraightFlush.java
- tests.hand.TestFourOfAKind.java
- tests.hand.TestFullHouse.java
- tests.hand.TestFlush.java
- tests.hand.TestStraight.java
- tests.hand.TestThreeOfAKind.java
- tests.hand.TestTwoPair.java
- tests.hand.TestPair.java

The test to determine if any given Hand contains duplicate cards is located in the TestHandDuplicateCards.java file.

The tests.hand.AllHandScoreTests.java test suite contains all of the tests for verifying the correct score is given to each hand type.
These test files include:
- tests.hand.TestRoyalFlushScore.java
- tests.hand.TestStraightFlushScore.java
- tests.hand.TestFourOfAKindScore.java
- tests.hand.TestFullHouseScore.java
- tests.hand.TestFlushScore.java
- tests.hand.TestStraightScore.java
- tests.hand.TestThreeOfAKindScore.java
- tests.hand.TestTwoPairScore.java
- tests.hand.TestPairScore.java
- tests.hand.TestHighCardScore.java
- tests.hand.TestSampleHandScoring.java

The tests.card.AllCardTests.java test suite contains all of the tests for verifying Cards are initialized with the correct values.
These test files include:
- tests.card.TestCardFaceValue.java [Tests to make sure the face value input of the card is valid, i.e. Two, Three, King, etc.]
- tests.card.TestCardInputCharacters.java [Tests to make sure the card input starts with a capital]
- tests.card.TestCardInputLength.java [Tests to make sure the length of the input is valid, i.e. between 8 and 13 characters]
- tests.card.TestCardSuit.java [Tests to make sure the card suit is input correctly, i.e. Hearts, Clubs, etc.]
- tests.card.TestCardValues.java [Test that generates all possible valid Card inputs, verifies that they are indeed valid.]

The tests.player.AllPlayerTests.java test suite contains all of the tests for verifying Players are initialized correctly.
These test files include:
- tests.player.TestPlayerHand.java [Tests to make sure giving a player a new hand works.]
- tests.player.TestPlayerHandScore.java [Tests to make sure that the player's hand score is the same as the hand's hand score.]
- tests.player.TestPlayerName.java [Tests to make sure that a Player inputs their name correctly, i.e. no spaces, symbols.]

The tests.game.AllGameTests.java test suite contains all of the tests for verifying a Game is created correctly.
These test files include:
- tests.game.TestGameGetPlayer.java [Tests to make sure the correct player is returned from the list of players.]
- tests.game.TestGameHandRankings.java [Tests to make sure Players are given the correct ranking, based on their hand.]
- tests.game.TestGameInitialization.java [Tests to make sure the Game stores the correct amount of players.]
- tests.game.TestGameOutput.java [Tests to make sure the Game outputs the correct String after calculating rankings and sorting Players according to ranking.]
- tests.game.TestGameSortByRanking.java [Tests to make sure the Game sorts players correctly, based on their rank.]
- tests.game.TestGameUserInput.java [Tests to make sure the Game accepts valid input from a Player when starting a new game.]

The tests.AllTests.java test suite will run all of these tests.
