package SeaBattle;

public class GameSystem {
    public static final String GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(GREEN + "------------------------------");
        System.out.println( "    Welcome to Sea Battle!    "    );
        System.out.println("------------------------------" + ANSI_RESET);
        GameMenu menu = new GameMenu();
        menu.runGame();
    }
}
