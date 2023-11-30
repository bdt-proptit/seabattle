package Product;
import java.util.*;
public class Player {
    private String name;
    private Board board;
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Player(String name, int rows, int cols) {
        this.name = name;
        this.board = new Board(rows, cols);
    }

    // Getter
    public String getName() {return name;}
    public Board getBoard() {return board;}


    public void startGame() {
        System.out.println(name + ", it's your turn to place ships.");
        placeShips();
    }

    private void placeShips() {

        for (ShipType shipType : ShipType.values()) {
            System.out.println("Placing " + shipType.name());
            int size = shipType.getSize();

            for (int i = 1; i <= size; i++) {
                displayBoard();

                System.out.println("Enter the starting coordinates: ");
                Pos startPos = getInputCoordinates(scanner);

                System.out.println("Enter the ending coordinates: ");
                Pos endPos = getInputCoordinates(scanner);

                if (validateAndPlaceShip(shipType, startPos, endPos)) {
                    System.out.println(shipType.name() + " placed successfully!");
                    i--;
                } else {
                    System.out.println("Invalid placement. Try again.");
                }
            }
        }

        displayBoard();

        System.out.println("Press Enter to continue to the next player...");
        scanner.nextLine(); 
    }

    private void displayBoard() {
        
        Cell[][] grid = board.getGrid();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                System.out.print(grid[i][j].getState().ordinal() + " ");
            }
            System.out.println();
        }
    }

    
}
}

