import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ManChoiMoi  {
    Scanner cin = new Scanner(System.in);
    void endGame(NguoiChoi a) throws InterruptedException, IOException {
        System.out.println("Chúc mừng " + a.getTen() + " đã chiến thắng!");
        TimeUnit.SECONDS.sleep(5);
        Main.xoaManHinh();
        manHinhBatDau();
    }
    void inGame() throws InterruptedException, IOException {
        ArrayList<NguoiChoi> ps = new ArrayList<>();
        ps.add(new NguoiChoi(1));
        ps.add(new NguoiChoi(2));
        ps.get(0).setTen();
        ps.get(0).datTau();
        ps.get(1).setTen();
        ps.get(1).datTau();
        int turn = 0;
        while(ps.get(0).getDiem() < 5 && ps.get(1).getDiem() < 5){
            int n = 0;
            do{
                if(n == 2){
                    ps.get(turn).hienThiBanDau();
                    TimeUnit.SECONDS.sleep(2);
                    for(int i=0; i<12; ++i) System.out.println();
                    Main.xoaManHinh();
                }
                System.out.println("Lượt chơi của " + ps.get(turn).getTen() + ". Hãy đưa ra lựa chọn: ");
                System.out.println("1, Bắn.");
                System.out.println("2, Xem bản đồ.");
                n = cin.nextInt();
            }
            while(n != 1);
            ps.get(1-turn).hienThiDaBiBan();
            ps.get(1-turn).biBan();
            if(ps.get(1-turn).biBanHa())  ps.get(turn).tangDiem();
            if(ps.get(turn).getDiem() == 5) endGame(ps.get(turn));
            TimeUnit.SECONDS.sleep(2);
            turn = 1 - turn;
            Main.xoaManHinh();
        }
    }
    void manHinhBatDau() throws InterruptedException, IOException {
        System.out.print("                                         $$\\                  $$\\     $$\\     $$\\           \n");
        System.out.print("                                         $$ |                 $$ |    $$ |    $$ |          \n");
        System.out.print("      $$$$$$$\\  $$$$$$\\   $$$$$$\\        $$$$$$$\\   $$$$$$\\ $$$$$$\\ $$$$$$\\   $$ | $$$$$$\\  \n");
        System.out.print("     $$  _____|$$  __$$\\  \\____$$\\       $$  __$$\\  \\____$$\\\\_$$  _|\\_$$  _|  $$ |$$  __$$\\ \n");
        System.out.print("     \\$$$$$$\\  $$$$$$$$ | $$$$$$$ |      $$ |  $$ | $$$$$$$ | $$ |    $$ |    $$ |$$$$$$$$ |\n");
        System.out.print("      \\____$$\\ $$   ____|$$  __$$ |      $$ |  $$ |$$  __$$ | $$ |$$\\ $$ |$$\\ $$ |$$   ____|\n");
        System.out.print("     $$$$$$$  |\\$$$$$$$\\ \\$$$$$$$ |      $$$$$$$  |\\$$$$$$$ | \\$$$$  |\\$$$$  |$$ |\\$$$$$$$\\ \n");
        System.out.print("     \\_______/  \\_______| \\_______|      \\_______/  \\_______|  \\____/  \\____/ \\__| \\_______|\n");
        int n;
        System.out.println("\n1, Bắt đầu trò chơi.");
        System.out.println("2, Thoát trò chơi.");
        n = cin.nextInt();
        if(n == 1){
            inGame();
        }
        else{
            System.out.println("(┬┬﹏┬┬) bái bai o(TヘTo)");
        }
    }
}
