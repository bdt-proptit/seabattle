import NguoiChoi.*;
import Tau.Scan;

public class BatDauTroChoi {
    public void batDauChoi(){
        while (true){
            HienThi hienThi = new HienThi();
            hienThi.menuCheDoChoi();
            hienThi.duongKeNgang();
            System.out.print("Chọn chế độ chơi: ");
            int mode = Integer.valueOf(new Scan().cin());
            hienThi.duongKeNgang();
            switch (mode) {
                case 1:
                    System.out.println("Chế độ người với người.");
                    hienThi.duongKeNgang();
                    nguoiVoiNguoi();
                    break;
                case 2:
                    System.out.println("Chế độ người với máy.");
                    hienThi.duongKeNgang();
                    hienThi.menuDoKho();
                    hienThi.duongKeNgang();
                    System.out.print("Chọn độ khó: ");
                    int level=Integer.valueOf(new Scan().cin());
                    hienThi.duongKeNgang();
                    switch (level) {
                        case 1:
                            System.out.println("Chế độ dễ");
                            break;
                        case 2:
                            System.out.println("Chế độ trung bình.");
                            break;
                        case 3:
                            System.out.println("Chế độ khó.");
                            break;
                        case 4:
                            System.out.println("Thoát.");
                            break;
                        default:
                            System.out.println("Độ khó không hợp lệ.");
                    }
                    hienThi.duongKeNgang();
                    break;
                case 3:
                    System.out.println("Thoát.");
                    hienThi.duongKeNgang();
                    return;
                default:
                    System.out.println("Chế độ không hợp lệ.");
                    hienThi.duongKeNgang();
            }
        }
    }
    public void nguoiVoiNguoi() {
        HienThi hienThi = new HienThi();
        NguoiChoi player1 = new NguoiChoi();
        NguoiChoi player2 = new NguoiChoi();
        new NguoiChoi_ChuanBi(player1).chuanBi();
        new NguoiChoi_ChuanBi(player2).chuanBi();
        while(player1.getHP()!=0 && player2.getHP()!=0) {
            new NguoiChoi_DenLuot(player1, player2).denLuot();
            new NguoiChoi_DenLuot(player2, player1).denLuot();
            System.out.println("Tung " + player1.getHP());
            System.out.println("ngoc " + player2.getHP());
        }
        hienThi.thongBaoKetQua(player1, player2);
    }

    public void nguoiVoiMayDe() {}
    public void nguoiVoiMayTrungBinh() {}
    public void nguoiVoiMayKho() {}
}
