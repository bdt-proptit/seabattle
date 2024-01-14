class GameBoard {
    int[][] board;
    Cell[][] cells;
    public GameBoard() {
        this.board = new int[10][10];
        this.cells = new Cell[10][10];
        initializeCells();
    }


    // Hàm khởi tạo các ô trên bảng
    private void initializeCells() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    public boolean placeShip(int x, int y, int size, boolean vertical) {
        // Kiểm tra hướng đặt tàu
        if (vertical) {
            if (y + size > 10) {
                System.out.println("\033[1;31m Không thể đặt tàu vì vượt quá biên ngang.\033[0m");
                return false;
            }
            for (int i = y; i < y + size; i++) {
                if (board[x][i] != 0) {
                    System.out.println("\033[1;31m Không thể đặt tàu vì trùng với tàu khác.\033[0m");
                    return false;
                }
            }
            for (int i = y; i < y + size; i++) {
                board[x][i] = 1; // Gán giá trị ô là 1 để thể hiện có tàu
            }
        } else {
            if (x + size > 10) {
                System.out.println("\033[1;31m Không thể đặt tàu vì vượt quá biên doc.\033[0m");
                return false;
            }
            for (int i = x; i < x + size; i++) {
                if (board[i][y] != 0) {
                    System.out.println("\033[1;31m Không thể đặt tàu vì trùng với tàu khác.\033[0m");
                    return false;
                }
            }
            for (int i = x; i < x + size; i++) {
                board[i][y] = 1; // Gán giá trị ô là 1 để thể hiện có tàu
            }
        }

        return true; // Đặt tàu thành công
    }

    public void displayBoard() {
        System.out.println("Bảng trò chơi:");
        System.out.println("  A B C D E F G H I J"); // Đánh số cột

        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + " "); // Đánh số hàng
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". "); // Ô trống
                } else if (board[i][j] == 1) {
                    System.out.print("O "); // Ô có tàu
                } else if (board[i][j] == 2) {
                    System.out.print("X "); // Ô đã bắn trúng tàu
                } else if (board[i][j] == 3) {
                    System.out.print("- "); // Ô đã bắn trượt (không có tàu)
                }
            }
            System.out.println();
        }
    }
}