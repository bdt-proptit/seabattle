package Product;

public class Cell {
    private State state;
    private Ship ship;

    // Constructor
    public Cell() {
        this.state = State.EMPTY;
        this.ship = null;
    }

    // Getter Setters
    public State getState() {return state;}
    public Ship  getShip()  {return ship;}
    public void setState(State state) {this.state = state;}
    public void setShip (Ship ship)   {this.ship = ship;}
}