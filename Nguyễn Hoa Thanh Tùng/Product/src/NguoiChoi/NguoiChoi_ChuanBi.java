package NguoiChoi;

import Tau.*;

public class NguoiChoi_ChuanBi {
    private NguoiChoi nguoiChoi;
    private HienThi hienThi;
    public NguoiChoi_ChuanBi(NguoiChoi nguoiChoi) {
        this.nguoiChoi = nguoiChoi;
        hienThi = new HienThi(nguoiChoi, new NguoiChoi());
    }

    public void chuanBi(){
        nguoiChoi.setTen();
        hienThi.duongKeNgang();
        chonViTriTau();
    }
    private void chonViTriTau() {
        nguoiChoi.getDsachTau().add(TauTuanTra.tauTuanTraFromScanner());
        capNhatViTriTau(nguoiChoi.getDsachTau().getLast());
        hienThi.duongKeNgang();
        hienThi.banDo();
        nguoiChoi.getDsachTau().add(TauTuanTra.tauTuanTraFromScanner());
        capNhatViTriTau(nguoiChoi.getDsachTau().getLast());
        hienThi.duongKeNgang();
        hienThi.banDo();
        nguoiChoi.getDsachTau().add(TauKhuTruc.tauKhuTrucFromScanner());
        capNhatViTriTau(nguoiChoi.getDsachTau().getLast());
        hienThi.duongKeNgang();
        hienThi.banDo();
        nguoiChoi.getDsachTau().add(TauNgam.tauNgamFromScanner());
        capNhatViTriTau(nguoiChoi.getDsachTau().getLast());
        hienThi.duongKeNgang();
        hienThi.banDo();
        nguoiChoi.getDsachTau().add(ThietGiapHam.thietGiapHamFromScanner());
        capNhatViTriTau(nguoiChoi.getDsachTau().getLast());
        hienThi.duongKeNgang();
        hienThi.banDo();
    }
    private void capNhatViTriTau(Tau tau) {
        int start = tau.getViTriDau().getX() == tau.getViTriDuoi().getX() ? Math.min(tau.getViTriDau().getY(), tau.getViTriDuoi().getY()) : Math.min(tau.getViTriDau().getX(), tau.getViTriDuoi().getX());
        int end = tau.getViTriDau().getX() == tau.getViTriDuoi().getX() ? Math.max(tau.getViTriDau().getY(), tau.getViTriDuoi().getY()) : Math.max(tau.getViTriDau().getX(), tau.getViTriDuoi().getX());
        for (int i = start; i <= end; i++) {
            if (tau.getViTriDau().getY() == tau.getViTriDuoi().getY())
                nguoiChoi.getViTriTau()[i][tau.getViTriDau().getY()] = 1;
            else nguoiChoi.getViTriTau()[tau.getViTriDau().getX()][i] = 1;
        }
    }
}
