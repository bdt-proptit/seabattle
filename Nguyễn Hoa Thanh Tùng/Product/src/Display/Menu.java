package Display;

import java.util.Scanner;

public class Menu extends EffectDisplay{
    public static String background_color;
    public static String text_color;
    private static String horizontalLine = "-".repeat(80);
    public Menu() {
    }
    public void setDefaultcolor() {
        background_color=GREEN_BACKGROUND;
        text_color=GREEN;
    }
    public void changeColor() {
//        System.out.println("Đổi màu Background");
        if(background_color.equals(GREEN_BACKGROUND)) background_color=RED_BACKGROUND;
        else background_color=GREEN_BACKGROUND;
        if(text_color.equals(GREEN)) text_color=RED;
        else text_color=GREEN;
    }
    public String getBackgroundColor() {
        return background_color;
    }
    public String getTextColor() {
        return background_color;
    }
    public void menuSetShipsPosition() {
//        System.out.println("Chế độ đặt tàu:");
        System.out.println("------------------------------" );
        System.out.println("|     1. Tự chọn.            |" );
        System.out.println("|     2. Đặt ngẫu nhiên.     |" );
        System.out.println("------------------------------" );
    }
    public void menuPlayer() {
//        System.out.println("Hiển thị menu người chơi");
        System.out.println(getBackgroundColor() + BLACK + "-----------------------------" + DEFAULT);
        System.out.println(getBackgroundColor() + BLACK + "|      1. Xem bảng          |" + DEFAULT);
        System.out.println(getBackgroundColor() + BLACK + "|      2. Khai hỏa          |" + DEFAULT);
        System.out.println(getBackgroundColor() + BLACK + "|      3. Kết thúc lượt     |" + DEFAULT);
        System.out.println(getBackgroundColor() + BLACK + "-----------------------------" + DEFAULT);
    }
    public void menuStart() {
//        System.out.println("Hiển thị menu bắt đầu.");
        System.out.println("--------------------------------");
        System.out.println("|     1. Bắt đầu trò chơi.     |");
        System.out.println("|     2. Xem bảng xếp hạng     |");
        System.out.println("|     3. Thoát trò chơi.       |");
        System.out.println("--------------------------------");
    }
    public void menuGameMode() {
//        System.out.println("Chọn chế độ chơi.");
        System.out.println("-------------------------------");
        System.out.println("|     1. Người với Người.     |");
        System.out.println("|     2. Người với Máy.       |");
        System.out.println("|     3. Thoát                |");
        System.out.println("-------------------------------");
    }
    public void menuDifficultyLevel() {
//        System.out.println("Chọn độ khó khi chơi với máy");
        System.out.println("-------------------------");
        System.out.println("|     1. Dễ             |");
        System.out.println("|     2. Trung bình     |");
        System.out.println("|     3. Khó            |");
        System.out.println("|     4. Thoát          |");
        System.out.println("-------------------------");
    }
    public void enterToContinue() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhấn Enter để tiếp tục...");
            if (sc.nextLine().isEmpty()) {
                horizontalLine();
                clrscr();
                break;
            }
        }
    }
    public void horizontalLine(){
//        System.out.println("Hiển thị dấu gạch ngang đỏ");
        System.out.printf("%s%-80s%s\n", RED, horizontalLine, DEFAULT);
    }


}
