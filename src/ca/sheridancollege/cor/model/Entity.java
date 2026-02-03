package ca.sheridancollege.cor.model;

/**
 * Base class for player and monsters.
 * @author mellowboy
 */
public abstract class Entity {
	private int health;
	private int shield;
	private int attack;

	public void setHealth(int health) { this.health = health; }
	public void setShield(int shield) { this.shield = shield; }
	public void setAttack(int attack) { this.attack = attack; }

	public int getHealth() { return health; }
	public int getShield() { return shield; }
	public int getAttack() { return attack; }

	public abstract void setup();
}
