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
    public Card draw() {
        return super.getCards().remove(super.getRandomIndex());
    }
}
