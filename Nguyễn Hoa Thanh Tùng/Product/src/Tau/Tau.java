package Tau;

public class Tau {
    private String ten;
    private int HP, chieuDai;
    private ToaDo viTriDau, viTriDuoi;

    public Tau() {
        this.ten="";
        this.chieuDai=0;
        this.HP=0;
    }
    public String getTen() {
        return ten;
    }

    public int getHP() {
        return HP;
    }
    public int getChieuDai() {
        return chieuDai;
    }
    public ToaDo getViTriDau() {
        return viTriDau;
    }

    public ToaDo getViTriDuoi() {
        return viTriDuoi;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void trungDan(){
        HP--;
    }
    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }
    public void setViTriDau() {
        System.out.print("Nhập vị trí đầu: ");
        this.viTriDau = ToaDo.toaDoFromScanner();
    }
    public void setViTriDuoi() {
        while(true) {
            System.out.print("Nhập vị trí đuôi: ");
            this.viTriDuoi = ToaDo.toaDoFromScanner();
            if(kiemTraViTriTau()) return;
            else System.out.println("Vị trí đuôi tàu chưa hợp lệ.");
        }
    }
    public boolean kiemTraViTriTau(){
        if(viTriDuoi.getY()==viTriDau.getY() && Math.abs(viTriDuoi.getX()-viTriDau.getX())==chieuDai-1) return true;
        if(viTriDuoi.getX()==viTriDau.getX() && Math.abs(viTriDuoi.getY()-viTriDau.getY())==chieuDai-1) return true;
        return false;
    }
}