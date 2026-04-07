package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.states.GameContext;
import ca.sheridancollege.cor.view.Console;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author mellowboy
 */
public class GameController {
	private final String title;
    private final GameContext context;
	private final GameData data;

	public GameController(String title) {
		this.title = title;
		context = new GameContext();
		data = new GameData(this, context);
	}
        //Get Method for context
        public GameContext getContext()
        {
            return context;
        }

	public final void setup() {
		context.resetState(data);
	}

	public void run() {
		Console.printTitleAwake(title.toUpperCase());
		Console.printlnAwake("     by Banjo-Kazoowi (Group 7)");
		setup();
		while (context.isGameRunning()) {
			try {
				context.update();
			} catch (Exception ex) {
				Console.printlnAwake("Game ran into a problem: " + ex.getMessage());
				Console.exit(this);
			}
		}
		InputController.pressEnterToContinue(data.getScanner(), "Press enter to exit...");
		data.closeScanner();
	}

	public void exit() {
		context.shouldExitGame();
	}
}
