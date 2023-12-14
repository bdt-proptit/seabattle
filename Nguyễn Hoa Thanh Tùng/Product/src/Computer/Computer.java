package Computer;

import Player.Player;

import java.util.ArrayList;

public class Computer extends Player {
    // Em chưa nghĩ ra ạ
    int difficulty_level;
    public Computer(int difficulty_level) {
        name = "Máy";
        shotCount = 0;
        HP = 0;
        this.difficulty_level=difficulty_level;
        listShip = new ArrayList<>();
        positionShips = new int[10][10];
        for (int i=0;i<10;++i) for (int j=0;j<10;++j) positionShips[i][j]=0;
    }
}
