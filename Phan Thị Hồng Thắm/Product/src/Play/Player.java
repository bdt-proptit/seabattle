package Play;
import Ship.*;
public class Player {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    private String playerName;
    private int cellFired = 0, shipDestroy = 0, shipRemain = 5,length_BattleShip = 5,length_DestroyedBoat = 4,length_PatrolBoat = 2, length_Submarine = 3;
    public int getLength_BattleShip() {
        return length_BattleShip;
    }
    public void setLength_BattleShip(int length) {
        this.length_BattleShip = length;
    }
    public void setLength_DestroyedBoat(int length_DestroyedBoat) {
        this.length_DestroyedBoat = length_DestroyedBoat;
    }
    public int getLength_DestroyedBoat() {
        return length_DestroyedBoat;
    }
    public void setLength_PatrolBoat(int length_PatrolBoat) {
        this.length_PatrolBoat = length_PatrolBoat;
    }
    public int getLength_PatrolBoat() {
        return length_PatrolBoat;
    }

    public void setLength_Submarine(int length_Submarine) {
        this.length_Submarine = length_Submarine;
    }
    public int getLength_Submarine() {
        return length_Submarine;
    }
    public void setCellFired(int cellFired) {
        this.cellFired = cellFired;
    }
    public int getCellFired() {
        return cellFired;
    }

    public void setShipDestroy(int shipDestroy) {
        this.shipDestroy = shipDestroy;
    }
    public int getShipDestroy() {
        return shipDestroy;
    }
    public void setShipRemain(int shipRemain) {
        this.shipRemain = shipRemain;
    }
    public int getShipRemain(){
        return shipRemain;
    }
    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void SetupMyMap(String[][] myMap){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                myMap[i][j]= ANSI_BLUE + "~" + ANSI_RESET;
            }
        }
        PatrolBoat patrolBoat1 = new PatrolBoat();
        patrolBoat1.SetupShip(myMap);
        PatrolBoat patrolBoat2 = new PatrolBoat();
        patrolBoat2.SetupShip(myMap);
        DestroyerBoat destroyerBoat = new DestroyerBoat();
        destroyerBoat.SetupShip(myMap);
        Submarine submarine = new Submarine();
        submarine.SetupShip(myMap);
        BattleShip battleShip = new BattleShip();
        battleShip.SetupShip(myMap);
    }
    public void ShowMyMap(String[][] map){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i=0;i<10;i++){
            System.out.print((char)('0'+i) + " ");
            for(int j=0;j<10;j++) System.out.print(map[i][j]+" ");
            System.out.print('\n');
        }
    }
}
