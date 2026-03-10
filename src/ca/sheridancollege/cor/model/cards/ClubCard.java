package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 * Club type card.
 *
 * @author mellowboy
 */
public class ClubCard extends Card {

    public ClubCard(int value) {
        this.setSuit(Suit.CLUBS);
        this.setValue(value);
    }

    @Override
    public void apply(Player player, Monster monster) {
        // TODO:
    }
}
