/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.states.GameContext;
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
public class GameControllerTest {
    
    public GameControllerTest() {
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
     * Test of setup method, of class GameController.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        GameController instance = new GameController("TestGame");
        instance.setup();
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.getContext());
        assertNotNull(instance.getContext().getState());
    }

    /**
     * Test of getContext method, of class GameController.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        GameController instance = new GameController("TestGame");

        GameContext result = instance.getContext();

    // Context should be initialized, not null
        assertNotNull(result);

    // The context should have a state (MenuState) after setup
        assertNotNull(result.getState());

    }

    /**
     * Test of getTitle method, of class GameController.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        GameController instance = new GameController("MyCardGame");

        String result = instance.getTitle();

        assertEquals("MyCardGame", result);
    }

    
    
}
