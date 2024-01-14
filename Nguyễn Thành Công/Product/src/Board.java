public class Board {
    private int size;
    private int numCrafts = 5;
    private int destroyedCrafts;
    private CellStatus[][] gird = new CellStatus[25][25];
    private int [][] see = new int[25][25];
    private int min(int a, int b){
        if (a<b) return a;
        return b;
    }
    private int max(int a, int b){
        if (a>b) return a;
        return b;
    }
    public void setUpAllCellStatus(){
        for (int i=1;i<=size;i++){
            for (int j=1;j<=size;j++) gird[i][j]=CellStatus.WATER;
        }
    }
    public void markLocation(Position positionClone, String orientation, int shipSize, CellStatus status){
        Position position = new Position();
        position.setX(positionClone.getX());
        position.setY(positionClone.getY());

        if (orientation.equals("NORTH")) position.setX(position.getX()-shipSize+1);
        else if (orientation.equals("SOUTH")) position.setX(position.getX()+shipSize-1);
        else if (orientation.equals("EAST")) position.setY(position.getY()+shipSize-1);
        else position.setY(position.getY()-shipSize+1);

        for (int i=min(position.getX(),positionClone.getX());i<=max(position.getX(),positionClone.getX());i++){
            for (int j=min(position.getY(),positionClone.getY());j<=max(position.getY(),positionClone.getY());j++){
                gird[i][j]=status;
            }
        }
    }
    public void setSize(int size){
        this.size = size;
    }
//    public int getSize (){
//        return this.size;
//    }
    public boolean checkposition(Position position){
        return position.getX()>=1 && position.getX()<=size && position.getY()>=1 && position.getY()<=size && gird[position.getX()][position.getY()]==CellStatus.WATER;
    }
    public boolean checkMap(Position position){
        return position.getX()>=1 && position.getX()<=size && position.getY()>=1 && position.getY()<=size;
    }
    public boolean checkOrientation (String orientation, Position positionClone, int shipSize){
        Position position = new Position();
        position.setX(positionClone.getX());
        position.setY(positionClone.getY());

        if (orientation.equals("NORTH")) position.setX(position.getX()-shipSize+1);
        else if (orientation.equals("SOUTH")) position.setX(position.getX()+shipSize-1);
        else if (orientation.equals("EAST")) position.setY(position.getY()+shipSize-1);
        else if (orientation.equals("WEST")) position.setY(position.getY()-shipSize+1);
        else return false;

        if (!checkposition(position)) return false;

        for (int i=min(position.getX(),positionClone.getX());i<=max(position.getX(),positionClone.getX());i++){
            for (int j=min(position.getY(),positionClone.getY());j<=max(position.getY(),positionClone.getY());j++){
                if (gird[i][j]!=CellStatus.WATER) return false;
                //System.out.print(gird[i][j]+" ");
            }
            //System.out.println();
        }

        return true;
    }
    public boolean isAttack(Position position){
        return gird[position.getX()][position.getY()]==CellStatus.HIT;
    }
    public void setSeeCell(Position position){
        see[position.getX()][position.getY()] = 1;
    }
    public boolean isSeen(Position position){
        if (this.see[position.getX()][position.getY()]==1) return true;
        return false;
    }
    public void setDestroyedCrafts() {
        destroyedCrafts++;
    }
    public boolean areAllCraftsDestroyed(){
        return destroyedCrafts == numCrafts;
    }
    public void setHitCell(Position position){
        gird[position.getX()][position.getY()] = CellStatus.HIT;
        see[position.getX()][position.getY()] = 1;
    }
    public void show(boolean unveil){
        Display board = new Display();
        if (unveil) board.unveil(gird,see,size);
        else board.veil(gird,see,size);
    }
}
