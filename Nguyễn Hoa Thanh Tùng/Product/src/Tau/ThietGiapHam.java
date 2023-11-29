package Tau;

public class ThietGiapHam extends Tau{
    public ThietGiapHam() {
        setTen("Thiết giáp hạm");
        setChieuDai(5);
        setHP(5);
    }
    public static ThietGiapHam thietGiapHamFromScanner() {
        ThietGiapHam tau = new ThietGiapHam();
        tau.setViTriDau();
        tau.setViTriDuoi();
        return tau;
    }
}
