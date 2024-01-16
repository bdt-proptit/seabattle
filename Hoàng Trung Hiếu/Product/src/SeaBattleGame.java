import java.util.Scanner;

class SeaBattleGame {
    Player[] players;
    boolean gameOver;
    private Scanner scanner;

    public SeaBattleGame(String player1Name, String player2Name) {
        this.players = new Player[2];
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
        this.gameOver = false;
        this.scanner = new Scanner(System.in);
    }

    private void displayPlayerBoard(Player player) {
        System.out.print(player.name);
        System.out.println("'s Board:");
        player.board.displayBoard();
    }

    private int endTurnOption() {
        System.out.println("Chọn hành động:");
        System.out.println("1. Xem bảng của mình");
        System.out.println("2. Bắn tàu đối phương");
        System.out.println("3. Kết thúc lượt");
        System.out.println("4. Xem bảng các ô đã bắn đối thủ");

        return scanner.nextInt();
    }

    public void setUpGame() {
        // Option các loại tàu
        System.out.println(" \033[1;31m! Trước khi bắt đầu, mỗi người chơi sẽ đặt các loại tàu sau:\033[0m");
        System.out.println(" \033[3;1;31m*** 2 Thuyền Tuần Tra (Patrol Boat) kích thước 1x2\033[0m");
        System.out.println(" \033[3;1;31m*** 1 Tàu Khu Trục (Destroyer Boat) kích thước 1x4\033[0m");
        System.out.println(" \033[3;1;31m*** 1 Tàu Ngầm (Submarine) kích thước 1x3\033[0m");
        System.out.println(" \033[3;1;31m*** 1 Thiết Giáp Hạm (Battle Ship) kích thước 1x5\033[0m");

        // Đặt tàu cho mỗi người chơi
        for (Player player : players)  {
            System.out.println(player.name + ", đặt tàu của bạn:");
            player.placeShips();
            System.out.println("Tàu của " + player.name + " đã được đặt.");
            displayPlayerBoard(player);

            System.out.println("\n\n--------------------------------------------------\n\n");
        }

        System.out.println("\033[1;31m" + "\n\nBAT DAU TRO CHOI \n\n" + "\033[0m");
    }

    public void startGame() {
        int currentPlayerIndex = 0;

        while (!gameOver) {
            Player currentPlayer = players[currentPlayerIndex];

            // Hiển thị bảng của người chơi hiện tại
            System.out.println("\033[1;31m"+ "Lượt của " + currentPlayer.name + "\033[0m");
            System.out.println("\033[1;31m"+ "Bảng của " + currentPlayer.name + ":" + "\033[0m");
            currentPlayer.board.displayBoard();

            // Lựa chọn hành động của người chơi
            int choice = endTurnOption();

            switch (choice) {
                case 1:
                    displayPlayerBoard(currentPlayer);
                    break;
                case 2:
                    System.out.println("Nhập tọa độ bắn (ví dụ: A5):");
                    System.out.print("Nhập hàng (1-10): ");
                    int x = scanner.nextInt() - 1;
                    System.out.print("Nhập cột (A-J): ");
                    String yString = scanner.next().toUpperCase();
                    int y = yString.charAt(0) - 'A';

                    // Check if the selected cell has a ship
                    if (players[(currentPlayerIndex + 1) % 2].board.board[x][y] == 1) {
                        System.out.println("Bắn trúng tàu đối phương!");
                        players[(currentPlayerIndex + 1) % 2].board.cells[x][y].setHit(true);
                        players[(currentPlayerIndex + 1) % 2].board.board[x][y] = 2; // Change symbol to 'X'
                    } else {
                        System.out.println("Bắn trượt!");
                        players[(currentPlayerIndex + 1) % 2].board.board[x][y] = 3; // Change symbol to '-'
                    }

                    break;
                case 3:
                    currentPlayerIndex = (currentPlayerIndex + 1) % 2; // Chuyển đến người chơi tiếp theo
                    gameOver = isGameOver(); // Kiểm tra điều kiện kết thúc
                    break;

                    case 4:
                    displayOpponentHitCells(players[(currentPlayerIndex + 1) % 2]);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
            if (gameOver) {
                // Hiển thị thông báo kết quả thắng cuộc
                Player winner = players[(currentPlayerIndex + 1) % 2];
                System.out.println("\033[1;31m" + "Trò chơi kết thúc! " + winner.name + " thắng cuộc!" + "\033[0m");
            }
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            boolean hasRemainingShips = false; // Thêm biến để kiểm tra có tàu còn lại hay không
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (player.board.board[i][j] == 1) {
                        hasRemainingShips = true;
                        break;
                    }
                }
                if (hasRemainingShips) {
                    break; // Nếu có tàu còn lại, không cần kiểm tra các ô khác
                }
            }

            if (!hasRemainingShips) {
                return true; // Nếu không còn tàu nào trên bảng, game kết thúc
            }
        }
        return false; // Nếu có ít nhất một người chơi còn tàu, game chưa kết thúc
    }
    private void displayOpponentHitCells(Player opponent) {
        System.out.println("Bảng các ô bạn đã bắn trên bảng của " + opponent.name + ":");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (opponent.board.cells[i][j].isHit()) {
                    System.out.print("X "); // Đã bắn trúng ô của đối thủ
                } else {
                    System.out.print(". "); // Ô chưa bị bắn
                }
            }
            System.out.println();
        }
    }
}
