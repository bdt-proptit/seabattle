package Thuyen;

import java.util.Scanner;

public class MainBattle {
    private static void menuGame() {
        while (true) {
            System.out.println("Chao mung den voi tro choi \"Sea Battle\"");
            System.out.println("1. Bat dau");
            System.out.println("2. Thoat");
            Scanner sc = new Scanner(System.in);
            int press = sc.nextInt();
            if (press == 1) Start();
            else if (press == 2) break;
            else System.out.println("Ban da nhap sai cu phap!\nMoi nhap lai!");
        }
    }
    private static void Start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nguoi choi thu nhat nhap ten: ");
        String namePlayer1 = sc.nextLine();
        char[][] board1 = Boards.createBoard('~');
        String[] ships = new String[6];
        ships[1] = "Thiet Giap Ham";
        ships[2] = "Tau Khu Truc";
        ships[3] = "Tau Ngam";
        ships[4] = "Thuyen Tuan Tra";
        int[] length = new int[6];
        length[1]=5;
        length[2]=4;
        length[3]=3;
        length[4]=length[5]=2;
        /*Hết giờ rồi nhưng mà em chưa set Thuyền với chơi ạ :((. Vì yêu cầu 50% nên em xin phép được gửi đến đây thôi ạ <3
        Các class còn lại thì em xong rồi nên các anh có thể xem giúp em phần đó với ạ :>> */
    }
    private void endGame(){
    }
    public static void main(String[] args) {
        menuGame();
    }
}
