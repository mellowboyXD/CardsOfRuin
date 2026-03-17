package ca.sheridancollege.cor.model;

/**
 * Base class for player and monsters.
 *
 * @author mellowboy
 */
public abstract class Entity {
    private final int MAX_HEALTH = 100;
    private final int MAX_ATTACK = 500;
    private final int MAX_SHIELD = 300;

    private int health;
    private int shield;
    private int attack;

    public void setHealth(int health) {
        if (health <= MAX_HEALTH) this.health = health;
    }

    public void setShield(int shield) {
        if (shield <= MAX_SHIELD) this.shield = shield;
    }

    public void setAttack(int attack) {
        if (attack <= MAX_ATTACK) this.attack = attack;
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
}
