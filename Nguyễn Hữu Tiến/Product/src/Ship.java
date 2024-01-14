import java.util.Scanner;
public class Ship {
    private ClearScreen clrscr = new ClearScreen();
    // fields
    private String shipType; // patrol, destroyer, submarine, battle
    char x; int y; // Coordinates of the first square of the ship
    private int dx, dy;
    private char direction; // WASD
    private int length;
    private boolean partDestroyed[];
    private int destroyed = 0;
    public boolean isDestroyed = false;
    // methods
    Scanner sc = new Scanner(System.in);
    public static boolean checkCoords(char x, int y){
        if(((x >= 'A' && x <= 'J') || (x >= 'a' && x <= 'j')) && (y >= 1 && y <= 10)) return true;
        else return false;
    }
    public boolean checkDirection(char direction){
        if(direction == 'W' || direction == 'A' || direction == 'S' || direction == 'D') return true;
        if(direction == 'w' || direction == 'a' || direction == 's' || direction == 'd') return true;
        else return false;
    }
    private boolean checkPosition(){
        if(direction == 'W' && y - length >= 1) return true;
        else if(direction == 'A' && x - length >= 'A') return true;
        else if(direction == 'S' && y + length <= 10 ) return true;
        else if(direction == 'D' && x + length <= 'J') return true;
        else return false;
    }
    public Ship(){}
    public void setShipType(String shipType){
        this.shipType = shipType;
    }
    public void setFirstCoord(){
        System.out.print("Enter the head's coordinate of the ship: ");
        char x = sc.next().charAt(0);
        int y = sc.nextInt();
        while(!checkCoords(x, y)){
            System.out.print("Invalid coordinate! Enter the head's coordinate of the ship: ");
            x = sc.next().charAt(0);
            y = sc.nextInt();
        }
        this.x = x;
        this.y = y;
    }
    public void setDirection(){
        System.out.print("Enter the direction of the ship: ");
        char direction = sc.next().charAt(0);
        while(!checkDirection(direction)){
            clrscr.clear();
            System.out.print("Invalid direction!\nW: up\nA: left\nS: down\nD: right\n");
            System.out.print("Enter the direction of the ship:");
            direction = sc.next().charAt(0);
        }
        if(direction >= 'a' && direction <= 'z') direction -= 32;
        this.direction = direction;
        switch(direction){
            case 'W': dx = 0; dy = -1; break;
            case 'A': dx = -1; dy = 0; break;
            case 'S': dx = 0; dy = 1; break;
            case 'D': dx = 1; dy = 0; break;
        }
    }
    public void setLength(){
        switch (shipType) {
            case "patrol":
                length = 2;
                break;
            case "destroyer":
                length = 4;
                break;
            case "submarine":
                length = 3;
                break;
            case "battle":
                length = 5;
                break;
        }
    }
    public void placeShip(String shipType){
        System.out.println("Placing a " + shipType + " ship");
        setShipType(shipType);
        setLength();
        setFirstCoord();
        setDirection();
        while(!checkPosition()){
            System.out.println("Invalid position, please try again!");
            setFirstCoord();
            setDirection();
        }
        partDestroyed = new boolean[length];
        for(boolean c : partDestroyed) c = false;
    }
    public int checkHit(char px, int py){
        // return 0: enemy's ship is destroyed
        // return 1: hit
        // return -1: miss
        for(int i = 0; i < length; i++) {
            if (px == x + i * dx && py == y + i * dy) {
                partDestroyed[i] = true;
                destroyed++;
                System.out.println("Hit!");
                if(destroyed == length){
                    System.out.println("Congratulation, you have sunken a enemy's " + shipType + "!");
                    isDestroyed = true;
                    return 0;
                }
                return 1;
            }
        }
        return -1;
    }
}
