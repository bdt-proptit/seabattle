package seabattle;

import java.util.Scanner;

public class Seabattle {

    static Seabattle x = new Seabattle();
    Player player1 = new Player();
    Player player2 = new Player();

    public static void main(String[] args) {

        disPlayRule();
        x.startGame();
    }

    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bắt Đầu:");
        System.out.println("Mời Người chơi 1 nhập 5 tọa độ của tàu: ");
        player1.setPosShip();
        System.out.println("Mời Người chơi 2 nhập 5 tọa độ của tàu: ");
        player2.setPosShip();
        while (true) {
// lượt chơi người 1
            disPlayStatus(player1, player2);
            System.out.printf("Mời Người chơi 1 nhập tọa độ bắn: ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (player1.checkHit(x, y)) {
                System.out.println("-----------Trúng---------");
                if (player1.checkWin()) {
                    System.out.println("----------- Người chơi 1 đã thắng ----------");
                    endGame();
                    break;
                }
            }
// lượt chơi người 2       
            disPlayStatus(player2, player1);
            System.out.printf("Mời Người chơi 2 nhập tọa độ bắn: ");
            x = input.nextInt();
            y = input.nextInt();
            if (player2.checkHit(x, y)) {
                System.out.println("-----------Trúng---------");
                if (player2.checkWin()) {
                    System.out.println("----------- Người chơi 2 đã thắng ----------");
                    endGame();
                    break;
                }
            }

        }
    }

    public static void disPlayRule() {
        System.out.println("""
                           \nLuat choi: 
                           1 
                           2 
                           3 
                           4 
                           5 
                           6 
                           """);
    }

    public static void disPlayStatus(Player ta, Player dich) {
        int x1 = 0; // so tau con lai của minh
        for (int i = 1; i <= 5; i++) {
            if (ta.ship[i].tinhTrang > 0) {
                x1++;
            }
        }
        int x2 = 0; // so tau da pha
        for (int i = 1; i <= 5; i++) {
            if (dich.ship[i].tinhTrang == 0) {
                x2++;
            }
        }
        System.out.println("\nTinh Hinh Hien tai:\n- Số ô đã bắn:" + ta.numberFired + "\n- Số tàu địch chìm: " + x2 + "\n- Số tàu còn lại của ta: " + x1);
    }

    public void endGame() {
        System.out.println("Bảng của người chơi 1 -------- Bảng của người chơi 2");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf(player1.myTableNow[i][j] + " ");
            }
            System.out.printf("---------");
            for (int j = 1; j <= 10; j++) {
                System.out.printf(player2.myTableNow[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
