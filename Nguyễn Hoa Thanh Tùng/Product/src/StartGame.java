import Display.Display;
import Player.*;
import Ship.Scan;

public class StartGame {
    public void startPlay(){
        while (true){
            Display display = new Display();
            display.menuGameMode();
            display.horizontalLine();
            System.out.print("Chọn chế độ chơi: ");
            int mode = Integer.valueOf(new Scan().cin());
            display.horizontalLine();
            switch (mode) {
                case 1:
                    System.out.println("Chế độ người với người.");
                    display.horizontalLine();
                    PvP();
                    break;
                case 2:
                    System.out.println("Chế độ người với máy.");
                    display.horizontalLine();
                    display.menuDifficultyLevel();
                    display.horizontalLine();
                    System.out.print("Chọn độ khó: ");
                    int level=Integer.valueOf(new Scan().cin());
                    display.horizontalLine();
                    switch (level) {
                        case 1:
                            System.out.println("Chế độ dễ");
                            PvE_Easy();
                            break;
                        case 2:
                            System.out.println("Chế độ trung bình.");
                            PvE_Medium();
                            break;
                        case 3:
                            System.out.println("Chế độ khó.");
                            PvE_Hard();
                            break;
                        case 4:
                            System.out.println("Thoát.");
                            break;
                        default:
                            System.out.println("Độ khó không hợp lệ.");
                    }
                    display.horizontalLine();
                    break;
                case 3:
                    System.out.println("Thoát.");
                    display.horizontalLine();
                    return;
                default:
                    System.out.println("Chế độ không hợp lệ.");
                    display.horizontalLine();
            }
        }
    }
    public void PvP() {
        Display display = new Display();
        Player player1 = new Player();
        Player player2 = new Player();
        new Player_Prepare(player1).prepare();
        new Player_Prepare(player2).prepare();
        while(true) {
            new Player_Turn(player1, player2).turn();
            if (player2.getHP()==0) break;
            new Player_Turn(player2, player1).turn();
            if (player2.getHP()==0) break;
        }
        display.resultNotification(player1, player2);
        display.enterToContinue();
        display.horizontalLine();
    }

    public void PvE_Easy() {}
    public void PvE_Medium() {}
    public void PvE_Hard() {}
}
