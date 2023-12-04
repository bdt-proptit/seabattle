package seabattle;

import java.util.Scanner;

public class Seabattle {

    public void startGame(Player player1, Player player2) {
        Scanner input = new Scanner(System.in);
        int KHOANGCACH = 50;
        System.out.println("Bắt Đầu:");
        System.out.println("Mời Người chơi 1 nhập 5 tọa độ của tàu: ");
        player1.setPosShip();
        for (int i = 1; i <= KHOANGCACH; i++) {
            System.out.println();
        }
        System.out.println("Mời Người chơi 2 nhập 5 tọa độ của tàu: ");
        player2.setPosShip();

        while (true) {
            int check = 0;
            for (int i = 1; i <= KHOANGCACH; i++) {
                System.out.println();
            }
// lượt chơi người 1
            System.out.println("Lượt chơi của người chơi 1: ");
            disPlayStatus(player1, player2);
            while (true) {
                int number = Player.setNumber();
                if (number == 1) {
                    player1.disPlayMyTable();
                } else if (number == 2) {
                    player1.disPlayHisTable(player2);
                    System.out.printf("Mời Người chơi 1 nhập tọa độ bắn: ");
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if (player2.checkHit(x, y)) {
                        System.out.println("\n----------- Trúng ---------\n");
                        if (player2.checkWin()) {
                            System.out.println("\n----------- Người chơi 1 đã thắng ----------\n");
                            endGame(player1, player2);
                            check = 1;
                            break;
                        }
                    }
                }else if(number == -23){
                    endGame(player1, player2);
                }
                else {
                    break;
                }
            }
            if (check == 1) {
                break;
            }
            for (int i = 1; i <= KHOANGCACH; i++) {
                System.out.println();
            }
// lượt chơi người 2       
            System.out.println("Lượt chơi của người chơi 2: ");
            disPlayStatus(player2, player1);
            while (true) {
                int number = Player.setNumber();
                if (number == 1) {
                    player1.disPlayMyTable();
                } else if (number == 2) {
                    player2.disPlayHisTable(player1);
                    System.out.printf("Mời Người chơi 2 nhập tọa độ bắn: ");
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if (player1.checkHit(x, y)) {
                        System.out.println("----------- Trúng ---------");
                        if (player1.checkWin()) {
                            System.out.println("----------- Người chơi 1 đã thắng ----------");
                            endGame(player1, player2);
                            check = 1;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (check == 1) {
                break;
            }

        }
    }

    public void disPlayRule() {
        System.out.println("""
                           \nLuat choi: 
                           Mỗi người chơi có 5 con tàu....
                           1, 2, 3 thể hiện vị trí tàu 1, 2 3
                           -1 thể hiện ví trí tàu đã bị bắn;
                           -2 thể hiện vị trí đã bị bắn nhưng không trúng tàu
                           khi nhập vị trí của tàu cần nhập 3 chỉ số (x, y, z)
                                x, y là tọa độ của ô bên trái, cao nhất của tàu
                                z là: = 1 khi tàu nằm ngang
                                      = 2 khi tàu nằm dọc                                                                                               
                           """);
    }

    public static void disPlayStatus(Player ta, Player dich) {
        int x1 = 0; // so tau con lai của minh
        for (int i = 1; i <= 5; i++) {
            if (ta.ship[i].getStatus() > 0) {
                x1++;
            }
        }
        int x2 = 0; // so tau da pha
        for (int i = 1; i <= 5; i++) {
            if (dich.ship[i].getStatus() == 0) {
                x2++;
            }
        }
        System.out.println("\nTinh Hinh Hien Tai cua ban:\n- Số ô đã bắn: " + dich.getNumberFired() + "\n- Số tàu địch chìm: " + x2 + "\n- Số tàu còn lại của ta: " + x1);
        System.out.println("""
                           \n
                           1 - Xem cách Đặt Thuyền của mình.
                           2 - Đặt lệnh khai hỏa.
                           3 - Kết Thúc lượt.                                                                          
                           """);
    }

    public void endGame(Player player1, Player player2) {
        System.out.println("     Bảng của người chơi 1      -------------      Bảng của người chơi 2");
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (player1.myTableNow[i][j] >= 0) {
                    System.out.printf(" " + player1.myTableNow[i][j] + " ");
                } else {
                    System.out.printf(player1.myTableNow[i][j] + " ");
                }
            }
            System.out.printf("  -------------  ");
            for (int j = 1; j <= 10; j++) {
                if (player2.myTableNow[i][j] >= 0) {
                    System.out.printf(" " + player2.myTableNow[i][j] + " ");
                } else {
                    System.out.printf(player2.myTableNow[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
