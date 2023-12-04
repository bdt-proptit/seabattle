package Ship;
public class BattleShip {
    Ship battleShip = new Ship();
    public void SetupShip(char[][] map){
        System.out.println("Thiết Giáp Hạm có chiều dài là 5.");
        battleShip.setPostStart();
        battleShip.setPostEnd();
        if(battleShip.getPostStart().getX() == battleShip.getPostEnd().getX()){
            for(int i=battleShip.getPostStart().getY();i<=battleShip.getPostEnd().getY();i++){
                map[battleShip.getPostStart().getX()][i]='B';
            }
        }
        else if(battleShip.getPostStart().getY() == battleShip.getPostEnd().getY()) {
            for (int i = battleShip.getPostStart().getX(); i <= battleShip.getPostEnd().getX(); i++) {
                map[i][battleShip.getPostStart().getY()] = 'B';
            }
        }
    }
}
