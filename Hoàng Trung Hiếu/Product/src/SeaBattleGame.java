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

        // Biến chỉ số của người chơi hiện tại
        int currentPlayerIndex = 0;

        while (!gameOver) {
            Player currentPlayer = players[currentPlayerIndex];

            // Hiển thị bảng của người chơi hiện tại
            System.out.println("Lượt của " + currentPlayer.name);
            System.out.println("Bảng của " + currentPlayer.name + ":");
            currentPlayer.board.displayBoard();

            // Lựa chọn hành động của người chơi
            System.out.println("Lựa chọn hành động:");
            System.out.println("1. Xem bảng của mình");
            System.out.println("2. Bắn tàu đối phương");
            System.out.println("3. Kết thúc lượt");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bảng của " + currentPlayer.name + ":");
                    currentPlayer.board.displayBoard();
                    break;
                case 2:
                    System.out.println("Nhập tọa độ bắn (ví dụ: A5):");
                    // Xử lý việc bắn tàu ở vị trí target của đối phương
                    // currentPlayer.shoot(target); // Cần triển khai phương thức này trong class Player
                    break;
                case 3:
                    System.out.println(currentPlayer.name + " đã kết thúc lượt.");
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

            // Kiểm tra điều kiện kết thúc trò chơi
            if (isGameOver()) {
                gameOver = true;
                System.out.println("Trò chơi kết thúc!");
                // Hiển thị thông tin về người chiến thắng và bảng kết quả
                // displayWinner(); // Cần triển khai phương thức này
            }

            // Chuyển lượt sang người chơi tiếp theo
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }

    // Inside SeaBattleGame class
    public boolean isGameOver() {
        for (Player player : players) {
            Ship[] playerShips = player.getShips(); // Lấy danh sách tàu của người chơi
            for (Ship ship : playerShips) {
                if (ship != null && !ship.isSunk()) { // Kiểm tra ship có null không trước khi gọi isSunk()
                    return false; // Nếu có tàu chưa bị chìm, trò chơi chưa kết thúc
                }
            }
        }
        return true; // Nếu không còn tàu nào chưa chìm, trò chơi đã kết thúc
    }

}
