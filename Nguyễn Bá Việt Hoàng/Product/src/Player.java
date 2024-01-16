import java.util.Scanner;

public class Player extends GameBoard {
    public Ship[] ships = new Ship[10];
    public int shipRemain = 0, check = 0;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpShip() {
        while (shipRemain < 5) {
            Scanner input = new Scanner(System.in);
            String name;
            int sizeShip;
            char sign;
            if (shipRemain < 2) {
                name = "Patrol Boat";
                sizeShip = 2;
                sign = 'P';
            } else if (shipRemain == 2) {
                name = "Destroyer Boat";
                sizeShip = 4;
                sign = 'D';
            } else if (shipRemain == 3) {
                name = "Submarine";
                sizeShip = 3;
                sign = 'S';
            } else {
                name = "Battle Ship";
                sizeShip = 5;
                sign = 'B';
            }
            Scanner sc = new Scanner(System.in);
            while (true) {
                showBoard();
                System.out.println("Setup your " + name + "with size 1x" + sizeShip + ":");
                ships[shipRemain] = new Ship();
                System.out.println("Enter bow's coordinate: ");
                System.out.print("Bow's row: ");
                ships[shipRemain].setName(name);
                int bowRow = input.nextInt();
                ships[shipRemain].setBowRow(bowRow);
                System.out.print("Bow's column: ");
                int bowColumn = input.nextInt();
                ships[shipRemain].setBowColumn(bowColumn);
                System.out.println("Enter stern's coordinate: ");
                System.out.print("Stern's row: ");
                int sternRow = input.nextInt();
                ships[shipRemain].setSternRow(sternRow);
                System.out.print("Stern's column: ");
                int sternColumn = input.nextInt();
                ships[shipRemain].setSternColumn(sternColumn);
                ships[shipRemain].setSizeShip(sizeShip);
                ships[shipRemain].setSign(sign);
                sign = ships[shipRemain].getSign();
                shipRemain++;
                if (checkSetUp(bowRow, bowColumn, sternRow, sternColumn, sizeShip)) {
                    for (int z = bowRow; z <= sternRow; z++)
                        for (int t = bowColumn; t <= sternColumn; t++) {
                            setBoard(z, t, sign);
                        }
                    break;
                } else {
                    shipRemain--;
                    System.out.println("Invalid value!");
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    ClearScreen.clrscr();
                }
            }
            showBoard();
            System.out.println("Enter to continue...");
            sc.nextLine();
            ClearScreen.clrscr();
        }
    }

    public boolean checkSetUp(int x, int y, int z, int t, int u) {
        if (x < 1 || x > 10 || z < 1 || z > 10 || y < 1 || y > 10 || t < 1 || t > 10) return false;
        else {
            if (x == z) {
                if (y != t - u + 1 && y != t + u - 1) return false;
            } else if (y != t) return false;
            else if (x != z - u + 1 && x != z + u - 1) {
                return false;
            }
            int swap;
            if (x > z) {
                swap = x;
                x = z;
                z = swap;
            }
            if (y > t) {
                swap = y;
                y = t;
                t = swap;
            }
            for (int i = x; i <= z; i++)
                for (int j = y; j <= t; j++)
                    if (getBoard(i, j) == 'P'||getBoard(i, j) == 'D'||getBoard(i, j) == 'S'||getBoard(i, j) == 'B') return false;
        }
        return true;
    }

    public void beAttacked() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter fire coordinate: ");
            System.out.print("x: ");
            int x = input.nextInt();
            System.out.print("y: ");
            int y = input.nextInt();
            if (x >= 1 && x <= 10 && y >= 1 && y <= 10) {
                hitCheck(x, y);
                break;
            } else System.out.println("Invalid value!");
            if(check == 1) break;
        }
    }

    public void hitCheck(int x, int y) {
        if (getBoard(x, y) == 'P'||getBoard(x, y) == 'D'||getBoard(x, y) == 'S'||getBoard(x, y) == 'B') {
            System.out.println("Hit!");
            setBoard(x, y, 'x');
            shipCheck(x, y, ships);
            int ok = 0;
            Scanner option = new Scanner(System.in);
            while (shipRemain >= 1 && ok == 0) {
                System.out.println("Press \"1\" to continue your turn!\nPress \"2\" to skip your turn!");
                byte choice = option.nextByte();
                if (choice == 1) {
                    System.out.println("You can continue your turn!");
                    System.out.println(getName() + "'s map: ");
                    showOpponentBoard();
                    beAttacked();
                    ok = 1;
                } else if (choice == 2) {
                    System.out.println("Your turn has ended!");
                    ok = 1;
                } else System.out.println("Invalid value!");
            }
        } else if (getBoard(x, y) == 'x') System.out.println("You hit the same coordinate!\nYour turn has ended!");
        else {
            setBoard(x, y, 'o');
            System.out.println("Miss!\nYour turn has ended!");
        }
    }

    public void shipCheck(int x, int y, Ship[] ships) {
        for (int list = 0; list < 5; list++) {
            if (x >= ships[list].getBowRow() && x <= ships[list].getSternRow() && y >= ships[list].getBowColumn() && y <= ships[list].getSternColumn()) {
                ships[list].setSizeShip(ships[list].getSizeShip() - 1);
                if (ships[list].getSizeShip() == 0) {
                    shipRemain--;
                    System.out.println(ships[list].getName() + " has been taken down!");
                    winCheck();
                    for (int a = ships[list].getBowRow(); a <= ships[list].getSternRow(); a++) {
                        for (int b = ships[list].getBowColumn(); b <= ships[list].getSternColumn(); b++) {
                            setBoard(a, b, 'X');
                        }
                    }
                }
                break;
            }
        }
    }

    public void winCheck() {
        if (shipRemain == 0) {
            System.out.println(getName() + " won!");
            System.out.println("Game over!");
            check = 1;
        }
    }
}
