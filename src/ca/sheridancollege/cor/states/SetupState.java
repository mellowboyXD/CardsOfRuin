package ca.sheridancollege.cor.states;

import java.util.ArrayList;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Hand;
import ca.sheridancollege.cor.model.Monster;

/**
 *
 * @author mellowboy
 */
public class SetupState implements GameState {

    private final GameData data;
    private boolean ready;

    public SetupState(GameData data) {
        this.data = data;
        ready = false;
    }

    @Override
    public void enter() {
        // setup initial hand
        var hand = data.getHand();
        if (hand == null) {
            hand = new Hand(GameData.HAND_SIZE);
            hand.setCards(new ArrayList<>());
            for (int i = 0; i < hand.getSize(); i++) {
                hand.getCards().add(data.getDeck().drawRandom());
            }
            data.setHand(hand);
        }

        if (hand.getSize() < GameData.HAND_SIZE) {
            int oldSize = hand.getSize();
            hand.setSize(GameData.HAND_SIZE);
            for (int i = oldSize; i < hand.getSize(); i++) {
                hand.getCards().add(data.getDeck().drawRandom());
            }
        }

        var currentMonster = data.getMonster();
        if (currentMonster == null) {
            // TODO: use builder design pattern to create monster
            currentMonster = new Monster();
            currentMonster.setup();
            data.setMonster(currentMonster);
        } else {
            // decrease shield after each round
            if (currentMonster.getShield() > 0) {
                int shield = currentMonster.getShield();
                float modifier = 0.90f;
                currentMonster.setShield(Math.round(shield * modifier));
            }
        }

        System.out.println("==== PREPARE FOR BATTLE ====");
        System.out.println("Monster #" + (data.getMonstersDefeated() + 1) + " " + currentMonster);
        System.out.println("Your stats: " + data.getPlayer());
        System.out.println("Your hand: " + data.getHand());
    }

    @Override
    public void update() {
        ready = true;
    }

    @Override
    public void exit() {
        System.out.println("\n==== PICK PHASE ====");
    }

    @Override
    public GameState nextState() {
        if (ready)
            return new DrawCardState(data);

        // stay in this state
        return null;
    }

}
