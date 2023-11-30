package main.controller;

import main.model.GameBoard;

public class Player {
    private String name;
    private int destroyedShip, existShip;
    public GameBoard playerBoard = new GameBoard();
    public static Square oppBoard = new Square();
    private Ship[] shipList = new Ship[5];
    public static void hitShip(Position pos, GameBoard oopSea){
        oppBoard.getSquareShoted()[pos.getX()-1][pos.getY()-1] = oopSea.board[pos.getX()-1][pos.getY()-1].getHaveShip();
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDestroyedShip(int destroyedShip){
        this.destroyedShip = destroyedShip;
    }
    public void setExistShip(int existShip){
        this.existShip = existShip;
    }
    public String getName(){
        return this.name;
    }
    public int getDestroyedShip(){
        return this.destroyedShip;
    }
    public int getExistShip(){
        return this.existShip;
    }
    public void printPlayerBoard(GameBoard gameBoard){
        for(int i = 0; i < 34; i++) System.out.print("-");
        System.out.println();
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++)
            {
                if(i == j && i == 0) System.out.print("|  ");
                else if(j == 0||i==0) System.out.printf("|%-2d", ((i==0)?j : i));
                else
                {
                    System.out.print("|  ");
                }
                if(j == 10) System.out.println("|");
            }
        }
        for(int i = 0; i < 34; i++) System.out.print("-");
    }
    public void printOopBoard() {

    }
}
