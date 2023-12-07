package Ship;
public class BattleShip {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE ="\u001B[34m";
    Ship battleShip = new Ship();
    public void SetupShip(String[][] map){
        System.out.println( ANSI_GREEN + "Thiết Giáp Hạm " + ANSI_RESET + "có chiều dài là 5.");
        battleShip.setPostStart();
        battleShip.setPostEnd();
        if(battleShip.getPostStart().getX() == battleShip.getPostEnd().getX()){
            for(int i=battleShip.getPostStart().getY();i<=battleShip.getPostEnd().getY();i++) {
                while (map[battleShip.getPostStart().getX()][i] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    battleShip.setPostStart();
                    battleShip.setPostEnd();
                }
            }
            for(int i=battleShip.getPostStart().getY();i<=battleShip.getPostEnd().getY();i++){
                map[battleShip.getPostStart().getX()][i] = ANSI_GREEN + "B" + ANSI_RESET;
            }
        }
        else if(battleShip.getPostStart().getY() == battleShip.getPostEnd().getY()) {
            for (int i = battleShip.getPostStart().getX(); i <= battleShip.getPostEnd().getX(); i++) {
                while (map[i][battleShip.getPostStart().getY()] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    battleShip.setPostStart();
                    battleShip.setPostEnd();
                }
            }
            for (int i = battleShip.getPostStart().getX(); i <= battleShip.getPostEnd().getX(); i++) {
                map[i][battleShip.getPostStart().getY()] = ANSI_GREEN + "B" + ANSI_RESET;
            }
        }
    }
}
