package SeaBattle.board;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int length;
    private char[][] board;
    private int numShips = 0;
    public static char HIT = '☒';
    public static char MISS = '☸';
    public static char SHIP = '☐';
    public static char WATER = '≈';

    public Board(int length) {
        this.length = length;
        board = initBoard();
    }

    public Board(char[][] matrix) {
        this.length = matrix.length;
        board = matrix;
    }

    private char[][] initBoard() {
        char[][] matrix = new char[length][length];
        for (char[] row : matrix) {
            Arrays.fill(row, WATER);
        }
        return matrix;
    }

    public int getLength() {
        return length;
    }

    public int getNumShips() {
        return numShips;
    }

    public char[][] getBoard() {
        return board;
    }

    public char at(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    public boolean set(char status, Position position) {
        board[position.getRow()][position.getColumn()] = status;
        return true;
    }

    public boolean thereIsShip(Position position) {
        return at(position) == SHIP;
    }

    public boolean thereIsWater(Position position) {
        return at(position) == WATER;
    }

    public boolean thereIsMiss(Position position) {
        return at(position) == MISS;
    }

    public boolean thereIsHit(Position position) {
        return at(position) == HIT;
    }

    public boolean thereIsSpace(Ship ship) {
        int l = ship.getLength();
        int x = ship.getPosition().getRow();
        int y = ship.getPosition().getColumn();
        if (ship.getDirection() == Direction.HORIZONTAL) return (length - y + 1) > l;
        else return (length - x + 1) > l;
    }

    public boolean isNearShip(Ship ship) throws PositionException {
        int k, row, column;
        row = ship.getPosition().getRow();
        column = ship.getPosition().getColumn();

        if (ship.getDirection() == Direction.HORIZONTAL) k = column;
        else k = row;

        for (int i = 0; i < ship.getLength() && k + i < length - 1; i++) {
            if (isShipAround(row, column)) return true;

            if (ship.getDirection() == Direction.HORIZONTAL) column++;
            else if (ship.getDirection() == Direction.VERTICAL) row++;
        }
        return false;
    }

    private boolean isShipAround(int row, int column) throws PositionException {
        ArrayList<Position> list = getAllNearPositions(row, column);
        for (Position position : list) {
            if (at(position) == SHIP) return true;
        }
        return false;
    }

    public ArrayList<Position> getPossibleTarget(Position position) throws PositionException {
        int row = position.getRow(), column = position.getColumn();
        ArrayList<Position> list = new ArrayList<>();

        if (row - 1 >= 0 && !thereIsMiss(new Position(row - 1, column))
                && !thereIsHit(new Position(row - 1, column)))
            list.add(new Position(row - 1, column));

        if (column - 1 >= 0 && !thereIsMiss(new Position(row, column - 1))
                && !thereIsHit(new Position(row, column - 1)))
            list.add(new Position(row, column - 1));

        if (row + 1 < length && !thereIsMiss(new Position(row + 1, column))
                && !thereIsHit(new Position(row + 1, column)))
            list.add(new Position(row + 1, column));

        if (column + 1 < length && !thereIsMiss(new Position(row, column + 1))
                && !thereIsHit(new Position(row, column + 1)))
            list.add(new Position(row, column + 1));
        return list;
    }

    public ArrayList<Position> getAllNearPositions(int row, int column) throws PositionException {
        ArrayList<Position> list = new ArrayList<>();

        if (row - 1 >= 0) list.add(new Position(row - 1, column));

        if (row + 1 < length) list.add(new Position(row + 1, column));

        if (column + 1 < length) list.add(new Position(row, column + 1));

        if (column - 1 >= 0) list.add(new Position(row, column - 1));

        if (row - 1 >= 0 && column + 1 < length) list.add(new Position(row - 1, column + 1));

        if (row - 1 >= 0 && column - 1 >= 0) list.add(new Position(row - 1, column - 1));

        if (row + 1 < length && column + 1 < length) list.add(new Position(row + 1, column + 1));

        if (row + 1 < length && column - 1 >= 0) list.add(new Position(row + 1, column - 1));
        return list;
    }

    public boolean addShip(Ship ship) throws BoardException, PositionException {
        int k = 0, row, column;
        if (!thereIsShip(ship.getPosition())) {
            if (thereIsSpace(ship)) {
                if (!isNearShip(ship)) {
                    row = ship.getPosition().getRow();
                    column = ship.getPosition().getColumn();
                    for (int i = 0; i < ship.getLength() && k + i < length; i++) {
                        if (ship.getDirection() == Direction.HORIZONTAL) {
                            if (i == 0) k = column;
                            board[row][column + i] = SHIP;
                        } else if (ship.getDirection() == Direction.VERTICAL) {
                            if (i == 0) k = row;
                            board[row + i][column] = SHIP;
                        }
                        numShips++;
                    }
                    return true;
                }
                else throw new BoardException("Error, another ship is nearby");
            }
            else throw new BoardException("Error, there's no space for that ship with that direction");
        }
        else throw new BoardException("Error, there's already a ship in that location");
    }

    public boolean addHit(Position position) throws BoardException {
        if (thereIsShip(position)) {
            numShips--;
            return set(HIT, position);
        } else if (thereIsWater(position)) return set(MISS, position);
        else throw new BoardException("Error, you've already shot at this location!");
    }

//    public Position randPositionFromList(ArrayList<Position> list) {
//        Random rand = new Random();
//        return list.get(rand.nextInt(list.size()));
//    }

    public Board getBoardHideShips() throws PositionException {
        char[][] matrix = new char[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!thereIsShip(new Position(i, j))) {
                    matrix[i][j] = at(new Position(i, j));
                } else matrix[i][j] = WATER;
            }
        }
        return new Board(matrix);
    }

    public void reset() {
        numShips = 0;
        board = initBoard();
    }

}
