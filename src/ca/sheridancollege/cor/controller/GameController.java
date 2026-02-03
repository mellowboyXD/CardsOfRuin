package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.states.GameContext;
import ca.sheridancollege.cor.states.MenuState;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author mellowboy
 */
public class GameController {
	private final String title;
	private GameData data;
	private GameContext context;

	public GameController(String title) {
		this.title = title;
		setup();
	}

	public final void setup() {
		data = new GameData();
		context = new GameContext();
		context.setState(new MenuState(data));
	}

	public String getTitle() {
		return title;
	}

	public void run() {
		while(true) {
			context.update();
		}
	}
}
