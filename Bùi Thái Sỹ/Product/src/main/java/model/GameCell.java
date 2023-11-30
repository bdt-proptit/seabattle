package main.model;

public class GameCell {
    private int haveShip, shoted;
    public int getHaveShip() {
        return haveShip;
    }
    public int getShoted(){
        return shoted;
    }
    public void setCellStatus(int haveShip, int shoted){
        this.haveShip = haveShip;
        this.shoted = shoted;
    }
    public void fillColorCell(int haveShip, int shoted){

    }
    public void printCell(){

    }
}
