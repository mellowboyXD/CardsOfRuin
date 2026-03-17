package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 * This is the class for the type Spades.
 *
 * @author mellowboy
 */
public class SpadeCard extends Card {

    public SpadeCard(int value) {
        this.setSuit(Suit.SPADES);
        this.setValue(value);
    }

    /**
     * Increase player's attack by card value. If attack is already at max value, notify.
     *
     * @param player
     * @param monster
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerAttack = player.getAttack();
        var newAttack = playerAttack + getValue();
        if (newAttack <= player.getMaxAttack()) {
            player.setAttack(newAttack);
            System.out.println("Gained attack points!");
        } else {
            System.out.println("Attack is already at max!");
        }
    }
}
