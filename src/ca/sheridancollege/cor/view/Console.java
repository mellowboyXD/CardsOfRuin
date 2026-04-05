package ca.sheridancollege.cor.view;

import ca.sheridancollege.cor.controller.GameController;

import java.util.List;

public class Console implements Sleeper {
    public static final long SLEEP_TIME_MS = 1000; // 1 second

    // using singleton pattern to have only one active instance of this class
    private static Console instance = new Console();

    protected static void setInstance(Console console) {
        instance = console;
    }

    /**
     * Prints a decorative label without sleeping.
     * @param labelMessage - the label to display
     */
    public static void printLabelAwake(String labelMessage) {
        System.out.printf("%n===== %s =====%n", labelMessage);
    }

    /**
     * Prints the title without sleeping.
     * @param title - the title of the game
     */
    public static void printTitleAwake(String title) {
        System.out.printf("%n----- %s -----%n", title);
    }

    /**
     * Prints the message and puts the current thread to sleep for SLEEP_TIME_MS milliseconds.
     * This method does not add a new line at the end.
     * @param message - the message to display to player
     */
    public static void print(String message) {
        System.out.print(message);
        doSleep();
    }

    /**
     * Prints the message without sleeping.
     * @param message - the message to display to the player
     */
    public static void printlnAwake(String message) {
        System.out.println(message);
    }

    /**
     * Prints a list of menu-like options to the screen and sleep for SLEEP_TIME_MS milliseconds.
     * Please note that options should override toString() to print information that is wanted.
     * @param options - the list of options
     * @param <T> - the type that is passed to this function
     */
    public static <T> void printOptions(List<T> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, options.get(i));
        }
        doSleep();
    }

    /**
     * Prints the message and puts the current thread to sleep for SLEEP_TIME_MS milliseconds.
     * This method adds a newline at the end.
     * @param message - the message to display to player
     */
    public static void println(String message) {
        System.out.println(message);
        doSleep();
    }

    /**
     * Puts the current thread to sleep for SLEEP_TIME_MS milliseconds.
     */
    protected static void doSleep() {
        instance.sleep(Console.SLEEP_TIME_MS);
    }

    /**
     * Prints a message without sleeping
     * @param message - the message to display
     */
    public static void printAwake(String message) {
        System.out.print(message);
    }

    @Override
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep was interrupted");
        }
    }

    public static void exit(GameController controller) {
        controller.exit();
    }
}
