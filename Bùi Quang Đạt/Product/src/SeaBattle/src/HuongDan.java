import java.io.*;
public class HuongDan {
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
        System.out.println(ANSI_CYAN + "-----------------------Hướng-Dẫn-Cho-Noob--------------------------------------");
        System.out.println("|- Bạn sẽ đóng vai 1 thượng tá lên kế hoạch để bắn thuyền bên địch.           |");
        System.out.println("|- Hiện tại bạn và địch sở hữu số lượng thuyền như nhau.                      |");
        System.out.println("|- Bạn phải bố trí các thuyền của bạn sao cho bên địch không thể bắn trúng.   |");
        System.out.println("|- Đồng thời tính toán thật kĩ lưỡng để hạ hết thuyền bên địch.               |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Bấm phím 1 để quay lại Menu.");
        System.out.println("Bấm phím 2 để thoát chương trình.");
        System.out.print("Lựa chọn của bạn: ");
    }
}
