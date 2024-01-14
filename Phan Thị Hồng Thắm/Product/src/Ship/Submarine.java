package Ship;

public class Submarine {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE ="\u001B[35m";
    public static final String ANSI_BLUE ="\u001B[34m";
    Ship submarine = new Ship();
    public void SetupShip(String[][] map){
        System.out.println(ANSI_PURPLE + "Tàu ngầm" + ANSI_RESET + " có chiều dài là 3");
        submarine.setPostStart();
        submarine.setPostEnd();
        if(submarine.getPostStart().getX() == submarine.getPostEnd().getX()){
            for(int i=submarine.getPostStart().getY();i<=submarine.getPostEnd().getY();i++) {
                while (map[submarine.getPostStart().getX()][i] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc! Vui lòng nhập lại");
                    submarine.setPostStart();
                    submarine.setPostEnd();
                }
            }
            for(int i=submarine.getPostStart().getY();i<=submarine.getPostEnd().getY();i++){
                map[submarine.getPostStart().getX()][i] = ANSI_PURPLE + "S" + ANSI_RESET;
            }
        }
        else if(submarine.getPostStart().getY() == submarine.getPostEnd().getY()) {
            for (int i = submarine.getPostStart().getX(); i <= submarine.getPostEnd().getX(); i++) {
                while (map[i][submarine.getPostStart().getY()] != ANSI_BLUE + "~" + ANSI_RESET) {
                    System.out.println("Vị trí đã có thuyền tọa lạc!");
                    submarine.setPostStart();
                    submarine.setPostEnd();
                }
            }
            for (int i = submarine.getPostStart().getX(); i <= submarine.getPostEnd().getX(); i++) {
                map[i][submarine.getPostStart().getY()] = ANSI_PURPLE + "S" + ANSI_RESET;
            }
        }
    }
}
