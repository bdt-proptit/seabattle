public class GameBoard {
    private final char[][] board = new char[15][15];

    GameBoard() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                setBoard(i, j, 'w');
            }
        }
    }

    public char getBoard(int row, int column) {
        return board[row][column];
    }

    public void setBoard(int row, int column, char c) {
        board[row][column] = c;
    }

    public void showBoard() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0) System.out.print("    ");
                else if (i == 0) System.out.printf(" %4d ", j);
                else if (j == 0) System.out.printf(" %3d |", i);
                else {
                    if (getBoard(i, j) == 'x') {
                        System.out.print(" ");
                        System.out.printf(Color.HIT + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else if (getBoard(i, j) == 'o') {
                        System.out.print(" ");
                        System.out.printf(Color.MISS + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else if (getBoard(i, j) == 'd') {
                        System.out.print(" ");
                        System.out.printf(Color.DEAD + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else {
                        System.out.print(" ");
                        System.out.printf(Color.WATER + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    }
                }
            }
            System.out.println();
        }
    }

    public void showOpponentBoard() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0) System.out.print("    ");
                else if (i == 0) System.out.printf(" %4d ", j);
                else if (j == 0) System.out.printf(" %3d |", i);
                else {
                    if (getBoard(i, j) == 'x') {
                        System.out.print(" ");
                        System.out.printf(Color.HIT + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else if (getBoard(i, j) == 'o') {
                        System.out.print(" ");
                        System.out.printf(Color.MISS + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else if (getBoard(i, j) == 'd') {
                        System.out.print(" ");
                        System.out.printf(Color.DEAD + " %c ", getBoard(i, j));
                        System.out.printf(Color.RESET + " |");
                    } else {
                        System.out.print(" ");
                        System.out.print(Color.FOG + " f ");
                        System.out.printf(Color.RESET + " |");
                    }
                }
            }
            System.out.println();
        }
    }
}

