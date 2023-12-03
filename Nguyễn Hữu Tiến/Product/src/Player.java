import java.util.Scanner;
public class Player {
    private ClearScreen clrscr = new ClearScreen();
    private String playerName;
    private Ship shipList[] = new Ship[6];
    private int remainingShips = 5;
    private int totalHit = 0;
    // methods
    Scanner sc = new Scanner(System.in);

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRemainingShips() {
        return remainingShips;
    }

    public void setRemainingShips(int remainingShips) {
        this.remainingShips = remainingShips;
    }

    public int getTotalHit() {
        return totalHit;
    }

    public void setTotalHit(int totalHit) {
        this.totalHit = totalHit;
    }

    public Player(){}
    public void getInformation(){
        System.out.println("Player 1");
        System.out.print("Enter your name: ");
        playerName = sc.nextLine();
        for(int i = 1; i <= 5; ++i){
            shipList[i] = new Ship();
            if(i <= 2)
                shipList[i].placeShip("patrol");
            else if(i == 3)
                shipList[i].placeShip("destroyer");
            else if(i == 4)
                shipList[i].placeShip("submarine");
            else if(i == 5)
                shipList[i].placeShip("battle");
        }
        clrscr.clear();
    }
    public void showInformation(Player player2){
        System.out.println("Player: " + playerName);
        System.out.println("Remaining ships: " + remainingShips);
        System.out.println("Total hit: " + totalHit);
        System.out.println("Enemy's ship destroyed: " + (5 - player2.getRemainingShips()));
    }
    public void shoot(Player player2){
        System.out.print("Enter the coordinate you want to shoot: ");
        char px = sc.next().charAt(0);
        int py = sc.nextInt();
        if(px >= 'a' && px <= 'z') px -= 32;
        if(!Ship.checkCoords(px, py)){
            clrscr.clear();
            System.out.println("Invalid coordinate, try again!");
            px = sc.next().charAt(0);
            py = sc.nextInt();
            if(!Ship.checkCoords(px, py)){
                System.out.println("Invalid coordinate, you lost your turn!");
                return;
            }
        }
        // player can shoot again one time
        for(int i = 1; i <= 5; ++i){
            int x = shipList[i].checkHit(px, py);
            switch(x){
                case -1:
                    System.out.println("Miss!"); break;
                case 0:
                    player2.setRemainingShips(player2.getRemainingShips() - 1);
                case 1:
                    totalHit++;
            }
        }
    }
}
