/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seabattle_mvp;

import java.util.ArrayList;
import java.util.Scanner;

public final class Player extends Board {

    private String Name;
    private int NumberBulletFired = 0;
    private int cnt_ship = 0; // đếm số thuyền đã đặt
    private int[] check_ship = new int[5]; // kiểm tra thuyền đã đặt đủ chưa
    ArrayList<String> Name_Ship = new ArrayList<>(); // tên thuyền đã đặt
    ArrayList<Integer> Coordinates_X = new ArrayList<>(); // tọa độ hoành của thuyền
    ArrayList<Integer> Coordinates_Y = new ArrayList<>(); // tọa độ tung của thuyền
    private int x1, y1;
    private int x2, y2;
    public Scanner scanner = new Scanner(System.in);
    
    public void setBullet(){
        ++this.NumberBulletFired;
    }
    public int getBullet() {
        return this.NumberBulletFired;
    }
    public void setCoordinates() {
        System.out.print("x1 = ");
        this.x1 = Integer.parseInt(scanner.nextLine());
        System.out.print("y1 = ");
        this.y1 = Integer.parseInt(scanner.nextLine());
        System.out.print("x2 = ");
        this.x2 = Integer.parseInt(scanner.nextLine());
        System.out.print("y2 = ");
        this.y2 = Integer.parseInt(scanner.nextLine());
    }

    public void setCheckShip() {
        for (int pos = 1; pos <= 4; ++pos) {
            this.check_ship[pos] = 1;
        }
    }

    public void printCheckShip() { // in số hiệu tàu chưa đặt
        for (int pos = 1; pos <= 4; ++pos) {
            if (pos == 1) {
                if (this.check_ship[pos] <= 2) {
                    System.out.print(pos);
                }
            } else if (this.check_ship[pos] == 1) {
                System.out.print(pos);
            }
        }
    }

    public void setShip(int number) { // đặt thuyền + lưu độ dài của thuyền đã đặt
        if (this.x1 == this.x2) {
            if (Math.abs(this.y1 - this.y2) != number) { // kiểm tra độ dài hợp lệ hay không
                System.out.println("INVALID! Wrong ship size!");
            } else {
                if (this.y1 > this.y2) {
                    int tmp = this.y1;
                    this.y1 = this.y2;
                    this.y2 = tmp;
                }
                int check_pos = 0; // kiểm tra tại vị trí đó đã có tàu đặt chưa
                for (int pos = this.y1 - 1; pos <= this.y2 - 1; ++pos) {
                    if (MyBoard[this.x1 - 1][pos] == 'X') {
                        check_pos = 1;
                        break;
                    }
                }
                if (check_pos == 1) {
                    System.out.println("INVALID! There is already a ship located at that location!");
                } else { // tại tọa độ đó chưa có tàu đặt thì đặt tàu
                    System.out.println("Booked the boat successfully!");
                    for (int pos = this.y1 - 1; pos <= this.y2 - 1; ++pos) {
                        MyBoard[this.x1 - 1][pos] = 'X';
                    }

                    ++this.cnt_ship; // đếm đã đặt đủ thuyền hay chưa
                    ++this.check_ship[number]; // kiểm tra thuyền đó đã đặt chưa

                    this.Coordinates_X.add(this.x1); // lưu 2 tọa độ của thuyền hiện tại
                    this.Coordinates_X.add(this.x2);
                    this.Coordinates_Y.add(this.y1);
                    this.Coordinates_Y.add(this.y2);

                    if (number == 1) {
                        this.Name_Ship.add("Patrol Boat");       // lưu thuyền tại tọa độ đó
                    } else if (number == 2) {
                        this.Name_Ship.add("Destroyer Boat");
                    } else if (number == 3) {
                        this.Name_Ship.add("Submarine");
                    } else if (number == 4) {
                        this.Name_Ship.add("Battle Ship");
                    }

                }
            }

        } else if (this.y1 == this.y2) {
            if (Math.abs(this.x1 - this.x2) != number) { // kiểm tra độ dài hợp lệ hay không
                System.out.println("INVALID! Wrong ship size!");
            } else {
                if (this.x1 > this.x2) {
                    int tmp = this.x1;
                    this.x1 = this.x2;
                    this.x2 = tmp;
                }
                int check_pos = 0; // kiểm tra tại vị trí đó đã có tàu đặt chưa
                for (int pos = this.x1 - 1; pos <= this.x2 - 1; ++pos) {
                    if (MyBoard[pos][this.y1 - 1] == 'X') {
                        check_pos = 1;
                        break;
                    }
                }
                if (check_pos == 1) {
                    System.out.println("INVALID!There is already a ship located at that location!");
                } else { // tại tọa độ đó chưa có tàu đặt thì đặt tàu
                    System.out.println("Booked the boat successfully!");
                    for (int pos = this.x1 - 1; pos <= this.x2 - 1; ++pos) {
                        MyBoard[pos][this.y1 - 1] = 'X';
                    }
                    ++this.cnt_ship;
                    ++this.check_ship[number];

                    this.Coordinates_X.add(this.x1); // lưu 2 tọa độ của thuyền hiện tại
                    this.Coordinates_X.add(this.x2);
                    this.Coordinates_Y.add(this.y1);
                    this.Coordinates_Y.add(this.y2);

                    if (number == 1) {
                        this.Name_Ship.add("Patrol Boat");       // lưu thuyền tại tọa độ đó
                    } else if (number == 2) {
                        this.Name_Ship.add("Destroyer Boat");
                    } else if (number == 3) {
                        this.Name_Ship.add("Submarine");
                    } else if (number == 4) {
                        this.Name_Ship.add("Battle Ship");
                    }
                }
            }
        } else {
            System.out.println("INVALID! Wrong ship size!");
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Player() {
        Board board = new Board();
        // nhập tên người chơi
        setName(scanner.nextLine());
        // khởi tạo tàu sắp được đặt
        setCheckShip();
        System.out.println("------------------------------------MENU---------------------------------");
        System.out.println("-   1. Two Patrol Boat 1x2                                              -");
        System.out.println("-   2. One Submarine 1x3                                                -");
        System.out.println("-   3. One Destroyer Boat 1x4                                           -");
        System.out.println("-   4. One Battle Ship 1x5                                              -");
        System.out.println("-------------------------------------------------------------------------");
        // đặt tàu của người chơi vào bảng
        while (true) {
            System.out.print("Select the ship you want to book by entering the number!(-");
            printCheckShip();
            System.out.print("-): ");

            int number = Integer.parseInt(scanner.nextLine());// nhập thuyền muốn đặt vào bảng
            //solve
            if (number == 1 && this.check_ship[number] <= 2) { // kiểm tra bằng số mấy và số đấy đã được điền tàu chưa
                System.out.println("Enter 2 coordinates (x,y) for Patrol Boat " + this.check_ship[number] + ":");
                setCoordinates();
                setShip(number);
            } else if (number == 2 && this.check_ship[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for Submarine:");
                setCoordinates();
                setShip(number);
            } else if (number == 3 && this.check_ship[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for Destroyer Boat:");
                setCoordinates();
                setShip(number);
            } else if (number == 4 && this.check_ship[number] == 1) {
                System.out.println("Enter 2 coordinates (x,y) for Battle Ship:");
                setCoordinates();
                setShip(number);
            } else {
                System.out.println("INVALID!");
            }
            displayMyboard(this.Name);
            if (this.cnt_ship == 5) {
                break;
            }
        }
    }
    
    
}
