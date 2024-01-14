import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameShip {
    private int lengthShip(int index) {
        switch (index) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 3;
        }
        return 5;
    }

    public void automaticShip(Scanner scanner, Player player, Player oppositPlayer) {
        int[] length = { 1, 1, 3, 2, 4 };
        for (int i = 0; i <= 4; i++) {
            createAutomaticShip(length[i], player);
            Board board = new Board();
            board.displayBoardShip(player.getBoard());
        }
        player.setCompleted(!player.getCompleted());
        MenuGame menuGame = new MenuGame();
        menuGame.menuInformationPlayer(scanner, player, oppositPlayer);
    }

    private void createAutomaticShip(int length, Player player) {
        Random random = new Random();
        do {
            int rowStart = random.nextInt(10) + 1;
            int columnStart = random.nextInt(10) + 1;
            int rowEnd = rowStart, columnEnd = columnStart;
            int choice = random.nextInt(4) + 1;
            switch (choice) {
                case 1:
                    columnEnd = columnStart - length;
                    break;
                case 2:
                    rowEnd = rowStart - length;
                    break;
                case 3:
                    columnEnd = columnStart + length;
                    break;
                case 4:
                    rowEnd = rowStart + length;
                    break;
            }
            if (columnEnd < 1 || rowEnd < 1)
                continue;
            Ship ship = new Ship(rowStart, columnStart, rowEnd, columnEnd, length + 1, true);
            if (checkValidShip(player, ship)) {
                return;
            }
        } while (true);
    }

    public void customShip(Scanner scanner, Player player, Player oppositePlayer) {
        int count[] = { 0, 2, 1, 1, 1 };
        int quantity = 0;
        do {
            ClearScreen.clearScreen();
            System.out.println("Enter the location of the ship for player: " + player.getName());
            Board board = new Board();
            board.displayBoardShip(player.getBoard());
            System.out.println("\n1. Enter location Patrol Boat(1 x 2).");
            System.out.println("2. Enter location Destroyer Boat(1 x 4).");
            System.out.println("3. Enter location Submarine(1 x 3).");
            System.out.println("4. Enter location Battle Ship(1 x 5).");
            System.out.println("5. Exit");
            int choice = Choice.enterChoice(5, scanner);
            if (choice == 5) {
                if (quantity < 5) {
                    System.out.println("You have not entered a sufficient quantity of ship.");
                    continue;
                }
                System.out.println("You have entered a sufficient quantity of ship.");
                player.setCompleted(!player.getCompleted());
                ClearScreen.clearScreen();
                MenuGame menuGame = new MenuGame();
                menuGame.menuInformationPlayer(scanner, player, oppositePlayer);
            }
            if (count[choice] == 0) {
                System.out.println("You have entered a sufficient quantity of this type of ship.");
                continue;
            }
            Ship ship = new Ship();
            String nameShip = ship.nameShip(choice);
            System.out.println(choice + ". Enter location " + nameShip + "(1 x " + lengthShip(choice) + ").");
            if (createCustomShip(scanner, choice, player)) {
                quantity++;
                count[choice]--;
            }
        } while (true);
    }

    public boolean createCustomShip(Scanner scanner, int index, Player player) {
        System.out.println("Enter starting location:");
        System.out.print("Enter row: ");
        int rowStart = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter column: ");
        int columnStart = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter ending location:");
        System.out.print("Enter row: ");
        int rowEnd = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter column: ");
        int columnEnd = Integer.parseInt(scanner.nextLine());
        int length = lengthShip(index);
        Ship ship = new Ship(rowStart, columnStart, rowEnd, columnEnd, length, true);
        return checkValidShip(player, ship);
    }

    public boolean checkValidShip(Player player, Ship ship) {
        if (!ship.checkLocation(player.getBoard())) {
            return false;
        }
        ArrayList<Ship> ships = player.getShips();
        ships.add(ship);
        player.setShips(ships);
        Board board = new Board();
        board.updateBoardShip(ship, player);
        return true;
    }

    public void updateShip(Player player, Player oppositePlayer) {
        ArrayList<Ship> ships = oppositePlayer.getShips();
        for (var ship : ships) {
            if (ship.getCheckStatus(oppositePlayer.getBoard())) {
                ship.setStatus(false);
            }
        }
        oppositePlayer.setShips(ships);
    }
}
