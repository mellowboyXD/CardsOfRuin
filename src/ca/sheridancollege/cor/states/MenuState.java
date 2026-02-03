package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Card;
import ca.sheridancollege.cor.model.GameData;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is where the menu is displayed allowing players to continue playing or
 * to view their deck if they have one.
 * 
 * TODO: Should render menu and process input.
 * TODO: Implement separate view for rendering
 * TODO: Implement InputController for input handling
 * @author mellowboy
 */
public class MenuState implements GameState{

	private final GameData data;
	private final Scanner scanner;
	private boolean startGame;

	public MenuState(GameData data) {
		this.data = data;
		this.scanner = data.getScanner();
		startGame = false;
	}

	@Override
	public void enter() {
		System.out.println("==== CARDS OF RUIN ====");
		System.out.println("1. Play/Continue");
		System.out.println("2. View Deck");
		System.out.println("3. Exit");
	}

	@Override
	public void update() {
		int choice = -1;
		do {
			System.out.print("> ");
			try {
				choice = scanner.nextInt();
				switch (choice) {
					case 1 -> startGame = true;
					case 2 -> showDeck();
					case 3 -> System.exit(0);
					default -> throw new IllegalStateException("Invalid Option");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input. Enter integers only.");
				scanner.next();
				choice = -1;
			} catch (IllegalStateException ex) {
				System.out.println("Invalid Input. Choose between 1 to 3.");
				choice = -1;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} while (choice == -1);
	}

	@Override
	public void exit() {
		System.out.println("\n==== SETUP PHASE ====");
	}

	@Override
	public GameState nextState() {
		if (startGame)
			return new SetupState(data);

		// stay in current state
		return null;
	}

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
