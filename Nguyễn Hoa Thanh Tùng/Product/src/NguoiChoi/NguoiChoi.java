package NguoiChoi;
import Tau.*;

import java.util.ArrayList;
import java.util.List;

public class NguoiChoi{
    private String ten;
    private int soLanBan, HP;
    private List<Tau> dsachTau;
    private int[][] viTriTau;
    public NguoiChoi(){
        ten = "";
        soLanBan = 0;
        HP = 16;
        dsachTau = new ArrayList<>();
        viTriTau = new int[10][10];
    }
    public void setTen() {
        System.out.print("Nhập tên người chơi: ");
        this.ten = new Scan().cin();
    }
    public void tangSoLanBan() {
        soLanBan++;
    }
    public void giamHP(){
        HP--;
    }
    public void setDsachTau(List<Tau> dsachTau) {
        this.dsachTau = dsachTau;
    }
    public void setViTriTau(int[][] viTriTau) {
        this.viTriTau = viTriTau;
    }
    public String getTen() {
        return ten;
    }
    public int getSoLanBan() {
        return soLanBan;
    }
    public int getHP() {
        return HP;
    }
    public List<Tau> getDsachTau() {
        return dsachTau;
    }
    public int[][] getViTriTau() {
        return viTriTau;
    }
}
