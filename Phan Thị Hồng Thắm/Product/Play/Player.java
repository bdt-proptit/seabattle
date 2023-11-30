package Play;
import Ship.*;
public class Player {
    private char[][] Mymap;
    private String playerName;
    private int cellFired = 0, shipDestroy = 0, shipRemain = 5;
    public void setPlayerName(){
        this.playerName=playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void SetupMyMap(char[][] map){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                map[i][j]='~';
            }
        }
        PatrolBoat patrolBoat1 = new PatrolBoat();
        patrolBoat1.SetupShip(Mymap);
        PatrolBoat patrolBoat2 = new PatrolBoat();
        patrolBoat2.SetupShip(Mymap);
        DestroyerBoat destroyerBoat = new DestroyerBoat();
        destroyerBoat.SetupShip(Mymap);
        Submarine submarine = new Submarine();
        submarine.SetupShip(Mymap);
        BattleShip battleShip = new BattleShip();
        battleShip.SetupShip(Mymap);
    }
    public void ShowMyMap(char[][] map){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++) System.out.print(map[i][j]+' ');
            System.out.print('\n');
        }
    }
}
