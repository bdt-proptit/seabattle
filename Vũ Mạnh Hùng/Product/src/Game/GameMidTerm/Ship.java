package GameMidTerm;

//Ship.java
public class Ship {
    private ShipType type;
    private State state;
    private int size;
    private int[] hitCounts;

    // Constructor
    public Ship(ShipType type) {
        this.type = type;
        this.size = type.getSize();
        this.hitCounts = new int[size];
    }

    // Getter 
    public ShipType getType() {return type;}
    public int getSize() {return size;}
    public int[] getHitCounts() {return hitCounts.clone();}

    public boolean isSunk() {
        for (int count : hitCounts) {
            if (count != 1) {
                return false;
            }
        }
        return true;
    }

    public void hit() {
        for (int i = 0; i < size; i++) {
            if (hitCounts[i] == 0) { // Chỉ tăng hitCount cho phần của tàu chưa được đánh trúng
                hitCounts[i]++;
                break;
            }
        }
    }
}