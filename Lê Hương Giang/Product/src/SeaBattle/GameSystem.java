package SeaBattle;

public class GameSystem {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("    Welcome to Sea Battle!    ");
        System.out.println("------------------------------");
        GameMenu menu = new GameMenu();
        menu.runGame();
    }
}
