package Display;

import Player.Player;

import java.util.Scanner;

public class Display extends EffectDisplay {
    private Player player, opponent;

    public Display(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }
    public Display(){
    }
    public void map() {
        System.out.println("Chức năng xem bảng.");
        horizontalLine();
        System.out.println(String.format("%-35s||%-36s", "          VỊ TRÍ ĐÃ BẮN", "            VỊ TRÍ TÀU PHE TA"));
        System.out.println(String.format("%-35s||%-36s", " ", " "));
        for (int i=0;i<10;++i) {
            if(i==0) {
                System.out.print("   ");
                for (int j=0;j<10;++j) System.out.print(j + "  ");
                System.out.print("  ||   ");
                System.out.print("   ");
                for (int j=0;j<10;++j) System.out.print(j + "  ");
                System.out.println();
            }
            for (int j=0;j<10;++j) {
                if(j==0) System.out.printf("%c ", 'a'+i);
                if (opponent.getPositionShips()[i][j]==2) System.out.print(RED_BACKGROUND + " X " + DEFAULT);
                else if(opponent.getPositionShips()[i][j]==3) System.out.print(RED + " X " + DEFAULT);
                else System.out.print(BLUE_BACKGROUND + GREY + " ~ " + DEFAULT);
            }
            System.out.print("   ||   ");
            for (int j=0;j<10;++j) {
                if(j==0) System.out.printf("%c ", 'a'+i);
                if (player.getPositionShips()[i][j]==2) System.out.print(RED_BACKGROUND + " X " + DEFAULT);
                else if (player.getPositionShips()[i][j]==1) System.out.print(WHITE + " * " +DEFAULT);
                else if(player.getPositionShips()[i][j]==3) System.out.print(RED + " X " + DEFAULT);
                else System.out.print(BLUE_BACKGROUND + GREY + " ~ " + DEFAULT);
            }
            System.out.println();
        }
        horizontalLine();
        enterToContinue();
    }
    public void informationPlayer() {
        System.out.println(String.format("%-40s", "Tên người chơi: " + player.getType()) + String.format("%-20s", "Số lượt đã bắn: " + player.getShotCount()));
        System.out.println(String.format("%-40s", "Số tàu còn lại: " + player.getListShip().size()) + String.format("%-20s", "Số tàu đã phá: " + (5- opponent.getListShip().size())));
    }
    public void menuPlayer() {
        System.out.println(
                "-----------------------------\n" +
                "|      1. Xem bảng          |\n" +
                "|      2. Khai hỏa          |\n" +
                "|      3. Kết thúc lượt     |\n" +
                "-----------------------------");
    }
    public void menuStart() {
        System.out.println("--------------------------------");
        System.out.println("|     1. Bắt đầu trò chơi.     |");
        System.out.println("|     2. Thoát trò chơi.       |");
        System.out.println("--------------------------------");
    }
    public void menuGameMode() {
        System.out.println("-------------------------------");
        System.out.println("|     1. Người với Người.     |");
        System.out.println("|     2. Người với Máy.       |");
        System.out.println("|     3. Thoát                |");
        System.out.println("-------------------------------");
    }
    public void menuDifficultyLevel() {
        System.out.println("-------------------------");
        System.out.println("|     1. Dễ             |");
        System.out.println("|     2. Trung bình     |");
        System.out.println("|     3. Khó            |");
        System.out.println("|     4. Thoát          |");
        System.out.println("-------------------------");
    }
    public void resultNotification(Player player1, Player player2) {
        if(player2.getHP()==0) System.out.println("Người chơi " + RED + player1.getType() + DEFAULT + " chiến thắng với " + RED + player1.getShotCount() + DEFAULT + " lần bắn.");
        else System.out.println("Người chơi " + RED + player2.getType() + DEFAULT + " chiến thắng với " + RED + player2.getShotCount() + DEFAULT + " lần bắn.");
    }
    public void horizontalLine(){
        System.out.println(String.format(RED + CROSSED + "%-80s" + DEFAULT, " "));
    }
    public void enterToContinue() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhấn Enter để tiếp tục...");
            if (sc.nextLine().isEmpty()) {
                break;
            }
        }
    }
}
