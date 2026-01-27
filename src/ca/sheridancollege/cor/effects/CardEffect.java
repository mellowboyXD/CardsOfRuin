package ca.sheridancollege.cor.effects;

import ca.sheridancollege.cor.model.Monster;
import ca.sheridancollege.cor.model.Player;

/**
 *
 * @author mellowboy
 */
public interface CardEffect {
	void apply(Player player, Monster monster);
}
