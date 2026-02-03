package ca.sheridancollege.cor.model;

/**
 *
 * @author mellowboy
 */
public class Hand extends Deck {
	public Hand(int size) {
		super(size);
	}

	@Override
	public Card draw() {
		return super.getCards().remove(super.getRandomIndex());
	}
}
