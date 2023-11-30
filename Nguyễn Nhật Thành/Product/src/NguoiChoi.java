import java.util.Scanner;

public class NguoiChoi {
    BangDau sanDau = new BangDau();
    Scanner cin = new Scanner(System.in);
    private int Diem = 0;
    private String Ten;
    void setTen(){
        System.out.print("Nhập tên người chơi: ");
        Ten = cin.nextLine();
    }
    String getTen(){ return Ten; }
    void tangDiem(){ ++Diem; };
    int getDiem(){ return Diem; }
}
