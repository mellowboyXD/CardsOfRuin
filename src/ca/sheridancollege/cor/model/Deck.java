package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.model.cards.Card;
import ca.sheridancollege.cor.model.cards.CardGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A concrete class that represents any deck of cards.
 *
 * @author mellowboy
 */
public class Deck {

    // The group of cards, stored in an ArrayList
    private List<Card> cards;
    private int size;
    private final Random rand;

    public Deck(int size) {
        this.size = size;
        rand = new Random();
        cards = new ArrayList<Card>();
    }

    /**
     * Initialize deck that contains unique cards.
     */
    public final void setup() {
        for (int i = 0; i < size; i++) {
            var newCard = CardGenerator.generateCard();
            /* make sure the cards are unique. */
            while (cards.contains(newCard))
                newCard = CardGenerator.generateCard();
            cards.add(newCard);
        }
    }

    /**
     * @return the deck of cards.
     */
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.get(getRandomIndex());
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the deck of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getRandomIndex() {
        return rand.nextInt(cards.size());
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Card card : cards) {
            ret.append(card).append("\t");
        }
        return ret.toString();
    }
}
