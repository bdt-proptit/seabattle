package Ship;
import Play.*;
public class DestroyerBoat {
    Ship destroyerBoat = new Ship();
    public void SetupShip(char[][] map){
        System.out.print("Tàu Khu Trục"+"\n"+"Chiều dài: 3"+"\n");
        destroyerBoat.setPostStart();
        destroyerBoat.setPostEnd();
        if(destroyerBoat.getPostStart().getX() == destroyerBoat.getPostEnd().getX()){
            for(int i=destroyerBoat.getPostStart().getY();i<=destroyerBoat.getPostEnd().getY();i++){
                map[destroyerBoat.getPostStart().getX()][i]='X';
            }
        }
        else if(destroyerBoat.getPostStart().getY() == destroyerBoat.getPostEnd().getY()){
            for(int i=destroyerBoat.getPostStart().getX();i<=destroyerBoat.getPostEnd().getX();i++){
                map[i][destroyerBoat.getPostStart().getY()]='X';
            }
        }
    }

}
