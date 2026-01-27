package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.states.GameContext;
import java.util.List;
import java.util.Scanner;

/**
 * Central storage that contains all the entities and states of the game.
 * @author mellowboy
 */
public class GameData {
	public static int DECK_SIZE = 15;
	public static int HAND_SIZE = 3;

	private GameContext context;
	private Player player;
	private Monster monster;
	private Scanner scanner;
	private Deck deck; // general deck of cards
	private Hand hand; // what the player currently has in hand
	private int round;
	private int monstersDefeated;

	public GameData() {
		setup();
	}

	public final void setup() {
		player = new Player();
		context = new GameContext();
		scanner = new Scanner(System.in);
		round = 1;
		monstersDefeated = 0;
		deck = new Deck(DECK_SIZE);
		deck.setup();
		hand = null;
		monster = null;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand cards) {
		hand = cards;
	}

	public Deck getDeck() {
		return deck;
	}

	public int getRound() {
		return round;
	}

	// increment round aka move to next round
	public void nextRound() {
		round++;
	}

	public int getMonstersDefeated() {
		return monstersDefeated;
	}

	public void defeatMonster() {
		monstersDefeated++;
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

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void closeScanner() {
		scanner.close();
	}
}
