package ca.sheridancollege.cor.model;

/**
 * Base class for player and monsters.
 *
 * @author mellowboy
 */
public abstract class Entity {
    private final int MAX_HEALTH = 200;
    private final int MAX_ATTACK = 150;
    private final int MAX_SHIELD = 300;

    private int health;
    private int shield;
    private int attack;

    public void setHealth(int health) {
        if (health < 0)
            this.health = 0;
        else
            this.health = Math.min(health, MAX_HEALTH);
    }

    public void setShield(int shield) {
        if (shield < 0)
            this.shield = 0;
        else
            this.shield = Math.min(shield, MAX_SHIELD);
    }

    public void setAttack(int attack) {
        if (attack < 0)
            this.attack = 0;
        else
            this.attack = Math.min(attack, MAX_ATTACK);
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public int getAttack() {
        return attack;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getMaxAttack() {
        return MAX_ATTACK;
    }

    public int getMaxShield() {
        return MAX_SHIELD;
    }

    public abstract void setup();

    @Override
    public String toString() {
        return "health: %d - attack: %d - shield: %d".formatted(getHealth(), getAttack(), getShield());
    }
}
