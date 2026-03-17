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

    /**
     * Increase player's health by card value. Notify if health is already at max value.
     * @param player
     * @param monster
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerHealth = player.getHealth();
        var newHealth = playerHealth + getValue();
        if (newHealth <= player.getMaxHealth()) {
            player.setHealth(newHealth);
            System.out.println("Gained health points!");
        } else {
            System.out.println("Already at max health points!");
        }
    }
}
