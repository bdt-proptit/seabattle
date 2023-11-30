package SeaBattle;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends BattleField{
    Scanner sc = new Scanner(System.in);
    ArrayList <String> ShipType = new ArrayList<>();
    ArrayList <Integer> CoordinateX = new ArrayList<>();
    ArrayList <Integer> CoordinateY = new ArrayList<>();
    private int x1, y1, x2, y2;
    private String username;
    public int countShipNumber = 0; // đếm số thuyền
    public int[] shipNumber = new int[5];
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }


    public void setCoordinates(){
        System.out.print("Enter x1: ");
        setX1(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter y1: ");
        setY1(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter x2: ");
        setX2(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter y2: ");
        setY2(Integer.parseInt(sc.nextLine()));
    }
    public Player(){
        setUsername(sc.nextLine());
        System.out.println("--------------------------");
        System.out.println("1. Two Patrol Boat 1x2    ");
        System.out.println("2. One Submarine 1x2      ");
        System.out.println("3. One Destroyer Boat 1x2 ");
        System.out.println("4. One Battle Ship 1x2    ");
        System.out.println("--------------------------");
        while (true){
            System.out.print("Select the ship you want to place: ");
            int shipOption = Integer.parseInt(sc.nextLine());
            switch (shipOption){
                case 1:

            }
        }
    }
    public void placeShip(int shipLength) {
        if (x1 == x2) {
            if (Math.abs(y1 - y2) != shipLength) {
                System.out.println("Invalid! Please re-check!");
            } else {
                if (y1 > y2) {
                    int temp = y1;
                    y1 = y2;
                }
                boolean checkPlacedShip = false;
                for (int i = y1; i <= y2; ++i) {
                    if (myBoard[x1][i] == 'X') { // đã có thuyền đặt
                        checkPlacedShip = true;
                        break;
                    }
                }
                if (checkPlacedShip) {
                    System.out.println("There's already a ship placed!");
                } else {
                    System.out.println("Successfully placed ship!");
                    ++this.countShipNumber;
                    ++this.shipNumber[shipLength];
                    for (int i = y1; i <= y2; ++i) {
                        myBoard[x1][i] = 'X';
                    }
                }
                this.CoordinateX.add(this.x1);
                this.CoordinateX.add(this.x2);
                this.CoordinateY.add(this.y1);
                this.CoordinateY.add(this.y2);
                if (shipLength == 1) this.ShipType.add("Patrol Ship");
                else if (shipLength == 2) this.ShipType.add("Destroyer Ship");
                else if (shipLength == 3) this.ShipType.add("Submarine");
                else if (shipLength == 4) this.ShipType.add("Battle Ship");
            }
        }
        else{
            System.out.println("Invalid ship length!");
        }
    }
    public void updateData(){
        // update kết quả
    }

    public void shoot(Player currentPlayer, Player nextPlayer){
        System.out.print("Enter shooting coordinateS (x, y): ");
        System.out.print("x = ");   int x = Integer.parseInt(sc.nextLine());
        System.out.print("y = ");   int y = Integer.parseInt(sc.nextLine());


    }
//    void checkHit(int x, int y){
//
//    }
    public void checkWinner(){
        if (countShipNumber==0){
            System.out.println("Winner!");
            System.out.println("Goodbye!");;
            return;
        }
    }
}
