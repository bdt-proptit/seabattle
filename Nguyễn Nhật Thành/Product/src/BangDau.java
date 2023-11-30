import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangDau {
    Scanner cin = new Scanner(System.in);
    private char[][] grid = new char[10][10];
    BangDau(){
        for(int i=0; i<10; ++i){
            for(int j=0; j<10; ++j) grid[i][j] = '-';
        }
    }
    public void HienThi(){
        char st = 'A';
        String kc = "   ";
        for(int i=0; i<10; ++i){
            System.out.print(kc + (i+1));
            kc = "  ";
        }
        System.out.println();
        for(int i=0; i<10; ++i){
            System.out.print(st++ + " |");
            for(int j=0; j<10; ++j) System.out.print(grid[i][j] + " |");
            System.out.print("\n");
        }
    }
    public void datTau(){
        List<Tau> danhSachTau = new ArrayList<>();
        danhSachTau.add(new Tau("Thuyền tuần tra", 2));
        danhSachTau.add(new Tau("Thuyền tuần tra", 2));
        danhSachTau.add(new Tau("Tàu ngầm", 3));
        danhSachTau.add(new Tau("Tàu khu vực", 4));
        danhSachTau.add(new Tau("Thiết giáp hạm", 5));
        for(var x : danhSachTau){
            HienThi();
            System.out.println("Nhập tọa độ đầu cuối của " + x.getTen() + "(dài " + x.getDoDai() + ")" + ": ");
            String toaDoDau = cin.nextLine();
            String toaDoCuoi = cin.nextLine();
            int x1 = (int)toaDoDau.charAt(0) - 'A';
            int y1 = Integer.parseInt(toaDoDau.substring(1)) - 1;
            int x2 = (int)toaDoCuoi.charAt(0) - 'A';
            int y2 = Integer.parseInt(toaDoCuoi.substring(1)) - 1;
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            if(x1 == x2){
                for(int i=y1; i<=y2; ++i) grid[x1][i] = 'S';
            }
            else {
                for (int i = x1; i <= x2; ++i) grid[i][y1] = 'S';
            }
        }
    }
}
