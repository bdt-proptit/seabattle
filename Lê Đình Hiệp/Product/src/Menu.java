import java.util.Scanner;

public class Menu {
    public static int restartGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn có muốn khởi động lại trò chơi");
        System.out.println("1. Có");
        System.out.println("2. Không");
        System.out.print("Lựa chọn của bạn là: ");
        int chosen = Integer.parseInt(sc.nextLine());
        if(chosen == 1) return 1;
        return 0;
    }
    public static void setUpScreen(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên người chơi: ");
        player.setName(sc.nextLine());
        System.out.println("Người chơi " + player.getName() + " chuẩn bị");
    }
    public static void pauseScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhấn Enter để tiếp tục");
        sc.nextLine();
        System.out.println("-".repeat(30));
    }
    public static void outputShotBoard(Player player){
        System.out.println("Bảng đối thủ dạng sương mù");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(player.getShotBoard() + " ");
            }
            System.out.println();
        }
    }
    public static void shootNoti(int cas){
        if(cas == 1){
            System.out.println("Đã bắn trúng");
        }else if(cas == 2){
            System.out.println("Đã bắn trượt");
        }
    }
    public static void outputPlayerBoard(Player player){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(player.getMainBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int inputFunction(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Lượt chơi của " + player.getName());
        System.out.println("Số ô đã bắn: " + player.getNumberOfShotCell());
        System.out.println("Số tàu đã phá: " + player.getShipDestroyed());
        System.out.println("Số tàu còn lại: " + player.getShipRemain());
        System.out.println("Các chức năng:");
        System.out.println("1. Xem bảng của bản thân");
        System.out.println("2. Đặt lệnh khai hỏa");
        System.out.println("3. Kết thúc lượt");
        System.out.print("Sự lựa chọn của bạn là: ");
        int chosen = Integer.parseInt(sc.nextLine());
        return chosen;
    }
    public static int[] inputShootLocation(){
        Scanner sc = new Scanner(System.in);
        int[] location = new int[2];
        System.out.println("Vui lòng nhập tọa độ bắn");
        System.out.print("Nhâp hoành độ: ");
        location[0] = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tung độ: ");
        location[1] = Integer.parseInt(sc.nextLine());
        return location;
    }
    public static Ship inputShip(ShipType shipType){
        Scanner sc = new Scanner(System.in);
        Ship ship = new Ship();
        int i = 1;
        System.out.println("Danh sách tàu hiện có:");
        for(Ship list : shipType.getList()){
            System.out.println(i + " " + list.getName() + " " + list.getLength() + "x1");
            i++;
        }
        System.out.print("Vui lòng chọn tàu: ");
        int chosen = Integer.parseInt(sc.nextLine());
        chosen--;
        ship = shipType.getList().get(chosen);
        System.out.print("Nhập hoành độ: ");
        ship.setX(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhập tung độ: ");
        ship.setY(Integer.parseInt(sc.nextLine()));
        System.out.println("List direction");
        System.out.println("1. Bắc");
        System.out.println("2. Nam");
        System.out.println("3. Đông");
        System.out.println("4. Tây");
        System.out.print("Nhập hướng: ");
        ship.setDirection(Integer.parseInt(sc.nextLine()));
        shipType.getList().remove(chosen);
        return ship;
    }
    public static void endGameNoti(int status, Player p1, Player p2){
        if(status == 1){
            System.out.println("Player 1 win");
        }else if(status == 2){
            System.out.println("Player 2 win");
        }
        if(status == 1 || status == 2){
            System.out.println("Bảng của người chơi 1:");
            Menu.outputPlayerBoard(p1);
            System.out.println("Bảng của người chơi 2:");
            Menu.outputPlayerBoard(p2);
        }else{
            System.out.println("Lượt chơi đã kết thúc");
            pauseScreen();
        }
    }
}
