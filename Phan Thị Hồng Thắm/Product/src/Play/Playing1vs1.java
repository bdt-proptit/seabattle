package Play;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Playing1vs1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Scanner sc = new Scanner(System.in);
    private String [][] map1 = new String[10][10];
    private String [][] map2 = new String[10][10];
    private String line = String.valueOf('-').repeat(40);
    Player player1 = new Player();
    Player player2 = new Player();
    public void Mode(){
        System.out.println("Các chức năng trong game: ");
        System.out.println(ANSI_CYAN + line + ANSI_RESET );
        System.out.println(ANSI_RED + "1. Thiết lập người chơi" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "2. Kí hiệu trong game." + ANSI_RESET);
        System.out.println(ANSI_GREEN + "3. Bắt đầu game" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "4. Thoát game." + ANSI_RESET);
        System.out.println(ANSI_CYAN + line + ANSI_RESET);
        while(true){
            System.out.print("Chọn chức năng: ");
            int function = Integer.valueOf(sc.nextLine());
            switch (function){
                case 1:
                    ChoosePlayer();
                    break;
                case 2:
                    sign();
                    break;
                case 3:
                    System.out.println("3...2...1...Start!");
                    GameBoard gameBoard = new GameBoard();
                    int check =0;
                    gameBoard.Start(player1,player2,map1,map2);
                    if(check == 1) Mode();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    public void ChoosePlayer(){
        System.out.println("Danh sách người chơi: ");
        System.out.println(ANSI_CYAN + line + ANSI_RESET);
        System.out.println("1. Player 1");
        System.out.println("2. Player 2");
        System.out.println(ANSI_CYAN + line + ANSI_RESET);
        while(true){
            System.out.print("Chọn người chơi để thiết lập: ");
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
                    System.out.println("Tên: " + ANSI_CYAN + player1.getPlayerName() + ANSI_RESET);
                    player1.ShowMyMap(map1);
                case 2:
                    System.out.println("Thiết lập Player2!");
                    System.out.print("Nhập tên đi: ");
                    String playerName2 = sc.nextLine();
                    player2.setPlayerName(playerName2);
                    System.out.println("Xong tên rồi thì Setup Thuyền chuẩn bị chiến nào!!");
                    player2.SetupMyMap(map2);
                    System.out.println("Người chơi có thông tin là: ");
                    System.out.println("Tên: " + ANSI_CYAN + player2.getPlayerName() + ANSI_RESET);
                    player2.ShowMyMap(map2);
                    Mode();
                    break;
            }
        }
    }
    public void sign(){
        System.out.println("Các kí hiệu trong game :");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println( ANSI_RED + "P: Patrol Boat - Thuyền Tuần Tra" + ANSI_RESET);
        System.out.println( ANSI_YELLOW + "D: Destroyed Boat - Tàu Khu Trục" + ANSI_RESET);
        System.out.println( ANSI_PURPLE + "S: Submarine - Tàu Ngầm" + ANSI_RESET);
        System.out.println( ANSI_GREEN + "B: BattleShip - Thiết Giáp Hạm" + ANSI_RESET);
        System.out.println( ANSI_RED_BACKGROUND + "o" + ANSI_RESET + ": Vị trí đạn bắn nhưng không trúng tàu");
        System.out.println( ANSI_RED_BACKGROUND + "X" + ANSI_RESET + ": Vị trí đạn bắn trúng tàu");
        System.out.println(ANSI_BLUE + "~: Nước biển" + ANSI_RESET);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
