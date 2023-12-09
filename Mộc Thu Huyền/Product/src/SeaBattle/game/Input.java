package SeaBattle.game;


import SeaBattle.board.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static Position readPosition(Scanner sc, Board board, String message) {
        try {
            System.out.print(message);
            String s = sc.nextLine().toLowerCase();
            char row = s.charAt(0);
            int column = Integer.parseInt(s.substring(1));
            Position.isInRange(row, column, board);
            return new Position(row, column - 1);
        } catch (PositionException | NumberFormatException | StringIndexOutOfBoundsException e) {
            Display.printError("Error, allowed values between A1 and " + Position.encode(board.getLength() - 1) + board.getLength());
            return readPosition(sc, board, message);
        }

    }

    public static Direction readDirection(Scanner sc, String message) {
        try {
            System.out.print(message);
            String s = sc.nextLine();
            return Direction.decode(s.charAt(0));
        } catch (DirectionException | StringIndexOutOfBoundsException e) {
            Display.printError("Error, allowed values for direction are 'h' or 'v'");
            return readDirection(sc, message);
        }
    }

    public static int readOption(Scanner sc, String message) {
        try {
            System.out.print(message);
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException | InputMismatchException e) {
            Display.printError("Error, please enter a number to continue ");
            return readOption(sc, message);
        }
    }

}
