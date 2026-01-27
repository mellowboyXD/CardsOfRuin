package ca.sheridancollege.cor.model.states;

/**
 *
 * @author mellowboy
 */
public class GameContext {
	private GameState currentState;

	public void setState(GameState state) {
		if (currentState != null)
			currentState.exit();
		
		currentState = state;
		currentState.enter();
	}

	public GameState getState() {
		return currentState;
	}

	public void update() {
		if (currentState != null) {
			currentState.update();
		}

		GameState next = currentState.nextState();
		if (next != null) {
			setState(next);
		}
	}
}
