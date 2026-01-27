package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Card;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Hand;
import ca.sheridancollege.cor.model.Monster;
import java.util.ArrayList;

/**
 *
 * @author mellowboy
 */
public class SetupState implements GameState{

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
			hand.setCards(new ArrayList<Card>());
			for(int i = 0; i < hand.getCards().size(); i++) {
				hand.getCards().add(data.getDeck().draw());
			}
			data.setHand(hand);
		}

		var currentMonster = data.getMonster();
		if (currentMonster == null) {
			// TODO: use builder design pattern to create monster
			currentMonster = new Monster();
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
			return new PickState(data);

		// stay in this state
		return null;
	}

}
