package NguoiChoi;

import Tau.Scan;

public class NguoiChoi_DenLuot {
    private NguoiChoi nguoiChoi, doiThu;
    private HienThi hienThi;
    public NguoiChoi_DenLuot(NguoiChoi nguoiChoi, NguoiChoi doiThu) {
        this.nguoiChoi = nguoiChoi;
        this.doiThu = doiThu;
        hienThi = new HienThi();
    }

    public void denLuot() {
        boolean daTanCong = false;
        while(true) {
            HienThi hienThi = new HienThi(nguoiChoi, doiThu);
            hienThi.thongTinNguoiChoi();
            hienThi.duongKeNgang();
            hienThi.menuNguoiChoi();
            hienThi.duongKeNgang();
            System.out.print("Chọn chức năng người chơi: ");
            int mode = Integer.valueOf(new Scan().cin());
            hienThi.duongKeNgang();
            switch (mode) {
                case 1:
                    hienThi.banDo();
                    break;
                case 2:
                    new NguoiChoi_KhaiHoa(nguoiChoi, doiThu).khaiHoa(daTanCong);
                    daTanCong = true;
                    break;
                case 3:
                    if (!daTanCong) {
                        System.out.println("Bạn chưa tấn công lượt này");
                        hienThi.duongKeNgang();
                    }
                    else {
                        System.out.println("Kết thúc lượt chơi.");
                        hienThi.duongKeNgang();
                        return;
                    }
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    hienThi.duongKeNgang();
            }
        }
    }
}
