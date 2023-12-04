import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BangDau {
    Scanner cin = new Scanner(System.in);
    private char[][] grid = new char[10][10];
    List<Tau> danhSachTau = new ArrayList<>();
    char[][] getGrid(){ return grid; }
    BangDau(){
        for(int i=0; i<10; ++i){
            for(int j=0; j<10; ++j) grid[i][j] = '-';
        }
        danhSachTau.add(new Tau("Thuyền tuần tra", 2));
        danhSachTau.add(new Tau("Thuyền tuần tra", 2));
        danhSachTau.add(new Tau("Tàu ngầm", 3));
        danhSachTau.add(new Tau("Tàu khu vực", 4));
        danhSachTau.add(new Tau("Thiết giáp hạm", 5));
    }
    void setViTri(int x, int y, char a){
        grid[x][y] = a;
    }
    public void hienThi() throws InterruptedException {
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
    public void datTau() throws InterruptedException, IOException {
        hienThi();
        for(var x : danhSachTau){
            System.out.println("Nhập tọa độ đầu cuối của " + x.getTen() + "(dài " + x.getDoDai() + ")" + ": ");
            String toaDoDau = cin.nextLine();
            String toaDoCuoi = cin.nextLine();
            int x1 = (int)toaDoDau.charAt(0) - 'A';
            int y1 = Integer.parseInt(toaDoDau.substring(1)) - 1;
            int x2 = (int)toaDoCuoi.charAt(0) - 'A';
            int y2 = Integer.parseInt(toaDoCuoi.substring(1)) - 1;
            x.setToaDo(x1, y1, x2, y2);
            if(x1 == x2){
                for(int i=Integer.min(y1, y2); i<=Integer.max(y1, y2); ++i) grid[x1][i] = 'T';
            }
            else {
                for(int i = Integer.min(x1, x2); i <= Integer.max(x1, x2); ++i) grid[i][y1] = 'T';
            }
            hienThi();
        }
        TimeUnit.SECONDS.sleep(2);
        for(int i=0; i<12; ++i) System.out.println();
        Main.xoaManHinh();
    }
    boolean kiemTraTrung(int x, int y){
        return grid[x][y] == 'T';
    }
    boolean kiemTraChim(char[][] chim){
        for(int i=0; i<danhSachTau.size(); ++i){
            danhSachTau.get(i).kiemTraChim(grid);
            if(danhSachTau.get(i).daChim()){
                System.out.println("Đã đánh chìm " + danhSachTau.get(i).getTen());
                danhSachTau.get(i).setChim(chim);
                danhSachTau.get(i).setChim(grid);
                danhSachTau.remove(i);
                return true;
            }
        }
        return false;
    }
}
