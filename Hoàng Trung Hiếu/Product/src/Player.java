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
            return new Ship[0];
        }
        return ships.toArray(new Ship[0]);
    }

    // Phương thức đặt tàu
    public void placeShips() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 1; i++) { // Đặt 5 loại tàu như trong yêu cầu
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
            System.out.print("Chọn hướng (1 - ngang, 0 - dọc): ");
            boolean vertical = scanner.nextInt() == 1;

            boolean placed = board.placeShip(x, y, size, vertical);
            if (!placed) {
                System.out.println("Không thể đặt tàu ở vị trí này. Vui lòng chọn vị trí khác.");
                i--;
            }
        }
    }

    public boolean shoot(int x, int y, GameBoard opponentBoard) {
        Cell targetCell = opponentBoard.cells[x][y];

        if (targetCell.isHit()) {
            System.out.println("Ô này đã được bắn trúng trước đó.");
            return false;
        } else {
            targetCell.setHit(true);

            if (targetCell.hasShip()) {
                System.out.println("Bắn trúng phần của tàu đối thủ!");

                // Cập nhật thông tin trên bảng của đối thủ
                opponentBoard.board[x][y] = 2; // Đánh dấu ô đã bắn trúng tàu của đối thủ

                Ship targetShip = targetCell.getShip();
                if (targetShip != null) {
                    targetShip.updateHitStatus();


                    if (targetShip.isSunk()) {
                        System.out.println("Đối thủ đã bắn hết các ô của tàu của bạn!");
                    }
                }

                // Kiểm tra nếu tàu đã bị bắn hết các ô
                boolean allCellsHit = true;
                for (int i = 0; i < targetShip.getSize(); i++) {
                    Cell cell = targetShip.getCell(i);
                    if (!cell.isHit()) {
                        allCellsHit = false;
                        break;
                    }
                }
                if (allCellsHit) {
                    System.out.println("Đối thủ đã bắn hết các ô của tàu của bạn!");
                }

                return true; // Trả về true khi bắn trúng tàu
            } else {
                System.out.println("Bắn trượt!");
                opponentBoard.board[x][y] = 3;
                return false;
            }
        }
    }
    public boolean hasLost() {
        Ship[] playerShips = getShips();
        for (Ship ship : playerShips) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
