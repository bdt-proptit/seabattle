public class Board {
    private int size;
    private int numCrafts = 5;
    private int destroyedCrafts;
    private CellStatus[][] gird = new CellStatus[size+1][size+1];

    Board(int size){
        this.size = size;
    }
    public void setUpCellStatus(){
        for (int i=1;i<=size;i++){
            for (int j=1;j<=size;j++) gird[i][j]=CellStatus.WATER;
        }
    }
    public int getSize (){
        return this.size;
    }
    public boolean checkposition(Position position){
        return position.getX()>=1 && position.getX()<=size && position.getY()>=1 && position.getY()<=size;
    }
    public boolean checkOrientation (String orientation, Position position, int size){
        if (orientation.equals("NOTH")){
            position.setY(position.getY()-size+1);
            if (checkposition(position)){
                return true;
            }
        }
        else if (orientation.equals("SOUTH")){
            position.setY(position.getY()+size-1);
            if (!checkposition(position)){
                return true;
            }
        }
        else if (orientation.equals("EAST")){
            position.setX(position.getX()+size-1);
            if (!checkposition(position)){
                return true;
            }
        }
        else if (orientation.equals("WEST")){
            position.setX(position.getX()-size+1);
            if (!checkposition(position)){
                return true;
            }
        }
        return false;
    }
    public boolean isSeen(Position position){
        if (gird[position.getX()][position.getY()].equals(CellStatus.WATER)) return false;
        else return true;
    }
    public void setDestroyedCrafts() {
        destroyedCrafts++;
    }
    public boolean areAllCraftsDestroyed(){
        return destroyedCrafts == numCrafts;
    }
    public void setHitCell(Position position){
        gird[position.getX()][position.getY()] = CellStatus.HIT;
    }
    public void show(boolean unveil){
        if (unveil == true){

        }
        else
        {

        }
    }

}
