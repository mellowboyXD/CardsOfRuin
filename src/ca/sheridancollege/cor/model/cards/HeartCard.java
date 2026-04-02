package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.view.Console;

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

    /**
     * Increase player's health by card value. Notify if health is already at max value.
     * @param player - the player entity
     * @param monster - the monster entity
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerHealth = player.getHealth();
        var newHealth = playerHealth + getValue();
        if (newHealth <= player.getMaxHealth()) {
            player.setHealth(newHealth);
            Console.println("You gained %d health points!".formatted(getValue()));
        } else {
            Console.println("Your health is already at max!");
        }
    }
}
