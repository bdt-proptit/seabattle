import java.util.Scanner;

public class GameMenu {
    private DisplayMessage displayMessage = new DisplayMessage();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Battleship Game");
        while (true) {
            displayMessage.printMenu();
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    displayMessage.printMessage("Chế độ chơi PVP\n");
                    char ask;
                    do {
                        PVP();
                        displayMessage.printMessage("Bạn có muốn chơi tiếp không (Y/N): ");
                        ask = sc.nextLine().charAt(0);
                    } while (ask == 'Y' || ask == 'y');
                    System.out.println("Cảm ơn bạn đã chơi ♥");
                    return;
                case 2:
                    displayMessage.printMessage("Chế độ chơi đang được phát triển\n\n");
                    break; // Hiện tại chưa được phát triển nên sẽ để break để chuyển về Menu
                case 3:
                    displayMessage.printRules();
                    Delay.delay(5000); // Delay 5s để đọc luật
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã chơi ♥");
                    return;
                default:
                    System.out.print("Vui lòng chọn lại: ");
            }
        }
    }


    public void PVP() {
        Player player1 = new Player();
        Player player2 = new Player();
        Grid player1AttackGrid = new Grid();
        Grid player2AttackGrid = new Grid();
        System.out.println("--------------------------------");
        System.out.println("\nNgười chơi 1 đặt thuyền\n");
        player1.playerGrid.printGrid();
        System.out.println();
        equip(player1);
        //ClearScreen.clrscr(); // Xóa màn hình
        System.out.println("--------------------------------");
        System.out.println("\nNgười chơi 2 đặt thuyền\n");
        player2.playerGrid.printGrid();
        System.out.println();
        equip(player2);
        System.out.println("--------------------------------");
        ClearScreen.clrscr(); // Xóa màn hình
        play(player1, player2, player1AttackGrid, player2AttackGrid);
        displayMessage.printMessage("Bảng thuyền của người chơi 1\n");
        player1.playerGrid.printGrid();
        displayMessage.printMessage("\nBảng thuyền của người chơi 2\n");
        player2.playerGrid.printGrid();
    }

    // switch turn
    public void play(Player player1, Player player2, Grid player1AttackGrid, Grid player2AttackGrid) {
        while (true) {
            System.out.println("\nNgười chơi 1 bắn");
//            System.out.println("Bảng thuyền");
//            player1.printPlayerGrid(); // in bảng thuyền
//            System.out.println();
//            System.out.println("Bảng tấn công");
//            player1AttackGrid.printGrid(); // in bảng tấn công
            player1.printPlayerGrid(player1AttackGrid, player1.playerGrid);
            if (player1.attack(player2.playerGrid, player1AttackGrid)) {
                player1.setHit(player1.getHit() + 1);
            }
            System.out.println("--------------------------------");
            if (player1.getHit() == 16) {
                System.out.println("\nNgười chơi 1 thắng!!!");
                break;
            }
            Delay.delay(1000); // Dừng màn hình 1s
            ClearScreen.clrscr(); // Xóa màn hình
            System.out.println("\nNgười chơi 2 bắn");
//            System.out.println("Bảng thuyền");
//            player2.printPlayerGrid();
//            System.out.println();
//            System.out.println("Bảng tấn công");
//            player2AttackGrid.printGrid();
            player2.printPlayerGrid(player2AttackGrid, player2.playerGrid);
            if (player2.attack(player1.playerGrid, player2AttackGrid)) {
                player2.setHit(player2.getHit() + 1);
            }
            System.out.println("--------------------------------");
            if (player2.getHit() == 16) {
                System.out.println("Người chơi 2 thắng");
                break;
            }
            Delay.delay(1000); // Dừng màn hình 1s
            ClearScreen.clrscr(); // Xóa màn hình
        }

    }

    public void equip(Player player) {
        System.out.println("Đặt 1 Thiết Giáp Hạm (Battle Ship) 1x5");
        player.placeShip();
        player.playerGrid.printGrid();
        System.out.println("\nĐặt 1 Tàu Khu Trục (Destroyer Boat) 1x4");
        player.placeShip();
        player.playerGrid.printGrid();
        System.out.println("\n1 Tàu Ngầm (Submarine) 1x3");
        player.placeShip();
        player.playerGrid.printGrid();
        System.out.println("\nĐặt 2 Thuyền Tuần Tra (Patrol Boat) 1x2");
        player.placeShip();
        player.playerGrid.printGrid();
        System.out.println();
        player.placeShip();
        player.playerGrid.printGrid();
    }

    public void PVE() {

    }

}
