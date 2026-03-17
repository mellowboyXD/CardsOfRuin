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

    /**
     * Increase player's attack by 3/4 of card's value and monster's shield by 1/4 of card's value.
     *
     * @param player
     * @param monster
     */
    @Override
    public void apply(Player player, Monster monster) {
        var playerAttack = player.getAttack();
        var monsterShield = monster.getShield();
        var newPlayerAttack = (int) (playerAttack + (0.75 * getValue()));
        var newMonsterShield = (int) (monsterShield + (0.25 * getValue()));

        if (newPlayerAttack <= player.getMaxAttack()) {
            player.setAttack(newPlayerAttack);
            System.out.println("Gained attack points!");
        } else {
            System.out.println("Attack already at max value!");
        }

        if (newMonsterShield <= monster.getMaxShield()) {
            monster.setShield(newMonsterShield);
            System.out.println("Monster gained %d shield!".formatted(newMonsterShield));
        }
    }
}
