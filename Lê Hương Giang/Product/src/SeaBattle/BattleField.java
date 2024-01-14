package SeaBattle;

public class BattleField extends GameSystem {
    public char[][] myBoard = new char[15][15], opponentBoard = new char[15][15];

    public BattleField() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                myBoard[i][j] = ' ';
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                opponentBoard[i][j] = ' ';
            }
        }
    }

    public void createMyBoard(String myName) {
        System.out.println(myName);
        System.out.print("-  ");
        for (int column = 1; column <= 10; ++column) { // in cột
            if (column < 10) System.out.print(column + "  ");
            else System.out.print(column + "|");
        }
        System.out.print("\n");
        for (int row = 0; row < 10; ++row) {
            int row_present = row + 1;
            if (row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");

            for (int column = 0; column < 10; ++column) {
                System.out.print(myBoard[row][column] + " |");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------------------");
    }

    public void displayBoard(String myName, String opponentName) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.print(YELLOW + myName + ANSI_RESET);
        for (int column = 0; column < 33 - myName.length(); ++column) {
            System.out.print(" ");
        }
        System.out.print("       ");
        System.out.print(YELLOW + opponentName + ANSI_RESET);
        for (int column = 0; column < 33 - opponentName.length(); ++column) {
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.print("-  ");
        for (int column = 1; column <= 10; ++column) { // in số cột của bảng của bản thân
            if (column < 10) System.out.print(column + "  ");
            else System.out.print(column + "|");
        }
        System.out.print(BLUE + "~~~~~" + ANSI_RESET + "| -  ");

        for (int column = 1; column <= 10; ++column) { // in số cột của bảng của đối thủ
            if (column < 10) System.out.print(column + "  ");
            else System.out.println(column + "|");
        }
        // in hàng
        for (int row = 0; row < 10; ++row) {
            int row_present = row + 1;
            if (row < 9) System.out.print(row_present + " |"); // in cột của mình
            else System.out.print(row_present + "|");

            for (int column = 0; column < 10; ++column) {
                System.out.print(myBoard[row][column] + " |");
            }
            System.out.print(BLUE + "~~~~~" + ANSI_RESET +"| ");
            if (row < 9)
                System.out.print(row_present + " |"); // in cột của đối thủ
            else
                System.out.print(row_present + "|");
            for (int column = 0; column < 10; ++column) {
                System.out.print(opponentBoard[row][column] + " |");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}
