import java.util.Scanner;

public class Map {
    void clearAndPrint() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        this.printGrid();
    }

    void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private int size = 10, down = 0;
    private int[][] grid = new int[size][size];

    Map() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 1;
            }
        }
        // createAllShips();
        // grid[2][3] = 1;
    }

    Boolean checkShip(int x, int y) {
        return grid[y][x] == 1;
    }

    void printGrid() {
        System.out.print("     ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + "   ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------------------------------------");

            if (i != 9)
                System.out.print(i + 1 + "  | ");
            else
                System.out.print(i + 1 + " | ");

            for (int j = 0; j < 10; j++) {
                if (grid[j][i] == 1)
                    System.out.print("o" + " | ");
                else
                    System.out.print(" " + " | ");

            }
            System.out.println();
        }
        System.out.println();

    }

    void createShip(int size) {
        // this.printGrid();
        System.out.println("Tau nam ngang(1) hay doc(2): ");
        Scanner sc = new Scanner(System.in);
        int rotation, x, y;
        rotation = sc.nextInt();
        clear();
        this.printGrid();
        System.out.println("Toa do dinh tren ben trai cua tau.");
        System.out.print("X: ");
        x = sc.nextInt();
        System.out.print("Y: ");
        y = sc.nextInt();
        addShip(rotation, size, x, y);
        clear();
        // TODO: check invalid
    }

    void createAllShips() {
        System.out.println("Nhap toa do cua cac tau");
        System.out.println("Thiet giap ham (1x5)");
        createShip(5);
        System.out.println("Tau khu truc (1x4)");
        createShip(4);
        System.out.println("Tau ngam (1x3)");
        createShip(3);
        System.out.println("Tau tuan tra (1x2)");
        createShip(2);
        System.out.println("Tau tuan tra (1x2)");
        createShip(2);
        clear();
    }

    void addShip(int rotation, int size, int x, int y) {
        if (rotation == 1) {
            for (int i = 0; i < size; i++) {
                grid[x + i - 1][y - 1] = 1;
            }
        } else {
            for (int i = 0; i < size; i++) {
                grid[x - 1][y + i - 1] = 1;
            }
        }
    }

    public int getDown() {
        return down;
    }
}
