package Play;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("~-------------------------------------------------------------~");
        System.out.println("|                                                             |");
        System.out.println("| Chào mừng bạn đã tham gia trò chơi SeaBattle của Phan Thắm! |");
        System.out.println("|                                                             |");
        System.out.println("~-------------------------------------------------------------~");
        while(true){
            System.out.println("Are you ready? Nếu sẵn sàng nhấn phím 1");
            int number = Integer.valueOf(sc.nextLine());
            if(number == 1){
                Playing1vs1 playing = new Playing1vs1();
                playing.Mode();
            }
            else System.out.println("Bạn chưa sẵn sàng ư?? Vậy hãy bình tĩnh và nhập lại nhé <3!!");
        }
    }
    public static int Exit(){
        return 0;
    }

}