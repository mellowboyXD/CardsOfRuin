package ca.sheridancollege.cor.view;

/**
 * This interface provides a contract for implementing a sleeping functionality.
 * This is a more robust approach as sleep can then be easily tested.
 */
public interface Sleeper {
    void sleep(long ms);
}
