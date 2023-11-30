package main.controller;

public class GameStatus {
    public int gameStatus;
    public void checkGameStatus(int destroyedShip1, int destroyedShip2){
        if(destroyedShip1 == 5 || destroyedShip2 == 5) gameStatus = 1;
        else gameStatus = 0;
    }
}
