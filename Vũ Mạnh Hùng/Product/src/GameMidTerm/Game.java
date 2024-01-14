package GameMidTerm;
import java.util.*;

//Game.java
public class Game {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        Player currentPlayer = player1;
        Player opponent = player2;

        while (true) {
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            currentPlayer.displayBoard();
            currentPlayer.displayOppBoard(opponent);

            currentPlayer.shoot(opponent);

            if (opponent.getBoard().allShipsSunk()) {
                System.out.println(currentPlayer.getName() + " wins!");
                currentPlayer.displayBoard();
                opponent.displayBoard();
                break;
            }
            //Next turn
            Player tmp = currentPlayer;currentPlayer = opponent;opponent = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create players
        Player player1 = new Player("Player 1", 10, 10);
        Player player2 = new Player("Player 2", 10, 10);
        // Create the game
        Game game = new Game(player1, player2);

        // Allow players to place ships
        game.placeShips(player1);
        System.out.println("Press Enter to continue to the next player...");
        scanner.nextLine();
        player1.clearScreen();
        game.placeShips(player2);
        System.out.println("Press Enter to start playing...");
        scanner.nextLine();
        player2.clearScreen();
        // Start the game
        game.startGame();
    }

    private void placeShips(Player player) {
        player.startGame();
    }
}
//A1
//A2
//B1
//B2
//C1
//C4
//D1
//D3
//E1
//E5

//F6
//F7
//G6
//G7
//H6
//H9
//I6
//I8
//J6
//J10