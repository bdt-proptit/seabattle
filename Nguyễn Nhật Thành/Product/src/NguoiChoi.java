import java.util.Scanner;
public class NguoiChoi{
    int stt;
    private BangDau sanDau = new BangDau();
    private BangDau daBiBan = new BangDau();
    Scanner cin = new Scanner(System.in);
    private int Diem = 0;
    private String Ten;
    NguoiChoi(int a){
        stt = a;
    }
    void setTen(){
        System.out.print("Nhập tên người chơi " + stt + ": ");
        Ten = cin.nextLine();
    }
    String getTen(){ return Ten; }
    int getDiem(){ return Diem; }
    void tangDiem(){ ++Diem; }
    void hienThiBanDau() throws InterruptedException{ sanDau.hienThi(); }
    void hienThiDaBiBan() throws InterruptedException{ daBiBan.hienThi(); }
    void datTau() throws InterruptedException { sanDau.datTau(); }
    void biBan(){
        System.out.print("Nhập vị trí bắn: ");
        String toaDoBan = cin.nextLine();
        int x = (int)toaDoBan.charAt(0) - 'A';
        int y = Integer.parseInt(toaDoBan.substring(1)) - 1;
        if(sanDau.kiemTraTrung(x, y)){
            System.out.println("Bắn trúng!");
            daBiBan.setViTri(x, y, 'X');
            sanDau.setViTri(x, y, 'X');
        }
        else{
            System.out.println("Bắn trượt!");
            daBiBan.setViTri(x, y, 'O');
            sanDau.setViTri(x, y, 'O');
        }
    }
    boolean biBanHa(){ return sanDau.kiemTraChim(daBiBan.getGrid()); }
}
