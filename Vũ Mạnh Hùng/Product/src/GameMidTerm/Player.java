package GameMidTerm;
import java.util.*;
//Player.java
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
        scanner.nextLine();
        clearScreen();
        placeShips();
    }
    private void placeShips() {
    	for (ShipType shipType : ShipType.values()) {
            if (!shipType.getIsPlaced()) {
                int size = shipType.getSize();
                clearScreen();
                displayBoard();

                Pos startPos, endPos;
                boolean validPlacement;

                do {
                    System.out.println("Placing " + shipType.name());
                    System.out.print("Enter the starting coordinates: ");
                    startPos = getInputCoord(scanner);

                    System.out.print("Enter the ending coordinates: ");
                    endPos = getInputCoord(scanner);

                    validPlacement = isValidShipPlacement(shipType, startPos, endPos);

                    if (!validPlacement) {
                        System.out.println("Invalid placement! Please try again.");
                    }

                } while (!validPlacement);

                placeShip(shipType, startPos, endPos);

                System.out.println("\n" + shipType.name() + " placed successfully!");
                shipType.place();
            }
        }
        for (ShipType shipType : ShipType.values()) shipType.unplace();
        displayBoard();
        
    }

    private boolean isValidShipPlacement(ShipType shipType, Pos startPos, Pos endPos) {
        int size = shipType.getSize();
        int startRow = startPos.getX();
        int startCol = startPos.getY();
        int endRow = endPos.getX();
        int endCol = endPos.getY();

        if ((startRow == endRow && Math.abs(startCol - endCol) + 1 == size) ||
            (startCol == endCol && Math.abs(startRow - endRow) + 1 == size)) {
            for (int i = Math.min(startRow, endRow); i <= Math.max(startRow, endRow); i++) {
                for (int j = Math.min(startCol, endCol); j <= Math.max(startCol, endCol); j++) {
                    if (board.getGrid()[i][j].getState() == State.OCCUPIED) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void clearScreen() {
    	for (int clr = 1; clr <= 100; clr++)
    		System.out.print("\n");
    }
    private void placeShip(ShipType shipType, Pos startPos, Pos endPos) {
        int startRow = startPos.getX();
        int startCol = startPos.getY();
        int endRow = endPos.getX();
        int endCol = endPos.getY();

        if (startRow == endRow) {
            // Horizontal placement
            for (int col = Math.min(startCol, endCol); col <= Math.max(startCol, endCol); col++) {
                board.getGrid()[startRow][col].setState(State.OCCUPIED);
                board.getGrid()[startRow][col].setShip(new Ship(shipType));
            }
        } else if (startCol == endCol) {
            // Vertical placement
            for (int row = Math.min(startRow, endRow); row <= Math.max(startRow, endRow); row++) {
                board.getGrid()[row][startCol].setState(State.OCCUPIED);
                board.getGrid()[row][startCol].setShip(new Ship(shipType));
            }
        }
    }
    private Pos getInputCoord(Scanner scanner) {
        String input = scanner.nextLine().toUpperCase();
        char column = input.charAt(0);
        int row = Integer.parseInt(input.substring(1)) - 1;  // Convert to 0-based index
        return new Pos(row, column - 'A');
    }
    public void displayBoard() {
        System.out.println("----------------" + name + " Board--------------");
        System.out.println("____________________________________________");

        System.out.print("|  | ");
        for (int col = 0; col < board.getCols(); col++) {
        	char column = (char) (col + 'A');
            System.out.print(column + " | ");
        }
        System.out.println();

        for (int row = 0; row < board.getRows(); row++) {
        	if (row == 9) System.out.print("|" + (row+1) + "|");
        	else System.out.print("| " + (row+1) + "|");
            for (int col = 0; col < board.getCols(); col++) {
                Cell cell = board.getGrid()[row][col];
                switch (cell.getState()) {
	                case EMPTY:
	                    System.out.print(" . |");
	                    break;
	                case OCCUPIED:
	                	System.out.print(" V |"); // Thuyền chưa bị bắn trúng
	                    break;
	                case HIT:
	                	System.out.print(" # |"); // Thuyền bị bắn trúng
	                	break;
	                case MISS:
	                    System.out.print(" m |");
	                    break;
                    default:
                        break;
                }
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------");
    }

    public void displayOppBoard(Player opponent) {
        System.out.println("-----------" + name + "'s Opponent Board--------");
        System.out.println("____________________________________________");

        System.out.print("|  | ");
        for (int col = 0; col < opponent.getBoard().getCols(); col++) {
            char column = (char) (col + 'A');
            System.out.print(column + " | ");
        }
        System.out.println();

        for (int row = 0; row < opponent.getBoard().getRows(); row++) {
            if (row == 9) System.out.print("|" + (row+1) + "|");
            else System.out.print("| " + (row+1) + "|");
            for (int col = 0; col < opponent.getBoard().getCols(); col++) {
                Cell cell = opponent.getBoard().getGrid()[row][col];
                switch (cell.getState()) {
                    case HIT:
                        System.out.print(" # |");
                        break;
                    case MISS:
                        System.out.print(" m |");
                        break;
                    default:
                        System.out.print(" . |");
                        break;
                }
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------");
    }

    public void shoot(Player opponent) {
        System.out.println("Enter coordinates to shoot: ");
        Pos shotPos = getInputCoord(scanner);

        int row = shotPos.getX();
        int col = shotPos.getY();

        Cell targetCell = opponent.getBoard().getGrid()[row][col];
        Ship targetShip = targetCell.getShip();

        if (targetCell.getState() == State.EMPTY) {
            System.out.println("Miss!");
            targetCell.setState(State.MISS);
        } 
        else if (targetCell.getState() == State.OCCUPIED) {
            System.out.println("Hit!");
            targetCell.setState(State.HIT);
            targetShip.hit();

            if (targetShip.isSunk()) {
                System.out.println("You sunk the opponent's " + targetShip.getType().name() + "!");
                opponent.getBoard().updateHitCount(targetShip.getType());
            }
        } 
        else {
            System.out.println("You already shot there. Try again.");
            shoot(opponent);  // Recursive call to shoot again
        }

        // Clear the screen 
        clearScreen();
    }
}



