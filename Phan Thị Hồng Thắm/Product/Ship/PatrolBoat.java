package Ship;

public class PatrolBoat {
    Ship patrolBoat = new Ship();
    public void SetupShip(char[][] map){
        System.out.print("Thuyền Tuần Tra"+"\n"+"Chiều dài: 3"+"\n");
        patrolBoat.setPostStart();
        patrolBoat.setPostEnd();
        if(patrolBoat.getPostStart().getX() == patrolBoat.getPostEnd().getX()){
            for(int i=patrolBoat.getPostStart().getY();i<=patrolBoat.getPostEnd().getY();i++){
                map[patrolBoat.getPostStart().getX()][i]='X';
            }
        }
        else if(patrolBoat.getPostStart().getY() == patrolBoat.getPostEnd().getY()) {
            for (int i = patrolBoat.getPostStart().getX(); i <= patrolBoat.getPostEnd().getX(); i++) {
                map[i][patrolBoat.getPostStart().getY()] = 'X';
            }
        }
    }
}
