package Play;
import java.util.Scanner;
public class GameBoard{
    Scanner sc = new Scanner(System.in);
    private char[][] opponentMap1 = new char[10][10];
    private char[][] opponentMap2 = new char[10][10];
    public void Start(int check,Player player1, Player player2, char[][] map1, char[][] map2){
        Manage manage = new Manage();
        manage.setOpponentMap(opponentMap1);
        manage.setOpponentMap(opponentMap2);
        System.out.println("Danh sách người chơi: ");
        System.out.println("~--------------------------~");
        System.out.println("1. " + player1.getPlayerName());
        System.out.println("2. " + player2.getPlayerName());
        System.out.println("~--------------------------~");
        System.out.print("Chọn người chơi bắt đầu: ");
        int choose = sc.nextInt();
        gameLoop:
        while(true){
            if(choose == 1){
                System.out.println("Đến lượt: " + player1.getPlayerName());
                manage.Turn(player1, map1, opponentMap2);
                System.out.print("Nhập vị trí bắn đạn: ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                manage.CheckCellFired(x,y,map2,opponentMap2,player1,player2);
                manage.CheckWin(check, player1, player2,map1,map2);
                choose = 2;
            }
            if(choose == 2){
                System.out.println("Đến lượt: " + player2.getPlayerName());
                manage.Turn(player2, map2, opponentMap1);
                System.out.print("Nhập vị trí bắn đạn: ");
                int x= sc.nextInt();
                int y = sc.nextInt();
                manage.CheckCellFired(x,y,map1,opponentMap1,player2,player1);
                manage.CheckWin(check,player1, player2,map1,map2);
                choose = 1;
            }
        }
    }

}
