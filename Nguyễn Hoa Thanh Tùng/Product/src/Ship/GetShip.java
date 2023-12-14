package Ship;

import Display.Display;

import java.util.Random;

public class GetShip extends Ship{
    public static Ship fromScanner(String type, int length, int position[][]) {
        Ship ship = new Ship(type, length);
        Display display = new Display();
        while (true) {
            System.out.println(String.format("Nhập thông tin %s (1x%d):", ship.getType(), ship.getLength()));
            ship.setBowPosition();
            ship.setSternPosition();
            switch (ship.checkShipPosition(position)) {
                case 0:
                    System.out.println("Đặt " + ship.getType() + " thành công.");
                    return ship;
                case 1:
                    System.out.println("Tàu không đủ chiều dài.");
                    System.out.println("Đặt tàu không thành công.");
                    display.horizontalLine();
                    break;
                case 2:
                    System.out.println("Vị trí này đã có tàu.");
                    System.out.println("Đặt tàu không thành công.");
                    display.horizontalLine();
                    break;
                case 3:
                    System.out.println("Vị trí đầu và đuôi tàu không hợp lệ.");
                    System.out.println("Đặt tàu không thành công.");
                    display.horizontalLine();
                    break;
            }
        }
    }
    public static Ship random(String type, int length, int position[][]) {
        Random random = new Random();
        Ship ship = new Ship(type, length);
        int x, y;
        while (true) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(position[x][y]==0) break;
        }
        ship.setBowPosition(x, y);
        if (x-length+1>=0) {
            ship.setSternPosition(x-length+1, y);
            if (ship.checkShipPosition(position)==0) return ship;
        }
        if (y+length-1<10) {
            ship.setSternPosition(x, y+length-1);
            if (ship.checkShipPosition(position)==0) return ship;
        }
        if (x+length-1<10){
            ship.setSternPosition(x+length-1, y);
            if (ship.checkShipPosition(position)==0) return ship;
        }
        if (y-length+1>=0) {
            ship.setSternPosition(x, y-length+1);
            if (ship.checkShipPosition(position)==0) return ship;
        }
        return null;
    }
}
