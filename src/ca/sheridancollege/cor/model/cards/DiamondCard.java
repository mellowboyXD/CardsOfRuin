package ca.sheridancollege.cor.model.cards;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.view.Console;

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

    /**
     * Increase player's attack by 3/4 of card's value and monster's shield by 1/4 of card's value.
     *
     * @param player - the player entity
     * @param monster - the monster entity
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerAttack = player.getAttack();
        var monsterShield = monster.getShield();
        var playerAttackGain = (int) (0.75 * getValue());
        var monsterShieldGain = (int) (0.25 * getValue());
        var newPlayerAttack = playerAttack + playerAttackGain;
        var newMonsterShield = monsterShield + monsterShieldGain;

        if (newPlayerAttack <= player.getMaxAttack()) {
            player.setAttack(newPlayerAttack);
            Console.println("You gained %d attack points!".formatted(playerAttackGain));
        } else {
            Console.println("Your attack already at max value!");
        }

        if (newMonsterShield <= monster.getMaxShield()) {
            monster.setShield(newMonsterShield);
            Console.println("Monster gained %d shield!%n".formatted(monsterShieldGain));
        }
    }
}
