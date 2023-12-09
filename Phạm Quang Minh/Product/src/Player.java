import java.util.ArrayList;

public class Player {
    private int index;
    private String name;
    private int numberShot;
    private char[][] board;
    private char[][] oppositeBoard;
    private boolean completed;
    private ArrayList<Ship> ships;

    Player(int index, String name, int numberShot, char[][] board, char[][] oppositeBoard, Boolean completed,
            ArrayList<Ship> ships) {
        this.index = index;
        this.name = name;
        this.numberShot = numberShot;
        this.board = board;
        this.oppositeBoard = oppositeBoard;
        this.completed = completed;
        this.ships = ships;
    }

    Player() {
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return name;
    }

    public char[][] getBoard() {
        return board;
    }

    public char[][] getOppositeBoard() {
        return oppositeBoard;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setOppositeBoard(char[][] oppositeBoard) {
        this.oppositeBoard = oppositeBoard;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public int getNumberShot() {
        return numberShot;
    }

    public void setNumberShot(int numberShot) {
        this.numberShot = numberShot;
    }

    public int destroyedShips() {
        int count = 0;
        for (var ship : ships) {
            if (!ship.getStatus())
                count++;
        }
        return count;
    }

    public int remainNumberShips() {
        int count = 0;
        for (var ship : ships) {
            if (ship.getStatus())
                count++;
        }
        return count;
    }
}
