package Tau;

public class TauKhuTruc extends Tau{
    public TauKhuTruc(){
        setTen("Tàu khu trục");
        setChieuDai(4);
        setHP(4);
    }
    public static TauKhuTruc tauKhuTrucFromScanner(){
        TauKhuTruc tau = new TauKhuTruc();
        System.out.printf("Nhập thông tin %s:\n", tau.getTen());
        tau.setViTriDau();
        tau.setViTriDuoi();
        return tau;
    }
}
