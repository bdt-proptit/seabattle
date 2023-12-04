package Ship;

public class PatrolBoat {
    Ship patrolBoat = new Ship();
    public void SetupShip(char[][] map){
        System.out.println("Thuyền tuần tra có chiều dài là 2.");
        patrolBoat.setPostStart();
        patrolBoat.setPostEnd();
        if(patrolBoat.getPostStart().getX() == patrolBoat.getPostEnd().getX()){
            for(int i=patrolBoat.getPostStart().getY();i<=patrolBoat.getPostEnd().getY();i++){
                map[patrolBoat.getPostStart().getX()][i]='P';
            }
        }
        else if(patrolBoat.getPostStart().getY() == patrolBoat.getPostEnd().getY()) {
            for (int i = patrolBoat.getPostStart().getX(); i <= patrolBoat.getPostEnd().getX(); i++) {
                map[i][patrolBoat.getPostStart().getY()] = 'P';
            }
        }
    }
}
