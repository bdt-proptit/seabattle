package main.controller;
import main.model.GameShip;
import main.model.GameBoard;

import java.util.Scanner;

public class Ship {
    private int sizeShip;
    private GameShip ship;
    public void setSizeShip(int sizeShip) {
        this.sizeShip = sizeShip;
    }
    public int getSizeShip() {
        return sizeShip;
    }
    public GameShip getShip(){
        return ship;
    }
    public void setShip(GameShip ship){
        this.ship = ship;
    }
    public void setShipOnBoard(GameBoard gameBoard){
        if(ship.getStart().getX() == ship.getEnd().getX()){
            for(int i = Math.min(ship.getStart().getY(), ship.getEnd().getY()); i <= Math.max(ship.getStart().getY(), ship.getEnd().getY()); i++){
                gameBoard.board[ship.getStart().getX()-1][i-1].setCellStatus(1, 0);
            }
        }
    }
    public void checkPosShip(GameBoard gameBoardPlayer){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vi tri bat dau va vi tri ket thuc theo dang x1, y1, x2, y2: ");
        Position posStart = new Position();
        Position posEnd = new Position();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        posStart.setPosition(x1, y1);
        posEnd.setPosition(x2, y2);
        ship.setPosShip(posStart, posEnd);
        while(!ship.checkPosShipOnBoard(gameBoardPlayer, 2)){
            System.out.println("Toa do khong dung vui long nhap lai: ");
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            posStart.setPosition(x1, y1);
            posEnd.setPosition(x2, y2);
            ship.setPosShip(posStart, posEnd);
        }
    }
}
