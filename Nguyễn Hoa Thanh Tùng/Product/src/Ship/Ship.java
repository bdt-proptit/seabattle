package Ship;

import Display.Display;

public class Ship {
    private String type;
    private int HP, length;
    private Coordinate bowPosition, sternPosition;

    public Ship() {
        this.type ="";
        this.length =0;
        this.HP=0;
    }
    public Ship(String type, int length) {
        this.type = type;
        this.HP = length;
        this.length = length;
        bowPosition = new Coordinate();
        sternPosition = new Coordinate();
    }
    public String getType() {
        return type;
    }

    public int getHP() {
        return HP;
    }
    public int getLength() {
        return length;
    }
    public Coordinate getBowPosition() {
        return bowPosition;
    }

    public Coordinate getSternPosition() {
        return sternPosition;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void shotHit(){
        HP--;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setBowPosition() {
        System.out.print("Nhập vị trí đầu: ");
        this.bowPosition = Coordinate.coodinateFromScanner();
    }
    public void setSternPossition() {
        System.out.print("Nhập vị trí đuôi: ");
        this.sternPosition = Coordinate.coodinateFromScanner();
    }
    public static Ship getShipFromScanner(String type, int length, int position[][]) {
        Ship ship = new Ship(type, length);
        Display display = new Display();
        while (true) {
            System.out.println(String.format("Nhập thông tin %s (1x%d):", ship.getType(), ship.getLength()));
            ship.setBowPosition();
            ship.setSternPossition();
            if(ship.checkShipPosition(position)) {
                System.out.println("Đặt " + ship.getType() + " thành công.");
                return ship;
            } else {
                System.out.println("Đặt tàu không thành công.");
                display.horizontalLine();
            }
        }
    }
    public boolean checkShipPosition(int viTri[][]){
        if(getBowPosition().getX()!= getSternPosition().getX() && getBowPosition().getY()!= getSternPosition().getY()) return false;
        int start = getBowPosition().getX() == getSternPosition().getX() ? Math.min(getBowPosition().getY(), getSternPosition().getY()) : Math.min(getBowPosition().getX(), getSternPosition().getX());
        int   end = getBowPosition().getX() == getSternPosition().getX() ? Math.max(getBowPosition().getY(), getSternPosition().getY()) : Math.max(getBowPosition().getX(), getSternPosition().getX());
        if(end-start+1!= getLength()) {
            System.out.println("Tàu không đủ chiều dài.");
            return false;
        }
        for (int i=start;i<=end;++i) {
            if((getBowPosition().getX()== getSternPosition().getX() && viTri[getBowPosition().getX()][i]==1) || (getBowPosition().getY()== getSternPosition().getY() && viTri[i][getBowPosition().getY()]==1)) {
                System.out.println("Vị trí này đã có thuyền.");
                return false;
            }
        }
        return true;
    }
}