package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.controller.InputController;
import ca.sheridancollege.cor.view.Console;

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
            Console.println("Hooray!! Monster #%d was defeated.".formatted(monsterIdx));
            Console.println("You get some points!");
            gameData.defeatMonster();
            Console.println("Beginning round %d...".formatted(gameData.getRound()));
        } else if (player.getHealth() <= 0) {
            Console.println("You lost!");
            Console.println("You lasted %d rounds".formatted(gameData.getRound()));
            Console.println("Better luck next time");
        }
    }

    @Override
    public void update() {
        InputController.pressEnterToContinue(scanner);
        ready = true;
    }

    @Override
    public void exit() {
        Console.printLabelAwake("");
    }

    @Override
    public GameState nextState() {
        if (ready)
            return new MenuState(gameData);
        return null;
    }
}
