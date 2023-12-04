import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
    public static void main (String[] agrs){
        Scanner sc = new Scanner(System.in);

        GameMenu menu = new GameMenu();

        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println("1. Choi moi");
            System.out.println("2. Choi tiep");
            System.out.println("3. Choi voi may");
            System.out.println("4. Xep hang");
            System.out.println("5. Thoat Game");
            System.out.print("Chon chuc nang ban muon: ");
            int function = sc.nextInt();
            sc.nextLine();

            switch (function){
                case 1:
                    menu.newGame();
                    break;
                case 2:
                    menu.continueGame();
                    break;
                case 3:
                    menu.AIGame();
                    break;
                case 4:
                    menu.Ranking();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vui long chon dung chuc nang");

            }
            System.out.print("Nhan Enter de tro ve menu");
            sc.nextLine();
        }
    }
}