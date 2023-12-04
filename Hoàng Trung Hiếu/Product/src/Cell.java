public class Cell {
    private boolean hasShip;
    private boolean isHit;
    private Ship ship;

    public Cell() {
        this.hasShip = false;
        this.isHit = false;
    }
    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        this.isHit = hit;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        this.hasShip = true;
    }
    public Ship getShip() {
        return ship;
    }

    public Cell[] cells;
}
