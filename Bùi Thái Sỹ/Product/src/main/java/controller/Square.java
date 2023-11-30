package main.controller;

public class Square {
    private int[][] squareShoted = new int[10][10];
//    public void InitSquare(){
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 10; j++) squareShoted[i][j] = 0;
//        }
//    }
    public void setSquareShoted(int[][] squareShoted) {
        this.squareShoted = squareShoted;
    }
    public int[][] getSquareShoted() {
        return squareShoted;
    }
    public void fillColorSquare(Position pos, int status){

    }
    public void printSquare(Square square){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(square.squareShoted[i][j] == 1) System.out.printf("Ban Trung");
                else if(square.squareShoted[i][j] == 0) System.out.println("Ban Khong Trung");
                else System.out.println("Chua ban");
            }
        }
    }
}
