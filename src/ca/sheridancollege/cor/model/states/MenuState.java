package ca.sheridancollege.cor.model.states;

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

	private GameData data;
	private GameContext context;
	private Scanner scanner;

	public MenuState(GameData data) {
		this.data = data;
		this.scanner = data.getScanner();
	}

	@Override
	public void enter() {
		System.out.println("==== Cards Of Ruin ====");
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
					case 1 -> throw new UnsupportedOperationException("Not Implemented Yet! Should Move on to next state");
					case 2 -> throw new UnsupportedOperationException("Not Implemented Yet! Should move to display deck");
					case 3 -> throw new UnsupportedOperationException("Not Implemented Yet!");
					default -> throw new IllegalStateException("Invalid State");
				}
			} catch (InputMismatchException ex) {
				scanner.next();
				choice = -1;
			} catch (IllegalStateException ex) {
				System.out.println("Invalid Input. Choose between 1 to 3.");
				choice = -1;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} while (choice != -1);
	}

	@Override
	public void exit() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public GameState nextState() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
}
