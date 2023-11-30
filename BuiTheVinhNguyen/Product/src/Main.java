import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Starting start = new Starting();
        Ingame ingame = new Ingame();
        Board Player1 = new Board(), Player2 = new Board();
        Scanner sc = new Scanner(System.in);
        start.startingActions(Player1, Player2);

    }
}