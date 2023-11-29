package NguoiChoi;

import Tau.*;
/*
        Qui ước hiển thị:
            0: không có tàu
            1: tàu chưa bị bắn
            2: tàu đã bị bắn
            3: vị trí bị bắn nhưng không có tàu (bắn trượt)
 */
public class NguoiChoi_KhaiHoa {
    private NguoiChoi nguoiChoi, doiThu;
    private HienThi hienThi;
    public NguoiChoi_KhaiHoa(NguoiChoi nguoiChoi, NguoiChoi doiThu) {
        this.nguoiChoi = nguoiChoi;
        this.doiThu = doiThu;
        hienThi = new HienThi();
    }

    public void khaiHoa(boolean daTanCong) {
        System.out.println("Chức năng khai hỏa.");
        hienThi.duongKeNgang();
        if(daTanCong) {
            System.out.println("Bạn đã tấn công ở lượt này.");
            hienThi.enterDeTiepTuc();
            return;
        }
        ToaDo viTriBan = chonViTriBan();
        nguoiChoi.tangSoLanBan();
        boolean trungDan = false;
        for(Tau tau : doiThu.getDsachTau()) {
            int start = tau.getViTriDau().getX()==tau.getViTriDuoi().getX() ? Math.min(tau.getViTriDau().getY(), tau.getViTriDuoi().getY()) : Math.min(tau.getViTriDau().getX(), tau.getViTriDuoi().getX());
            int end = tau.getViTriDau().getX()==tau.getViTriDuoi().getX() ? Math.max(tau.getViTriDau().getY(), tau.getViTriDuoi().getY()) : Math.max(tau.getViTriDau().getX(), tau.getViTriDuoi().getX());
            if(viTriBan.getX()==tau.getViTriDau().getX() && start <= viTriBan.getY() && viTriBan.getY() <= end || viTriBan.getY()==tau.getViTriDau().getY() && start <= viTriBan.getX() && viTriBan.getX() <= end) {
                doiThu.getViTriTau()[viTriBan.getX()][viTriBan.getY()]=2;
                capNhatKetQuaBan(doiThu, tau);
                trungDan = true;
                return;
            }
            if(!trungDan) {
                System.out.println("Bạn đã bắn trượt.");
                hienThi.enterDeTiepTuc();
            }
            doiThu.getViTriTau()[viTriBan.getX()][viTriBan.getY()]=3;
        }
    }
    private ToaDo chonViTriBan(){
        while(true) {
            System.out.print("Chọn vị trí bắn: ");
            ToaDo viTriBan = ToaDo.toaDoFromScanner();
            int trangThai = doiThu.getViTriTau()[viTriBan.getX()][viTriBan.getY()];
            if(trangThai==2 || trangThai==3) {
                System.out.println("Bạn đã bắn ở vị trí này.");
                hienThi.enterDeTiepTuc();
                hienThi.duongKeNgang();
            }
            else {
                hienThi.duongKeNgang();
                return viTriBan;
            }
        }
    }
    private void capNhatKetQuaBan(NguoiChoi doiThu, Tau tau) {
        System.out.println("Bạn đã bắn trúng tàu.");
        tau.trungDan();
        doiThu.giamHP();
        if(tau.getHP()==0) {
            doiThu.getDsachTau().remove(tau);
            System.out.println("Tàu đã chìm.");
        }
        hienThi.enterDeTiepTuc();
        hienThi.duongKeNgang();
    }
}
