package Player;
import Ship.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String type;
    private int shotCount, HP;
    private List<Ship> listShip;
    private int[][] positionShips;
    public Player(){
        type = "";
        shotCount = 0;
        HP = 0;
        listShip = new ArrayList<>();
        positionShips = new int[10][10];
        for (int i=0;i<10;++i) for (int j=0;j<10;++j) positionShips[i][j]=0;
    }
    public void setType() {
        System.out.print("Nhập tên người chơi: ");
        this.type = new Scan().cin();
    }
    public void increaseShotCount() {
        shotCount++;
    }
    public void setHP(int HP) {
        this.HP=HP;
    }
    public void decreaseHP(){
        HP--;
    }
    public void setListShip(List<Ship> listShip) {
        this.listShip = listShip;
    }
    public void setPositionShips(int[][] positionShips) {
        this.positionShips = positionShips;
    }
    public String getType() {
        return type;
    }
    public int getShotCount() {
        return shotCount;
    }
    public int getHP() {
        return HP;
    }
    public List<Ship> getListShip() {
        return listShip;
    }
    public int[][] getPositionShips() {
        return positionShips;
    }
}
