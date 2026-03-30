package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.view.ConsoleView;

import java.util.Scanner;

public class RewardState implements GameState {
    private final Scanner scanner;
    private final GameData gameData;
    private final Monster monster;
    private final Player player;
    private boolean ready;

    public RewardState(GameData data) {
        this.gameData = data;
        scanner = data.getScanner();
        monster = data.getMonster();
        player = data.getPlayer();
        ready = false;
    }

    @Override
    public void enter() {
        var monsterIdx = gameData.getMonstersDefeated() + 1;
        if (monster.getHealth() <= 0) {
            System.out.printf("Hooray!! Monster #%d was defeated.\n", monsterIdx);
            System.out.println("You get some points!");
            gameData.defeatMonster();
            System.out.printf("Beginning round %d...\n", gameData.getRound());
        } else if (player.getHealth() <= 0) {
            System.out.println("You lost!");
            System.out.printf("You lasted %d rounds", gameData.getRound());
            System.out.println("Better luck next time");
        }
    }

    @Override
    public void update() {
        ConsoleView.pressEnterToContinue(scanner);
        ready = true;
    }

    @Override
    public void exit() {
        System.out.println("===== =====");
    }

    @Override
    public GameState nextState() {
        if (ready)
            return new MenuState(gameData);
        return null;
    }
}
