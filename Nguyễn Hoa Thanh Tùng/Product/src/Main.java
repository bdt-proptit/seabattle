import Display.*;
import Ship.Scan;
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        while (true) {
            display.menuStart();
            display.horizontalLine();
            System.out.print("Chọn chức năng: ");
            int mode=Integer.valueOf(new Scan().cin());
            display.horizontalLine();
            switch (mode) {
                case 1:
                    display.clrscr();
                    System.out.println("Bắt đầu trò chơi.");
                    display.horizontalLine();
                    new StartGame().startPlay();
                    break;
                case 2:
                    display.clrscr();
                    System.out.println("Xem bảng xếp hạng");
                    display.horizontalLine();
                    display.showRanking();
                    break;
                case 3:
                    display.clrscr();
                    System.out.println("Thoát trò chơi.");
                    display.horizontalLine();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    display.enterToContinue();
                    display.horizontalLine();
            }
        }
    }
}
