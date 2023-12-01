public class Cell {
    private int x, y;
    private String status;

    public Cell(int x, int y){
        setX(x);
        setY(y);
        this.status = "Empty";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
