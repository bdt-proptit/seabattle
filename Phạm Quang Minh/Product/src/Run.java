import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Player player = new Player();
        Player oppositePlayer = new Player();
        Scanner scanner = new Scanner(System.in);
        MenuGame menuGame = new MenuGame();
        menuGame.menu(scanner, player, oppositePlayer);
    }
}
