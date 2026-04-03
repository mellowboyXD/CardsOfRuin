package ca.sheridancollege.cor.model;

/**
 * This is the monster class, and it uses a builder design pattern to create a new monster.
 * It allows the class to be flexible and monster creation do not have to be bound to constructors.
 * @author mellowboy
 */
public class Monster extends Entity {

	public Monster(Builder builder) {
		super.setHealth(builder.health);
		super.setAttack(builder.attack);
		super.setShield(builder.shield);
	}

	/**
	 * Use this method to set up the monster when the game initially starts or restarts.
	 * Prefer to use builder patterns when adjusting monsters between rounds.
	 * This method does nothing but is required as Monster needs to implement it.
	 */
	@Override
	public void setup() {
	}

	/**
     * This is an inner class that is responsible to build the monster.
     * This contains the base for the builder pattern.
     * I took inspiration from this <a href="https://www.baeldung.com/java-builder-pattern">blog post</a>
     */
	public static class Builder {
		private int health;
		private int shield;
		private int attack;

		public Builder health(int health) {
			this.health = health;
			return this;
		}

		public Builder shield(int shield) {
			this.shield = shield;
			return this;
		}

		public Builder attack(int attack) {
			this.attack = attack;
			return this;
		}

		public Monster build() {
			return new Monster(this);
		}
	}
}
