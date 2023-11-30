import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.Scanner;

public class Menu2NguoiChoi {
    Scanner sc = new Scanner(System.in);
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

    public void hienThi(){
        System.out.println(ANSI_CYAN + "------------2 Người Chơi------------");
        System.out.println("|1. Đặt thuyền thủ công.           |");
        System.out.println("|2. Tự động đặt thuyền.            |");
        System.out.println("------------------------------------");
        System.out.print("Lựa chọn của bạn là: ");
    }
    public void hoatDong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sound sound = new Sound();
        while(true){
            hienThi();
            choice = sc.nextInt();
            sound.Button();
            if(choice == 1){
                return;
            }else if(choice == 2){
                return;
            }else{
                System.out.println("Bạn nhập sai rồi. Chương trình sẽ quay lại Menu");
            }
        }
    }

}
