import java.util.Scanner;

public class Play {
    private void printBetween(String name) {
        int space = (113 - name.length()) / 2;
        System.out.print(String.format("%" + space + "s", ""));
        System.out.print(MakeColor.reset + MakeColor.backgoundRed + String.format("%" + name.length() + "s", name)
                + MakeColor.reset
                + MakeColor.blue);
        System.out.println();
    }

    private void printInformation(Player player, Player oppositePlayer) {
        Board board = new Board();
        printBetween("Round: " + player.getName());
        printNamePlayer(player, oppositePlayer);
        board.displayBoardGame(player.getBoard(), player.getOppositeBoard());
        System.out.println("The number of shot on the enemy: " + player.getNumberShot());
        System.out.println("The number of ships destroyed: " + oppositePlayer.destroyedShips());
        System.out.println("The remaining number of ships: " + player.remainNumberShips());
    }

    private boolean shotOut(Scanner scanner, Player player, Player oppositePlayer, boolean swap) {
        printInformation(player, oppositePlayer);
        System.out.println("ENTER THE LOCATION YOU WANT TO SHOT");
        System.out.print("Enter row: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter column: ");
        int column = Integer.parseInt(scanner.nextLine());
        Shot shot = new Shot(row, column);
        GameShot gameShot = new GameShot();
        return gameShot.checkShipShot(player, oppositePlayer, shot, swap);
    }

    public void menuInGame(Scanner scanner, Player player, Player oppositePlayer) {
        if (!player.getCompleted() || !oppositePlayer.getCompleted()) {
            System.out.println("You haven't finished entering player.");
            MenuGame menuGame = new MenuGame();
            menuGame.menuInformationPlayer(scanner, player, oppositePlayer);
            return;
        }

        boolean swap = true;
        do {
            ClearScreen.clearScreen();
            if (player.remainNumberShips() == 0 || oppositePlayer.remainNumberShips() == 0) {
                if (player.remainNumberShips() == 0) {
                    winner(oppositePlayer, player);
                } else
                    winner(player, oppositePlayer);
                return;
            }
            if (swap) {
                swap = shotOut(scanner, player, oppositePlayer, swap);
            } else {
                swap = shotOut(scanner, oppositePlayer, player, swap);
            }
        } while (true);
    }

    private void printName(Player player, boolean choice) {
        String namePlayer = "Board: " + player.getName();
        int space = (44 - namePlayer.length()) / 2;
        System.out.print(String.format("%" + space + "s", ""));
        System.out.print(MakeColor.reset + MakeColor.backgoundRed
                + String.format("%" + namePlayer.length() + "s", namePlayer) + MakeColor.reset
                + MakeColor.blue);
        if (choice) {
            System.out.print(String.format("%" + (space + 25) + "s", ""));
        } else
            System.out.println();
    }

    public void printNamePlayer(Player player, Player oppositePlayer) {
        printName(player, true);
        printName(oppositePlayer, false);
    }

    private void winner(Player player, Player oppositePlayer) {
        printBetween("WINNER: " + player.getName());
        printNamePlayer(player, oppositePlayer);
        Board board = new Board();
        board.displayBoardGame(player.getBoard(), oppositePlayer.getBoard());
        File file = new File();
        file.addPlayer(player);
    }
}
