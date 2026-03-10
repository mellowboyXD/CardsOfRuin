package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.effects.CardEffect;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.model.Monster;

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
public abstract class Card implements CardEffect {

    private Suit suit;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 13;
    private int value;

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
    public void setValue(int value) throws IllegalArgumentException {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Card value must be between " + MIN_VALUE + " and " + MAX_VALUE);
        }
        this.value = value;
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

    @Override
    public abstract void apply(Player player, Monster monster);
}