package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 * Diamond type card.
 *
 * @author mellowboy
 */
public class DiamondCard extends Card {
    public DiamondCard(int value) {
        this.setSuit(Suit.DIAMONDS);
        this.setValue(value);
    }

    @Override
    public void apply(Player player, Monster monster) {
        // TODO:
    }
}
