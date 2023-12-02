package Display;

import Player.Player;

import java.util.*;

public class Display extends Menu{
    private Player player, opponent;
    protected static List<Player> winner;
    public Display(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }
    public Display(){
    }
    public void map() {
        horizontalLine();
        System.out.println(RED + String.format("%-35s", "          VỊ TRÍ ĐÃ BẮN") + DEFAULT + "||" + GREEN + String.format("%-35s","            VỊ TRÍ TÀU PHE TA") + DEFAULT);
        System.out.println(String.format("%-35s||%-35s", " ", " "));
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
                else System.out.print(BLUE_BACKGROUND + BLACK + " ~ " + DEFAULT);
            }
            System.out.print("   ||   ");
            for (int j=0;j<10;++j) {
                if(j==0) System.out.printf("%c ", 'a'+i);
                if (player.getPositionShips()[i][j]==1) System.out.print(WHITE_BACKGROUND + BLACK + " * " +DEFAULT);
                else if (player.getPositionShips()[i][j]==2) System.out.print(RED_BACKGROUND + " X " + DEFAULT);
                else if(player.getPositionShips()[i][j]==3) System.out.print(RED + " X " + DEFAULT);
                else System.out.print(BLUE_BACKGROUND + BLACK + " ~ " + DEFAULT);
            }
            System.out.println();
        }
        horizontalLine();
        enterToContinue();
    }
    public void informationPlayer() {
//        System.out.println("Hiển thị thông tin người chơi.");
        System.out.println(getBackgroundColor() + BLACK + String.format("%-40s", "Tên người chơi: " + player.getName()) + String.format("%-20s", "Số lượt đã bắn: " + player.getShotCount()) + DEFAULT);
        System.out.println(getBackgroundColor() + BLACK + String.format("%-40s", "Số tàu còn lại: " + player.getListShip().size()) + String.format("%-20s", "Số tàu đã phá: " + (5- opponent.getListShip().size())) + DEFAULT);
    }
    public void showRanking() {
//        System.out.println("Hiển thị bảng xếp hạng.");
        if(winner.size()==0) {
            System.out.println("Chưa có người chơi nào chiến thắng.");
            enterToContinue();
            return;
        }
        Collections.sort(winner, new SortComparator());
        System.out.println(String.format("%-15s%-30s%-20s%-10s", "Ranking", "Tên người chơi", "Số lần bắn", "Số tàu còn lại"));
        horizontalLine();
        for (int i=0;i<winner.size();++i) {
            System.out.println(String.format("%-3s%-12d%-30s%-20d%-10d", " ", i+1, winner.get(i).getName(), winner.get(i).getShotCount(), winner.get(i).getListShip().size()));
            horizontalLine();
        }
        enterToContinue();
    }
    public void resultNotification(Player player1, Player player2) {
//        System.out.println("Thông báo kết quả người chiến thắng");
        if(player2.getHP()==0) {
            System.out.println("Người chơi " + RED + player1.getName() + DEFAULT + " chiến thắng với " + RED + player1.getShotCount() + DEFAULT + " lần bắn.");
            winner.add(player1);
        } else {
            System.out.println("Người chơi " + RED + player2.getName() + DEFAULT + " chiến thắng với " + RED + player2.getShotCount() + DEFAULT + " lần bắn.");
            winner.add(player2);
        }
        enterToContinue();
    }
}
