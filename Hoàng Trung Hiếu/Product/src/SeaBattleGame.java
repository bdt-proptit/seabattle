import java.util.Scanner;
class SeaBattleGame {
    Player[] players;
    boolean gameOver;

    public SeaBattleGame(String player1Name, String player2Name) {
        this.players = new Player[2];
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
        this.gameOver = false;
    }

    public void startGame() {
        // Đặt tàu cho mỗi người chơi
        for (Player player : players) {
            System.out.println(player.name + ", đặt tàu của bạn:");
            player.placeShips();
            System.out.println("Tàu của " + player.name + " đã được đặt.");
        }

        // Hiển thị thông tin trước khi bắt đầu
        System.out.println("Bắt đầu trò chơi Sea Battle!");
        int currentPlayerIndex = 0;

        while (!gameOver) {
     //       Player currentPlayer = players[currentPlayerIndex];

            for (Player currentPlayer : players) {
                if (gameOver) break;

                // Hiển thị bảng của người chơi hiện tại
                System.out.println("Lượt của " + currentPlayer.name);
                System.out.println("Bảng của " + currentPlayer.name + ":");
                currentPlayer.board.displayBoard();

                // Lựa chọn hành động của người chơi
                System.out.println("Lựa chọn hành động:");
                System.out.println("1. Xem bảng của mình");
                System.out.println("2. Bắn tàu đối phương");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Bảng của " + currentPlayer.name + ":");
                        currentPlayer.board.displayBoard();
                        break;
                    case 2:
                        System.out.println("Nhập tọa độ bắn (ví dụ: A5):");
                        System.out.print("Nhập hàng (1-10): ");
                        int x = scanner.nextInt() - 1;
                        System.out.print("Nhập cột (A-J): ");
                        String yString = scanner.next().toUpperCase();
                        int y = yString.charAt(0) - 'A';

                        boolean hit = currentPlayer.shoot(x, y, players[(currentPlayerIndex + 1) % 2].board);

                        if (hit) {
                            if (currentPlayer.hasLost()) {
                                gameOver = true;
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;

            }
        }

        // Hiển thị kết quả khi game kết thúc
        System.out.println("Trò chơi kết thúc!");
        for (Player player : players) {
            System.out.println("Bảng của " + player.name + ":");
            player.board.displayBoard();
        }
        System.out.println("Kết quả:");
        for (Player player : players) {
            if (player.hasLost()) {
                System.out.println(player.name + " đã phá hủy hết tàu của đối thủ và thắng cuộc!");
            } else {
                System.out.println(player.name + " đã thua cuộc.");
            }
        }
    }
}