import NguoiChoi.*;
import Tau.Scan;

public class Main {
    public static void main(String[] args) {
        HienThi hienThi = new HienThi();
        while (true) {
            hienThi.menuBatDau();
            hienThi.duongKeNgang();
            System.out.print("Chọn chức năng: ");
            int mode=Integer.valueOf(new Scan().cin());
            hienThi.duongKeNgang();
            switch (mode) {
                case 1:
                    System.out.println("Bắt đầu trò chơi.");
                    hienThi.duongKeNgang();
                    new BatDauTroChoi().batDauChoi();
                    break;
                case 2:
                    System.out.println("Thoát trò chơi.");
                    hienThi.duongKeNgang();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    hienThi.duongKeNgang();
            }
        }
    }
}
