package Product;

public class Ship {
    private ShipType type;
    private int size;
    private int hitCount;

    // Constructor
    public Ship(ShipType type) {
        this.type = type;
        this.size = calculateSize();
        this.hitCount = 0;
    }

    // Getter 
    public ShipType getType() {return type;}
    public int getSize() {return size;}
    public int getHitCount() {return hitCount}

    public boolean isSunk() {
        return hitCount == size;
    }

    public void hit() {
        if (!isSunk()) hitCount++;
    }

    private int calculateSize() {
        switch (type) {
            case PATROL_BOAT:
                return 2;
            case DESTROYER_BOAT:
                return 4;
            case SUBMARINE:
                return 3;
            case BATTLESHIP:
                return 5;
            default:
                return 0;
        }
    }
}
