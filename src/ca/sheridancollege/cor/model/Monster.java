package ca.sheridancollege.cor.model;

/**
 *
 * @author mellowboy
 */
public class Monster extends Entity {

	@Override
	public void setup() {
		super.setHealth(100);
		super.setAttack(20);
		super.setShield(50);
	}
	
}
