package ca.sheridancollege.cor.model;

/**
 * A class that models each Player in the game.
 *
 * @author mellowboy
 */
public class Player extends Entity {

	@Override
	public void setup() {
		super.setHealth(100);
		super.setAttack(30);
		super.setShield(60);
	}
}
