/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model.cards;

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
public class CardGeneratorTest {
    
    public CardGeneratorTest() {
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
     * Test of generateCard method, of class CardGenerator.
     */
    @Test
    public void testGenerateCard() {
        System.out.println("generateCard");
        Card result = CardGenerator.generateCard();

        // Should never return null
        assertNotNull(result);

        // Must be one of the four concrete card types
        assertTrue(
            result instanceof HeartCard  ||
            result instanceof DiamondCard ||
            result instanceof ClubCard   ||
            result instanceof SpadeCard
        );

        // Value must be within valid card range (1–13)
        // Note: generateRandomValue() uses nextInt(12) + 1, so range is 1–12
        assertTrue(result.getValue() >= Card.getMinValue());
        assertTrue(result.getValue() <= Card.getMaxValue());

        // Suit must not be null
        assertNotNull(result.getSuit());
    }

    // generateCard() produces cards across multiple calls (randomness check)
    @Test
    public void testGenerateCardRandomness() {
        // Run many times — should see more than one unique suit eventually
        boolean seenHeart = false, seenDiamond = false,
                seenClub  = false, seenSpade  = false;

        for (int i = 0; i < 100; i++) {
            Card card = CardGenerator.generateCard();
            assertNotNull(card);
            if (card instanceof HeartCard)   seenHeart   = true;
            if (card instanceof DiamondCard) seenDiamond = true;
            if (card instanceof ClubCard)    seenClub    = true;
            if (card instanceof SpadeCard)   seenSpade   = true;
        }

        // After 100 cards all four suits should have appeared
        assertTrue("Expected at least one HeartCard",   seenHeart);
        assertTrue("Expected at least one DiamondCard", seenDiamond);
        assertTrue("Expected at least one ClubCard",    seenClub);
        assertTrue("Expected at least one SpadeCard",   seenSpade);

    }
    
}
