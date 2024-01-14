import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n"+"\033[1;31m\033[7m\033[7m" + "[SEA BATTLE GAME]" + "\033[0m" + "\n\n\n");

        System.out.print("Nhập tên người chơi 1: ");
        String player1Name = scanner.nextLine();

        System.out.print("Nhập tên người chơi 2: ");
        String player2Name = scanner.nextLine();

        SeaBattleGame seaBattleGame = new SeaBattleGame(player1Name, player2Name);

        seaBattleGame.setUpGame();

        seaBattleGame.startGame();
    }
}
