package SeaBattle;
import java.util.*;
public class GameMenu {
    Scanner sc = new Scanner(System.in);
    public void menuStart(){
        System.out.println("----------MENU START----------");
        System.out.println("|1. Start.                   |");
        System.out.println("|2. View game instructions.  |");
        System.out.println("|3. Quit.                    |");
        System.out.println("------------------------------");

    }
    public void menuInstruction() {
        System.out.println("" +
                "Là một người chơi, tôi có thể vào game và bắt đầu chơi. Sẽ có hai người chơi trong một ván game và lượt sẽ được luân phiên.\n" +
                "Ban đầu, người chơi được cho 1 bảng 10x10, một cột đánh từ A->J, một cột đánh từ 1->10. \n" +
                "Mỗi người chơi sở hữu 5 con thuyền như sau:\n" +
                "2 Thuyền Tuần Tra (Patrol Boat) 1x2\n" +
                "1 Tàu Khu Trục (Destroyer Boat) 1x4\n" +
                "1 Tàu Ngầm (Submarine) 1x3\n" +
                "1 Thiết Giáp Hạm (Battle Ship) 1x5\n" +
                "Người chơi sẽ có thể nhập vào 2 toạ độ (X,Y) với từng mẫu thuyền để đặt thuyền, màn hình sẽ hiển thị thuyền lên bảng.\n" +
                "Sau khi đặt xong hết, sẽ sang lượt đặt của người kia.\n" +
                "1 tàu sẽ bị phá huỷ chỉ sau khi toàn bộ điểm bị phá hết. ví dụ tàu 1x5 thì ít nhất 5 phát bắn trúng đích toàn bộ để phá\n" +
                "Khi bên nào bị phá hết tàu trước lập tức thua cuộc và hiển thị màn hình kết quả, bảng của cả 2 bên\n");
    }
    public void endGame(){
        System.out.println("Goodbye!");
    }
    public void setupScreen(Player p1, Player p2){
        System.out.print ("Please enter 1st username: ");
        p1.setUsername(sc.nextLine());
        System.out.print("Please enter 2nd username: ");
        p2.setUsername(sc.nextLine());

    }

    public void runGame() {
        menuStart();
        System.out.print("Enter your option: ");
        int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    break;
                case 2:
                    menuInstruction();
                    System.out.println("Do you want to start game?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter your option(Y/N): ");
                    int opt = Integer.parseInt(sc.nextLine());
                    if (opt == 1){
                   //
                    }
                    else {
                        endGame();
                        return;
                    }
                    break;
                case 3:
                    endGame();
                    return;
                default:
                    System.out.println("Invalid option! Please re-enter!");
                    break;
        }
    }

}

