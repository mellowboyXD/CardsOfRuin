/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
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
public class CardTest {
    
    public CardTest() {
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
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new CardImpl();
        assertNull(instance.getSuit());
        instance.setSuit(Suit.HEARTS);
        assertEquals(Suit.HEARTS, instance.getSuit());
    }

    /**
     * Test of setSuit method, of class Card.
     */
    @Test
    public void testSetSuit() {
        System.out.println("setSuit");
        Card instance = new CardImpl();
        instance.setSuit(Suit.DIAMONDS);
        assertEquals(Suit.DIAMONDS, instance.getSuit());
        instance.setSuit(Suit.SPADES);
        assertEquals(Suit.SPADES, instance.getSuit());
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new CardImpl();
        assertEquals(0, instance.getValue());
        instance.setValue(7);
        assertEquals(7, instance.getValue());
    }

    /**
     * Test of setValue method, of class Card.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Card instance = new CardImpl();
        instance.setValue(1);
        assertEquals(1, instance.getValue());
        instance.setValue(13);
        assertEquals(13, instance.getValue()); 
        // Below min — should throw
        try {
            instance.setValue(0);
            fail("Expected IllegalArgumentException for value 0");
            } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            instance.setValue(14);
            fail("Expected IllegalArgumentException for value 14");
            } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * Test of getMinValue method, of class Card.
     */
    @Test
    public void testGetMinValue() {
        System.out.println("getMinValue");
        assertEquals(1, Card.getMinValue());
    }

    /**
     * Test of getMaxValue method, of class Card.
     */
    @Test
    public void testGetMaxValue() {
        System.out.println("getMaxValue");
        assertEquals(13, Card.getMaxValue());
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new CardImpl();
        instance.setSuit(Suit.CLUBS);
        instance.setValue(5);

        assertEquals("5 of clubs", instance.toString());
    }

    /**
     * Test of equals method, of class Card.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Card instance = new CardImpl();
        instance.setSuit(Suit.HEARTS);
        instance.setValue(3);

        // null should be false
        assertNotEquals(null, instance);

        // Same object — true
        assertEquals(instance, instance);

        // Same class, same suit and value — true
        Card same = new CardImpl();
        same.setSuit(Suit.HEARTS);
        same.setValue(3);
        assertEquals(instance, same);

        // Different value — false
        Card diffValue = new CardImpl();
        diffValue.setSuit(Suit.HEARTS);
        diffValue.setValue(5);
        assertNotEquals(instance, diffValue);

        // Different suit — false
        Card diffSuit = new CardImpl();
        diffSuit.setSuit(Suit.SPADES);
        diffSuit.setValue(3);
        assertNotEquals(instance, diffSuit);
    }

    /**
     * Test of apply method, of class Card.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        Player player = new Player();
        player.setup();
        Monster monster = new Monster.Builder().build();
        monster.setup();
        Card instance = new CardImpl();

        instance.apply(player, monster);
    }

    public static class CardImpl extends Card {
        @Override    
        public void apply(Player player, Monster monster) {
        }
    }
    
}
