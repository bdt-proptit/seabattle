package Play;
import java.util.Scanner;
public class Playing {
    Scanner sc = new Scanner(System.in);
    private char [][] map1;
    private char [][] map2;
    Player player1 = new Player();
    Player player2 = new Player();
    public void Mode(){
        System.out.println("Các chức năng trong game: ");
        System.out.println("1. Thiết lập người chơi");
        System.out.println("2. Bắt đầu game");
        System.out.println("3. Thoát chức năng");
        System.out.print("Chọn chức năng: ");
        while(true){
            int function = Integer.valueOf(sc.nextLine());
            switch (function){
                case 1:
                    ChoosePlayer();
                case 2:

                default:
                    return;
            }
        }
    }
    public void ChoosePlayer(){
        System.out.println("Danh sách người chơi: ");
        System.out.println("Chọn người chơi muốn thiết lập: ");
        System.out.println("1. Player 1");
        System.out.println("2. Player 2");
        System.out.println("3. Thoát người chơi");
        while(true){
            int choose = Integer.valueOf((sc.nextLine()));
            switch(choose){
                case 1:
                    System.out.println("Bạn chọn thiết lập Player1!");
                    System.out.print("Nhập tên đi: ");
                    player1.setPlayerName();
                    System.out.println("Xong tên rồi thì Setup Thuyền chuẩn bị chiến nào!!");
                    player1.SetupMyMap(map1);
                    System.out.println("Người chơi có thông tin là: ");
                    System.out.println("Tên: " + player1.getPlayerName());
                    player1.ShowMyMap(map1);

                case 2:
                    System.out.println("Bạn chọn thiết lập Player2!");
                    System.out.print("Nhập tên đi: ");
                    player2.setPlayerName();
                    System.out.println("Xong tên rồi thì Setup Thuyền chuẩn bị chiến nào!!");
                    player2.SetupMyMap(map2);
                    System.out.println("Người chơi có thông tin là: ");
                    System.out.println("Tên: " + player2.getPlayerName());
                    player2.ShowMyMap(map2);
                default:
                    return;
            }
        }
    }


}
