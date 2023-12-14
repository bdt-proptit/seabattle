
public class Ship {
    private String name;
    private int length;
    private int x;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int y;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private Direction direction;

    public void setLength(int length) {
        this.length = length;
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

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }
}
