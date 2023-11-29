package Tau;

public class TauTuanTra extends Tau{
    public TauTuanTra(){
        setTen("Tàu tuần tra");
        setChieuDai(2);
        setHP(2);
    }
    public static TauTuanTra tauTuanTraFromScanner(){
        TauTuanTra tau = new TauTuanTra();
        System.out.printf("Nhập thông tin %s:\n", tau.getTen());
        tau.setViTriDau();
        tau.setViTriDuoi();
        return tau;
    }
}
