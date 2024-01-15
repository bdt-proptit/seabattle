import java.util.Random;
import java.util.ArrayList;

class Coord{
    public Coord(){}
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
    int x; int y;
}
public class Computer extends Player {
    private int preX, preY, dx, dy, index = 0, streak = 0, bound = 0; // streak shows how many square hitted in a row
    private final Random rand = new Random();
    private final char[] a = {'W', 'S', 'A', 'D'};
    private char preDir = ' ';
    private ArrayList<Coord> lis; // list of hitted point in a row
    private boolean flag = false; int k = 0;

    private final String[] botName = {"Alex", "Peter", "Anna", "Tom"};
    public void getInformation(){
        int n = rand.nextInt(4);
        this.setPlayerName(botName[n]);
        System.out.println("Bạn đang chơi với máy " + getPlayerName());
        System.out.println(getPlayerName() + " đang đặt tàu, vui lòng chờ giây lát!");
        for (int i = 0; i < 5; ++i) {
            Ship ship = new Ship();
            if (i < 2)
                ship.placeShipAuto("thuyền tuần tra", getBoard());
            else if (i == 2)
                ship.placeShipAuto("tàu ngầm", getBoard());
            else if (i == 3)
                ship.placeShipAuto("tàu khu trục", getBoard());
            else if (i == 4)
                ship.placeShipAuto("chiến giáp hạm", getBoard());
            getShipList().add(ship);
        }
    }

    public void shoot(Player player2){
        int x = 0, y = 0;
        boolean cont = false;
        if(!cont){ // a random coordinate
            x = rand.nextInt(1, Board.size + 1);
            y = rand.nextInt(1, Board.size + 1);
            if(!checkValidHit(x, y, player2)){
                shoot(player2);
                return;
            }

            int d = 0, check = 0;
            for(int i = 0; i < 5; ++i){
                int k = player2.getShipList().get(i).checkHit(x, y, 0);
                switch(k){
                    case -1: d++; break;
                    case 1:
                        setTotalHit(getTotalHit() + 1); check = 1;
                        cont = true; streak = 1; preX = x; preY = y; index = 0; bound = 0;
                        lis = new ArrayList<>(); lis.add(new Coord(x, y));
                        System.out.println("Thuyền của bạn đã bị đánh trúng!");break;
                    case 0:
                        check = 1;
                        cont = false; streak = 0; // if a ship has already sunk, we don't need to find anymore
                        player2.setRemainingShips(player2.getRemainingShips() - 1);
                        break;
                }
                if(check == 1) break;
            }
            if(d == 5){
                player2.getBoard().setElement(x, y, Board.miss);
                System.out.println("Trượt mất rồi, bạn gặp may đấy. Nhưng chỉ lần này thôi!");
            }
            else
                player2.getBoard().setElement(x, y, Board.hit);
        }
        else{
            // khi bắn ngẫu nhiên trúng một điểm, máy tính sẽ lưu lại điểm đấy, các lượt bắn sau, máy tính sẽ lần lượt
            // kiểm tra từng hướng WASD để greedy
            // khi một hướng bất kỳ là đúng, máy sẽ tiếp tục đi cho đến khi hết tất cả

            if(preDir == ' '){
                if(index == 4) { // after finding all direction
                    cont = false;
                    shoot(player2);
                    return;
                }
                preDir = a[index]; ++index;
                if(index == 2 || index == 4) bound = 0;
                switch(preDir){
                    case 'W': dx = -1; dy = 0; break;
                    case 'S': dx = 1;  dy = 0; break;
                    case 'A': dx = 0; dy = -1; break;
                    case 'D': dx = 0;  dy = 1; break;
                }
            }

            x = preX + streak * dx;
            y = preY + streak * dy;
            if(!checkValidHit(x, y, player2)){ // (x,y) is out of bound
                bound += 1; streak = 1; preDir = ' ';
                shoot(player2);
                return;
            }

            int d = 0, check = 0;
            for(int i = 0; i < 5; ++i){
                int k = player2.getShipList().get(i).checkHit(x, y, 0);
                switch(k){
                    case -1: d++; break;
                    case 1:
                        setTotalHit(getTotalHit() + 1); check = 1;
                        streak++; lis.add(new Coord(x, y));
                        System.out.println("Thuyền của bạn đã bị đánh trúng!");break;
                    case 0:
                        cont = false;
                        player2.setRemainingShips(player2.getRemainingShips() - 1);
                        break;
                }
                if(check == 1) break;
            }
            if(d == 5){
                player2.getBoard().setElement(x, y, Board.miss);
                bound++; preDir = ' '; streak = 1; // reverse to the opposite direction
                System.out.println("Trượt mất rồi, bạn gặp may đấy. Nhưng chỉ lần này thôi!");
                if(bound == 2){
                    preDir = ' '; bound = 0;

                }
            }
            else
                player2.getBoard().setElement(x, y, Board.hit);
        }
    }
}