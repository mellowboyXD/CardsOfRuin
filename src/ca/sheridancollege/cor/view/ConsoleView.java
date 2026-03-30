package ca.sheridancollege.cor.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mellowboy
 */
public class ConsoleView {
    public static void pressEnterToContinue(Scanner scanner) {
        System.out.print("Press enter to continue...");
        scanner.nextLine();
    }

    public static int readInt(Scanner scanner) throws InputMismatchException {
        while (true) {
            try {
                int num = scanner.nextInt();
                /* Scanner.nextInt() or Scanner.next() often leaves trailing `/n`
                    behind leading to unwanted behaviors where `/n` is an expected input */
                scanner.nextLine();
                return num;
            } catch (InputMismatchException ex) {
                System.out.print("Invalid input. Please enter numbers only. > ");
                scanner.nextLine();
            }
        }
    }

    public static void clear(Scanner scanner) {
        scanner.nextLine();
    }
}
