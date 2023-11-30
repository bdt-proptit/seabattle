package Play;
import java.util.Scanner;
public class Login{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chào mừng bạn đã tham gia trò chơi SeaBattle của Phan Thắm!");
        while(true){
            System.out.println("Are you ready? Nếu sẵn sàng nhấn phím 1");
            int number = Integer.valueOf(sc.nextLine());
            if(number == 1){
                Playing playing = new Playing();
                playing.Mode();
            }
            else System.out.println("Bạn chưa sẵn sàng ư?? Vậy hãy bình tĩnh và nhập lại nhé!!");
        }
    }
}