import java.io.*;
public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    public void hienThiMenu(){
        System.out.println(ANSI_CYAN+"-------------SEA~~~BATTLE-------------");
        System.out.println("|1. Chơi hai người.                  |");
        System.out.println("|2. Đấu với máy tính.                |");
        System.out.println("|3. Hai máy tính đấu với nhau.       |");
        System.out.println("|4. Bảng xếp hạng.                   |");
        System.out.println("|5. Hướng Dẫn.                       |");
        System.out.println("|6. Cài Đặt.                         |");
        System.out.println("|7. Thoát.                           |");
        System.out.println("--------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
}
