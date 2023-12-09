package SeaBattle;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends BattleField {
    Scanner sc = new Scanner(System.in);
    private int bulletNumber = 0;
    ArrayList<Integer> CoordinateX = new ArrayList<>(); // lưu tọa độ x
    ArrayList<Integer> CoordinateY = new ArrayList<>(); // lưu tọa độ y
    private int x1, y1, x2, y2;
    private String username;
    public int countShipNumber = 0; // đếm số thuyền đã đặt, đủ 5 thuyền thì break
    private final int[] checkShipType = new int[5];

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

    public void setBulletNumber() {
        ++this.bulletNumber;
    }
    public int getBulletNumber() {
        return this.bulletNumber;
    }

    public void setExistedShip() { // kiểm tra xem đã đặt đủ slg loại tàu đấy chưa
        for (int i = 1; i <= 4; ++i) {
            this.checkShipType[i] = 1;
        }
    }

    public void setCoordinates() {
        System.out.print("x1 = ");
        this.x1 = Integer.parseInt(sc.nextLine());
        System.out.print("y1 = ");
        this.y1 = Integer.parseInt(sc.nextLine());
        System.out.print("x2 = ");
        this.x2 = Integer.parseInt(sc.nextLine());
        System.out.print("y2 = ");
        this.y2 = Integer.parseInt(sc.nextLine());
    }

    public void ShipMenu(){
        System.out.println("--------------------------------SHIP LIST--------------------------------");
        System.out.println("-   1. Two Patrol Boat 1x2                                              -");
        System.out.println("-   2. One Submarine 1x3                                                -");
        System.out.println("-   3. One Destroyer Boat 1x4                                           -");
        System.out.println("-   4. One Battle Ship 1x5                                              -");
    }
    public char[][] getMyBoard() {
        return myBoard;
    }
    public void setMyBoard(char[][] myBoard) {
        this.myBoard = myBoard;
    }

    public Player() {
        setUsername(sc.nextLine());
        setExistedShip();
        while (true) {
            ShipMenu();
            System.out.print("Enter number of the ship you want to place (1, 2, 3, 4): ");
            int number = Integer.parseInt(sc.nextLine());
            if (number == 1 && this.checkShipType[number] <= 2) {
                System.out.println("Enter 2 coordinates (x,y) for " + GREEN + "Patrol Boat 1x2" + ANSI_RESET + ": ");
                setCoordinates();
                placeShip(number);
            } else if (number == 2 && this.checkShipType[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for " + GREEN + "Submarine 1x3" + ANSI_RESET + ": ");
                setCoordinates();
                placeShip(number);
            } else if (number == 3 && this.checkShipType[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for " + GREEN + "Destroyer Boat 1x4" + ANSI_RESET + ": ");
                setCoordinates();
                placeShip(number);
            } else if (number == 4 && this.checkShipType[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for " + GREEN + "Battle Ship 1x5" + ANSI_RESET + ": ");
                setCoordinates();
                placeShip(number);
            } else {
                System.out.println(RED + "INVALID!" + ANSI_RESET);
            }
            createMyBoard(this.username);
            if (this.countShipNumber == 5) { // nếu đặt đủ 5 thuyền rồi
                break;
            }
        }
    }

    public void placeShip(int shipLength) {
        if (this.x1 == this.x2) {
            if (Math.abs(this.y1 - this.y2) != shipLength) {
                System.out.println(RED + "INVALID! Wrong ship size!" + ANSI_RESET);
            } else {
                if (this.y1 > this.y2) { // swap y1 y2 nếu tọa độ cuối nhỏ hơn
                    int tmp = this.y1;
                    this.y1 = this.y2;
                    this.y2 = tmp;
                }
                boolean isPlaced = false; // kiểm tra tại vị trí đó đã có tàu đặt chưa
                for (int i = this.y1 - 1; i <= this.y2 - 1; ++i) {
                    if (myBoard[this.x1 - 1][i] == 'X') { // tại tọa độ này đã được đặt tàu r
                        isPlaced = true;
                        break;
                    }
                }
                if (isPlaced) {
                    System.out.println(RED + "INVALID! There is already a ship located at that location!" + ANSI_RESET);
                } else { // nếu tại tọa độ đó chưa có tàu đặt -> đặt X
                    System.out.println(GREEN + "Successfully placed ship!" + ANSI_RESET);
                    for (int i = this.y1 - 1; i <= this.y2 - 1; ++i) {
                        myBoard[this.x1 - 1][i] = 'X';
                    }

                    ++this.countShipNumber; // tăng số thuyền đã đặt
                    ++this.checkShipType[shipLength]; // kiểm tra xem loại thuyền đó được đặt đủ chưa
                    // lưu tọa độ của thuyền sau khi đặt
                    this.CoordinateX.add(this.x1);
                    this.CoordinateX.add(this.x2);
                    this.CoordinateY.add(this.y1);
                    this.CoordinateY.add(this.y2);
                }
            }
        }
        else if (this.y1 == this.y2) {
            if (Math.abs(this.x1 - this.x2) != shipLength) { // kiểm tra độ dài hợp lệ hay không
                System.out.println(RED + "INVALID! Wrong ship size!" + ANSI_RESET);
            } else {
                if (this.x1 > this.x2) {
                    int tmp = this.x1;
                    this.x1 = this.x2;
                    this.x2 = tmp;
                }
                boolean isPlaced = false; // kiểm tra tại vị trí đó đã có tàu đặt chưa
                for (int pos = this.x1 - 1; pos <= this.x2 - 1; ++pos) {
                    if (myBoard[pos][this.y1 - 1] == 'X') {
                        isPlaced = true; // tại tọa độ này đã được đặt tàu r
                        break;
                    }
                }
                if (isPlaced) {
                    System.out.println(RED + "INVALID! There is already a ship located at that location!" + ANSI_RESET);
                }
                else { // nếu tại tọa độ đó chưa có tàu đặt -> đặt X
                    System.out.println(GREEN + "Successfully placed ship!" + ANSI_RESET);
                    for (int i = this.x1 - 1; i <= this.x2 - 1; ++i) {
                        myBoard[i][this.y1 - 1] = 'X';
                    }
                    ++this.countShipNumber; // tăng số thuyền đã đặt
                    ++this.checkShipType[shipLength]; // kiểm tra xem loại thuyền đó được đặt đủ chưa
                    // lưu tọa độ của thuyền sau khi đặt
                    this.CoordinateX.add(this.x1);
                    this.CoordinateX.add(this.x2);
                    this.CoordinateY.add(this.y1);
                    this.CoordinateY.add(this.y2);
                }
            }
        }
        else System.out.println(RED + "INVALID! Wrong ship size!" + ANSI_RESET);
    }

//    void checkHit(int x, int y){
//
//    }
}
