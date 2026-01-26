package ca.sheridancollege.cor.entities;

import ca.sheridancollege.cor.entities.Card;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any deck of cards.
 *
 * @author dancye
 * @author Paul Bonenfant
 * @author Prem Parashar
 * @author mellowboy
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;

    public Deck(int size) {
        this.size = size;
    }

    /**
     * @return the deck of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}
