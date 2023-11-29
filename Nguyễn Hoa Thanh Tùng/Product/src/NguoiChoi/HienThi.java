package NguoiChoi;

import Tau.Scan;

import java.io.IOException;

public class HienThi {
    private NguoiChoi nguoiChoi, doiThu;
    private static String keNgang = "-".repeat(100);

    public HienThi(NguoiChoi nguoiChoi, NguoiChoi doiThu) {
        this.nguoiChoi = nguoiChoi;
        this.doiThu = doiThu;
    }
    public HienThi(){
    }
    public void banDo() {
        System.out.println("Chức năng xem bảng.");
        duongKeNgang();
        System.out.println(String.format("%-36s||%-36s", "          VỊ TRÍ ĐÃ BẮN", "            VỊ TRÍ TÀU PHE TA"));
        System.out.println(String.format("%-36s||%-36s", " ", " "));
        for (int i=0;i<10;++i) {
            if(i==0) {
                System.out.print("   ");
                for (int j=0;j<10;++j) System.out.print(j + "  ");
                System.out.print("   ||   ");
                System.out.print("   ");
                for (int j=0;j<10;++j) System.out.print(j + "  ");
                System.out.println();
            }
            for (int j=0;j<10;++j) {
                if(j==0) System.out.printf("%c  ", 'a'+i);
                if (doiThu.getViTriTau()[i][j]==2) System.out.print("X  ");
                else System.out.print("~  ");
            }
            System.out.print("   ||   ");
            for (int j=0;j<10;++j) {
                if(j==0) System.out.printf("%c  ", 'a'+i);
                if (nguoiChoi.getViTriTau()[i][j]==2) System.out.print("X  ");
                else if (nguoiChoi.getViTriTau()[i][j]==1) System.out.print("*  ");
                else System.out.print("~  ");
            }
            System.out.println();
        }
        duongKeNgang();
        enterDeTiepTuc();
    }
    public void thongTinNguoiChoi() {
        System.out.println(String.format("%-40s", "Tên người chơi: " + nguoiChoi.getTen()) + String.format("%-20s", "Số lượt đã bắn: " + nguoiChoi.getSoLanBan()));
        System.out.println(String.format("%-40s", "Số tàu còn lại: " + nguoiChoi.getDsachTau().size()) + String.format("%-20s", "Số tàu đã phá: " + (5-doiThu.getDsachTau().size())));
    }
    public void menuNguoiChoi() {
        System.out.println("" +
                "-----------------------------\n" +
                "|      1. Xem bảng          |\n" +
                "|      2. Khai hỏa          |\n" +
                "|      3. Kết thúc lượt     |\n" +
                "-----------------------------");
    }
    public void menuBatDau() {
        System.out.println("--------------------------------");
        System.out.println("|     1. Bắt đầu trò chơi.     |");
        System.out.println("|     2. Thoát trò chơi.       |");
        System.out.println("--------------------------------");
    }
    public void menuCheDoChoi() {
        System.out.println("-------------------------------");
        System.out.println("|     1. Người với Người.     |");
        System.out.println("|     2. Người với Máy.       |");
        System.out.println("|     3. Thoát                |");
        System.out.println("-------------------------------");
    }
    public void menuDoKho() {
        System.out.println("-------------------------");
        System.out.println("|     1. Dễ             |");
        System.out.println("|     2. Trung bình     |");
        System.out.println("|     3. Khó            |");
        System.out.println("|     4. Thoát          |");
        System.out.println("-------------------------");
    }
    public void thongBaoKetQua(NguoiChoi player1, NguoiChoi player2) {
        if(player2.getHP()==0) System.out.printf("Người chơi %s chiến thắng với %d lần bắn.\n", player1.getTen(), player1.getSoLanBan());
        else System.out.printf("Người chơi %s chiến thắng với %d lần bắn.\n", player2.getTen(), player2.getSoLanBan());
    }
    public void duongKeNgang(){
        System.out.println(keNgang);
    }
    public void enterDeTiepTuc()  {
        System.out.print("Bấm Enter để tiếp tục.");
        try {
            System.in.read();
            new Scan().cin();
        } catch (IOException e) {

        }
    }
}
