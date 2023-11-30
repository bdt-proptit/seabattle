package Ship;

public class BattleShip {
    Ship battleShip = new Ship();
    public void SetupShip(char[][] map){
        System.out.print("Thiết Giáp Hạm"+"\n"+"Chiều dài: 5"+"\n");
        battleShip.setPostStart();
        battleShip.setPostEnd();
        if(battleShip.getPostStart().getX() == battleShip.getPostEnd().getX()){
            for(int i=battleShip.getPostStart().getY();i<=battleShip.getPostEnd().getY();i++){
                map[battleShip.getPostStart().getX()][i]='X';
            }
        }
        else if(battleShip.getPostStart().getY() == battleShip.getPostEnd().getY()) {
            for (int i = battleShip.getPostStart().getX(); i <= battleShip.getPostEnd().getX(); i++) {
                map[i][battleShip.getPostStart().getY()] = 'X';
            }
        }
    }
}
