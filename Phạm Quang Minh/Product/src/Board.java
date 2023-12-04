public class Board {
    public char[][] createBoard() {
        char[][] board = new char[15][15];
        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 10; j++)
                board[i][j] = ' ';
        return board;
    }

    private void printShip(char[][] board, int row, int column) {
        if (board[row][column] >= '2' && board[row][column] <= '5') {
            String[] color = { "\u001B[41m", "\u001B[42m", "\u001B[46m", "\u001B[44m" };
            int index = (int) (board[row][column] - '0');
            System.out.print(MakeColor.reset + color[index - 2]);
            System.out.print(" " + "s" + " |");
        } else {
            if (board[row][column] == 'x')
                System.out.print(MakeColor.reset + MakeColor.backgoundPurple);
            else if (board[row][column] == 'o')
                System.out.print(MakeColor.reset + MakeColor.backgoundYellow);
            System.out.print(" " + board[row][column] + " |");
        }
        if (board[row][column] != ' ') {
            System.out.print(MakeColor.reset + MakeColor.green);
        }
    }

    public void displayBoardShip(char[][] board) {
        System.out.print(MakeColor.reset + MakeColor.green);
        for (int i = 0; i < 44; i++)
            System.out.print("_");
        System.out.println();
        System.out.print("|  |");
        for (int i = 1; i <= 10; i++)
            System.out.print(String.format(" %-2s|", i));
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(String.format("|%2s|", i));
            for (int j = 1; j <= 10; j++)
                printShip(board, i, j);
            System.out.println();
        }
        System.out.print(MakeColor.reset + MakeColor.blue);
    }

    public void updateBoardShip(Ship ship, Player player) {
        char length = (char) (ship.getLength() + 48);
        char[][] board = player.getBoard();
        if (ship.getColumnStart() == ship.getColumnEnd()) {
            int begin = Math.min(ship.getRowEnd(), ship.getRowStart());
            int end = Math.max(ship.getRowEnd(), ship.getRowStart());
            for (int i = begin; i <= end; i++) {
                board[i][ship.getColumnStart()] = length;
            }
        } else {
            int begin = Math.min(ship.getColumnEnd(), ship.getColumnStart());
            int end = Math.max(ship.getColumnEnd(), ship.getColumnStart());
            for (int i = begin; i <= end; i++)
                board[ship.getRowStart()][i] = length;
        }
        player.setBoard(board);
    }

    private void print25Space() {
        System.out.print(String.format("%25s", ""));
    }

    private void printColumn() {
        System.out.print("|  |");
        for (int i = 1; i <= 10; i++)
            System.out.print(String.format(" %-2s|", i));
    }

    private void printRow(char[][] board, int row) {
        System.out.print(String.format("|%2s|", row));
        for (int j = 1; j <= 10; j++) {
            printShip(board, row, j);
        }
    }

    private void print_() {
        for (int i = 0; i < 44; i++)
            System.out.print("_");
    }

    public void displayBoardGame(char[][] board, char[][] boardOpposite) {
        System.out.print(MakeColor.reset + MakeColor.green);
        print_();
        print25Space();
        print_();
        System.out.println();
        printColumn();
        print25Space();
        printColumn();
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            printRow(board, i);
            print25Space();
            printRow(boardOpposite, i);
            System.out.println();
        }
        System.out.print(MakeColor.reset + MakeColor.blue);
    }
}
