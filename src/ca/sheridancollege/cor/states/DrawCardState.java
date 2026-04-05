package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.cards.Card;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Hand;
import ca.sheridancollege.cor.controller.InputController;
import ca.sheridancollege.cor.view.Console;

import java.util.Scanner;

/**
 * Represents the state where the player draws and selects a card to apply.
 * This state displays the player's current hand and allows them to choose
 * a card to use, which will then be applied to player stats or game effects.
 * The selected card's effects will be processed before transitioning to the
 * combat phase.
 *
 * @author mellowboy
 * @see GameState
 * @see GameData
 * @see Hand
 * @see Card
 */
public class DrawCardState implements GameState {

    /**
     * Shared game data containing player information and game state
     */
    private final GameData data;

    /**
     * Scanner instance for reading user input
     */
    private final Scanner scanner;

    /**
     * Flag indicating whether a card has been successfully selected
     */
    private boolean ready = false;

    /**
     * Reference to the player's hand containing available cards
     */
    private final Hand hand;

    /**
     * Constructs a new DrawCardState with the given game data.
     * Initializes references to the scanner and player's hand for easy access.
     *
     * @param data The shared game data object containing player information
     *             and game configuration
     */
    public DrawCardState(GameData data) {
        this.data = data;
        this.scanner = data.getScanner();
        this.hand = data.getHand();
    }

    /**
     * Displays the player's current hand with numbered options.
     * Each card is shown with its details, and the total hand size is displayed.
     * Called when entering this state.
     * TODO: Consider moving display logic to a separate view class
     * TODO: Add visual formatting improvements for better readability
     */
    @Override
    public void enter() {
        Console.printOptions(hand.getCards());
    }

    /**
     * Processes player input for card selection.
     * Continuously prompts until a valid card choice is made.
     * Handles:
     * - Integer input validation
     * - Out-of-range selections (choices exceeding hand size)
     * - Input mismatches
     * Once a valid card is selected, it will be applied to player stats
     * and effects in future implementations.
     * TODO: Create proper card class hierarchy for different card types
     */
    @Override
    public void update() {
        int choice;
        do {
            try {
                Console.print("pick a card > ");
                choice = InputController.readInt(scanner);
                if (choice > hand.getSize() || choice < 1)
                    throw new IllegalStateException("Invalid choice");
            } catch (IllegalStateException ex) {
                // Handle out-of-range selections
                Console.println("Invalid option. Try again.");
                choice = -1;    // Reset choice to continue loop
            }
        } while (choice == -1); // Continue until valid input received

        var selectedCard = hand.draw(choice - 1);
        Console.println("Selected card: " + selectedCard);
        selectedCard.apply(data.getPlayer(), data.getMonster());
        Console.println("Player: " + data.getPlayer());

        ready = true;
    }

    /**
     * Performs cleanup before transitioning to the next state.
     * Displays a message indicating the start of the combat phase.
     * TODO: Add any necessary cleanup of temporary state variables
     */
    @Override
    public void end() {
        InputController.pressEnterToContinue(scanner);
        Console.printLabelAwake("COMBAT PHASE");
    }

    /**
     * Determines the next state after card selection.
     * Currently, throws UnsupportedOperationException as the next state
     * (combat phase) is not yet implemented.
     *
     * @return The next game state: combat phase
     */
    @Override
    public GameState nextState() {
        if (ready)
            return new CombatState(data);

        // Stay in current state if no card has been selected yet
        return null;
    }
}
