package Ship;

public class PatrolBoat {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE ="\u001B[34m";
    Ship patrolBoat = new Ship();
    public void SetupShip(String[][] map){
        System.out.println(ANSI_RED + "Thuyền tuần tra" + ANSI_RESET +" có chiều dài là 2.");
        patrolBoat.setPostStart();
        patrolBoat.setPostEnd();
        if(patrolBoat.getPostStart().getX() == patrolBoat.getPostEnd().getX()){
            for(int i=patrolBoat.getPostStart().getY();i<=patrolBoat.getPostEnd().getY();i++) {
                while (map[patrolBoat.getPostStart().getX()][i] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    patrolBoat.setPostStart();
                    patrolBoat.setPostEnd();
                }
            }
            for(int i=patrolBoat.getPostStart().getY();i<=patrolBoat.getPostEnd().getY();i++){
                map[patrolBoat.getPostStart().getX()][i] = ANSI_RED + "P" + ANSI_RESET;
            }
        }
        else if(patrolBoat.getPostStart().getY() == patrolBoat.getPostEnd().getY()) {
            for (int i = patrolBoat.getPostStart().getX(); i <= patrolBoat.getPostEnd().getX(); i++) {
                while (map[i][patrolBoat.getPostStart().getY()] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    patrolBoat.setPostStart();
                    patrolBoat.setPostEnd();
                }
            }
            for (int i = patrolBoat.getPostStart().getX(); i <= patrolBoat.getPostEnd().getX(); i++) {
                map[i][patrolBoat.getPostStart().getY()] = ANSI_RED + "P" + ANSI_RESET;
            }
        }
    }
}
