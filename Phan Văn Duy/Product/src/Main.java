package seabattle;

public class Main {

    public static void main(String[] args) {
        Seabattle seabattle = new Seabattle();
        Player player1 = new Player();
        Player player2 = new Player();

        while (true) {
            seabattle.disPlayRule();
            seabattle.startGame(player1, player2);
            System.out.println("1 - Nếu Muốn chơi tiếp nhập");
            if (Player.setNumber() != 1) {
                break;
            }
        }
    }
}
