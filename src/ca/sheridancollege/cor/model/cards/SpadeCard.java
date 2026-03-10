package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 * This is the class for the type Spades.
 */
public class SpadeCard extends Card {

    public SpadeCard(int value) {
        this.setSuit(Suit.SPADES);
        this.setValue(value);
    }

    @Override
    public void apply(Player player, Monster monster) {
        // TODO:
    }
}
