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

    /**
     * Increase player's shield by card value. Notify if already at max shield.
     * @param player
     * @param monster
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerShield = player.getShield();
        var newShield = playerShield + getValue();
        if (newShield <= player.getMaxShield()) {
            player.setShield(newShield);
            System.out.println("Gained shield!");
        } else {
            System.out.println("Shield is already at max value!");
        }
    }
}
