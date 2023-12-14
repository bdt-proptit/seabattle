import java.util.Scanner;

public class Game {
    private Map p1 = new Map();
    private Map p2 = new Map();

    void printGrid(int[][] board) {
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
                if (board[i][j] == 1)
                    System.out.print("o" + " | ");
                else if (board[i][j] == 2)
                    System.out.print("x" + " | ");
                else
                    System.out.print(" " + " | ");

            }
            System.out.println();
        }
        System.out.println();

    }

    void show1() {
        p1.printGrid();
    }

    void show2() {
        p2.printGrid();
    }

    int checkWin() {
        int cond = 14;// 14
        // System.out.println(p1.getDown());
        if (p1.getDown() == cond)
            return 1;
        if (p2.getDown() == cond)
            return 2;
        return 0;
    }

    Scanner sc = new Scanner(System.in);

    void pause() {
        System.out.println("Enter de tiep tuc..");
        sc.nextLine();
        sc.nextLine();
    }

    void play() {

        int[][] board1 = new int[10][10], board2 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board1[i][j] = 0;
                board2[i][j] = 0;
            }
        }
        // int[][][] boards = new int[2][10][10];
        // boards[0] = board1;
        // boards[0] = board2;
        int turn = 1, input;
        while (true) {
            turn = (turn + 1) % 2;
            // System.out.println(turn);

            while (true) {
                System.out.println("Player " + (turn + 1) + ":");
                printMenu();
                input = sc.nextInt();
                p1.clear();
                if (input == 1) {
                    if (turn == 0)
                        this.show1();
                    else
                        this.show2();
                    pause();
                }
                if (input == 2) {
                    if (turn == 0) {
                        printGrid(board1);
                    } else
                        printGrid(board2);

                    System.out.println("Vi tri tan cong");
                    System.out.print("X: ");
                    int x = sc.nextInt() - 1;
                    System.out.print("Y: ");
                    int y = sc.nextInt() - 1;
                    if (turn == 0) {
                        if (p2.checkShip(x, y))
                            board1[y][x] = 1;
                        else
                            board1[y][x] = 2;

                        printGrid(board1);
                        if (checkWin() == 1) {
                            System.out.println("Player 1 wins");
                            return;
                        } else if (checkWin() == 2) {
                            System.out.println("Player 2 wins");
                            return;
                        }
                        pause();
                    } else {
                        if (p1.checkShip(x, y))
                            board2[y][x] = 1;
                        else
                            board2[y][x] = 2;

                        printGrid(board2);
                        if (checkWin() == 1) {
                            System.out.println("Player 1 wins");
                            return;
                        } else if (checkWin() == 2) {
                            System.out.println("Player 2 wins");
                            return;
                        }
                        pause();
                    }
                    break;
                }
                // System.out.println(checkWin());
                // if (checkWin() == 1) {
                // System.out.println("Player 1 wins");
                // return;
                // } else if (checkWin() == 2) {
                // System.out.println("Player 2 wins");
                // return;
                // }
            }

        }
    }

    void printMenu() {

        System.out.println("Lua chon:");
        System.out.println("1. Xem bang cua toi.");
        System.out.println("2. Tan cong.");
        System.out.print("> ");
    }
}
