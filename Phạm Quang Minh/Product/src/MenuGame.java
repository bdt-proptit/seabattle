import java.util.ArrayList;
import java.util.Scanner;

public class MenuGame {

    private void instruction(Scanner scanner, Player player, Player oppositePlayer) {
        System.out.println("\t\tINSTRUCTION");
        System.out.println(
                "The game board is a square matrix with rows labeled by numbers and columns labeled by letters.");
        System.out.println(
                "Use the keyboard to input the location of the ship and the location where you want to shoot.");
        System.out.println("If you sink all the ships, you will achieve victory.");
        System.out.println("1. Exit");
        int choice = Choice.enterChoice(1, scanner);
        menu(scanner, player, oppositePlayer);
    }

    public void menu(Scanner scanner, Player player, Player oppositePlayer) {
        ClearScreen.clearScreen();
        System.out.println(MakeColor.reset + MakeColor.backgoundRed + "\tSEA BATTLE" + MakeColor.reset + MakeColor.blue);
        System.out.println("1. Play");
        System.out.println("2. Instruction");
        System.out.println("3. Ranking");
        System.out.println("4. Exit");
        int choice = Choice.enterChoice(4, scanner);
        ClearScreen.clearScreen();
        switch (choice) {
            case 1:
                menuInformationPlayer(scanner, player, oppositePlayer);
                break;
            case 2:
                instruction(scanner, player, oppositePlayer);
                break;
            case 3:
                File file = new File();
                file.printRanking(player, oppositePlayer);
            case 4:
                return;
        }
    }

    public void enterInformation(Scanner scanner, int index, Player player, Player oppositePlayer) {
        ClearScreen.clearScreen();
        System.out.println("ENTER INFORMATION OF THE PLAYER " + index);
        System.out.print("Enter name player: ");
        String namePlayer = scanner.nextLine();
        Board board = new Board();
        char[][] boardTemple = board.createBoard();
        char[][] oppositeBoard = board.createBoard();
        ArrayList<Ship> ships = new ArrayList<>();
        player = new Player(index, namePlayer, 0, boardTemple, oppositeBoard, false, ships);
        enterTypeShip(scanner, player, oppositePlayer);
    }

    public void menuInformationPlayer(Scanner scanner, Player player, Player oppositePlayer) {
        ClearScreen.clearScreen();
        if (player.getIndex() == 2) {
            Player templePlayer = player;
            player = oppositePlayer;
            oppositePlayer = templePlayer;
        }
        do {
            System.out.println("\tENTER INFORMATION OF THE PLAYER");
            System.out.println("1. Player 1");
            System.out.println("2. Player 2");
            System.out.println("3. Play");
            System.out.println("4. Exit");
            int choice = Choice.enterChoice(4, scanner);
            switch (choice) {
                case 1:
                    enterInformation(scanner, 1, player, oppositePlayer);
                    break;
                case 2:
                    enterInformation(scanner, 2, oppositePlayer, player);
                    break;
                case 3:
                    if (!player.getCompleted()) {
                        System.out.println("You haven't finished entering player 1.");
                    }
                    if (!oppositePlayer.getCompleted()) {
                        System.out.println("You haven't finished entering player 2.");
                    }
                    if (player.getCompleted() && oppositePlayer.getCompleted()) {
                        Play play = new Play();
                        play.menuInGame(scanner, player, oppositePlayer);
                    }
                    break;
                case 4:
                    menu(scanner, player, oppositePlayer);
                    return;
            }
        } while (true);
    }

    public void enterTypeShip(Scanner scanner, Player player, Player oppositPlayer) {
        ClearScreen.clearScreen();
        System.out.println("\tENTER TYPE SHIP");
        System.out.println("1. Automatic ship entry");
        System.out.println("2. Custom ship entry");
        System.out.println("3. Exit");
        int choice = Choice.enterChoice(3, scanner);
        GameShip gameShip = new GameShip();
        switch (choice) {
            case 1:
                gameShip.automaticShip(scanner, player, oppositPlayer);
                break;
            case 2:
                gameShip.customShip(scanner, player, oppositPlayer);
                break;
            case 3:
                menu(scanner, player, oppositPlayer);
                break;
        }

    }
}
