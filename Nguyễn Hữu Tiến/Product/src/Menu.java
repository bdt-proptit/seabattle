import java.util.Scanner;
public class Menu {
    // attributes
    private Scanner sc = new Scanner(System.in);
    private GamePlay gamePlay = new GamePlay();

    public Menu(){}
    public void showLogo(){
        System.out.println(Board.ANSI_CYAN + "  _________              __________         __    __   __");
        System.out.println(" /   _____/ ____ _____   \\______   \\____  _/  |__/  |_|  |   ____");
        System.out.println(" \\_____  \\_/ __ \\\\__  \\    |   |  _/__  \\ \\   __\\   __\\  | _/ __ \\");
        System.out.println(" /        \\  ___/_/ __ \\_  |   |   \\/ __ \\_|  |  |  | |  |__  ___/_");
        System.out.println("/_______  /\\___  /____  / /______  /____  /|__|  |__| |____/\\___  /");
        System.out.println("        \\/     \\/     \\/         \\/     \\/                      \\/" + Board.ANSI_RESET);
    }

    public void startMenu() {
        showLogo();
        System.out.println("_________________________________________________");
        System.out.println("1. Chế độ 2 người chơi");
        System.out.println("2. Chơi với máy");
        System.out.println("3. Hướng dẫn chơi");
        System.out.println("4. Bảng xếp hạng");
        System.out.println("5. Cài đặt");
        System.out.println("6. Thông tin game");
        System.out.println("7. Thoát!");

        System.out.print("Chọn chức năng: ");
        int choice;
        choice = sc.nextInt();

        if(choice < 1 || choice > 7) {
            int cnt = 0;
            while(choice < 1 || choice > 7) {
                System.out.print("Đã xảy ra lỗi! Vui lòng nhập lại: ");
                choice = sc.nextInt();
                cnt++;
                if (cnt > 3) System.exit(0);
            }
        }

        sc.nextLine();
        switch(choice){
            case 1: gamePlay.twoPlayerMode(); returnToMenu(); break;
            case 2: gamePlay.playWithComputer(); returnToMenu(); break;
            case 3: howToPlay(); break;
            case 4: showRank(); break;
            case 5: setting(); break;
            case 6: about(); break;
            case 7: System.exit(0);
        }
    }

    private void returnToMenu() {
        System.out.print("Bấm Enter để quay trở lại menu!");
        String s = sc.nextLine();
        OF.clrscr();
        startMenu();
    }

    public void howToPlay(){
        System.out.println("_________________________________________________");
        System.out.println("Sea battle là một board game 2 người chơi");
        System.out.println("Mỗi người chơi có 5 chiếc thuyền thuộc 4 loại với kích thước:");
        System.out.println("  * 2 thuyền tuần tra (Patrol Boat): 1x2");
        System.out.println("  * 1 tàu ngầm (Submarine)         : 1x3");
        System.out.println("  * 1 tàu khu trục (Destroyer Boat): 1x4");
        System.out.println("  * 1 chiến giáp hạm (Battle Ship) : 1x5");
        System.out.println();
        System.out.println("Trước khi bắt đầu trò chơi, 2 người chơi cần phải quy định kích thước bảng");
        System.out.println("Sau đó, mỗi người chơi sẽ tiến hành đặt tàu");
        System.out.println("Mỗi lượt chơi, mỗi người chơi sẽ chọn một tọa độ bất kỳ trên bảng để tấn công");
        System.out.println("Một tọa độ bao gồm một chữ cái và một số");
        System.out.println("Chữ cái đại diện cho cột, số đại diện cho hàng");
        System.out.println("Trò chơi kết thúc khi một trong hai người chơi phá hủy hết tàu của đối thủ");
        returnToMenu();
    }
    public void showRank(){
        System.out.println("_________________________________________________");
        System.out.println("Tính năng đang phát triển");
        returnToMenu();
    }
    public void setting(){
        System.out.println("_________________________________________________");
        System.out.println("Tính năng đang phát triển");
        returnToMenu();
    }

    public void about(){
        System.out.println("_________________________________________________");
        System.out.println("Sea Battle là một dự án game console sử dụng ngôn ngữ Java " +
                           "nằm trong khóa Java cơ bản cho D22 của CLB lập trình PTIT (ProPTIT)");
        System.out.println("Tác giả: Nguyễn Hữu Tiến");
        System.out.println("Mô tả: đẹp trai, học giỏi, nhiều người theo đuổi");
        System.out.println("Nhược điểm: ế vàaaa (hơi) ảo tưởng");
        System.out.println("FaceBook: https://www.facebook.com/HeckerChuoi/");
        System.out.println("Github: https://github.com/Hecker-Chuoi");
        System.out.println(Board.ANSI_CYAN + "______         ______ _____ _____ _____ ");
        System.out.println("| ___ \\        | ___ \\_   _|_   _|_   _|");
        System.out.println("| |_/ / __ ___ | |_/ / | |   | |   | |  ");
        System.out.println("|  __/ '__/ _ \\|  __/  | |   | |   | |");
        System.out.println("| |  | | | (_) | |     | |  _| |_  | |  ");
        System.out.println("\\_|  |_|  \\___/\\_|     \\_/  \\___/  \\_/  " + Board.ANSI_RESET);
        returnToMenu();
    }

//    public static void main(String[] args){
//        Menu menu = new Menu();
//        menu.showLogo();
//        menu.startMenu();
//    }
}
