package ca.sheridancollege.cor.model;

import ca.sheridancollege.cor.controller.GameController;
import ca.sheridancollege.cor.controller.EntityModifierOnEachRoundController;
import ca.sheridancollege.cor.states.GameContext;
import ca.sheridancollege.cor.view.Console;

import java.util.Scanner;

/**
 * Central storage container that holds all game-related data and entities.
 * Acts as the single source of truth for the game state, providing access to:
 * - Player and monster entities
 * - Card deck and hand management
 * - Game progression tracking (rounds, monsters defeated)
 * - Input handling resources
 * - State management context
 * This class follows the principle of centralizing game state to facilitate
 * easy data sharing between different game states and components.
 *
 * @author mellowboy
 * @see GameContext
 * @see Player
 * @see Monster
 * @see Deck
 * @see Hand
 */
public class GameData {

    /**
     * The maximum number of cards allowed in the player's deck
     */
    public static int DECK_SIZE = 15;

    /**
     * The maximum number of cards the player can hold in their hand at once
     */
    public static int HAND_SIZE = 3;

    /**
     * The game state machine context that manages state transitions
     */
    private final GameContext context;

    /**
     * The player entity containing player-specific attributes and stats
     */
    private final Player player;

    /**
     * The current monster entity being fought, null if no active monster
     */
    private Monster monster;

    /**
     * Scanner instance for handling user input throughout the game
     */
    private final Scanner scanner;

    /**
     * The player's complete collection of available cards
     */
    private final Deck deck;

    /**
     * The player's current hand of cards drawn from the deck
     */
    private Hand hand;

    /**
     * The current round number in the game (starts at 1)
     */
    private int round;

    /**
     * Counter tracking how many monsters the player has defeated
     */
    private int monstersDefeated;

    /**
     * The game controller.
     */
    private final GameController gameController;

    /**
     * The entity updater controller.
     */
    private final EntityModifierOnEachRoundController entityModifierOnEachRoundController;

    /**
     * Constructs a new GameData instance and initializes all game components.
     * Calls {@link #setup()} to establish the initial game state.
     */
    public GameData(GameController gameController, GameContext context) {
        this.gameController = gameController;
        this.context = context;
        player = new Player();
        scanner = new Scanner(System.in);
        deck = new Deck(DECK_SIZE);
        entityModifierOnEachRoundController = EntityModifierOnEachRoundController.getInstance();
        setup();
    }

    /**
     * Initializes or resets all game data to their starting values.
     * This method is marked final to prevent overriding and ensure
     * consistent initialization across all game instances.
     * Creates fresh instances of:
     * - Player entity
     * - Game context for state management
     * - Scanner for input handling
     * - Deck with initial cards
     * Resets tracking variables:
     * - Round counter to 1
     * - Monsters defeated to 0
     * - Hand to null (will be populated when game starts)
     * - Monster to null (will be created when combat begins)
     */
    public final void setup() {
        player.setup();
        round = 1;
        monstersDefeated = 0;
        deck.reset(); // Initialize deck with cards
        hand = null;  // Hand starts empty, will be drawn when game begins
        monster = null; // No monster initially
    }

    /**
     * Gets the player's current hand of cards.
     *
     * @return The current Hand object, or null if no hand has been drawn yet
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Sets the player's current hand of cards.
     * Typically called when drawing cards from the deck.
     *
     * @param cards The new Hand object containing the player's cards
     */
    public void setHand(Hand cards) {
        hand = cards;
    }

    /**
     * Gets the player's complete deck of cards.
     *
     * @return The Deck object containing all player cards
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Gets the current round number.
     *
     * @return The current round (starts at 1)
     */
    public int getRound() {
        return round;
    }

    /**
     * Increments the round counter.
     * Called when the player progresses to the next round/encounter.
     */
    public void nextRound() {
        round++;
    }

    /**
     * Gets the total number of monsters defeated by the player.
     *
     * @return The count of defeated monsters
     */
    public int getMonstersDefeated() {
        return monstersDefeated;
    }

    /**
     * Increments the monsters defeated counter.
     * Called when a monster is successfully defeated in combat.
     */
    public void defeatMonster() {
        monster = null;
        monstersDefeated++;
        nextRound();
        entityModifierOnEachRoundController.updatePlayer(player, round);
        Console.println("Your new stats: " + player.toString());
    }

    /**
     *
     * @return true if a game should continue and false if a new game should be created
     */
    public boolean inNewGame() {
        return hand == null;
    }

    /**
     * Gets the game context that manages state transitions.
     *
     * @return The GameContext object controlling the game flow
     */
    public GameContext getContext() {
        return context;
    }

    public GameController getGameController() { return gameController; }

    public EntityModifierOnEachRoundController entityRoundController() {
        return entityModifierOnEachRoundController;
    }

    /**
     * Gets the player entity.
     *
     * @return The Player object containing player stats and attributes
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the current monster entity.
     *
     * @return The current Monster object, or null if no active monster
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Sets the current monster entity.
     * Called when a new monster encounter begins.
     *
     * @param monster The new Monster object to be fought
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Gets the scanner instance for user input.
     *
     * @return The Scanner object used for reading console input
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Closes the scanner to release system resources.
     * Should be called when the game is shutting down to prevent resource leaks.
     * Note: After calling this method, the scanner cannot be used again.
     */
    public void closeScanner() {
        scanner.close();
    }
}
