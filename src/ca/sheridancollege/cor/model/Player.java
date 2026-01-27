package ca.sheridancollege.cor.model;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant
 * @author Prem Parashar
 * @author mellowboy
 */
public class Player {

    private String id; //the unique id for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param id the unique ID to assign to this player.
     */
    public Player(String id) {
        this.id = id;
    }

    /**
     * @return the player id
     */
    public String getId() {
        return id;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param id the player id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
