public class Ship extends GameBoard {
    private String name;
    private int bowRow, bowColumn, sternRow, sternColumn, sizeShip;
    private char sign;

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getSternColumn() {
        return sternColumn;
    }

    public void setSternColumn(int sternColumn) {
        this.sternColumn = sternColumn;
    }

    public int getSternRow() {
        return sternRow;
    }

    public void setSternRow(int sternRow) {
        this.sternRow = sternRow;
    }

    public int getSizeShip() {
        return sizeShip;
    }

    public void setSizeShip(int sizeShip) {
        this.sizeShip = sizeShip;
    }
}
