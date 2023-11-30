public class Grid {

    public String[][] board;
    private final int size = 10;

    public Grid() {
        board = new String[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Color.WATER + "~" + Color.RESET;
            }
        }
    }

    public void printGrid() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        System.out.println("  -------------------");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + "|");
            for (int j = 0; j < size; j++) {
                if (j == size - 1)
                    System.out.print(board[i][j] + "|");
                else
                    System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  -------------------");
    }

    public boolean checkExsitShip(String head, String last) {
        int headXIndex = head.toUpperCase().charAt(0) - 'A';
        int lastXIndex = last.toUpperCase().charAt(0) - 'A';
        int headYIndex = Integer.parseInt(head.substring(1)) - 1;
        int lastYIndex = Integer.parseInt(last.substring(1)) - 1;
        if (checkCoordinates(head) && checkCoordinates(last)) {
            if (headXIndex == lastXIndex) {
                for (int i = headYIndex; i <= lastYIndex; i++) {
                    if (board[headXIndex][i].equals(Color.SHIP + "S" + Color.RESET)) {
                        return true;
                    }
                }
            } else if (headYIndex == lastYIndex) {
                for (int i = headXIndex; i <= lastXIndex; i++) {
                    if (board[i][headYIndex].equals(Color.SHIP + "S" + Color.RESET)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkHit(String attack) {
        int attackXIndex = attack.toUpperCase().charAt(0) - 'A';
        int attackYIndex = Integer.parseInt(attack.substring(1)) - 1;
        if (checkCoordinates(attack)) {
            return board[attackXIndex][attackYIndex].equals(Color.HIT + "X" + Color.RESET) || board[attackXIndex][attackYIndex].equals(Color.MISS + "*" + Color.RESET);
        }
        return false;
    }

    public boolean checkCoordinates(String coordinates) {
        int xIndex = coordinates.toUpperCase().charAt(0) - 'A';
        int yIndex = Integer.parseInt(coordinates.substring(1)) - 1;
        return xIndex >= 0 && xIndex < size && yIndex >= 0 && yIndex < size;
    }

    public void printAttackAndShipGrid(Grid playerAttackGrid, Grid playerGrid) {
        System.out.printf("%-25s%-25s\n", "  Bảng tấn công", "   Bảng thuyền");
        System.out.printf("%-25s%-25s\n", "  1 2 3 4 5 6 7 8 9 10", "   1 2 3 4 5 6 7 8 9 10");
        System.out.printf("%-25s%-25s\n", " ---------------------", "  ---------------------");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + "|");
            for (int j = 0; j < size; j++) {
                if (j == size - 1)
                    System.out.print(playerAttackGrid.board[i][j] + "|");
                else
                    System.out.print(playerAttackGrid.board[i][j] + " ");
            }
            System.out.printf("%5c|",(char) ('A' + i));
            for (int j = 0; j < size; j++) {
                if (j == size - 1)
                    System.out.print(playerGrid.board[i][j] + "|");
                else
                    System.out.print(playerGrid.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("%-25s%-25s\n", " ---------------------", "  ---------------------");
    }


}




