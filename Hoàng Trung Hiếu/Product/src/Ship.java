class Ship {
    int size;
    boolean[] hits;

    public boolean isSunk() {
        for (boolean hit : hits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }
    public Ship(int size) {
        this.size = size;
    }

}
