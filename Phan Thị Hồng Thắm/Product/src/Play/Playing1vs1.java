package Play;
import java.util.Scanner;
public class Playing1vs1 {
    Scanner sc = new Scanner(System.in);
    private char [][] map1 = new char[10][10];
    private char [][] map2 = new char[10][10];
    Player player1 = new Player();
    Player player2 = new Player();
    public void Mode(){
        System.out.println("Các chức năng trong game: ");
        System.out.println("1. Thiết lập người chơi");
        System.out.println("2. Bắt đầu game");
        System.out.println("3. Thoát game.");
        System.out.print("Chọn chức năng: ");
        while(true){
            int function = Integer.valueOf(sc.nextLine());
            switch (function){
                case 1:
                    ChoosePlayer();
                    break;
                case 2:
                    System.out.println("3...2...1...Start!");
                    GameBoard gameBoard = new GameBoard();
                    int check =0;
                    gameBoard.Start(check,player1,player2,map1,map2);
                    if(check == 1) Mode();
                    break;
                default:
                    return ;
            }
        }
    }
    public void ChoosePlayer(){
        System.out.println("Danh sách người chơi: ");
        System.out.println("1. Player 1");
        System.out.println("2. Player 2");
        while(true){
            System.out.print("Chọn chức năng: ");
            int choose = Integer.valueOf((sc.nextLine()));
            switch(choose) {
                case 1:
                    System.out.println("Bạn chọn thiết lập Player1!");
                    System.out.print("Nhập tên đi: ");
                    String playerName1 = sc.nextLine();
                    player1.setPlayerName(playerName1);
                    System.out.println("Xong tên rồi thì Setup Thuyền chuẩn bị chiến nào!!");
                    player1.SetupMyMap(map1);
                    System.out.println("Người chơi có thông tin là: ");
                    System.out.println("Tên: " + player1.getPlayerName());
                    player1.ShowMyMap(map1);
                case 2:
                    System.out.println("Thiết lập Player2!");
                    System.out.print("Nhập tên đi: ");
                    String playerName2 = sc.nextLine();
                    player2.setPlayerName(playerName2);
                    System.out.println("Xong tên rồi thì Setup Thuyền chuẩn bị chiến nào!!");
                    player2.SetupMyMap(map2);
                    System.out.println("Người chơi có thông tin là: ");
                    System.out.println("Tên: " + player2.getPlayerName());
                    player2.ShowMyMap(map2);
                    Mode();
                    break;
            }
        }
    }
}
