package model;

import java.util.ArrayList;
import java.util.Scanner;

public class ShipType {
    private ArrayList<Ship> shipList;

    public ShipType() {
        shipList = new ArrayList<>(5);
        String data = "Battle Ship\n5\n"
                + "Destroyer Boat\n4\n"
                + "Submarine\n3\n"
                + "Patrol Boat\n2\n"
                + "Patrol Boat\n2\n";
        Scanner sc = new Scanner(data);
        while (sc.hasNextLine()) {
            Ship ship = new Ship();
            ship.setName(sc.nextLine());
            ship.setLength(Integer.parseInt(sc.nextLine()));
            shipList.add(ship);
        }
    }
    public ArrayList<Ship> getList() {
        return shipList;
    }
}
