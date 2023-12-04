package seabattle;

import java.util.Scanner;

public class Player {

    public int[] myTable[];
    public int[] myTableNow[];
    public Ship ship[];
    private int numberFired;
    private int[] vitri[];

//    public Player() {
//        //numberFired = 0;
//    }
    public void setPosShip() {
        Scanner input = new Scanner(System.in);
        vitri = new int[11][11];
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Mời bạn nhập tọa độ tàu thứ " + i + ": ");
            int row = input.nextInt();
            int col = input.nextInt();
            int ngangdoc = input.nextInt();
            vitri[i][1] = row;
            vitri[i][2] = col;
            vitri[i][3] = ngangdoc;
             System.out.println();
        }
        setShip();
    }

    public void setShip() {
        ship = new Ship[6];
        ship[1] = new Ship(2, 1, vitri[1][1], vitri[1][2], vitri[1][3]);
        ship[2] = new Ship(2, 1, vitri[2][1], vitri[2][2], vitri[2][3]);
        ship[3] = new Ship(3, 1, vitri[3][1], vitri[3][2], vitri[3][3]);
        ship[4] = new Ship(4, 1, vitri[4][1], vitri[4][2], vitri[4][3]);
        ship[5] = new Ship(5, 1, vitri[5][1], vitri[5][2], vitri[5][3]);
        setTable();
    }

    public void setTable() {
        myTable = new int[11][11];
        myTableNow = new int[11][11];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                myTable[i][j] = 0;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (ship[i].ngangdoc == 1) {
                for (int j = ship[i].getCol(); j < ship[i].getCol() + ship[i].getLength(); j++) {
                    myTable[ship[i].getRow()][j] = i;
                }
            } else {
                for (int j = ship[i].getRow(); j < ship[i].getRow() + ship[i].getLength(); j++) {
                    myTable[j][ship[i].getCol()] = i;
                }
            }
        }
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                myTableNow[i][j] = myTable[i][j];
            }
        }
    }

    public void disPlayMyTable() {
        System.out.println("Cach dat thuyen cua toi:");
        for (int i = 0; i <= 10; i++) {
            if (i == 1) {
                System.out.println();
            }
            for (int j = 0; j <= 10; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.printf("i/j ");
                    } else {
                        System.out.printf(" " + j + " ");
                    }
                }
                if (j == 0 && i != 0) {
                    if (i < 10) {
                        System.out.printf(" " + i + "  ");
                    } else {
                        System.out.printf(i + "  ");
                    }
                }
                if (i != 0 && j != 0) {
                    System.out.printf(" " + myTable[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public Boolean checkHit(int x, int y) {
        numberFired++;
        if (myTable[x][y] > 0) {
            ship[myTable[x][y]].setStatus(ship[myTable[x][y]].getStatus() - 1);
            myTableNow[x][y] = -1;
            return true;
        } else {
            myTableNow[x][y] = -2;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (myTableNow[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void disPlayHisTable(Player enemy) {
        System.out.println("Tinh Trang cua Dich\n");
        for (int i = 0; i <= 10; i++) {
            if (i == 1) {
                System.out.println();
            }
            for (int j = 0; j <= 10; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.printf("i/j ");
                    } else {
                        System.out.printf(" " + j + " ");
                    }
                }
                if (j == 0 && i != 0) {
                    if (i < 10) {
                        System.out.printf(" " + i + "  ");
                    } else {
                        System.out.printf(i + "  ");
                    }
                }
                if (i != 0 && j != 0) {
                    if (enemy.myTableNow[i][j] >= 0) {
                        System.out.printf(" 0 ");
                    } else {
                        System.out.printf(enemy.myTableNow[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();

    }

    public static int setNumber() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Mời bạn nhập chỉ thị: ");
        int number = input.nextInt();
        System.out.println();
        return number;
    }

    public int getNumberFired() {
        return numberFired;
    }
}
