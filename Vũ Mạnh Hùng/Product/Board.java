package Product;

public class Board {
    private Cell[][] grid;
    private int rows;
    private int cols;

    // Constructor
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        initializeGrid();
    }

    // Getter 
    public Cell[][] getGrid() {return grid;}

    public int getRows() {return rows;}

    public int getCols() {return cols;}

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void receiveShot(Pos pos) {}
    public boolean isAllShipsSunk() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].getShip() != null && !grid[i][j].getShip().isSunk()) {
                    return false;
                }
            }
        }
        return true;
    }

}
