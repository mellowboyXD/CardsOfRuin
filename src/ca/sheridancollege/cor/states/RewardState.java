package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;
import ca.sheridancollege.cor.controller.InputController;
import ca.sheridancollege.cor.view.Console;

import java.util.Scanner;

public class RewardState implements GameState {
    private final Scanner scanner;
    private final GameData data;
    private final Monster monster;
    private final Player player;
    private boolean ready;

    public RewardState(GameData data) {
        this.data = data;
        scanner = data.getScanner();
        monster = data.getMonster();
        player = data.getPlayer();
        ready = false;
    }

    private void resetGame() {
        data.getContext().resetState(data);
    }

    @Override
    public void enter() {
        var monsterIdx = data.getMonstersDefeated() + 1;
        if (monster.getHealth() <= 0) {
            Console.printLabelAwake("MONSTER DEFEATED!");
            Console.println("Hooray!! Monster #%d was defeated.".formatted(monsterIdx));
            Console.println("You get some points!");
            data.defeatMonster();
            Console.println("Beginning round %d...".formatted(data.getRound()));
        } else if (player.getHealth() <= 0) {
            Console.printLabelAwake("GAME OVER!");
            Console.println("You lost!");
            Console.println("You lasted %d rounds".formatted(data.getRound()));
            Console.println("Better luck next time.");
            resetGame();
        }
    }

    @Override
    public void update() {
        InputController.pressEnterToContinue(scanner);
        ready = true;
    }

    @Override
    public void end() {
        Console.printLabelAwake("");
    }

    @Override
    public GameState nextState() {
        if (ready)
            return new MenuState(data);
        return null;
    }
}
