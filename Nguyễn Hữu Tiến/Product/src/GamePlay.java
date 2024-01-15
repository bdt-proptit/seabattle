import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.Random;

public class GamePlay {
    private Scanner sc = new Scanner(System.in);
    private final StringBuilder tmp = new StringBuilder("1");
    private final Random rand = new Random();

    Player player1, player2;
    private void option(Player player1, Player player2, int n) {
        System.out.println("Đến lượt " + player1.getPlayerName() + " (người chơi " + n + ")");
        player2.getBoard().showBlindBoard();
        System.out.print("\nNhập tọa độ để bắn hoặc bấm 1 để xem tình trạng thuyền: ");
        StringBuilder s = new StringBuilder(10);
        s.append(sc.next());
        if (s.compareTo(tmp) == 0) {
            player1.getBoard().showPlayerBoard();
            System.out.print("\nNhập tọa độ để bắn: ");
            s = new StringBuilder(); s.append(sc.next());
        }
        OF.clrscr();
        player1.shoot(s, player2);
    }
    private void compareTwoPlayer(Player player1, Player player2){}

    public void twoPlayerMode(){
        // set board's size
        Board.setSize();
        player1 = new Player(); player2 = new Player();
        player1.getBoard().init(); player2.getBoard().init();
        System.out.print("Nhập tên người chơi 1: ");
        player1.getInformation();
        OF.clrscr();
        System.out.println("_________________________________________________");
        System.out.print("Nhập tên người chơi 2: ");
        player2.getInformation();
        OF.clrscr();

        System.out.println("_________________________________________________");
        int turn = 1; // player1 plays first
        while(true){
            if(turn == 1) { // player1
                option(player1, player2, 1);
                if(player2.getRemainingShips() == 0){
                    System.out.println("_________________________________________________");
                    System.out.println("Tất cả tàu của người chơi 2 đã bị phá hủy!");
                    System.out.println("Chúc mừng người chơi 1: " + player1.getPlayerName() + " đã giành chiến thắng!");
                    compareTwoPlayer(player1, player2);
                    return;
                }
            }
            else { //player2
                option(player2, player1, 2);
                if(player1.getRemainingShips() == 0){
                    System.out.println("Tất cả tàu của người chơi 1 đã bị phá hủy!");
                    System.out.println("Chúc mừng người chơi 2: " + player2.getPlayerName() + " đã dành chiến thắng!");
                    compareTwoPlayer(player1, player2);
                    return;
                }
            }
            turn *= -1;
        }
    }

    public void playWithComputer(){
        Board.setSize();
        player1 = new Player(); player2 = new Computer();

        player1.getBoard().init(); player2.getBoard().init();
        System.out.print("Nhập tên của bạn: ");
        player1.getInformation();
        OF.clrscr();
        ((Computer)player2).getInformation();
        System.out.println("_________________________________________________");
        int turn = 1; // player1 plays first
        while(true){
            if(turn == 1) { // player1
                option(player1, player2, 1);
                if(player2.getRemainingShips() == 0){
                    System.out.println("_________________________________________________");
                    System.out.println("Tất cả tàu của máy " + player2.getPlayerName() + " đã bị phá hủy!");
                    System.out.println("Chúc mừng bạn đã giành chiến thắng!");
                    compareTwoPlayer(player1, player2);
                    return;
                }
            }
            else { //player2
                ((Computer) player2).shoot(player1);
                if(player1.getRemainingShips() == 0){
                    System.out.println("Tất cả tàu của người chơi 1 đã bị phá hủy!");
                    System.out.println("Chúc mừng người chơi 2: " + player2.getPlayerName() + " đã dành chiến thắng!");
                    compareTwoPlayer(player1, player2);
                    return;
                }
            }
            turn *= -1;
        }
    }

//    public static void main(String[] args){
//        GamePlay gamePlay = new GamePlay();
//        gamePlay.twoPlayerMode();
//    }
}