package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.controller.InputController;
import ca.sheridancollege.cor.view.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the main menu state of the game where players can:
 * - Start or continue playing
 * - View their current deck
 * - Exit the game
 * This state serves as the entry point and navigation hub for the game.
 *
 * @author mellowboy
 * @see GameState
 * @see SetupState
 */
public class MenuState implements GameState {

    /**
     * Shared game data containing player information and game state
     */
    private final GameData data;

    /**
     * Scanner instance for reading user input
     */
    private final Scanner scanner;

    /**
     * Flag indicating whether to transition to the game setup phase
     */
    private boolean startOrContinueGame;

    /**
     * Constructs a new MenuState with the given game data.
     *
     * @param data The shared game data object containing player information
     *             and game configuration
     */
    public MenuState(GameData data) {
        this.data = data;
        this.scanner = data.getScanner();
        this.startOrContinueGame = false;
        if (data.getPlayer().getHealth() <= 0) {
            data.setup();
        }
    }

    /**
     * Displays the main menu options to the player.
     * Called when entering this state.
     */
    @Override
    public void enter() {
        if (data.inNewGame()) {
            Console.printOptions(new ArrayList<>(List.of(
                    "Start New Game",
                    "View Game Rules",
                    "Exit"
            )));
        } else {
            Console.printOptions(new ArrayList<>(List.of(
                    "Continue",
                    "View Deck",
                    "My Stats",
                    "Review Game Rules",
                    "Exit"
            )));
        }
    }

    /**
     * Processes user input and handles menu selections.
     * Continuously prompts for input until a valid option is selected.
     * Handles:
     * - Integer input validation
     * - Out-of-range selections
     * - Input mismatches
     * - General exceptions
     */
    @Override
    public void update() {
        int choice;
        do {
            Console.printAwake("choose from menu > ");
            try {
                choice = InputController.readInt(scanner);
                if (data.inNewGame()) {
                    // handle inputs for when not in game
                    switch (choice) {
                        case 1 -> startOrContinueGame = true;
                        case 2 -> showGameRules();
                        case 3 -> quitGame();
                        default -> throw new IllegalStateException("Invalid option! Choose between 1-3.");
                    }
                } else {
                    // handle input for when in game
                    switch (choice) {
                        case 1 -> startOrContinueGame = true; // Proceed to game setup
                        case 2 -> showDeck();
                        case 3 -> showPlayerStats();
                        case 4 -> showGameRules();
                        case 5 -> quitGame();
                        default -> throw new IllegalStateException("Invalid Option! Choose between 1-5.");
                    }
                }
            } catch (IllegalStateException ex) {
                // Handle out-of-range menu selections
                Console.println(ex.getMessage());
                choice = -1;    // Reset choice to continue loop
            }
        } while (choice == -1); // Continue until valid input received
    }

    /**
     * Performs cleanup before transitioning to the next state.
     * Displays a message indicating the start of the setup phase.
     */
    @Override
    public void end() {
        Console.printLabelAwake("SETUP PHASE");
        InputController.pressEnterToContinue(data.getScanner());
    }

    /**
     * Determines the next state based on user selection.
     *
     * @return SetupState if player chose to start game,
     * null to remain in current state
     */
    @Override
    public GameState nextState() {
        if (startOrContinueGame)
            return new SetupState(data);

        // Stay in current state if no valid transition requested
        return null;
    }

    /**
     * Displays all cards in the player's deck to the console.
     * If the deck is null, nothing is displayed.
     * TODO: Consider adding empty deck message
     */
    private void showDeck() {
        Console.printLabelAwake("DECK");
        var deck = data.getDeck();
        if (deck != null) {
            Console.println(deck.toString());
        }
    }

    private void showPlayerStats() {
        Console.printLabelAwake("MY STATS");
        Console.printlnAwake(data.getPlayer().toString());
        Console.printlnAwake("Round: " + data.getRound());
        Console.println("Monsters defeated: " + data.getMonstersDefeated());
    }

    private void showGameRules() {
    Console.printLabelAwake("GAME RULES");
    Console.printLabelAwake("The Goal of the Game is to defeat the monster before your health reaches 0.");
    Console.printLabelAwake("");
    Console.printLabelAwake("=== CARD TYPES ===");
    Console.printLabelAwake("HEART: Boosts your Health by card value");
    Console.printLabelAwake("DIAMOND: Boosts your attributes BUT also boosts the monster's attributes");
    Console.printLabelAwake("CLUB: Boosts your Shield by card value");
    Console.printLabelAwake("SPADE: Boosts your Attack by card value");
    Console.printLabelAwake("");
    Console.printLabelAwake("=== COMBAT RULES ===");
    Console.printLabelAwake("• Each round: Draw a card, then play a card");
    Console.printLabelAwake("• Player attacks FIRST in combat");
    Console.printLabelAwake("• Damage calculation: Damage = Opponent Attack - Your Shield");
    Console.printLabelAwake("• If Shield is 0, damage is taken from Health");
    Console.printLabelAwake("• Monsters get STRONGER each round");
    Console.printLabelAwake("");
    Console.printLabelAwake("=== GAME FLOW ===");
    Console.printLabelAwake("1. Draw Phase - Draw a card from your deck");
    Console.printLabelAwake("2. Apply Phase - Choose a card to play");
    Console.printLabelAwake("3. Combat Phase - Fight the monster (you attack first)");
    Console.printLabelAwake("4. Reward Phase - Collect rewards after victory");
    Console.printLabelAwake("");
    Console.printLabelAwake("=== GAME ENDING ===");
    Console.printLabelAwake("• You LOSE if your Health reaches 0");
    Console.printLabelAwake("• You can choose to continue or exit after defeating a monster");
}
    private void quitGame() {
        Console.exit(data.getGameController());
    }
}
