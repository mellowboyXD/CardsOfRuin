package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.model.cards.Card;

/**
 *
 * @author mellowboy
 */
public class Hand extends Deck {
    public Hand(int size) {
        super(size);
    }

    @Override
    public Card drawRandom() {
        return super.getCards().remove(super.getRandomIndex());
    }

    public Card draw(int index) {
        var cards = super.getCards();
        if (index < 0 || index > cards.size() - 1) {
            throw new IllegalArgumentException("Index invalid. Out of range");
        }

        this.setSize(this.getSize() - 1);
        if (this.getSize() < 0) {
            throw new IllegalStateException("Cannot remove. No cards");
        }
        return this.getCards().remove(index);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Card card : getCards()) {
            ret.append(card).append(" ");
        }
        return ret.toString();
    }
}
