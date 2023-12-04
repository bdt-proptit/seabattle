import java.util.ArrayList;

public class Player {
    Manage manage = new Manage();
    private String name;
    private int numberOfFire;
    private int numberOfKilledShip;
    private int numberOfLiveShips;
    private Board map = new Board();
    private Ships patrolBoat1 = new Ships();
    private Ships patrolBoat2 = new Ships();
    private Ships destroyerBoat = new Ships();
    private Ships submarine = new Ships();
    private Ships battleShip = new Ships();
    private ArrayList<Ships> listShips = new ArrayList<Ships>();

    Player(){
        patrolBoat1.setSize(2);
        patrolBoat2.setSize(2);
        destroyerBoat.setSize(3);
        submarine.setSize(4);
        battleShip.setSize(5);
        patrolBoat1.setName("Patrol Boat");
        patrolBoat2.setName("Patrol Boat");
        destroyerBoat.setName("Destroyer Boat");
        submarine.setName("submarine");
        battleShip.setName("Battle Ship");
        numberOfLiveShips = 5;
        numberOfFire = 0;
        numberOfKilledShip = 0;

        listShips.add(patrolBoat1);
        listShips.add(patrolBoat2);
        listShips.add(destroyerBoat);
        listShips.add(submarine);
        listShips.add(battleShip);
    }

    public ArrayList<Ships> getListShips() {
        return listShips;
    }
    public int getNumberOfKilledShip() {
        return numberOfKilledShip;
    }
    public void setNumberOfKilledShip(int numberOfKilledShip) {
        this.numberOfKilledShip = numberOfKilledShip;
    }
    public Board getMap() {
        return map;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfFire() {
        return numberOfFire;
    }
    public void setNumberOfFire(int numberOfFire) {
        this.numberOfFire = numberOfFire;
    }
    public int getNumberOfLiveShips() {
        return numberOfLiveShips;
    }
    public void setNumberOfLiveShips(int numberOfLiveShips) {
        this.numberOfLiveShips = numberOfLiveShips;
    }
}
