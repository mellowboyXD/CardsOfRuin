package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.model.states.GameContext;
import java.util.Scanner;

/**
 * Central storage that contains all the entities and states of the game.
 * @author mellowboy
 */
public class GameData {
	private GameContext context;
	private Player player;
	private Monster monster;
	private Scanner scanner;
	private int round;
	private int monstersDefeated;

	public GameData() {
		player = new Player("john");
		context = new GameContext();
		scanner = new Scanner(System.in);
		round = 1;
		monstersDefeated = 0;
	}

	public int getRound() {
		return round;
	}

	public int getMonstersDefeated() {
		return monstersDefeated;
	}

	public GameContext getContext() {
		return context;
	}

	public Player getPlayer() {
		return player;
	}

	public Monster getMonster() {
		return monster;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void closeScanner() {
		scanner.close();
	}
}
