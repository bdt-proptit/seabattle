import java.util.Scanner;

public class Menu {
    public static boolean validShip(Player player, Ship ship){
        int x = ship.getX();
        int y = ship.getY();
        int dx = ship.getDirection().dx;
        int dy = ship.getDirection().dy;
        if(ship.getX() < 0 || ship.getX() > 9 || ship.getY() < 0 || ship.getY() > 9) return false;
        for(int i = 0; i < ship.getLength(); i++){
            if(x + dx < 0|| x + dx > 9 ||  y + dy < 0|| y + dy > 9){
                return false;
            }
            if(player.getMainBoard()[x + dx * i][y + dy * i] != 0){
                return false;
            }
        }
        return true;
    }
    public static int restartGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn có muốn khởi động lại trò chơi");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int chosen;
        while(true){
            System.out.print("Lựa chọn của bạn là: ");
            try{
                chosen = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("Vui lòng nhập lại");
                continue;
            }
            if(chosen != 1 && chosen != 2){
                System.out.println("Vui lòng nhập lại");
            }else{
                break;
            }
        }
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
        System.out.print("x\\y");
        for(int i = 0; i < 10; i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            System.out.print(" " + i + " ");
            for(int j = 0; j < 10; j++){
                if(player.getShotBoard()[i][j] == 0){
                    System.out.print(" . ");
                }else if(player.getShotBoard()[i][j] == 1){
                    System.out.print(Color.ANSI_GREEN_BACKGROUND + " o " + Color.ANSI_RESET );
                }else if(player.getShotBoard()[i][j] == -1){
                    System.out.print(Color.ANSI_RED_BACKGROUND + " x " + Color.ANSI_RESET );
                }
            }
            System.out.println();
        }
    }
    public static void shootNoti(int cas){
        if(cas == 1){
            System.out.println("Đã bắn trúng");
        }else if(cas == 0){
            System.out.println("Đã bắn trượt");
        }
    }
    public static void outputPlayerBoard(Player player){
        System.out.println("Lượt chơi của " + player.getName());
        System.out.println("Số ô đã bắn: " + player.getNumberOfShotCell());
        System.out.println("Số tàu đã phá: " + player.getShipDestroyed());
        System.out.println("Số tàu còn lại: " + player.getShipRemain());

        System.out.println("-".repeat(80));
        System.out.printf("Bảng hiện tại: %25s %3s Bảng đối thủ:\n", "||", "");
        System.out.print("x\\y");
        for(int i = 0; i < 10; i++){
            System.out.print(" " + i + " ");
        }
        System.out.printf("%7s", "||");
        System.out.printf("%8s",  "x\\y");
        for(int i = 0; i < 10; i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            System.out.print(" " + i + " ");
            for(int j = 0; j < 10; j++){
                if(player.getMainBoard()[i][j] == 0){
                    System.out.print(" . ");
                }else{

                    System.out.print(Color.ANSI_YELLOW_BACKGROUND + " x " + Color.ANSI_RESET );
                }
            }
            System.out.printf("%7s", "||");
            System.out.printf("%7d ", i);
            for(int j = 0; j < 10; j++){
                if(player.getShotBoard()[i][j] == 0){
                    System.out.print(" . ");
                }else if(player.getShotBoard()[i][j] == 1){
                    System.out.print(Color.ANSI_GREEN_BACKGROUND + " o " + Color.ANSI_RESET );
                }else if(player.getShotBoard()[i][j] == -1){
                    System.out.print(Color.ANSI_RED_BACKGROUND + " x " + Color.ANSI_RESET );
                }
            }
            System.out.println();

        }
        System.out.println("-".repeat(80));
    }
    public static int inputFunction(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Các chức năng:");
        System.out.println("1. Đặt lệnh khai hỏa");
        System.out.println("2. Kết thúc lượt");
        int funcChoice;
        while(true){
            System.out.print("Sự lựa chọn của bạn là: ");
            try{
                funcChoice = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("Vui lòng nhập lại");
                continue;
            }
            if(funcChoice < 0 || funcChoice > 2){
                System.out.println("Vui lòng nhập lại");
            }else{
                break;
            }
        }
        return funcChoice;
    }
    public static int[] inputShootLocation(){
        Scanner sc = new Scanner(System.in);
        int[] location = new int[2];
        while(true){
            System.out.println("Vui lòng nhập tọa độ bắn");
            System.out.print("Nhâp X: ");
            try{
                location[0] = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("Vui lòng nhập lại");
                continue;
            }
            System.out.print("Nhập Y: ");
            try{
                location[1] = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("Vui lòng nhập lại");
                continue;
            }
            if(0 <= location[0] && location[0] <= 9 && 0 <= location[1] && location[1] <= 9) return location;
            System.out.println("Vui lòng nhập lại");
        }
    }
    public static Ship inputShip(ShipType shipType, Player player){
        Scanner sc = new Scanner(System.in);
        int shipChoice;
        Ship ship;
        while(true){
            ship = new Ship();
            int i = 1;
            System.out.println("Danh sách tàu hiện có:");
            for(Ship list : shipType.getList()){
                System.out.println(i + " " + list.getName() + " " + list.getLength() + "x1");
                i++;
            }
            while(true){
                System.out.print("Vui lòng chọn tàu: ");
                try{
                    shipChoice = Integer.parseInt(sc.nextLine());
                }catch(NumberFormatException ex){
                    System.out.println("Vui lòng nhập lại");
                    continue;
                }
                shipChoice--;
                if(shipChoice < 0 || shipChoice > shipType.getList().size() - 1){
                    System.out.println("Vui lòng nhập lại");
                }else{
                    break;
                }
            }
            System.out.println("Vui lòng nhập thông tin tàu");
            ship = shipType.getList().get(shipChoice);
            while(true){
                System.out.print("Nhập X: ");
                try{
                    ship.setX(Integer.parseInt(sc.nextLine()));
                }catch (NumberFormatException ex){
                    System.out.println("Vui lòng nhập lại");
                    continue;
                }
                break;
            }
            while(true){
                System.out.print("Nhập Y: ");
                try{
                    ship.setY(Integer.parseInt(sc.nextLine()));
                }catch (NumberFormatException ex){
                    System.out.println("Vui lòng nhập lại");
                    continue;
                }
                break;
            }
            System.out.println("Danh sách hướng");
            for(Direction dir : Direction.values()){
                System.out.print((dir.ordinal() + 1) + ". " + dir.vietnammese + " ");
            }
            System.out.println();
            int directionChoice;
            while(true){
                System.out.print("Nhập hướng: ");

                 try{
                     directionChoice = Integer.parseInt(sc.nextLine());
                 }catch(NumberFormatException ex){
                     System.out.println("Vui lòng nhập lại");
                     continue;
                 }
                 if(directionChoice < 1 || directionChoice > 4){
                     System.out.println("Vui lòng chọn lại");
                 }else{
                     break;
                 }
            }
            Direction direction = Direction.values()[directionChoice - 1];
            ship.setDirection(direction);
            if(validShip(player, ship) == true) break;
            System.out.println("Tàu không hợp lệ, vui lòng nhập lại");
        }
        shipType.getList().remove(shipChoice);
        return ship;
    }
    public static void endGameNoti(int status, Player p1, Player p2){
        if(status == 1 || status == 2){
            System.out.println("Bảng của người chơi 1:");
            Menu.outputPlayerBoard(p1);
            System.out.println("Bảng của người chơi 2:");
            Menu.outputPlayerBoard(p2);
            if(status == 1){
                System.out.println("Player 1 win");
            }else if(status == 2){
                System.out.println("Player 2 win");
            }
        }else{
            System.out.println("Lượt chơi đã kết thúc");
            pauseScreen();
        }
    }
    public static int inputGameMode(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Các chế độ chơi");
        System.out.println("1. PVP");
        System.out.println("2. PVE");
        int modeChoice;
        while (true){
            System.out.print("Lựa chọn của bạn là: ");
            try{
                modeChoice = Integer.parseInt(sc.nextLine());

            }catch(NumberFormatException ex){
                System.out.println("Vui lòng nhập lại");
                continue;
            }
            break;
        }
        return modeChoice;
    }
}
