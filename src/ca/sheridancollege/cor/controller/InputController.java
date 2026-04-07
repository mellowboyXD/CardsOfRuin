package ca.sheridancollege.cor.controller;

import ca.sheridancollege.cor.view.Console;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author mellowboy
 */
public class InputController {
    public static void pressEnterToContinue(Scanner scanner, String message) {
        Console.printAwake(message);
        scanner.nextLine();
    }

    public static void pressEnterToContinue(Scanner scanner) {
        pressEnterToContinue(scanner, "Press enter to continue...");
    }

    public static int readInt(Scanner scanner) throws NoSuchElementException {
        while (true) {
            try {
                int num = scanner.nextInt();
                /* Scanner.nextInt() or Scanner.next() often leaves trailing `/n`
                    behind leading to unwanted behaviors where `/n` is an expected input */
                scanner.nextLine();
                return num;
            } catch (InputMismatchException ex) {
                Console.printAwake("Invalid input. Please enter numbers only. > ");
                scanner.nextLine(); // reset scanner so that it can accept new input
            } catch (NoSuchElementException ex) {
                throw new NoSuchElementException("No more input");
            }
        }
    }
}
