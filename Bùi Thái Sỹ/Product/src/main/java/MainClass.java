package main;

import main.controller.Player;
import main.controller.Ship;
import main.controller.Square;
import main.model.GameBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //Player player = new Player();
        //player.printPlayerBoard(GameBoard);
        Scanner sc = new Scanner(System.in);
        String choose = sc.nextLine();
        switch (choose) {
            case "1" ->{
            }
            case "2" ->{
                Player player1 = new Player();
                Player player2 = new Player();
                GameBoard gameBoardPlayer1 = new GameBoard();
                //gameBoardPlayer1.initBoard();
                GameBoard gameBoardPlayer2 = new GameBoard();
                //gameBoardPlayer2.initBoard();
                Square oopBoardPlayer1 = new Square();
                //oopBoardPlayer1.InitSquare();
                Square oopBoardPlayer2 = new Square();
                //oopBoardPlayer2.InitSquare();
                player1.setDestroyedShip(0);
                player2.setDestroyedShip(0);
                player1.setExistShip(5);
                player2.setExistShip(5);
                ArrayList<Ship> listShip1 = new ArrayList<>();
                ArrayList<Ship> listShip2 = new ArrayList<>();
//                Ship[] listShip1 = new Ship[5];
//                Ship[] listShip2 = new Ship[5];
//                listShip1[0].setSizeShip(2);
//                listShip2[0].setSizeShip(2);
//                listShip1[1].setSizeShip(2);
//                listShip2[1].setSizeShip(2);
//                listShip1[2].setSizeShip(4);
//                listShip2[2].setSizeShip(4);
//                listShip1[3].setSizeShip(3);
//                listShip2[3].setSizeShip(3);
//                listShip1[4].setSizeShip(5);
//                listShip2[4].setSizeShip(5);
                Ship shipTemp = new Ship();
                shipTemp.setSizeShip(2);
                System.out.println("Moi nguoi choi nhap vi tri cua Thuyen Tuan Tra 1: ");
                shipTemp.checkPosShip(gameBoardPlayer1);
                listShip1.add(shipTemp);
                shipTemp.setShipOnBoard(gameBoardPlayer1);
                shipTemp.setSizeShip(2);
                System.out.println("Moi nguoi choi nhap vi tri cua Thuyen Tuan Tra 2: ");
                shipTemp.checkPosShip(gameBoardPlayer1);
                listShip1.add(shipTemp);
                shipTemp.setShipOnBoard(gameBoardPlayer1);
                shipTemp.setSizeShip(4);
                System.out.println("Moi nguoi choi nhap vi tri cua Tau Truc Khu: ");
                shipTemp.checkPosShip(gameBoardPlayer1);
                listShip1.add(shipTemp);
                shipTemp.setShipOnBoard(gameBoardPlayer1);
                shipTemp.setSizeShip(3);
                System.out.println("Moi nguoi choi nhap vi tri cua Tau Ngam: ");
                shipTemp.checkPosShip(gameBoardPlayer1);
                listShip1.add(shipTemp);
                shipTemp.setShipOnBoard(gameBoardPlayer1);
                shipTemp.setSizeShip(5);
                System.out.println("Moi nguoi choi nhap vi tri cua Thiet Giap Ham: ");
                shipTemp.checkPosShip(gameBoardPlayer1);
                listShip1.add(shipTemp);
                shipTemp.setShipOnBoard(gameBoardPlayer1);
            }

        }
    }
    
}
