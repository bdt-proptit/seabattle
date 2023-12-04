public class Ship {
    private String name;
    private int size;
    private int hP;
    private Position position;
    private String orientation;

    Ship(String name, int size) {
        this.name = name;
        this.size = size;
        hP = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setPosition(Position positionClone){
        Position position = new Position();
        position.setX(positionClone.getX());
        position.setY(positionClone.getY());
        this.position = position;
    }
    public Position getPosition(){
        return this.position;
    }
    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
    public String getOrientation(){
        return this.orientation;
    }
    public void setHP(){
        hP--;
    }
    public boolean isShotDown(){
        if (hP == 0) return true;
        else return false;
    }
    public boolean isHit(Position position){
        if (orientation.equals("NORTH")){
            return this.position.getY() == position.getY() && position.getX()<=this.position.getX() && position.getX() >= this.position.getX()-size+1;
        }
        else if (orientation.equals("SOUTH")){
            return this.position.getY() == position.getY() && position.getX()>=this.position.getX() && position.getX() <= this.position.getX()+size-1;
        }
        else if (orientation.equals("WEST")){
            return this.position.getX() == position.getX() && position.getY()<=this.position.getY() && position.getY() >= this.position.getY()-size+1;
        }
        else if (orientation.equals("EAST")){
            return this.position.getX() == position.getX() && position.getY()>=this.position.getY() && position.getY() <= this.position.getY()+size-1;
        }
        return false;
    }
}
