import java.util.ArrayList;
import java.util.Scanner;

public class Player extends BattleField{
    public Boat[] boats = new Boat[5];
    public int numberOfBoats = 0, check = 0, numberOfHits = 0;
    public void setUpBoat() {
        while (numberOfBoats < 5) {
            showBoard();
            Scanner input = new Scanner(System.in);
            String name;
            int sizeBoat;
            if(numberOfBoats < 2){
                name = "Thuyển Tuần Tra";
                sizeBoat = 2;
            }
            else if(numberOfBoats == 2){
                name = "Tàu khu trục";
                sizeBoat = 4;
            }
            else if(numberOfBoats == 3){
                name = "Tàu ngầm";
                sizeBoat = 3;
            }
            else {
                name = "Thiết chiến hạm";
                sizeBoat = 5;
            }
            System.out.println("Thông tin " + name + " kích cỡ 1x" + sizeBoat);
            System.out.println("Nhập tọa độ đầu tàu:");
            System.out.print("x: ");
            int x_begin = input.nextInt();
            System.out.print("y: ");
            int y_begin = input.nextInt();
            System.out.println("Nhập tọa độ đuôi tàu:");
            System.out.print("x: ");
            int x_end = input.nextInt();
            System.out.print("y: ");
            int y_end = input.nextInt();
            Boat tmp = new Boat(name, x_begin, y_begin, x_end, y_end, sizeBoat);
            boats[numberOfBoats] = tmp;
            numberOfBoats++;
            for (int i = x_begin; i <= x_end; i++) {
                for (int j = y_begin; j <= y_end; j++) {
                    setBoard(i, j, '~');
                }
            }
        }
        showBoard();
    }

    public void beAttacked(){
        numberOfHits++;
        Scanner input = new Scanner(System.in);
        System.out.print("x: ");
        int x = input.nextInt();
        System.out.print("y: ");
        int y = input.nextInt();
        checkHit(x, y);
    }
    public void checkHit(int x, int y){
        if(getBoard(x, y) == '~'){
            System.out.println("Đã bắn trúng tàu!");
            setBoard(x, y, 'x');
            checkBoat(x, y);
        }
        else{
            setBoard(x, y, 'o');
            System.out.println("Đã bắn không trúng tàu!");
        }
    }
    public void checkBoat(int x, int y){
        for(Boat tmp: boats){
            if(x >= tmp.getX_begin() && x <= tmp.getX_end() && y >= tmp.getY_begin() && y <= tmp.getY_end()){
                tmp.setSizeBoat(tmp.getSizeBoat() - 1);
                if(tmp.getSizeBoat() == 0){
                    numberOfBoats--;
                    System.out.println(tmp.getName() + " đã bị bắn hạ!");
                    checkWinner();
                }
            }
        }
    }
    public void checkWinner(){
        if(numberOfBoats == 0){
            System.out.println("Bạn là người chiến thắng!");
            System.out.println("Trò chơi kết thúc!");
            check = 1;
        }
    }
}
