package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.Card;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Hand;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Player picks a card to apply.
 * @author mellowboy
 */
public class DrawCardState implements GameState {

	private GameData data;
	private Scanner scanner;
	private boolean ready = false;
	private Hand hand;

	public DrawCardState(GameData data) {
		this.data = data;
		this.scanner = data.getScanner();
		this.hand = data.getHand();
	}

	@Override
	public void enter() {
		System.out.println("Size: " + hand.getCards().size());
		for (int i = 0; i < hand.getSize(); i++) {
			System.out.println("| " + (i + 1) + ". " + hand.getCards().get(i) + " | ");
		}
	}

	@Override
	public void update() {
		int choice = -1;
		do {
			try	{
				System.out.print("> ");
				choice = scanner.nextInt();
				if (choice > hand.getSize())
					throw new IllegalStateException("Invalid choice");
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input. Try again.");
				scanner.next();
				choice = -1;
			} catch (IllegalStateException ex) {
				System.out.println("Invalid option. Try again.");
				choice = -1;
			}
		} while (choice == -1);

		var selectedCard = hand.getCards().get(choice);
		System.out.println("Selected card: " + selectedCard);
		// TODO: Apply card to player stats
		// TODO: Set up cards classes
		// TODO: Implement different card effects
		ready = true;
	}

	@Override
	public void exit() {
		System.out.println("===== COMBAT PHASE =====");
	}

	@Override
	public GameState nextState() {
		if (ready)
			throw new UnsupportedOperationException("Next state not implemented(Current: " + this.getClass().getName() + ")");

		// stay in current state
		return null;
	}
}
