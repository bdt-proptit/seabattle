import java.util.Scanner;

public class StartGame {
    Scanner cin = new Scanner(System.in);
    void manHinhBatDau(){
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
            NguoiChoi p1 = new NguoiChoi();
            NguoiChoi p2 = new NguoiChoi();
            p1.setTen();
            p1.sanDau.datTau();
            p2.setTen();
            p2.sanDau.datTau();
        }
        else{
            System.out.println("(┬┬﹏┬┬) bái bai o(TヘTo)");
            return;
        }
    }
}
