package seabattle;

public class Ship {

    private int status;
    private int length;
    private int width;
    private int row;
    private int col;
    public int ngangdoc; // 1 là ngang, 0 là doc

    public Ship(int length, int width, int row, int col, int ngangdoc) {

        this.length = length;
        this.width = width;
        this.row = row;
        this.col = col;
        this.ngangdoc = ngangdoc;
        status = length * width;
    }

    public int getLength() {
        return length;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int x) {
        this.status = x;
    }
}
