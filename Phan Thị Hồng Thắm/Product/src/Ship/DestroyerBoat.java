package Ship;
import Play.*;
public class DestroyerBoat {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    Ship destroyerBoat = new Ship();
    public void SetupShip(String[][] map){
        System.out.println(ANSI_YELLOW + "Tàu Khu trục " + ANSI_RESET + "có chiều dài là 4");
        destroyerBoat.setPostStart();
        destroyerBoat.setPostEnd();
        if(destroyerBoat.getPostStart().getX() == destroyerBoat.getPostEnd().getX()){
            for(int i=destroyerBoat.getPostStart().getY();i<=destroyerBoat.getPostEnd().getY();i++) {
                while (map[destroyerBoat.getPostStart().getX()][i] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    destroyerBoat.setPostStart();
                    destroyerBoat.setPostEnd();
                }
            }
            for(int i=destroyerBoat.getPostStart().getY();i<=destroyerBoat.getPostEnd().getY();i++){
                map[destroyerBoat.getPostStart().getX()][i] = ANSI_YELLOW + "D" + ANSI_RESET;
            }
        }
        else if(destroyerBoat.getPostStart().getY() == destroyerBoat.getPostEnd().getY()) {
            for (int i = destroyerBoat.getPostStart().getX(); i <= destroyerBoat.getPostEnd().getX(); i++) {
                while (map[i][destroyerBoat.getPostStart().getY()] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    destroyerBoat.setPostStart();
                    destroyerBoat.setPostEnd();
                }
            }
            for (int i = destroyerBoat.getPostStart().getX(); i <= destroyerBoat.getPostEnd().getX(); i++) {
                map[i][destroyerBoat.getPostStart().getY()] = ANSI_YELLOW + "D" + ANSI_RESET;
            }
        }
    }

}
