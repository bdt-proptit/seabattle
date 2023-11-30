package Player;

import Display.*;
import Ship.Scan;

public class Player_Turn {
    private Player player, opponent;
    private Display display;
    public Player_Turn(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        display = new Display();
    }

    public void turn() {
        boolean attacked = false;
        while(true) {
            Display display = new Display(player, opponent);
            display.informationPlayer();
            display.horizontalLine();
            display.menuPlayer();
            display.horizontalLine();
            System.out.print("Chọn chức năng người chơi: ");
            int mode = Integer.parseInt(new Scan().cin());
            display.horizontalLine();
            switch (mode) {
                case 1:
                    display.map();
                    break;
                case 2:
                    new Player_Attack(player, opponent).attack(attacked);
                    if (opponent.getHP()==0) return;
                    break;
                case 3:
                    if (!attacked) {
                        System.out.println("Bạn chưa tấn công lượt này");
                        display.horizontalLine();
                    }
                    else {
                        System.out.println("Kết thúc lượt chơi.");
                        display.horizontalLine();
                        return;
                    }
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    display.horizontalLine();
            }
        }
    }
}
