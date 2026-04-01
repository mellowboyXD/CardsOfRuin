/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.states;

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
    
    public SetupStateTest() {
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
    public void tearDown(){}    /**
     * Test of enter method, of class SetupState.
     */
    @Test
    public void testEnter() {
        System.out.println("enter");
        GameData data = new GameData(); // hand=null, monster=null after setup()
        SetupState instance = new SetupState(data);
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
        GameData data = new GameData();
        SetupState instance = new SetupState(data);
        // TODO review the generated test code and remove the default call to fail.
        instance.enter();
        assertNull(instance.nextState());
        instance.update();
        assertNotNull(instance.nextState());
        assertTrue(instance.nextState() instanceof DrawCardState);
    }

    /**
     * Test of exit method, of class SetupState.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        GameData data = new GameData();
        SetupState instance = new SetupState(data);

        instance.exit();
    }

    /**
     * Test of nextState method, of class SetupState.
     */
    @Test
    public void testNextState() {
        System.out.println("nextState");
        GameData data = new GameData();
        SetupState instance = new SetupState(data);
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
