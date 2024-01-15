import java.util.Scanner;
import java.util.ArrayList;
public class Player {

    // attributes
    private String playerName;
    private ArrayList<Ship> shipList;
    private int remainingShips = 5;
    private int totalHit = 0;
    Scanner sc = new Scanner(System.in);
    private Board board;

    // getters, setters, constructor
    public Player(){
        shipList = new ArrayList<>();
        board = new Board();
    }

    public ArrayList<Ship> getShipList(){
        return shipList;
    }
    public Board getBoard(){
        return board;
    }
    // player name
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // remaining ship
    public int getRemainingShips() {
        return remainingShips;
    }
    public void setRemainingShips(int remainingShips) {
        this.remainingShips = remainingShips;
    }

    //total hits
    public int getTotalHit() {
        return totalHit;
    }
    public void setTotalHit(int totalHit) {
        this.totalHit = totalHit;
    }

    // methods
    public void getInformation(){
        playerName = sc.nextLine();
        System.out.println("1. Đặt tàu thủ công");
        System.out.println("2. Đặt tàu tự động");
        System.out.print("Chọn chế độ: ");
        int ops = sc.nextInt();
        System.out.println("_________________________________________________");
        if(ops == 1) {
            for (int i = 0; i < 5; ++i) {
                Ship ship = new Ship();
                if (i < 2)
                    ship.placeShipManual("thuyền tuần tra", this.board);
                else if (i == 2)
                    ship.placeShipManual("tàu ngầm", this.board);
                else if (i == 3)
                    ship.placeShipManual("tàu khu trục", this.board);
                else if (i == 4)
                    ship.placeShipManual("chiến giáp hạm", this.board);
                shipList.add(ship);
            }
            System.out.println("Đây là bản đồ vị trí tàu của bạn");
            board.showPlayerBoard();
            System.out.print("Bấm Enter để tiếp tục!");
            String s = sc.nextLine();
        }
        else{
            System.out.println("Đang đặt tàu tự động, vui lòng chờ giây lát!");
            for (int i = 0; i < 5; ++i) {
                Ship ship = new Ship();
                if (i < 2)
                    ship.placeShipAuto("thuyền tuần tra", this.board);
                else if (i == 2)
                    ship.placeShipAuto("tàu ngầm", this.board);
                else if (i == 3)
                    ship.placeShipAuto("tàu khu trục", this.board);
                else if (i == 4)
                    ship.placeShipAuto("chiến giáp hạm", this.board);
                shipList.add(ship);
            }
            System.out.println("\nĐây là bản đồ vị trí tàu của bạn");
            board.showPlayerBoard();
            sc.nextLine();
            System.out.print("Bấm Enter để tiếp tục!");
            String s = sc.nextLine();
        }
    }

    public void showInformation(Player player2){
        System.out.println("Player: " + playerName);
        System.out.println("Số tàu còn lại: " + remainingShips);
        System.out.println("Số lần bắn trúng: " + totalHit);
        System.out.println("Số tàu địch còn lại: " + player2.getRemainingShips());
    }

    public boolean checkValidHit(int x, int y, Player opponent){
        if(!Ship.checkCoord(x, y)){
            System.out.print("Tọa độ không hợp lệ! ");
            return false;
        }
        int c = opponent.getBoard().getElement(x, y);
        if(c == Board.miss || c == Board.hit) {
            System.out.print("Bạn đã bắn điểm này trước đó! ");
            return false;
        }
        return true;
    }

    public void shoot(StringBuilder s, Player player2){
        int x, i, y, cnt = 1;
        while(true) {
            x = 0; i = 0; y = 0;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9' && i < s.length()-1) {
                x = x * 10 + s.charAt(i) - '0';
                ++i;
            }
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z')) c -= 32;
            y = c - 'A' + 1;

            if(checkValidHit(x, y, player2)) break;

            if(cnt > 2){
                System.out.println("Bạn đã mất lượt!");
                return;
            }
            System.out.print("Vui lòng nhập lại: ");
            s = new StringBuilder(); s.append(sc.next()); ++cnt;
        }

        int d = 0, check = 0;
        for(i = 0; i < 5; ++i){
            int k = player2.getShipList().get(i).checkHit(x, y, 1);
            switch(k){
                case -1: d++; break;
                case 1:
                    totalHit++; check = 1;
                    System.out.println("Bạn đã bắn trúng tàu đối thủ!"); break;
                case 0:
                    check = 1;
                    player2.setRemainingShips(player2.getRemainingShips() - 1);
                    break;
            }
            if(check == 1) break;
        }
        if(d == 5){
            player2.getBoard().setElement(x, y, Board.miss);
            System.out.println("Trượt mất rồi, đối thủ đang cười vào mặt bạn!");
        }
        else
            player2.getBoard().setElement(x, y, Board.hit);
    }

//    public static void main(String[] args){
//        Player player1 = new Player();
//        player1.getInformation();
//    }
}