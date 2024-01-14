package Feature;
import Entity.Ship;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {
    int stt;
    int savedBoardSize;
    int playNow;
    String name;
    int turnCount;
    int remainShip;
    int Point;
    boolean isBot;
    boolean playWithBot;
    char[][] myBoard;
    char[][] boardOfEnemy;
    String[][] colorPrint;
    String[][] ships;
    public void importShips(ArrayList<Ship> ls){
        ships = new String[remainShip][6];
        for(int i=0; i<remainShip; ++i){
            ships[i][0] = ls.get(i).getShipName();
            ships[i][1] = Integer.toString(ls.get(i).getShipLength());
            ships[i][2] = Integer.toString(ls.get(i).x1);
            ships[i][3] = Integer.toString(ls.get(i).y1);
            ships[i][4] = Integer.toString(ls.get(i).x2);
            ships[i][5] = Integer.toString(ls.get(i).y2);
        }
    }
}
