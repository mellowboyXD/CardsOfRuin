package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Entity;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.view.ConsoleView;

import java.util.Scanner;

public class CombatState implements GameState{
    private final Player player;
    private final Monster monster;
    private final Scanner scanner;
    private boolean ready;
    private final int monsterIdx;

    public CombatState(GameData data) {
        this.player = data.getPlayer();
        this.monster = data.getMonster();
        this.scanner = data.getScanner();
        this.monsterIdx = data.getMonstersDefeated() + 1;
        ready = false;
    }

    private void entityAttack(Entity entity, int damageToDeal) {
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
        System.out.println("Player attacks...");
        var damageToDeal = player.getAttack();
        entityAttack(monster, damageToDeal);
        System.out.println("Monster took some damage.");
        System.out.println("Monster #%d: ".formatted(monsterIdx) + monster);
    }

    private void monsterAttacksPlayer() {
        System.out.printf("Monster #%d attacks...%n", monsterIdx);
        var damageToDeal = monster.getAttack();
        entityAttack(player, damageToDeal);
        System.out.println("Player took some damage.");
        System.out.println("Player: " + player);
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
        ConsoleView.pressEnterToContinue(scanner);
        ready = true;
    }

    @Override
    public void exit() {
        System.out.println("===== REWARD PHASE =====");
    }

    @Override
    public GameState nextState() {
        return null;
    }
}
