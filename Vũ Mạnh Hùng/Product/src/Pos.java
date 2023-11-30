package Product;

public class Pos {
    private int x;
    private int y;

    // Constructors
    public Pos() {}

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter Setters
    public int  getX() {return x;}
    public int  getY() {return y;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
}