package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Entity;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.controller.InputController;
import ca.sheridancollege.cor.view.Console;

import java.util.Scanner;

public class CombatState implements GameState{
    private final Player player;
    private final Monster monster;
    private final Scanner scanner;
    private boolean ready;
    private final int monsterIdx;
    private final GameData gameData;

    public CombatState(GameData data) {
        this.gameData = data;
        this.player = data.getPlayer();
        this.monster = data.getMonster();
        this.scanner = data.getScanner();
        this.monsterIdx = data.getMonstersDefeated() + 1;
        ready = false;
    }

    /**
     * Deals damage to the entity. Use this method to calculate and deal damage to the
     * entity. It initially deals all the damage to the entity's shield. If the shield is
     * zero, it deals the remaining damage to the entity's health.
     * @param entity - the entity to deal damage to, i.e., player or monster
     * @param damageToDeal - the total damage to deal to the entity
     */
    private void entityTakesDamage(Entity entity, int damageToDeal) {
        while(entity.getHealth() > 0 && damageToDeal > 0) {
            var currentShield = entity.getShield();
            if (currentShield > 0) {
                entity.setShield(currentShield - damageToDeal);
                damageToDeal -= currentShield;
            } else {
                entity.setHealth(entity.getHealth() - damageToDeal);
                damageToDeal -= entity.getHealth();
            }
        }
    }

    private void playerAttacksMonster() {
        Console.println("Player attacks...");
        var damageToDeal = player.getAttack();
        entityTakesDamage(monster, damageToDeal);
        Console.println("Monster took some damage.");
        Console.println("Monster #%d: ".formatted(monsterIdx) + monster);
    }

    private void monsterAttacksPlayer() {
        Console.println("Monster #%d attacks...".formatted(monsterIdx));
        var damageToDeal = monster.getAttack();
        entityTakesDamage(player, damageToDeal);
        Console.println("Player took some damage.");
        Console.println("Player: " + player);
    }

    @Override
    public void enter() {
        playerAttacksMonster();
        if (monster.getHealth() > 0) {
            monsterAttacksPlayer();
        }
    }

    @Override
    public void update() {
        InputController.pressEnterToContinue(scanner);
        ready = true;
    }

    @Override
    public void end() {
        Console.printLabelAwake("REWARD PHASE");
    }

    @Override
    public GameState nextState() {
        if (ready)
            return new RewardState(gameData);
        return null;
    }
}
