package seabattle;

import java.util.Scanner;

public class Player {

    public int myTable[][];
    public int myTableNow[][];
    static Ship ship[];
    public int numberFired;
    public int vitri[][];

    public Player() {
        numberFired = 0;
    }

    public void setPosShip() {
        Scanner input = new Scanner(System.in);
        System.out.println("Moi ban nhap vi tri 5 tau:");
        for (int i = 1; i <= 5; i++) {
            int row = input.nextInt();
            int col = input.nextInt();
            int ngangdoc = input.nextInt();
            vitri[i][1] = row;
            vitri[i][2] = col;
            vitri[i][3] = ngangdoc;
        }
        setShip();
    }

    public void setShip() {
        ship[1] = new Ship(2, 1, vitri[1][1], vitri[1][2], vitri[1][3]);
        ship[2] = new Ship(2, 1, vitri[2][1], vitri[2][2], vitri[2][3]);
        ship[3] = new Ship(3, 1, vitri[3][1], vitri[3][2], vitri[3][3]);
        ship[4] = new Ship(4, 1, vitri[4][1], vitri[4][2], vitri[4][3]);
        ship[5] = new Ship(5, 1, vitri[5][1], vitri[5][2], vitri[5][3]);
        setTable();
    }

    public void setTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                myTable[i][j] = 0;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (ship[i].ngangdoc == 1) {
                for (int j = ship[i].col; j < ship[i].col + ship[i].length; j++) {
                    myTable[ship[i].row][j] = i;
                }
            } else {
                for (int j = ship[i].row; j < ship[i].row + ship[i].length; j++) {
                    myTable[j][ship[i].col] = i;
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
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf(myTable[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Boolean checkHit(int x, int y) {
        numberFired++;
        if (myTable[x][y] > 0) {
            ship[myTable[x][y]].tinhTrang--;
            myTableNow[x][y] = -1;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (myTableNow[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void disPlayHisTable(Player player) {
        System.out.println("Tinh Trang cua Dich");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf(player.myTable[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
