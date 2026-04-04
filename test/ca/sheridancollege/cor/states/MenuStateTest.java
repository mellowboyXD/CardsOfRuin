/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.controller.GameController;
import ca.sheridancollege.cor.model.GameData;
import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hassenibrahim
 */
public class MenuStateTest {

    private final GameController mockGameController = new GameController("Test MenuState");
    private GameData data;
    private MenuState instance;
    
    public MenuStateTest() {
    }
    
    @Before
    public void setUp() {
        mockGameController.setup();
        data = new GameData(mockGameController, mockGameController.getContext());
        instance = new MenuState(data);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enter method, of class MenuState.
     */
    
    // Helper: redirects System.in so Scanner reads from a string instead of keyboard
    private void setGameDataWithInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        data = new GameData(mockGameController, mockGameController.getContext()); // GameData creates Scanner(System.in) in constructor
    }
    @Test
    public void testEnter() {
        System.out.println("enter");

        instance.enter();
    }

    /**
     * Test of update method, of class MenuState.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        // Simulate user typing "1" (Play/Continue) then Enter
        setGameDataWithInput("1\n");

        instance.update(); // reads "1", sets startGame = true

        // After choosing play, nextState() should return SetupState
        assertNotNull(instance.nextState());
        assertTrue(instance.nextState() instanceof SetupState);
    }

    /**
     * Test of nextState method, of class MenuState.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");

        // No update() called — startGame is false, should stay in this state
        GameState result = instance.nextState();
        assertNull(result);
    }
    
    @Test
    public void testNextStateAfterPlay() {
        System.out.println("nextState - after play selected");
        setGameDataWithInput("1\n");

        instance.update(); // simulate user choosing Play

        GameState result = instance.nextState();
        assertNotNull(result);
        assertTrue(result instanceof SetupState);
    }
}
