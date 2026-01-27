package ca.sheridancollege.cor.states;

/**
 *
 * @author mellowboy
 */
public interface GameState {
	void enter(); // setup for this
	void update(); 
	void exit();
	GameState nextState(); // returns the next state or null (stay)
}
