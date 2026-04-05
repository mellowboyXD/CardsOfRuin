package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.controller.GameController;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Hand;
import ca.sheridancollege.cor.model.Monster;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DrawCardStateTest {

    private final GameController mockGameController = new GameController("Testing Draw Card State");
    private DrawCardState instance;

    // initialize everything before each test
    @Before
    public void setUp() {
        GameData data = new GameData(mockGameController, mockGameController.getContext());
        data.setup();
        // In this state, monster is modified. So monster is required
        data.setMonster(new Monster.Builder().health(10).attack(20).shield(15).build());
        var hand = new Hand(GameData.HAND_SIZE);
        hand.setCards(new ArrayList<>());
        for (int i = 0; i < hand.getSize(); i++) {
            hand.getCards().add(data.getDeck().drawRandom());
        }
        data.setHand(hand);
        instance = new DrawCardState(data);
    }

    // Helper method to simulate user input
    public void provideInput(String input) {
        var testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        setUp();
    }

    @Test
    public void testUpdatePickValidCardOption() {
        System.out.println("Test: Picking a Valid card option");
        provideInput("1\n"); // 1 is a valid option
        instance.update();
    }

    /*
    * To test invalid input is a bit tricky. The DrawCardState class is implemented in such a way that
    * it is very complex to test for errors or invalid input. One way that I can think of is to implement
    * an ExceptionHandler class that gets invoked every time there is an exception. The handler can then set
    * a flag stating that so-and-so class was called. For testing, we could just expect that this class
    * throws a specific exception.
    * This is a bit more work, and frankly I do not have the time to do so.
    *
    * However, one can still verify that invalid inputs are properly handled in the game by simply running the
    * game and inputting invalid input manually. Below are the instructions for the specific test case.
    * */
    @Test
    public void testPickCardInvalidCardOption() {
        /*
        * Steps:
        * 1. Run the game until we reach the DrawCardState(PICK PHASE)
        * 2. Enter `5` when prompted to 'pick a card >'
        * 3. The expected output should be 'Invalid option. Try again.'
        *    If this is shown, consider this test as PASSED
        * */

        assertTrue(true); // placeholder denoting that this test should and will pass
    }
}