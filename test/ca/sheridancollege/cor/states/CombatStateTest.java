package ca.sheridancollege.cor.states;

import ca.sheridancollege.cor.controller.GameController;
import ca.sheridancollege.cor.model.GameData;
import ca.sheridancollege.cor.model.Monster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatStateTest {

    private final GameController mockController = new GameController("Testing Combat State");
    private GameData data;
    private CombatState instance;

    @Before
    public void setUp() throws Exception {
        data = new GameData(mockController, mockController.getContext());
        data.setup();
        instance = new CombatState(data);
    }

    /**
     * Player should not take any damage while monster should be dead.
     */
    @Test
    public void testEnterPlayerShouldTakeNoDamage() {
        var initialPlayerShield = data.getPlayer().getShield();
        var initialPlayerHealth = data.getPlayer().getHealth();

        data.setMonster(new Monster.Builder()
                .health(10)
                .attack(10000)
                .shield(10)
                .build());
        instance = new CombatState(data);

        instance.enter();

        var monster = data.getMonster();
        var player = data.getPlayer();

        assertEquals(initialPlayerShield, player.getShield());
        assertEquals(initialPlayerHealth, player.getHealth());
        assertEquals(0, monster.getHealth());
        assertEquals(0, monster.getShield());
    }

    /**
     * Player should take some damage while monster should not be dead.
     */
    @Test
    public void testEnterPlayerShouldTakeSomeDamage() {
        var initialPlayerShield = data.getPlayer().getShield();
        var initialPlayerHealth = data.getPlayer().getHealth();

        data.setMonster(new Monster.Builder()
                .health(10000)
                .attack(10)
                .shield(10)
                .build());
        instance = new CombatState(data);

        instance.enter();

        var monster = data.getMonster();
        var player = data.getPlayer();

        assertEquals(initialPlayerShield - 10, player.getShield());
        assertEquals(initialPlayerHealth, player.getHealth());
        assert(monster.getHealth() < 1000);
        assertEquals(0, monster.getShield());
    }
}