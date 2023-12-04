import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[SEA BATTLE GAME]");

        // Tạo trò chơi với hai người chơi
        SeaBattleGame seaBattleGame = new SeaBattleGame("Player 1", "Player 2");

        // Bắt đầu trò chơi
        seaBattleGame.startGame();

    }
}
