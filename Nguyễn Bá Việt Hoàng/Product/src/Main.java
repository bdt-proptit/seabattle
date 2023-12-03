import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        MainMenu menu = new MainMenu();
        DisplayTitle title = new DisplayTitle();
        ClearScreen.clrscr();
        title.showTitle();
        menu.startMenu(sc, player1, player2);
    }
}

