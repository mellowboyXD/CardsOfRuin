package ca.sheridancollege.cor;

import ca.sheridancollege.cor.controller.GameController;

/**
 * Main entry point of the game.
 * @author mellowboy
 */
public class Main {
	public static void main(String[] args) {
		GameController gameController = new GameController("Cards Of Ruins");

		// Run the game
		gameController.run();
	}
}
