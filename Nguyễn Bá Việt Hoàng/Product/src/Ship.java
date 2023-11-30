public class Ship extends GameBoard {
    private String name;
    private int bowRow, bowColumn, sternRow, sternColumn, sizeShip;
    public String getName() {
        return name;
    }
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public void setSternRow(int sternRow) {
        this.sternRow = sternRow;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public void setSternColumn(int sternColumn) {
        this.sternColumn = sternColumn;
    }

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public int getSternColumn() {
        return sternColumn;
    }

    public int getSternRow() {
        return sternRow;
    }

    public void setSizeShip(int sizeShip) {
        this.sizeShip = sizeShip;
    }

    public int getSizeShip() {
        return sizeShip;
    }
}
