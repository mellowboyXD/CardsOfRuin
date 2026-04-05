/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.model.cards.Card;
import java.util.ArrayList;
import java.util.List;
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
public class DeckTest {
    
    public DeckTest() {
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
     * Test of setup method, of class Deck.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        Deck instance = new Deck(10);
        instance.setup();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(10, instance.getCards().size());
        long uniqueCount = instance.getCards().stream().distinct().count();
        assertEquals(10, uniqueCount);
    }

    /**
     * Test of getCards method, of class Deck.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Deck instance = new Deck(5);
        List<Card> result = instance.getCards();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        
    }

    /**
     * Test of setCards method, of class Deck.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        Deck instance = new Deck(5);
        instance.setup();
        List<Card> newCards = new ArrayList<>();
        instance.setCards(newCards);
        assertSame(newCards, instance.getCards());
        assertTrue(instance.getCards().isEmpty());
        
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        Deck instance = new Deck(5);
        instance.setup();
        int sizeBefore = instance.getCards().size();
        instance.shuffle();
        int sizeAfter = instance.getCards().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    /**
     * Test of draw method, of class Deck.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Deck instance = new Deck(5);
        instance.setup();
        Card result = instance.drawRandom();
        assertNotNull(result);
        
    }

    /**
     * Test of getSize method, of class Deck.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Deck instance = new Deck(7);
        assertEquals(7, instance.getSize());
    }

    /**
     * Test of getRandomIndex method, of class Deck.
     */
    @Test
    public void testGetRandomIndex() {
        System.out.println("getRandomIndex");
        Deck instance = new Deck(10);
        instance.setup();
        int index = instance.getRandomIndex();
        assertTrue(index >= 0);
        assertTrue(index < instance.getCards().size());
    }

    /**
     * Test of toString method, of class Deck.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Deck emptyDeck = new Deck(5);
        assertEquals("", emptyDeck.toString());
        Deck instance = new Deck(5);
        instance.setup();
        String result = instance.toString();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    
}
