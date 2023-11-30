class GameBoard {
    int[][] board; // Mảng 2 chiều biểu diễn bảng
    Ship[] ships; // Mảng lưu trữ các tàu

    // Khởi tạo bảng và các tàu
    public GameBoard() {
        this.board = new int[10][10]; // Bảng kích thước 10x10
        this.ships = new Ship[5]; // Mảng lưu trữ 5 tàu
        // Khởi tạo các tàu và đặt giá trị cho ships[i] tương ứng
    }

    // Phương thức đặt tàu vào bảng
    public boolean placeShip(int x, int y, int size, boolean vertical) {
        // Kiểm tra hướng đặt tàu
        if (vertical) {
            if (y + size > 10) {
                System.out.println("Không thể đặt tàu vì vượt quá biên dọc.");
                return false;
            }
            for (int i = y; i < y + size; i++) {
                if (board[x][i] != 0) {
                    System.out.println("Không thể đặt tàu vì trùng với tàu khác.");
                    return false;
                }
            }
            for (int i = y; i < y + size; i++) {
                board[x][i] = 1; // Gán giá trị ô là 1 để thể hiện có tàu
            }
        } else {
            if (x + size > 10) {
                System.out.println("Không thể đặt tàu vì vượt quá biên ngang.");
                return false;
            }
            for (int i = x; i < x + size; i++) {
                if (board[i][y] != 0) {
                    System.out.println("Không thể đặt tàu vì trùng với tàu khác.");
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
                    System.out.print("- "); // Ô đã bắn nhưng không có tàu
                }
            }
            System.out.println();
        }
    }
}