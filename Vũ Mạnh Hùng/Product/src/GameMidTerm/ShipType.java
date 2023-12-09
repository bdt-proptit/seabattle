package GameMidTerm;

//ShipType.java
public enum ShipType {
	PATROL_BOAT_1(2), PATROL_BOAT_2(2), DESTROYER_BOAT(4), SUBMARINE(3), BATTLESHIP(5);

	private final int size;
	private boolean isPlaced;

	ShipType(int size) {
		this.size = size;
		this.isPlaced = false;
	}
	public int getSize() {
		return size;
	}
	public boolean getIsPlaced() {
		return isPlaced;
	}

	public void   place() {isPlaced = true;}
	public void unplace() {isPlaced = false;}
}
