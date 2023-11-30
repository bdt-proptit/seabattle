package main.model;

import main.controller.Position;

public class GameShip {
    private Position Start, End;
    public boolean checkPos(int a){
        if(a > 10 || a < 1) return false;
        else return true;
    }
    public Position getStart(){
        return Start;
    }
    public Position getEnd(){
        return End;
    }
    public void setPosShip(Position Start, Position End){
        this.Start = Start;
        this.End = End;
    }
    public boolean checkPosShipOnBoard(GameBoard gameBoard, int sizeShip){
        if(!checkPos(Start.getX()) || !checkPos(Start.getY()) || !checkPos(End.getX()) || !checkPos(End.getY())) return false;
        if((Start.getX() != End.getX()) && (Start.getY() != End.getY())) return false;
        if(Start.getX() == End.getX()){
            if(Math.abs(Start.getY() - End.getY()) != sizeShip) return false;
            for(int i = Math.min(Start.getY(), End.getY()) ; i <= Math.max(Start.getY(), End.getY()); i++){
                if(gameBoard.board[Start.getX()-1][i].getHaveShip() == 1) return false;
            }
        }else{
            if(Math.abs(Start.getX() - End.getX()) != sizeShip) return false;
            for(int i = Math.min(Start.getX(), End.getX()) ; i <= Math.max(Start.getX(), End.getX()); i++){
                if(gameBoard.board[i][Start.getY()-1].getHaveShip() == 1) return false;
            }
        }
        return true;
    }
}
