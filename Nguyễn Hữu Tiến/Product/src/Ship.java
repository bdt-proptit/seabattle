import java.util.Scanner;
import java.util.Random;

public class Ship {
    // attributes
    private String shipType; // patrol, destroyer, submarine, battle
    int x; int y; // Coordinates of the first square of the ship
    private int dx, dy;
    private char direction; // WASD
    private int length;
    private boolean[] isRemained;
    private int destroyedPart;
    public boolean isDestroyed;
    private final Scanner sc = new Scanner(System.in);

    // getters, setters, constructors
    public Ship(){
        destroyedPart = 0;
        isDestroyed = false;
    }
    public void setShipType(String shipType){
        this.shipType = shipType;
    }

    public void setFirstCoord(){
        System.out.print("Nhập tọa độ tàu: ");
        String s = sc.next();
        int x = 0, i = 0;
        while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            x = x * 10 + s.charAt(i) - '0';
            ++i;
        }
        char c = s.charAt(i); if(!(c >= 'A' && c <= 'Z')) c -= 32;
        int y = c - 'A' + 1;

        if(!checkCoord(x, y)){
            System.out.println("Tọa độ không tồn tại, vui lòng nhập lại!");
            setFirstCoord();
            return;
        }
        this.x = x;
        this.y = y;
    }

    public void setDirection(){
        System.out.print("Nhập hướng tàu: ");
        char direction = sc.next().charAt(0);
        if(!(direction >= 'A' && direction <= 'Z')) direction -= 32;

        if(!checkDirection(direction)) {
            System.out.print("Đầu vào không hợp lệ!\nW: hướng lên - S: hướng xuống - A: bên trái - D: bên phải\n");
            setDirection();
            return;
        }
        switch(direction){
            case 'W': dx = -1; dy = 0; break;
            case 'A': dx = 0; dy = -1; break;
            case 'S': dx = 1; dy = 0; break;
            case 'D': dx = 0; dy = 1; break;
        }
        this.direction = direction;
    }

    public void setLength(){
        switch (shipType) {
            case "thuyền tuần tra":
                length = 2;
                break;
            case "tàu ngầm":
                length = 3;
                break;
            case "tàu khu trục":
                length = 4;
                break;
            case "chiến giáp hạm":
                length = 5;
                break;
        }
    }

    // checkers
    public static boolean checkCoord(int x, int y){
        return (x >= 1 && x <= Board.size) && (y >= 1 && y <= Board.size); // size
    }
    public boolean checkDirection(char c){
        return c == 'W' || c == 'A' || c == 'S' || c == 'D';
    }
    private boolean checkPosition(){
        int lx = x + (length - 1)*dx; // Coordination of the ship's last square
        int ly = y + (length - 1)*dy;
        return checkCoord(lx, ly);
    }
    private boolean checkCollision(Board board){
        int x = this.x; int y = this.y;
        for(int i = 0; i < length; ++i){
            if(board.getElement(x, y) != Board.water)
                return false;
            x += dx; y += dy;
        }
        return true;
    }

    public int checkHit(int px, int py, int player){
        // return 0: enemy's ship is destroyed
        // return 1: hit
        // return -1: miss
        // player = 1: player1
        // player = 2: player2
        // player = 0: computer
        if(isDestroyed) return -1;

        for(int i = 0; i < length; i++) {
            if (px == x + i * dx && py == y + i * dy && isRemained[i]) {
                isRemained[i] = false;
                destroyedPart++;

                if(destroyedPart == length){
                    if(player == 0)
                        System.out.println("Một " + shipType + " của bạn đã bị đánh chìm!");
                    else
                        System.out.println("Chúc mừng, bạn vừa đánh chìm 1 " + shipType + " của đối thủ!");
                    isDestroyed = true;
                    return 0;
                }
                return 1;
            }
        }
        return -1;
    }

    // methods
    public void placeShipManual(String shipType, Board board){
        System.out.println("********************");
        System.out.println("Đặt " + shipType);
        setShipType(shipType);
        setLength();
        setFirstCoord();
        setDirection();
        if(!checkPosition()){
            System.out.println("Bạn đã đặt tàu ngoài bảng, vui lòng đặt lại!");
            placeShipManual(shipType, board);
            return;
        }
        if(!checkCollision(board)){
            System.out.println("Vị trí vừa đặt va chạm vào tàu khác, vui lòng đặt lại!");
            placeShipManual(shipType, board);
            return;
        }
        isRemained = new boolean[length+1];

        for(int i = 0; i < length; ++i) isRemained[i] = true;
        int x = this.x; int y = this.y;

        char c = '~';
        switch(shipType){
            case "thuyền tuần tra": c = 'P'; break; // patrol
            case "tàu ngầm": c = 'S'; break; // submarine
            case "tàu khu trục": c = 'D'; break; // destroyer
            case "chiến giáp hạm": c = 'B'; break; // battle ship
        }
        for(int i = 0; i < length; ++i){
            board.setElement(x, y, c);
            x += dx; y += dy;
        }
    }

    public void placeShipAuto(String shipType, Board board){
        Random rand = new Random();
        setShipType(shipType);
        setLength();
        char[] a = {'W', 'A', 'S', 'D'};
        int x, y; char dir;

        while(true){
            x = rand.nextInt(1, Board.size + 1);
            y = rand.nextInt(1, Board.size + 1);
            dir = a[rand.nextInt(4)];

            this.x = x; this.y = y;
            this.direction = dir;
            switch(direction){
                case 'W': dx = -1; dy = 0; break;
                case 'A': dx = 0; dy = -1; break;
                case 'S': dx = 1; dy = 0; break;
                case 'D': dx = 0; dy = 1; break;
            }
            if(checkPosition() && checkCollision(board)) break;
        }

        isRemained = new boolean[length+1];
        for(int i = 0; i < length; ++i) isRemained[i] = true;

        char c = '~';
        switch(shipType){
            case "thuyền tuần tra": c = 'P'; break; // patrol
            case "tàu ngầm": c = 'S'; break; // submarine
            case "tàu khu trục": c = 'D'; break; // destroyer
            case "chiến giáp hạm": c = 'B'; break; // battle ship
        }

        for(int i = 0; i < length; ++i){
            board.setElement(x, y, c);
            x += dx; y += dy;
        }
    }
}