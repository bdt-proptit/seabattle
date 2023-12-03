package SeaBattle.board;

public enum ShipType {
    PATROL(2, 2),
    SUBMARINE(1, 3),
    DESTROYER(1, 4),
    BATTLESHIP(1, 5);

    private int numShips;
    private int shipLength;

    ShipType(int numShips, int shipLength) {
        this.numShips = numShips;
        this.shipLength = shipLength;
    }

    public int getShipLength() {
        return shipLength;
    }

    public int getNumShips() {
        return numShips;
    }

    public static int lengthAllShips() {
        int sum = 0;
        for (ShipType type : ShipType.values()) sum += type.shipLength * type.numShips;
        return sum;
    }

    public static int sizeAllShips() {
        int sum = 0;
        for (ShipType type : ShipType.values()) sum += type.numShips;
        return sum;
    }

    public static String toVietNamNameShip(ShipType type) {
        return switch (type) {
            case BATTLESHIP -> "Thiết Giáp Hạm";
            case DESTROYER -> "Tàu Khu Vực";
            case PATROL -> "Thuyền Tuần Tra";
            case SUBMARINE -> "Tàu Ngầm";
        };
    }
}
