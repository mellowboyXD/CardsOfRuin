package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 * This class controls how entities get modified on each round.
 * It has logic for increasing monster attributes each round.
 */
public class EntityModifierOnEachRoundController {
    private static EntityModifierOnEachRoundController instance = null;
    private final int MAX_ROUND = 10;

    private EntityModifierOnEachRoundController() {}

    /**
     * @return a single instance on this class
     */
    public static EntityModifierOnEachRoundController getInstance() {
        if (instance == null) {
            instance = new EntityModifierOnEachRoundController();
        }
        return instance;
    }

    /**
     * Monster is in defensive 'stance' when in even rounds (2, 4, 6) and attacking 'stance' when
     * round is odd.
     * @param round - the current round
     * @return a new monster with the appropriate attributes
     * @throws IllegalArgumentException - if the round is negative
     */
    public Monster createMonster(int round) throws IllegalArgumentException {
        if (round < 0)
            throw new IllegalArgumentException("Invalid Round");

        int shield;
        int attack;
        int health;
        int modifier = Math.min(round, MAX_ROUND);

        if (round % 2 == 0) {
            // defense stance
            shield = modifier * 15;
            health = modifier * 20;
            attack = modifier * 5;
        } else {
            // attack stance
            shield = modifier * 5;
            health = modifier * 10;
            attack = modifier * 15;
        }

        return new Monster.Builder()
                .health(health)
                .attack(attack)
                .shield(shield)
                .build();
    }

    /**
     * Updates player's health, shield and attack. Should be invoked when a monster is defeated as
     * part of the reward given to the player.
     * @param player - the current player entity
     * @param round - the current round
     */
    public void updatePlayer(Player player, int round) {
        if (round < 0)
            throw new IllegalArgumentException("Invalid round");
        if (round <= MAX_ROUND) {
            player.setHealth((int) Math.round(player.getHealth() * 1.10));
            player.setAttack((int) Math.round(player.getAttack() * 1.12));
            player.setShield((int) Math.round(player.getShield() * 1.15));
        }
    }
}
