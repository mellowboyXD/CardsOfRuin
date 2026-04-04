/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.controller.GameController;
import ca.sheridancollege.cor.model.GameData;
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
public class SetupStateTest {
    private final GameController mockGameController = new GameController("Testing Setup");
    private GameData data;
    private SetupState instance;

    public SetupStateTest() {
    }

    @Before
    public void setUp() {
        instance = new SetupState(data);
        mockGameController.setup();
        data = new GameData(mockGameController, mockGameController.getContext());
    }
    
    @After
    public void tearDown(){}    /**
     * Test of enter method, of class SetupState.
     */
    @Test
    public void testEnter() {
        System.out.println("enter");
        instance.enter();
        assertNotNull(data.getHand());
        assertEquals(GameData.HAND_SIZE, data.getHand().getCards().size());
        assertNotNull(data.getMonster());
        assertEquals(100, data.getMonster().getHealth());
    }

    /**
     * Test of update method, of class SetupState.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        // TODO review the generated test code and remove the default call to fail.
        instance.enter();
        assertNull(instance.nextState());
        instance.update();
        assertNotNull(instance.nextState());
        assertTrue(instance.nextState() instanceof DrawCardState);
    }

    /**
     * Test of nextState method, of class SetupState.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");
        instance.enter();

        // Not ready yet — should stay in this state
        GameState result = instance.nextState();
        assertNull(result);

        // After update() — should transition to DrawCardState
        instance.update();
        GameState next = instance.nextState();
        assertNotNull(next);
        assertTrue(next instanceof DrawCardState);
    }
}
