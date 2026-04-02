package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.view.Console;

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
     * @param player - the player entity
     * @param monster - the monster entity
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerShield = player.getShield();
        var newShield = playerShield + getValue();
        if (newShield <= player.getMaxShield()) {
            player.setShield(newShield);
            Console.println("You gained %d shield!%n".formatted(getValue()));
        } else {
            Console.println("Your shield is already at max value!");
        }
    }
}
