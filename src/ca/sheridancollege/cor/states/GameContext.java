package ca.sheridancollege.cor.states;

/**
 * Manages the current state.
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

	/**
	 * @return the current state 
	 */
	public GameState getState() {
		return currentState;
	}

	/** 
	 * Updates the current state if it is not null and proceeds to next state
	 */
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
