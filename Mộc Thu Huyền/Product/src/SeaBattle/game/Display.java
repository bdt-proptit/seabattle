package SeaBattle.game;

import SeaBattle.board.ShipType;
import SeaBattle.board.Ship;
import SeaBattle.board.*;
import java.util.Scanner;

public class Display {

    public static void printTitle() {
        System.out.println(Colors.ANSI_RED + "WELLCOME TO SEABATTLE\n" + Colors.ANSI_RESET);
    }

    public static int printMenu() {
        printTitle();
        System.out.println(Colors.ANSI_GREEN + "|-----------------------------------|");
        System.out.println("|            Menu game              |");
        System.out.println("|1. Start a new game with friend    |");
        System.out.println("|2. Start a new game with AI        |");
        System.out.println("|3. Rule and legend                 |");
        System.out.println("|0. Exit                            |");
        System.out.println("|-----------------------------------|");
        return Input.readOption(new Scanner(System.in), "Your option is: " + Colors.ANSI_RESET);
    }

    public static void printRuleAndLegend() {
        System.out.println(Colors.ANSI_YELLOW + "How to win:\n" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_WHITE + "- Each player has a battlefield represented by a 10x10 grid (default) on which they place \"" + ShipType.sizeAllShips() + " ships, hidden from his adversary.\n" + "- The goal of the game is to sink all the enemy ships! A ship is sunk when it is hit once for each space it occupies.\n" + "- The " + ShipType.sizeAllShips() + " Ships occupy " + ShipType.lengthAllShips() + " total spaces, so the first player to register 16 hits wins! " + Colors.ANSI_RESET);

        System.out.println(Colors.ANSI_YELLOW + "\nGameplay:" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_WHITE + "- To play, follow the instructions to set up your " + ShipType.sizeAllShips() + " Ships in any scheme you want (no diagonal or adjacent placements to other ships are allowed).\n" + "- To place a ship you need to enter a starting coordinate (A1-J10 for the default 10x10 card) and a direction (vertical or horizontal).\n" + "- For example: A1 or B7. Ships may not overlap or adjoin (attached) and you must stay within the bounds of the edge.\n" + "- Once both players have set up their ships, the battle can begin!\n" + "- Launch torpedoes at your opponent's ships by guessing the coordinates.\n" + "- The rows are represented by the letters A-J and the columns with the numbers 1-10 (10x10 plate).\n" + "- Valid coordinates include a row followed by a column, e.g., A1, B7, J10, etc.\n" + "- You will be informed if you have hit or missed a ship.\n" + "- Sink all 5 computer ships to win!" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "Legend:\n" + Colors.ANSI_RESET);

        System.out.println("- ( " + Colors.ANSI_BLUE + Board.WATER + Colors.ANSI_WHITE + " )\t: Water\n" + "- (" + Colors.ANSI_YELLOW + Board.SHIP + Colors.ANSI_WHITE + ")\t: Ship\n" + "- (" + Colors.ANSI_RED + Board.HIT + Colors.ANSI_WHITE + ")\t: Ship Hit\n" + "- (" + Colors.ANSI_WHITE + Board.MISS + Colors.ANSI_WHITE + ")\t: Missed Shot\n");

        System.out.print("\nPress a button to continue...");
        new Scanner(System.in).nextLine();
    }

    public static void printCredits() {
        System.out.println("\nThanks for playing!");
        System.out.println("\nCreated by MocThuHuyen");
    }

    public static void printError(String message) {
        System.out.println(Colors.ANSI_RED + message + Colors.ANSI_RESET);
    }

    public static void printShot(Player player, Position position, boolean isHit) {
        System.out.println("- " + player.getName() + " He shot in " + position.toStringEncode(position) + ": " + (isHit ? Colors.ANSI_BLUE + "Hitted!" + Colors.ANSI_RESET : Colors.ANSI_RED + "Missed!" + Colors.ANSI_RESET));
    }

    public static void printWinner(Player player) {
        System.out.println(Colors.ANSI_BLUE + "\n " + player.getName() + " Won!" + Colors.ANSI_RESET + "\n");
        System.out.print("\nPress a button to continue...");
        new Scanner(System.in).nextLine();
    }

    public static void printCurrentShip(Ship ship, int numShipLeft) {
        System.out.println(ship.getName() + " (" + Colors.ANSI_YELLOW + ship.toGraphicLength() + Colors.ANSI_RESET + ") x" + numShipLeft);
    }

    public static void printAdjacentBoard(Player pOne, Player pTwo) throws PositionException {
        System.out.println(toStringAdjacentBoard(pOne, pTwo));
    }

    public static String toStringAdjacentBoard(Player pOne, Player pTwo) throws PositionException {
        Board firstBoard = pOne.getBoard();
        Board secondBoard = pTwo.getBoard().getBoardHideShips();
        String numbers = "⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑";
        String letters = "ͣᵇͨͩͤᶠᶢͪͥʲ";
        String s = "\n――――――――――――――――――――――――――――――――――\n";
        s += "\n     ";

        for (int i = 0; i < firstBoard.getLength(); i++) s += " " + numbers.charAt(i) + "    ";
        s += "          ";
        for (int i = 0; i < secondBoard.getLength(); i++) s += " " + numbers.charAt(i) + "    ";


        s += "\n";
        for (int i = 0; i < firstBoard.getLength(); i++) {
            s += Colors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";
            s += Colors.ANSI_RESET;

            for (int j = 0; j < firstBoard.getLength(); j++) {
                if (firstBoard.getBoard()[i][j] == Board.WATER)
                    s += Colors.ANSI_BLUE + " " + Board.WATER + " " + " " + Colors.ANSI_RESET;
                else if (firstBoard.getBoard()[i][j] == Board.HIT)
                    s += Colors.ANSI_RED + Board.HIT + " " + Colors.ANSI_RESET;
                else if (firstBoard.getBoard()[i][j] == Board.MISS) s += Board.MISS + " " + Colors.ANSI_RESET;
                else s += Colors.ANSI_YELLOW + firstBoard.getBoard()[i][j] + " " + Colors.ANSI_RESET;
            }

            s += "   ";

            s += Colors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";
            s += Colors.ANSI_RESET;

            for (int j = 0; j < secondBoard.getLength(); j++) {
                if (secondBoard.getBoard()[i][j] == Board.WATER)
                    s += Colors.ANSI_BLUE + " " + Board.WATER + " " + " " + Colors.ANSI_RESET;
                else if (secondBoard.getBoard()[i][j] == Board.HIT)
                    s += Colors.ANSI_RED + Board.HIT + " " + Colors.ANSI_RESET;
                else if (secondBoard.getBoard()[i][j] == Board.MISS) s += Board.MISS + " " + Colors.ANSI_RESET;
                else s += Colors.ANSI_YELLOW + secondBoard.getBoard()[i][j] + " " + Colors.ANSI_RESET;
            }

            s += "\n";
        }
        s += "\n――――――――――――――――――――――――――――――――――\n";
        return s;
    }

    public static void printBoard(Board board) {
        System.out.println(toStringBoard(board));
    }

    public static String toStringBoard(Board board) {
        String numbers = "⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑";
        String letters = "ͣᵇͨͩͤᶠᶢͪͥʲ";
        String s = "\n     ";
        for (int i = 0; i < board.getLength(); i++) s += " " + numbers.charAt(i) + "    ";
        s += "\n";
        for (int i = 0; i < board.getLength(); i++) {
            s += Colors.ANSI_WHITE;
            if (i == 5) s += " " + letters.charAt(i) + "    "; //f
            else if (i == 6) s += letters.charAt(i) + "    "; //g
            else s += letters.charAt(i) + "  ";

            for (int j = 0; j < board.getLength(); j++) {
                if (board.getBoard()[i][j] == Board.WATER)
                    s += Colors.ANSI_BLUE + " " + Board.WATER + " " + " " + Colors.ANSI_RESET;
                else if (board.getBoard()[i][j] == Board.HIT)
                    s += Colors.ANSI_RED + Board.HIT + " " + Colors.ANSI_RESET;
                else if (board.getBoard()[i][j] == Board.MISS)
                    s += Colors.ANSI_WHITE + Board.MISS + " " + Colors.ANSI_RESET;
                else s += Colors.ANSI_YELLOW + board.getBoard()[i][j] + " " + Colors.ANSI_RESET;
            }
            s += "\n";
        }
        return s;
    }
}
