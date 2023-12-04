package Ship;

public class Submarine {
    Ship submarine = new Ship();
    public void SetupShip(char[][] map){
        System.out.println("Tàu ngầm có chiều dài là 3");
        submarine.setPostStart();
        submarine.setPostEnd();
        if(submarine.getPostStart().getX() == submarine.getPostEnd().getX()){
            for(int i=submarine.getPostStart().getY();i<=submarine.getPostEnd().getY();i++){
                map[submarine.getPostStart().getX()][i]='S';
            }
        }
        else if(submarine.getPostStart().getY() == submarine.getPostEnd().getY()) {
            for (int i = submarine.getPostStart().getX(); i <= submarine.getPostEnd().getX(); i++) {
                map[i][submarine.getPostStart().getY()] = 'S';
            }
        }
    }
}
