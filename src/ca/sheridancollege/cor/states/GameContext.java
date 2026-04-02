package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;

/**
 * Manages the current state.
 *
 * @author mellowboy
 */
public class GameContext {
    private GameState currentState;
    private boolean isRunning;

    public GameContext() {
    }

    public void resetState(GameData data) {
        data.setup();
        setState(new MenuState(data));
        isRunning = true;
    }

    public boolean isGameRunning() {
        return isRunning;
    }

    public void shouldExitGame() {
        isRunning = false;
    }

    public void setState(GameState state) {
        if (currentState != null)
            currentState.end();

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
        if (!isRunning)
            return; // if game should exit, return

        if (currentState != null) {
            currentState.update();
        }

        GameState next = currentState.nextState();
        if (next != null) {
            setState(next);
        }
    }
}
