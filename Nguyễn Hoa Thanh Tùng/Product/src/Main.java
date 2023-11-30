import Display.Display;
import Ship.Scan;

public class Main {
    public static void main(String[] args) {
        Display hienThi = new Display();
        while (true) {
            hienThi.menuStart();
            hienThi.horizontalLine();
            System.out.print("Chọn chức năng: ");
            int mode=Integer.valueOf(new Scan().cin());
            hienThi.horizontalLine();
            switch (mode) {
                case 1:
                    System.out.println("Bắt đầu trò chơi.");
                    hienThi.horizontalLine();
                    new StartGame().startPlay();
                    break;
                case 2:
                    System.out.println("Thoát trò chơi.");
                    hienThi.horizontalLine();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    hienThi.horizontalLine();
            }
        }
    }
}
