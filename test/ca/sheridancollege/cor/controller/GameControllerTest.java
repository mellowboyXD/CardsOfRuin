package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.states.GameContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the main GameController class.
 * @author hassenibrahim
 * @author mellowboyxd
 */
public class GameControllerTest {

    private GameController instance;

    public GameControllerTest() {
    }

    @Before
    public void setUp() {
        instance = new GameController("Testing GameController class");
        instance.setup();
    }

    /**
     * Test of setup method, of class GameController.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        assertNotNull(instance.getContext());
        assertNotNull(instance.getContext().getState());
    }

    /**
     * Test of getContext method, of class GameController.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        GameContext result = instance.getContext();
        // Context should be initialized, not null
        assertNotNull(result);
        // The context should have a state (MenuState) after setup
        assertNotNull(result.getState());
    }
}
