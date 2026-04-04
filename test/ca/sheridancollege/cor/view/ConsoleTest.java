package ca.sheridancollege.cor.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class tests the Console view class which is responsible for outputting to the player
 */
public class ConsoleTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutputStream = System.out;
    private TestConsole testConsole;

    private static class TestConsole extends Console {
        public long sleptMs = 0;

        @Override
        public void sleep(long ms) {
           sleptMs = ms;
        }
    }

    /**
     * Sets the output stream to a variable that can therefore be tested.
     *
     * @throws Exception - in case of an I/O error or OS error
     */
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
        testConsole = new TestConsole();
        Console.setInstance(testConsole);
    }

    @After
    public void resetOutputStream() {
        Console.setInstance(new Console());
        System.setOut(originalOutputStream);
    }

    /**
     * Testing the printLabelAwake method.
     * printLabelAwake prints in the format `===== TESTS =====`
     * The method being tested here should not put the thread to sleep.
     */
    @Test
    public void testPrintLabelAwake() {
        var label = "TESTS";
        TestConsole.printLabelAwake(label);
        var expected = "%n===== %s =====%n".formatted(label);
        assertEquals(expected, outputStream.toString());
        assertEquals(0, testConsole.sleptMs);
    }

    /**
     * Testing printTitleAwake method.
     * printTitleAwake prints in the format `----- Tests -----`
     * The method should not put the thread to sleep.
     */
    @Test
    public void testPrintTitleAwake() {
        var title = "Tests";
        TestConsole.printTitleAwake(title);
        var expected = "%n----- %s -----%n".formatted(title);
        assertEquals(expected, outputStream.toString());
        assertEquals(0, testConsole.sleptMs);
    }

    /**
     * This method should put the thread to sleep right after printing.
     */
    @Test
    public void testPrint() {
        var str = "hello world";
        TestConsole.print(str);
        assertEquals(str, outputStream.toString());
        assertEquals(Console.SLEEP_TIME_MS, testConsole.sleptMs);
    }

    /**
     * Should print with newline without sleeping
     */
    @Test
    public void testPrintlnAwake() {
        var str = "hello world on new lines";
        TestConsole.printlnAwake(str);
        assertEquals(str + System.lineSeparator(), outputStream.toString());
        assertEquals(0, testConsole.sleptMs);
    }

    /**
     * Prints a list of options in a nice format and then sleeps
     */
    @Test
    public void testPrintOptions() {
        var opts = List.of("Heart", "Diamond", "Club", "Spade");
        TestConsole.printOptions(opts);
        var expected = "1 - Heart%n2 - Diamond%n3 - Club%n4 - Spade%n".formatted();
        assertEquals(expected, outputStream.toString());
        assertEquals(Console.SLEEP_TIME_MS, testConsole.sleptMs);
    }

    /**
     * Test if the method prints the message and puts the current thread to sleep for 1 second.
     */
    @Test
    public void testPrintln() {
        var str = "hello world. this is a test";
        TestConsole.println(str);
        assertEquals(str + System.lineSeparator(), outputStream.toString());
        assertEquals(Console.SLEEP_TIME_MS, testConsole.sleptMs);
    }
}