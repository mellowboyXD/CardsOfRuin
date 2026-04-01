/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.states.GameContext;
import java.util.Scanner;
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
public class GameDataTest {
    
    public GameDataTest() {
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
     * Test of setup method, of class GameData.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        GameData instance = new GameData();
        instance.setup();
        // TODO review the generated test code and remove the default call to fail.
        instance.nextRound();
        instance.defeatMonster();
        instance.setHand(new Hand(3));
        
        instance.setup();
        assertEquals(1,instance.getRound());
        assertEquals(0, instance.getMonstersDefeated());
        assertNull(instance.getHand());
        assertNull(instance.getMonster());
    }

    /**
     * Test of getHand method, of class GameData.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        GameData instance = new GameData();
        assertNull(instance.getHand());
    }

    /**
     * Test of setHand method, of class GameData.
     */
    @Test
    public void testSetHand() {
        System.out.println("setHand");
        Hand cards = null;
        GameData instance = new GameData();
        instance.setHand(cards);
        // TODO review the generated test code and remove the default call to fail.
        assertSame(cards, instance.getHand());
    }

    /**
     * Test of getDeck method, of class GameData.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        GameData instance = new GameData();
        Deck result = instance.getDeck();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(GameData.DECK_SIZE, result.getCards().size());
    }

    /**
     * Test of getRound method, of class GameData.
     */
    @Test
    public void testGetRound() {
        System.out.println("getRound");
        GameData instance = new GameData();
        int expResult = 1;
        int result = instance.getRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of nextRound method, of class GameData.
     */
    @Test
    public void testNextRound() {
        System.out.println("nextRound");
        GameData instance = new GameData();
        instance.nextRound();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(2, instance.getRound());
        instance.nextRound();
        assertEquals(3, instance.getRound());
    }

    /**
     * Test of getMonstersDefeated method, of class GameData.
     */
    @Test
    public void testGetMonstersDefeated() {
        System.out.println("getMonstersDefeated");
        GameData instance = new GameData();
        int expResult = 0;
        int result = instance.getMonstersDefeated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of defeatMonster method, of class GameData.
     */
    @Test
    public void testDefeatMonster() {
        System.out.println("defeatMonster");
        GameData instance = new GameData();
        instance.defeatMonster();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1, instance.getMonstersDefeated());
        instance.defeatMonster();
        assertEquals(2, instance.getMonstersDefeated());
    }

    /**
     * Test of getContext method, of class GameData.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        GameData instance = new GameData();
        GameContext result = instance.getContext();
        assertNotNull(result);
    }

    /**
     * Test of getPlayer method, of class GameData.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        GameData instance = new GameData();
        Player result = instance.getPlayer();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(100, result.getHealth());
    }

    /**
     * Test of getMonster method, of class GameData.
     */
    @Test
    public void testGetMonster() {
        System.out.println("getMonster");
        GameData instance = new GameData();
        assertNull(instance.getMonster()); 
        
        
    }

    /**
     * Test of setMonster method, of class GameData.
     */
    @Test
    public void testSetMonster() {
        System.out.println("setMonster");
        GameData instance = new GameData();
        Monster monster = new Monster();
        monster.setup();
        instance.setMonster(monster);
        assertSame(monster, instance.getMonster());
    }

    /**
     * Test of getScanner method, of class GameData.
     */
    @Test
    public void testGetScanner() {
        System.out.println("getScanner");
        GameData instance = new GameData();
        Scanner result = instance.getScanner();
        assertNotNull(result);
        
        
    }

    /**
     * Test of closeScanner method, of class GameData.
     */
    @Test
    public void testCloseScanner() {
        System.out.println("closeScanner");
        GameData instance = new GameData();
        instance.closeScanner();
        
    }
    
}
