package Tau;

public class TauNgam extends Tau{
    public TauNgam(){
        setTen("Tàu ngầm");
        setChieuDai(3);
        setHP(3);
    }
    public static TauNgam tauNgamFromScanner(){
        TauNgam tau = new TauNgam();
        System.out.printf("Nhập thông tin %s:\n", tau.getTen());
        tau.setViTriDau();
        tau.setViTriDuoi();
        return tau;
    }
}
