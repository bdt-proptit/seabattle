package Play;
import java.util.Scanner;
public class GameBoard{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Scanner sc = new Scanner(System.in);
    private String[][] opponentMap1 = new String[10][10];
    private String[][] opponentMap2 = new String[10][10];
    public void Start(Player player1, Player player2, String[][] map1, String[][] map2){
        Manage manage = new Manage();
        manage.setOpponentMap(opponentMap1);
        manage.setOpponentMap(opponentMap2);
        System.out.println("Danh sách người chơi: ");
        System.out.println(ANSI_CYAN + "~--------------------------~" + ANSI_RESET);
        System.out.println("1. " + player1.getPlayerName());
        System.out.println("2. " + player2.getPlayerName());
        System.out.println(ANSI_CYAN + "~--------------------------~" + ANSI_RESET);
        System.out.print("Chọn người chơi bắt đầu: ");
        int choose = sc.nextInt();
        while(true){
            if(choose == 1){
                System.out.println("Đến lượt: " + ANSI_PURPLE + player1.getPlayerName() + ANSI_RESET);
                manage.Turn(player1, map1, opponentMap2);
                System.out.print("Nhập vị trí bắn đạn: ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                manage.CheckCellFired(x,y,map2,opponentMap2,player1,player2);
                manage.CheckWin(player1, player2,map1,map2);
                choose = 2;
            }
            else if(choose == 2){
                System.out.println("Đến lượt: " + ANSI_PURPLE + player2.getPlayerName() + ANSI_RESET);
                manage.Turn(player2, map2, opponentMap1);
                System.out.print("Nhập vị trí bắn đạn: ");
                int x= sc.nextInt();
                int y = sc.nextInt();
                manage.CheckCellFired(x,y,map1,opponentMap1,player2,player1);
                manage.CheckWin(player1, player2,map1,map2);
                choose = 1;
            }
        }
    }

}
