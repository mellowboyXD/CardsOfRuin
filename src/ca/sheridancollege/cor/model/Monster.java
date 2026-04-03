package ca.sheridancollege.cor.model;

/**
 *
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
	 */
	@Override
	public void setup() {
		super.setHealth(100);
		super.setAttack(20);
		super.setShield(50);
	}

	/**
	 * This is an inner class that is responsible to build the monster.
	 * This contains the base for the builder pattern.
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
