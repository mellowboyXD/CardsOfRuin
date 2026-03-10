package ca.sheridancollege.cor.model.cards;

import java.util.Random;

import ca.sheridancollege.cor.model.Suit;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card
 * game.
 * 
 * @author Prem Parashar
 * @author dancye
 * @author mellowboyxd
 * @author ibrahass
 */

/*
 * This class is created to get Card suit of types heart, diamond, clubs and
 * generates a random 1 to 13 values
 * these values are going to be used to add health , shield, and attack points
 */
public final class Card {

    private static final Random random = new Random();
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 13;

    private Suit suit;
    private int value;

    /**
     * NoArgs constructor. Generates a random suit.
     * TODO: Delegate the suit creation to another class that will eventually
     * control how many of each suit the user can have. at each time
     */
    public Card() {
        var suitValue = (int) (Math.random() * 4) + 1;
        Suit suit;
        switch (suitValue) {
            case 1 -> suit = Suit.HEARTS;
            case 2 -> suit = Suit.DIAMONDS;
            case 3 -> suit = Suit.CLUBS;
            default -> suit = Suit.SPADES;
        }

        this(suit);
    }

    /**
     * Constructor to create a new card with a random value between 1-13
     * 
     * @param suit The suit of the card (HEARTS, DIAMONDS, CLUBS, SPADES)
     */
    public Card(Suit suit) {
        this.suit = suit;
        this.value = generateRandomValue();
    }

    /**
     * Constructor to create a new card with a specific value
     * 
     * @param suit  The suit of the card
     * @param value The specific value (should be between 1-13)
     */
    public Card(Suit suit, int value) {
        this.suit = suit;
        setValue(value); // Using setter to validate
    }

    /**
     * Generates a random value between MIN_VALUE and MAX_VALUE
     * 
     * @return random integer between 1-13
     */
    private int generateRandomValue() {
        return random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }

    /**
     * Gets the suit of the card
     * 
     * @return The Suit enum value
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card
     * 
     * @param suit The new suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Gets the value of the card
     * 
     * @return The card value (1-13)
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the card with validation
     * 
     * @param value The new value (must be between 1-13)
     * @throws IllegalArgumentException if value is outside 1-13 range
     */
    public void setValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Card value must be between " + MIN_VALUE + " and " + MAX_VALUE);
        }
        this.value = value;
    }

    /**
     * Rerolls the card to a new random value
     */
    public void rerollValue() {
        this.value = generateRandomValue();
    }

    /**
     * Static method to get the minimum possible card value
     * 
     * @return minimum card value (1)
     */
    public static int getMinValue() {
        return MIN_VALUE;
    }

    /**
     * Static method to get the maximum possible card value
     * 
     * @return maximum card value (13)
     */
    public static int getMaxValue() {
        return MAX_VALUE;
    }

    /**
     * @return a String representation of a card.
     */
    @Override
    public String toString() {
        return value + " of " + suit.toString().toLowerCase();
    }

    /**
     * @param obj is a Card to compare with
     * @return true if the obj is the same as this card.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != getClass())
            return false;

        Card other = (Card) obj;

        return other.getValue() == getValue() && other.getSuit() == getSuit();
    }

    // Testing Functionality
    /*
     * public static void main(String[] args) {
     * System.out.println("=== Quick Card Test ===");
     * 
     * // Create some random cards
     * for (int i = 0; i < 5; i++) {
     * Card card = new Card(Suit.HEARTS);
     * System.out.println(card);
     * }
     * 
     * // Test specific values
     * Card ace = new Card(Suit.SPADES, 1);
     * Card king = new Card(Suit.DIAMONDS, 13);
     * System.out.println("\n" + ace);
     * System.out.println(king);
     * }
     */
}
