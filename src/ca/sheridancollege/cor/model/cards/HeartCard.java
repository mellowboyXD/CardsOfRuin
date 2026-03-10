package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.model.Monster;

/**
 * This class is a card of type heart. It implements apply.
 *
 * @author mellowboy
 * */
public class HeartCard extends Card {

    public HeartCard(int value) {
        this.setSuit(Suit.HEARTS);
        this.setValue(value);
    }

    @Override
    public void apply(Player player, Monster monster) {
        // TODO: To implement this method accordingly
    }
}
