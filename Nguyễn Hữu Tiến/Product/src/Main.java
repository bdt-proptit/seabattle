import java.util.Scanner;

public class Main {
    public static Menu menu;
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws RuntimeException{
        menu = new Menu();
        menu.showLogo();
        System.out.print("Bấm Enter để tiếp tục!");
        String s = sc.nextLine();
        OF.clrscr();
        menu.startMenu();
    }
}