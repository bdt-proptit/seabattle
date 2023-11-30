package Ship;

public class Submarine {
    Ship submarine = new Ship();
    public void SetupShip(char[][] map){
        System.out.print("Tàu Ngầm"+"\n"+"Chiều dài: 3"+"\n");
        Ship submarine = new Ship();
        submarine.setPostStart();
        submarine.setPostEnd();
        if(submarine.getPostStart().getX() == submarine.getPostEnd().getX()){
            for(int i=submarine.getPostStart().getY();i<=submarine.getPostEnd().getY();i++){
                map[submarine.getPostStart().getX()][i]='X';
            }
        }
        else if(submarine.getPostStart().getY() == submarine.getPostEnd().getY()) {
            for (int i = submarine.getPostStart().getX(); i <= submarine.getPostEnd().getX(); i++) {
                map[i][submarine.getPostStart().getY()] = 'X';
            }
        }
    }
}
