package Ship;

import Display.Display;

import java.util.Random;

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
    public void setBowPosition(int x, int y){
        this.bowPosition = new Coordinate(x, y);
    }
    public void setSternPosition() {
        System.out.print("Nhập vị trí đuôi: ");
        this.sternPosition = Coordinate.coodinateFromScanner();
    }
    public void setSternPosition(int x, int y){
        this.sternPosition = new Coordinate(x, y);
    }
    public int checkShipPosition(int viTri[][]){
//        0: Đặt thành công
//        1: Đã có tàu
//        2: Tàu không đủ chiều dài
//        3: Vị trí đầu và đuôi tàu không hợp lệ
        if(getBowPosition().getX()!= getSternPosition().getX() && getBowPosition().getY()!= getSternPosition().getY()) return 3;
        int start = getBowPosition().getX() == getSternPosition().getX() ? Math.min(getBowPosition().getY(), getSternPosition().getY()) : Math.min(getBowPosition().getX(), getSternPosition().getX());
        int   end = getBowPosition().getX() == getSternPosition().getX() ? Math.max(getBowPosition().getY(), getSternPosition().getY()) : Math.max(getBowPosition().getX(), getSternPosition().getX());
        if(end-start+1!= getLength()) return 2;
        for (int i=start;i<=end;++i) {
            if((getBowPosition().getX()== getSternPosition().getX() && viTri[getBowPosition().getX()][i]==1) || (getBowPosition().getY()== getSternPosition().getY() && viTri[i][getBowPosition().getY()]==1)) return 1;
        }
        return 0;
    }
}