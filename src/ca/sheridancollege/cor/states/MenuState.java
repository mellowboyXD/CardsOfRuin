package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Card;
import ca.sheridancollege.cor.model.GameData;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the main menu state of the game where players can:
 * - Start or continue playing
 * - View their current deck
 * - Exit the game
 * 
 * This state serves as the entry point and navigation hub for the game.
 * 
 * @author mellowboy
 * @see GameState
 * @see SetupState
 */
public class MenuState implements GameState {

    /** Shared game data containing player information and game state */
    private final GameData data;
    
    /** Scanner instance for reading user input */
    private final Scanner scanner;
    
    /** Flag indicating whether to transition to the game setup phase */
    private boolean startGame;

    /**
     * Constructs a new MenuState with the given game data.
     * 
     * @param data The shared game data object containing player information
     *             and game configuration
     */
    public MenuState(GameData data) {
        this.data = data;
        this.scanner = data.getScanner();
        this.startGame = false;
    }

    /**
     * Displays the main menu options to the player.
     * Called when entering this state.
     * 
     * TODO: Should be moved to a separate view class for better separation of concerns
     */
    @Override
    public void enter() {
        System.out.println("==== CARDS OF RUIN ====");
        System.out.println("1. Play/Continue");
        System.out.println("2. View Deck");
        System.out.println("3. Exit");
    }

    /**
     * Processes user input and handles menu selections.
     * Continuously prompts for input until a valid option is selected.
     * 
     * Handles:
     * - Integer input validation
     * - Out-of-range selections
     * - Input mismatches
     * - General exceptions
     * 
     * TODO: Should be moved to InputController class for better input handling
     */
    @Override
    public void update() {
        int choice = -1;
        do {
            System.out.print("> ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> startGame = true;           // Proceed to game setup
                    case 2 -> showDeck();                  // Display player's deck
                    case 3 -> System.exit(0);              // Exit the application
                    default -> throw new IllegalStateException("Invalid Option");
                }
            } catch (InputMismatchException ex) {
                // Handle non-integer input
                System.out.println("Invalid input. Enter integers only.");
                scanner.next(); // Clear the invalid input
                choice = -1;    // Reset choice to continue loop
            } catch (IllegalStateException ex) {
                // Handle out-of-range menu selections
                System.out.println("Invalid Input. Choose between 1 to 3.");
                choice = -1;    // Reset choice to continue loop
            } catch (Exception ex) {
                // Catch-all for unexpected errors
                ex.printStackTrace();
            }
        } while (choice == -1); // Continue until valid input received
    }

    /**
     * Performs cleanup before transitioning to the next state.
     * Displays a message indicating the start of the setup phase.
     */
    @Override
    public void exit() {
        System.out.println("\n==== SETUP PHASE ====");
    }

    /**
     * Determines the next state based on user selection.
     * 
     * @return SetupState if player chose to start game,
     *         null to remain in current state
     */
    @Override
    public GameState nextState() {
        if (startGame)
            return new SetupState(data);

        // Stay in current state if no valid transition requested
        return null;
    }

    /**
     * Displays all cards in the player's deck to the console.
     * If the deck is null, nothing is displayed.
     * 
     * TODO: Consider adding empty deck message
     * TODO: Consider moving to a separate view class
     */
    private void showDeck() {
        System.out.println("\n==== Deck ====");
        var deck = data.getDeck();
        if (deck != null) {
            for (Card c : deck.getCards()) {
                System.out.println(c);
            }
        }
        
    }
}
