import java.util.Scanner;
import java.util.List;
class Player {
    String name;
    GameBoard board;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.board = new GameBoard();
    }
    private List<Ship> ships;
    public Ship[] getShips() {
        if (ships == null) {
            return new Ship[0]; // Trả về mảng rỗng nếu ships chưa được khởi tạo
        }
        return ships.toArray(new Ship[0]); // Chuyển đổi List thành mảng
    }

    // Phương thức đặt tàu
    public void placeShips() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) { // Đặt 5 loại tàu như trong yêu cầu
            int size;
            if (i == 0 || i == 1) {
                size = 2; // 2 thuyền tuần tra
            } else if (i == 2) {
                size = 3; // 1 tàu ngầm
            } else if (i == 3) {
                size = 4; // 1 tàu khu trục
            } else {
                size = 5; // 1 thiết giáp hạm
            }

            System.out.println("Đặt tàu thứ " + (i + 1) + " (kích thước " + size + "):");

            // Nhập vị trí và hướng của tàu
            System.out.print("Nhập hàng (1-10): ");
            int x = scanner.nextInt() - 1; // Chuyển đổi từ 1-10 thành 0-9
            System.out.print("Nhập cột (A-J): ");
            String yString = scanner.next().toUpperCase();
            int y = yString.charAt(0) - 'A'; // Chuyển đổi từ A-J thành 0-9
            System.out.print("Chọn hướng (0 - ngang, 1 - dọc): ");
            boolean vertical = scanner.nextInt() == 1;

            boolean placed = board.placeShip(x, y, size, vertical);
            if (!placed) {
                System.out.println("Không thể đặt tàu ở vị trí này. Vui lòng chọn vị trí khác.");
                i--; // Nếu không thể đặt tàu, lặp lại lần đặt tàu này
            }
        }
    }
}
