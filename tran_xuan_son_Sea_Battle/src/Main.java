import java.util.Scanner;
import java.util.Vector;
// Việc chưa hoàn thành:
//** (Xong)     Thêm tính năng bảng xếp hạng số lượt bắn ít nhất,
//        số tàu còn lại của người chơi khi thắng,
//        Lúc này khi vào game cần nhập thêm tên người chơi để lưu lại,
//        ở menu ban đầu có thể chọn hiển thị bảng xếp hạng.
//** (Đã xuất, nhưng chưa chạy đc ???) Export thành file .jar

//*** (Tạm xong, chưa biết có tôi ưu chưa)    Bot Greedy, biết chơi greedy như tập trung bắn nốt 1 tàu khi đã bắn trúng được 1 điểm.
//*** Vấn đề: nếu đánh  ô   (0,1) , mà (0,2) và ô (0,0) đều có tàu thì nó chỉ đánh theo 1 hướng :(


//***     Thêm tính năng lưu trạng thái của game để chơi tiếp khi thoát,
//        trạng thái của 1 game bao gồm trạng thái bảng của 2 người chơi,
//        lượt hiện tại, .. Sau đó ở menu ban đầu có thể chọn load game để chơi tiếp
// - Ý tưởng: Lưu lại Class GameMenu vào 1 vector, nếu mà -----Muốn chơi tiếps: 1 => Bật lại bảng theo lượt
                                                          //  -Ko muốn chơi tiếp, tạo gamemenu mới.
                                                          // Chơi xong nhớ reset(tạo lại gamemenu
//***Vấn đề : Chẳng nhé trong lúc chơi phải có 1 nút thoát?.....

//***     Cơ chế vẽ bảng dynamic, cho phép truyền vào 1 số để có bảng là hình vuông từ 10x10 đến 20x20,
//        mọi tính năng vẫn chạy tốt


// Yêu cầu: chữ vàng
// đưa ra lựa chọn: chữ xanh
// Báo lỗi: chữ đỏ
public class Main {
    public static Vector<Player> List = new Vector<>();
    public static Vector<Player> List_Ranking = new Vector<>(); // chỉ push ng thắng vô, sắp xếp.
 //   public static int thelastgame = 0;

    public static void main(String[] args) {
        Game_Menu gamemenu = new Game_Menu();

        //Scanner sc = new Scanner(System.in);
        while(true){ // Cho game chạy vô hạn luôn
            //Game_Menu gamemenu= new Game_Menu();
       //     if(thelastgame == 1){
       //         gamemenu.Continue();
       //     }
            //else
                gamemenu.LetsGo();
        }
    }
}
//2 or 1
//haruyama
//10
//0 0 0 1 1 1 1 2 3 0 6 0 0 6 0 8 3 2 3 6
//0 0 1 0 2 0 3 0 0 1 0 4 1 1 1 3 0 5 0 9


// 0 0 0 0 0 1 0 1 0 2 0 2 0 3 0 3 0 4 0 4 0 5 0 5 0 6 0 6 0 7 0 7 0 8 0 8 0 9 0 9
// 1 0 1 0 1 1 1 1 1 2 1 2 1 3 1 3
// 2 0 2 0
// 3 0 3 0