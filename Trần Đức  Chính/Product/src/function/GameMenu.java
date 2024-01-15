package function;

import graphic.ClearScreen;
import graphic.Delay;
import graphic.DisplayMessage;
import data.LeaderBoard;
import model.Grid;
import model.Player;

import java.util.Random;
import java.util.Scanner;

public class GameMenu {
    public LeaderBoard leaderBoard = new LeaderBoard();
    private final int turn = new Random().nextInt(2); // random người chơi bắn trước
    private DisplayMessage displayMessage = new DisplayMessage();
    Scanner sc = new Scanner(System.in);

    private void pressKey() {
        System.out.print("\nNhấn phím Enter để tiếp tục");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public void menu() {
        System.out.println("\nWelcome to Battleship Game");
        while (true) {
            displayMessage.printMenu();
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    ClearScreen.clrscr();
                    displayMessage.printMessage("Chế độ chơi PVP!!!!\n\n");
                    char ask;
                    do {
                        PVP();
                        pressKey();
                        ClearScreen.clrscr();
                        displayMessage.printMessage("Bạn có muốn chơi tiếp không (Y/N): ");
                        ask = sc.nextLine().charAt(0);
                        if (ask == 'Y' || ask == 'y') {
                            ClearScreen.clrscr(); // Xóa màn hình
                        }
                    } while (ask == 'Y' || ask == 'y');
                    System.out.println("\nCảm ơn bạn đã chơi ♥");
                    pressKey();
                    ClearScreen.clrscr();
                    break;
                case 2:
//                    displayMessage.printMessage("\nChế độ chơi đang được phát triển :<\n\n");
//                    pressKey();
//                    ClearScreen.clrscr(); // Xóa màn hình
                    ClearScreen.clrscr();
                    displayMessage.printMessage("Chế độ chơi PVE!!!!\n\n");
                    do {
                        PVE();
                        pressKey();
                        ClearScreen.clrscr();
                        displayMessage.printMessage("Bạn có muốn chơi tiếp không (Y/N): ");
                        ask = sc.nextLine().charAt(0);
                        if (ask == 'Y' || ask == 'y') {
                            ClearScreen.clrscr(); // Xóa màn hình
                        }
                    } while (ask == 'Y' || ask == 'y');
                    System.out.println("\nCảm ơn bạn đã chơi ♥");
                    pressKey();
                    ClearScreen.clrscr();
                    break;
                case 3:
                    ClearScreen.clrscr();
                    displayMessage.printRules();
                    pressKey();
                    ClearScreen.clrscr(); // Xóa màn hình
                    break;
                case 4:
                    ClearScreen.clrscr();
                    displayMessage.printMessage("Xem bảng xếp hạng\n\n");
                    leaderBoard.showLeaderBoard();
                    pressKey();
                    ClearScreen.clrscr();
                    break;
                case 5:
                    displayMessage.exitGame();
                    return;
                default:
                    System.out.print("Vui lòng chọn lại: ");
            }
        }
    }


    public void PVP() {
        System.out.print("Nhập kích thước bản đồ (10x10 -> 20x20): ");
        Player.playerGridSize = Integer.parseInt(sc.nextLine());
        Player player1 = new Player();
        Player player2 = new Player();
        Grid player1AttackGrid = new Grid();
        Grid player2AttackGrid = new Grid();
        System.out.print("Nhập tên người chơi 1: ");
        player1.setName(sc.nextLine());
        System.out.println("--------------------------------");
        equip(player1);

        pressKey();
        ClearScreen.clrscr(); // Xóa màn hình
        System.out.print("Nhập tên người chơi 2: ");
        player2.setName(sc.nextLine());
        System.out.println("--------------------------------");
        equip(player2);
        pressKey();
        ClearScreen.clrscr(); // Xóa màn hình

        // random người chơi bắn trước

        if (turn == 0) {
         //   playTurn= 1;
            System.out.println("Người chơi " + player1.getName() + " bắn trước\n");
            playPvP(player1, player2, player1AttackGrid, player2AttackGrid);
        } else {
       //     playTurn = 2;
            System.out.println("Người chơi " + player2.getName() + " bắn trước\n");
            playPvP(player2, player1, player2AttackGrid, player1AttackGrid);
        }
        displayMessage.printMessage("\nBảng thuyền của người chơi " + player1.getName() + "\n");
        player1.playerGrid.printGrid();
        displayMessage.printMessage("\nBảng thuyền của người chơi " + player2.getName() + "\n");
        player2.playerGrid.printGrid();
    }

    // switch turn
    public void playPvP(Player player1, Player player2, Grid player1AttackGrid, Grid player2AttackGrid) {
        while (true) {
            if (playerTurn(player1, player2, player1AttackGrid)) return;
            if (playerTurn(player2, player1, player2AttackGrid)) return;
        }

    }

    public boolean playerTurn(Player player1, Player player2, Grid player1AttackGrid) {
        System.out.println("Người chơi " + player1.getName() + " bắn\n");
    //    System.out.println("PlayTurn: " + playTurn);

        player1.printPlayerGrid(player1AttackGrid, player1.playerGrid);

        player1.setShipRemaining(5 - player1.countShipIsSunk(player1.playerGrid));
        player1.setShipDestroyed(player2.countShipIsSunk(player2.playerGrid));
        System.out.println("Số thuyền còn lại: " + player1.getShipRemaining());
        System.out.println("Số thuyền đã phá được: " + player1.getShipDestroyed());

        while (player1.attack(player2.playerGrid, player1AttackGrid)) {
         //   playTurn =  1;
            player1.setShipDestroyed(player2.countShipIsSunk(player2.playerGrid));
            if (player1.getShipDestroyed() == 5) {
                ClearScreen.clrscr();
                System.out.println(player1.getName() + " thắng!!!");
                System.out.println("Số thuyền còn lại: " + player1.getShipRemaining());
                System.out.println("Số phát bắn: " + player1.getHit());
                leaderBoard.printInfoToLeaderBoard(player1);
                return true;
            }
            Delay.delay(1000); // Dừng màn hình 1s
            ClearScreen.clrscr(); // Xóa màn hình
            System.out.println("Người chơi " + player1.getName() + " bắn tiếp: \n");
         //   System.out.println("PlayTurn: " + playTurn);
            player1.printPlayerGrid(player1AttackGrid, player1.playerGrid); // bản thuyền chơi của người chơi 1

            player1.setShipRemaining(5 - player1.countShipIsSunk(player1.playerGrid));
            player1.setShipDestroyed(player2.countShipIsSunk(player2.playerGrid));
            System.out.println("Số thuyền còn lại: " + player1.getShipRemaining());
            System.out.println("Số thuyền đã phá được: " + player1.getShipDestroyed());

        }
     //   playTurn = 2;
        Delay.delay(1000); // Dừng màn hình 1s
        ClearScreen.clrscr(); // Xóa màn hình
        return false;
    }

    public void equip(Player player) {
        displayMessage.printMessage("\nNgười chơi " + player.getName() + " đặt thuyền\n");
        player.playerGrid.printGrid();
        System.out.println();
        displayMessage.choseModePlaceShip();
        while (true) {
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    ClearScreen.clrscr(); // Xóa màn hình
                    player.handPlaceShip();
                    return;
                case 2:
                    ClearScreen.clrscr(); // Xóa màn hình
                    player.autoPlaceShip();
                    System.out.println("Đang đặt thuyền!!\n");
                    Delay.delay(2000); // Dừng màn hình 1s
                    System.out.println("Đã đặt xong thuyền!!");
                    Delay.delay(1000); // Dừng màn hình 1s
                    System.out.println("Bản thuyền của bạn\n");
                    player.playerGrid.printGrid();
                    System.out.println();
                    return;
                default:
                    System.out.print("Vui lòng chọn lại: ");
            }
        }
    }

    public void PVE() {
        System.out.print("Nhập kích thước bản đồ (10x10 -> 20x20): ");
        Player.playerGridSize = Integer.parseInt(sc.nextLine());
        Player player = new Player();
        Player computer = new Player();
        Grid playerAttackGrid = new Grid();
        Grid computerAttackGrid = new Grid();
        System.out.print("Nhập tên người chơi: ");
        player.setName(sc.nextLine());
        computer.setName("Máy");
        System.out.println("--------------------------------");
        equip(player);
        computer.autoPlaceShip();
        pressKey();
        ClearScreen.clrscr(); // Xóa màn hình
        System.out.println("Máy đang đặt thuyền!!!\n");
        Delay.delay(5000); // Dừng màn hình 1s
        System.out.println("Máy đã đặt xong thuyền!!!\n");
        Delay.delay(1000); // Dừng màn hình 1s
        ClearScreen.clrscr(); // Xóa màn hình
        System.out.println("Chọn chế độ máy: ");
        System.out.println("1. Máy dễ");
        System.out.println("2. Máy khó");
        System.out.print("Chọn: ");
        byte choice = Byte.parseByte(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Bạn đã chọn chế độ máy dễ");
                Delay.delay(2500);
                ClearScreen.clrscr();
                System.out.println("Người chơi " + player.getName() + " bắn trước");
                playPVE(player, computer, playerAttackGrid, computerAttackGrid, choice);
                break;
            case 2:
                System.out.println("Bạn đã chọn chế độ máy khó");
                Delay.delay(2500);
                ClearScreen.clrscr();
                System.out.println("Người chơi " + player.getName() + " bắn trước");
                playPVE(player, computer, playerAttackGrid, computerAttackGrid, choice);
                break;
            default:
                System.out.println("Bạn đã chọn chế độ máy dễ");
        }
        displayMessage.printMessage("\nBảng thuyền của người chơi " + player.getName() + "\n");
        player.playerGrid.printGrid();
        displayMessage.printMessage("\nBảng thuyền của máy\n");
        computer.playerGrid.printGrid();
    }

    public void playPVE(Player player, Player computer, Grid playerAttackGrid, Grid computerAttackGrid, int choice) {

        while (true) {
            if (playerTurn(player, computer, playerAttackGrid)) return;
            if (computerTurn(computer, player, computerAttackGrid, choice)) return;
        }

    }

    public boolean computerTurn(Player computer, Player player, Grid computerAttackGrid, int mode) {
        System.out.println(computer.getName() + " đang bắn");
        computer.setShipRemaining(5 - computer.countShipIsSunk(computer.playerGrid));
        computer.setShipDestroyed(player.countShipIsSunk(player.playerGrid));
        System.out.println("Số thuyền còn lại: " + computer.getShipRemaining());
        System.out.println("Số thuyền đã phá được: " + computer.getShipDestroyed());
        Delay.delay(2000); // Dừng màn hình 2s
        if (mode == 1) {
            while (computer.autoAttack(computer, player.playerGrid, computerAttackGrid)) {
                computer.setShipDestroyed(player.countShipIsSunk(player.playerGrid));
                if (computer.getShipDestroyed() == 5) {
                    ClearScreen.clrscr();
                    System.out.println("Máy thắng!!!");
                    System.out.println("Số thuyền còn lại: " + computer.getShipRemaining());
                    leaderBoard.printInfoToLeaderBoard(computer);
                    return true;
                }
                Delay.delay(2000); // Dừng màn hình 2s
                ClearScreen.clrscr(); // Xóa màn hình
                System.out.println("Máy bắn tiếp: \n");
                computer.setShipRemaining(5 - computer.countShipIsSunk(computer.playerGrid));
                computer.setShipDestroyed(player.countShipIsSunk(player.playerGrid));
                System.out.println("Số thuyền còn lại: " + computer.getShipRemaining());
                System.out.println("Số thuyền đã phá được: " + computer.getShipDestroyed());
                Delay.delay(2000); // Dừng màn hình 2s
            }
            Delay.delay(2000); // Dừng màn hình 2s
            ClearScreen.clrscr(); // Xóa màn hình
            return false;
        } else {
            while (computer.hardModeBotAttack(computer, player, player.playerGrid, computerAttackGrid)) {
                computer.setShipDestroyed(player.countShipIsSunk(player.playerGrid));
                if (computer.getShipDestroyed() == 5) {
                    ClearScreen.clrscr();
                    System.out.println("Máy thắng!!!");
                    System.out.println("Số thuyền còn lại: " + computer.getShipRemaining());
                    leaderBoard.printInfoToLeaderBoard(computer);
                    return true;
                }
                Delay.delay(2000); // Dừng màn hình 2s
                ClearScreen.clrscr(); // Xóa màn hình
                System.out.println("Máy bắn tiếp: \n");
                computer.setShipRemaining(5 - computer.countShipIsSunk(computer.playerGrid));
                computer.setShipDestroyed(player.countShipIsSunk(player.playerGrid));
                System.out.println("Số thuyền còn lại: " + computer.getShipRemaining());
                System.out.println("Số thuyền đã phá được: " + computer.getShipDestroyed());
                Delay.delay(2000); // Dừng màn hình 2s
            }
            Delay.delay(2000); // Dừng màn hình 2s
            ClearScreen.clrscr(); // Xóa màn hình
            return false;
        }

    }

}
