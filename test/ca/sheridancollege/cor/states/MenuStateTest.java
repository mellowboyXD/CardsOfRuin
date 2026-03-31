/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hassenibrahim
 */
public class MenuStateTest {
    
    public MenuStateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enter method, of class MenuState.
     */
    
    // Helper: redirects System.in so Scanner reads from a string instead of keyboard
    private GameData gameDataWithInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return new GameData(); // GameData creates Scanner(System.in) in constructor
    }
    @Test
    public void testEnter() {
        System.out.println("enter");
        GameData data = new GameData();
        MenuState instance = new MenuState(data);

        instance.enter();
    }

    /**
     * Test of update method, of class MenuState.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        // Simulate user typing "1" (Play/Continue) then Enter
        GameData data = gameDataWithInput("1\n");
        MenuState instance = new MenuState(data);

        instance.update(); // reads "1", sets startGame = true

        // After choosing play, nextState() should return SetupState
        assertNotNull(instance.nextState());
        assertTrue(instance.nextState() instanceof SetupState);
    }

    /**
     * Test of exit method, of class MenuState.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        GameData data = new GameData();
        MenuState instance = new MenuState(data);

        instance.exit(); // no exception expected
    }

    /**
     * Test of nextState method, of class MenuState.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");
        GameData data = new GameData();
        MenuState instance = new MenuState(data);

        // No update() called — startGame is false, should stay in this state
        GameState result = instance.nextState();
        assertNull(result);
    }
    
    @Test
    public void testNextStateAfterPlay() {
        System.out.println("nextState - after play selected");
        GameData data = gameDataWithInput("1\n");
        MenuState instance = new MenuState(data);

        instance.update(); // simulate user choosing Play

        GameState result = instance.nextState();
        assertNotNull(result);
        assertTrue(result instanceof SetupState);
    }
    
}
