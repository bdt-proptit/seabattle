package Ship;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public void check(Ship ship) {
        if(ship==null) return;
        System.out.println("hehe");
    }
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        new Test().check(null);

    }
}
