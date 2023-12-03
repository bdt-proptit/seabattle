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
            if (shipRemain < 2) {
                name = "Patrol Boat";
                sizeShip = 2;
            } else if (shipRemain == 2) {
                name = "Destroyer Boat";
                sizeShip = 4;
            } else if (shipRemain == 3) {
                name = "Submarine";
                sizeShip = 3;
            } else {
                name = "Battle Ship";
                sizeShip = 5;
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
                shipRemain++;
                int check = 0;
                if (bowRow < 1 || bowRow > 10 || sternRow < 1 || sternRow > 10 || bowColumn < 1 || bowColumn > 10 || sternColumn < 1 || sternColumn > 10) {
                    check = 1;
                    shipRemain--;
                    System.out.println("Invalid value!");
                } else {
                    if (bowRow == sternRow) {
                        if (bowColumn != sternColumn - sizeShip + 1 && bowColumn != sternColumn + sizeShip - 1) {
                            check = 1;
                            shipRemain--;
                            System.out.println("Invalid value!");
                        }
                    } else {
                        if (bowColumn != sternColumn) {
                            check = 1;
                            shipRemain--;
                            System.out.println("Invalid value!");
                        } else {
                            if (bowRow != sternRow - sizeShip + 1 && bowRow != sternRow + sizeShip - 1) {
                                check = 1;
                                shipRemain--;
                                System.out.println("Invalid value!");
                            }
                        }
                    }
                    if (check == 0) {
                        int swap = 0;
                        if (bowRow > sternRow) {
                            swap = bowRow;
                            bowRow = sternRow;
                            sternRow = swap;
                        }
                        if (bowColumn > sternColumn) {
                            swap = bowColumn;
                            bowColumn = sternColumn;
                            sternColumn = swap;
                        }
                        for (int i = bowRow; i <= sternRow; i++)
                            for (int j = bowColumn; j <= sternColumn; j++) {
                                if (getBoard(i, j) == 's') {
                                    check = 1;
                                    shipRemain--;
                                    System.out.println("Invalid value!");
                                    break;
                                }
                            }
                    }
                    if (check == 0) {
                        for (int z = bowRow; z <= sternRow; z++)
                            for (int t = bowColumn; t <= sternColumn; t++) {
                                setBoard(z, t, 's');
                            }
                        break;
                    }
                }
                System.out.println("Enter to continue...");
                sc.nextLine();
                ClearScreen.clrscr();
            }
            showBoard();
            System.out.println("Enter to continue...");
            sc.nextLine();
            ClearScreen.clrscr();
        }
    }

    public void beAttacked() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter fire coordinate: ");
        System.out.print("x: ");
        int x = input.nextInt();
        System.out.print("y: ");
        int y = input.nextInt();
        hitCheck(x, y);
    }

    public void hitCheck(int x, int y) {
        if (getBoard(x, y) == 's') {
            System.out.println("Hit!");
            setBoard(x, y, 'x');
            shipCheck(x, y, ships);
            int check = 0;
            Scanner option = new Scanner(System.in);
            while (check == 0) {
                System.out.println("Press \"1\" to continue your turn!\nPress \"2\" to skip your turn!");
                byte choice = option.nextByte();
                if (choice == 1) {
                    System.out.println("You can continue your turn!");
                    System.out.println(getName() + "'s map: ");
                    showOpponentBoard();
                    beAttacked();
                    check = 1;
                } else if (choice == 2) {
                    System.out.println("Your turn has ended!");
                    check = 1;
                } else {
                    System.out.println("Invalid value!");
                }
            }
        } else if (getBoard(x, y) == 'x') {
            System.out.println("Miss!\nYour turn has ended!");
        } else {
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
                            setBoard(a, b, 'd');
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
