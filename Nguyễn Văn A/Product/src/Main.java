import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static Vector<Player> List = new Vector<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Sea Battle");
        System.out.println("Let's play!: " + "\n" +  "1: Play" + "\n" + "2: Exit");
        int choice = sc.nextInt();
        GoodBye_Menu bye = new GoodBye_Menu();
        if(choice == 1) {
            bye.Show();
        }
        else
        {
            Welcome_Menu hello = new Welcome_Menu();
            hello.Show();
            hello.PlayNow();
            bye.Show();
        }
    }
}
//0 0 0 1 1 1 1 2 3 0 6 0 0 6 0 8 3 2 3 6
//0 0 1 0 2 0 3 0 0 1 0 4 1 1 1 3 0 5 0 9


// 0 0 0 0 0 1 0 1 0 2 0 2 0 3 0 3 0 4 0 4 0 5 0 5 0 6 0 6 0 7 0 7 0 8 0 8 0 9 0 9
// 1 0 1 0 1 1 1 1 1 2 1 2 1 3 1 3
// 2 0 2 0
// 3 0 3 0