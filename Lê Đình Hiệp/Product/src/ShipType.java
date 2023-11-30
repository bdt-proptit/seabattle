import java.util.ArrayList;
import java.util.Scanner;

public class ShipType {
    private ArrayList<Ship> list;

    ShipType(){
        list = new ArrayList<>(5);
        String data = "Patrol Boat\n2\n" +
                "Patrol Boat\n2\n" +
                "Destroyer Boat\n4\n" +
                "Submarine\n3\n" +
                "Battle Ship\n5\n";
        Scanner sc = new Scanner(data);
        for(int i = 0; i < 5; i++){
            Ship ship = new Ship();
            ship.setName(sc.nextLine());
            ship.setLength(Integer.parseInt(sc.nextLine()));
            list.add(ship);
        }
    }
    public ArrayList<Ship> getList() {
        return list;
    }
}
