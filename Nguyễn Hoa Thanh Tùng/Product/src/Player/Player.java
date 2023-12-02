package Player;
import Ship.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected String name;
    protected int shotCount, HP;
    protected List<Ship> listShip;
    protected int[][] positionShips;
    public Player(){
        name = "";
        shotCount = 0;
        HP = 0;
        listShip = new ArrayList<>();
        positionShips = new int[10][10];
        for (int i=0;i<10;++i) for (int j=0;j<10;++j) positionShips[i][j]=0;
    }
    public void setName() {
        System.out.print("Nhập tên người chơi: ");
        this.name = new Scan().cin();
    }
    public void setName(String name) {
        this.name=name;
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
    public String getName() {
        return name;
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
