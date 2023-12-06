package SeaBattle.board;

public class Ship {
    private String name;
    private int length;
    private Position position;
    private Direction direction;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.position = null;
        this.direction = null;
    }

    public Ship(String name, int length, Position position, Direction direction) {
        this.name = name;
        this.length = length;
        this.position = position;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toGraphicLength() {
        return ("" + Board.SHIP).repeat(length);
    }

    public String toString() {
        return name + ";" + length;
    }
}