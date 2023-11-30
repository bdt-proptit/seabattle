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
        showBoard();
        while (shipRemain < 5) {

            Scanner input = new Scanner(System.in);
            String name;
            int sizeBoat;
            if (shipRemain < 2) {
                name = "Patrol Boat";
                sizeBoat = 2;
            } else if (shipRemain == 2) {
                name = "Destroyer Boat";
                sizeBoat = 4;
            } else if (shipRemain == 3) {
                name = "Submarine";
                sizeBoat = 3;
            } else {
                name = "Battle Ship";
                sizeBoat = 5;
            }
            System.out.println("Setup your " + name + "with size 1x" + sizeBoat + ":");
            ships[shipRemain] = new Ship();
            System.out.println("Enter bow's coordinate: ");
            System.out.print("Bow's row: ");
            int bowRow = input.nextInt();
            ships[shipRemain].setBowRow(bowRow);
            System.out.print("Bow's column: ");
            int bowColumn = input.nextInt();
            ships[shipRemain].setBowColumn(bowRow);
            System.out.println("Enter stern's coordinate: ");
            System.out.print("Stern's row: ");
            int sternRow = input.nextInt();
            ships[shipRemain].setSternRow(bowRow);
            System.out.print("Stern's column: ");
            int sternColumn = input.nextInt();
            ships[shipRemain].setSternColumn(bowRow);
            shipRemain++;
            for (int i = bowRow; i <= sternRow; i++) {
                for (int j = bowColumn; j <= sternColumn; j++) {
                    setBoard(i, j, 's');
                }
            }
            showBoard();
            if (shipRemain == 5) {
                System.out.println("-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------\n" +
                        "-------------------------------------------------------------------");
            }
        }
    }

    public void beAttacked() {
        Scanner input = new Scanner(System.in);
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
        } else {
            setBoard(x, y, 'o');
            System.out.println("Miss!");
        }
    }

    public void shipCheck(int x, int y, Ship[] ships) {
        int bound = shipRemain;
        for (int list = 0; list < bound; list++) {
            if (x >= ships[list].getBowRow() && x <= ships[list].getBowColumn() && y >= ships[list].getSternRow() && y <= ships[list].getSternColumn()) {
                ships[list].setSizeShip(ships[list].getSizeShip() - 1);
                if (ships[list].getSizeShip() == 0) {
                    shipRemain--;
                    System.out.println(ships[list].getName() + " has been taken down!");
                    winCheck();
                }
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
