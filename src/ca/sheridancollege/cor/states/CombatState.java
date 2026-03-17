package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

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

    private void playerAttacksMonster() {
        System.out.println("Player attacks...");
        var damageToDeal = player.getAttack();
        while (monster.getHealth() > 0 && damageToDeal > 0) {
            var currentMonsterShield = monster.getShield();
            if (currentMonsterShield > 0) {
                monster.setShield(currentMonsterShield - damageToDeal);
                damageToDeal -= currentMonsterShield;
            } else {
                monster.setHealth(monster.getHealth() - damageToDeal);
                damageToDeal -= monster.getHealth();
            }
        }
        System.out.println("Monster took some damage.");
        System.out.println("Monster #%d: ".formatted(monsterIdx) + monster);
    }

    private void monsterAttacksPlayer() {
        System.out.printf("Monster #%d attacks...%n", monsterIdx);
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
        System.out.print("Press enter to continue...");
        scanner.nextLine();
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
