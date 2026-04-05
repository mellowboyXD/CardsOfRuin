/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.model.cards.Card;
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
public class HandTest {
    
    public HandTest() {
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
     * Test of draw method, of class Hand.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Hand instance = new Hand(5);
        instance.setup();
        int sizeBefore = instance.getCards().size();
        Card result = instance.drawRandom();
        assertNotNull(result);
        assertEquals(sizeBefore - 1, instance.getCards().size());
        
    }
    
}
