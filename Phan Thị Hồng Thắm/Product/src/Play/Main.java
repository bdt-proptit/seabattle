package Play;
import java.util.Scanner;
public class Main{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(ANSI_CYAN+ " _________     ________     _________     _________      _________     __________    __________     ___         ________\n" +
                "|\\   _____\\   |\\  _____\\   |\\   ___  \\   |\\   ___  \\    |\\   ___  \\   |\\___   ___\\  |\\___   ___\\   |\\  \\       |\\  _____\\\n" +
                "\\ \\  \\____|_  \\ \\ \\____|_  \\ \\  \\| \\  \\  \\ \\   \\|\\ /_   \\ \\  \\| \\  \\  \\/___ \\  \\    \\/___ \\  \\     \\ \\  \\      \\ \\ \\____|_\n" +
                " \\ \\______  \\  \\ \\  _____\\  \\ \\   ___  \\  \\ \\   ___   \\  \\ \\   ___  \\      \\ \\  \\        \\ \\  \\     \\ \\  \\      \\ \\  _____\\\n" +
                "  \\______|\\  \\  \\ \\ \\____|_  \\ \\  \\  \\  \\  \\ \\   \\|\\   \\  \\ \\  \\  \\  \\      \\ \\  \\        \\ \\  \\     \\ \\  \\_____ \\ \\ \\____|_\n" +
                "    _____\\_\\  \\  \\ \\_______\\  \\ \\__\\  \\__\\  \\ \\_________\\  \\ \\__\\  \\__\\      \\ \\__\\        \\ \\__\\     \\ \\_______\\ \\ \\_______\\\n" +
                "   |\\__________\\  \\|________|  \\|___|\\|___|  \\|__________|  \\|___|\\|___|      \\|__|         \\|__|      \\|_______|  \\|________|\n" + ANSI_RESET
        );
        while(true){
            System.out.println(ANSI_RED + "Are you ready? Nếu sẵn sàng nhấn phím 1" + ANSI_RESET);
            int number = Integer.valueOf(sc.nextLine());
            if(number == 1){
                Playing1vs1 playing = new Playing1vs1();
                playing.Mode();
            }
            else System.out.println(ANSI_RED + "Bạn chưa sẵn sàng ư?? Vậy hãy bình tĩnh và nhập lại nhé <3!!" + ANSI_RESET);
        }
    }
    public static int Exit(){
        return 0;
    }

}