import Computer.Computer;
import Display.*;
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
                    display.clrscr();
                    System.out.println("Chế độ người với người.");
                    display.horizontalLine();
                    PvP();
                    break;
                case 2:
                    display.clrscr();
                    System.out.println("Chế độ này đang phát triển.");
//                    System.out.println("Chế độ người với máy.");
                    display.horizontalLine();
//                    int level = chooseDiffitcultyLevel();
//                    if(level!=4) PvE(level);
//                    else System.out.println("Thoát chế độ đấu với máy.");
                    break;
                case 3:
                    display.clrscr();
                    System.out.println("Thoát.");
                    display.horizontalLine();
                    return;
                default:
                    display.clrscr();
                    System.out.println("Chế độ không hợp lệ.");
                    display.horizontalLine();
            }
        }
    }
    public void PvP() {
        Display display = new Display();
        Player player1 = new Player();
        Player player2 = new Player();
        display.setDefaultcolor();
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
    public void PvE(int level) {
        Display display = new Display();
        Player player1 = new Player();
        Computer computer = new Computer(level);
        new Player_Prepare(player1).prepare();
        new Player_Prepare(computer).prepare();
        while(true) {
            new Player_Turn(player1, computer).turn();
            if (computer.getHP()==0) break;
            new Player_Turn(computer, player1).turn();
            if (computer.getHP()==0) break;
        }
        display.resultNotification(player1, computer);
        display.enterToContinue();
        display.horizontalLine();
    }
    public int chooseDiffitcultyLevel() {
        Display display = new Display();
        while (true) {
            display.menuDifficultyLevel();
            display.horizontalLine();
            System.out.print("Chọn độ khó: ");
            int level = Integer.valueOf(new Scan().cin());
            display.horizontalLine();
            switch (level) {
                case 1:
                    System.out.println("Chế độ dễ");
                    return 1;
                case 2:
                    System.out.println("Chế độ trung bình.");
                    return 2;
                case 3:
                    System.out.println("Chế độ khó.");
                    return 3;
                case 4:
                    System.out.println("Thoát.");
                    return 4;
                default:
                    System.out.println("Độ khó không hợp lệ.");
            }
        }
    }
}
