package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.model.GameData;
import java.util.Scanner;


/**
 * Player picks a card to apply.
 * @author mellowboy
 */
public class PickPhase implements GameState {

	private GameData data;
	private Scanner scanner;

	public PickPhase(GameData data) {
		this.data = data;
		this.scanner = data.getScanner();
	}

	@Override
	public void enter() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not supported yet.");
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
