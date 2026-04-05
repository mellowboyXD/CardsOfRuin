package ca.sheridancollege.cor.controller;

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
        System.out.print(message);
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
                System.out.print("Invalid input. Please enter numbers only. > ");
            } catch (NoSuchElementException ex) {
                throw new NoSuchElementException("No more input");
            }
        }
    }

    public static void clear(Scanner scanner) {
        scanner.nextLine();
    }
}
