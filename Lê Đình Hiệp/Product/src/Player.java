import java.util.Scanner;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int[][] mainBoard;
    private int[][] shotBoard;
    private int numberOfShotCell;
    private int shipRemain;
    private int shipDestroyed;

    public int getShipDestroyed() {
        return shipDestroyed;
    }

    public void setShipDestroyed(int shipDestroyed) {
        this.shipDestroyed = shipDestroyed;
    }

    public int[][] getMainBoard() {
        return mainBoard;
    }

    public int[][] getShotBoard() {
        return shotBoard;
    }

    public int getNumberOfShotCell() {
        return numberOfShotCell;
    }

    public int getShipRemain() {
        return shipRemain;
    }

    public void setNumberOfShotCell(int numberOfShotCell) {
        this.numberOfShotCell = numberOfShotCell;
    }

    public void setShipRemain() {
        int[] mark = new int[10];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                mark[mainBoard[i][j]] = 1;
            }
        }
        int cnt = 0;
        for(int i = 1; i < 10; i++){
            if(mark[i] == 1) cnt++;
        }
        shipRemain = cnt;
    }

    Player(){
        mainBoard = new int[10][10];
        shotBoard = new int[10][10];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                mainBoard[i][j] = 0;
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                shotBoard[i][j] = 0;
            }
        }
    }

    public void setMainBoard(int[][] mainBoard) {
        this.mainBoard = mainBoard;
    }

    int shoots(int x, int y, Player opponent){
        if(opponent.getMainBoard()[x][y] != 0){
            opponent.getMainBoard()[x][y] = 0;
            shotBoard[x][y] = 1;
            return 1;
        }else{
            shotBoard[x][y] = -1;
        }
        return 0;
    }
    public void placeShip(Ship ship, int symbol){
        switch (ship.getDirection()) {
            case 1:
                for (int i = 0; i < ship.getLength(); i++) {
                    mainBoard[ship.getX() - i][ship.getY()] = symbol;
                }
                break;
            case 2:
                for (int i = 0; i < ship.getLength(); i++) {
                    mainBoard[ship.getX() + i][ship.getY()] = symbol;
                }
                break;
            case 3:
                for (int i = 0; i < ship.getLength(); i++) {
                    mainBoard[ship.getX()][ship.getY() + i] = symbol;
                }
                break;
            case 4:
                for (int i = 0; i < ship.getLength(); i++) {
                    mainBoard[ship.getX()][ship.getY() - i] = symbol;
                }
                break;
        }
    }
}
