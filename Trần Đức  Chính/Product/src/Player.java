import java.util.Scanner;

public class Player {
    private int hit = 0;

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public final Grid playerGrid = new Grid();

    public void placeShip() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập tọa độ đầu thuyền: ");
            String head = sc.nextLine();
            System.out.print("Nhập tọa độ đuôi thuyền: ");
            String last = sc.nextLine();
            int headXIndex = head.toUpperCase().charAt(0) - 'A';
            int lastXIndex = last.toUpperCase().charAt(0) - 'A';
            int headYIndex = Integer.parseInt(head.substring(1)) - 1;
            int lastYIndex = Integer.parseInt(last.substring(1)) - 1;
            if (playerGrid.checkExsitShip(head, last)) {
                System.out.println("\nVị trí đã có thuyền");
                System.out.println("Vui lòng nhập lại tọa độ\n");
                continue;
            }
            if (!playerGrid.checkCoordinates(head) || !playerGrid.checkCoordinates(last)) {
                System.out.println("\nTọa độ không hợp lệ");
                System.out.println("Vui lòng nhập lại tọa độ\n");
                continue;
            }
            if (headXIndex == lastXIndex) {
                for (int i = headYIndex; i <= lastYIndex; i++) {
                    playerGrid.board[headXIndex][i] = Color.SHIP + "S" + Color.RESET;
                }
                System.out.println("Đặt thuyền thành công");
                break;
            } else if (headYIndex == lastYIndex) {
                for (int i = headXIndex; i <= lastXIndex; i++) {
                    playerGrid.board[i][headYIndex] = Color.SHIP + "S" + Color.RESET;
                }
                System.out.println("Đặt thuyền thành công");
                break;
            } else {
                System.out.println("\nTọa độ không hợp lệ");
                System.out.println("Vui lòng nhập lại tọa độ");
            }
        }
    }

    public void printPlayerGrid(Grid playerAttackGrid, Grid playerGrid) {
        playerGrid.printAttackAndShipGrid(playerAttackGrid, playerGrid);
    }

    public boolean attack(Grid playerGrid, Grid playerAttackGrid) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ muốn bắn: ");
        while (true) {

            String attack = sc.nextLine();
            int attackXIndex = attack.toUpperCase().charAt(0) - 'A';
            int attackYIndex = Integer.parseInt(attack.substring(1)) - 1;
            if (playerAttackGrid.checkHit(attack)) {
                System.out.println("\nVị trí đã bắn!");
                System.out.print("Vui lòng nhập lại tọa độ: ");
                continue;
            }
            if (!playerAttackGrid.checkCoordinates(attack)) {
                System.out.println("\nTọa độ không hợp lệ!");
                System.out.print("Vui lòng nhập lại tọa độ: ");
                continue;
            }
            if (playerGrid.board[attackXIndex][attackYIndex].equals(Color.SHIP + "S" + Color.RESET)) {
                playerGrid.board[attackXIndex][attackYIndex] = Color.HIT + "X" + Color.RESET;
                playerAttackGrid.board[attackXIndex][attackYIndex] = Color.HIT + "X" + Color.RESET;
                System.out.println("Bắn trúng!");
                return true;
            } else {
                playerGrid.board[attackXIndex][attackYIndex] = Color.MISS + "*" + Color.RESET;
                playerAttackGrid.board[attackXIndex][attackYIndex] = Color.MISS + "*" + Color.RESET;
                System.out.println("Bắn trượt!");
                return false;
            }
        }
    }

}
