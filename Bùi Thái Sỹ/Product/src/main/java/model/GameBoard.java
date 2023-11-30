package main.model;

public class GameBoard {
    public GameCell[][] board = new GameCell[10][10];
    public void initBoard(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
            {
                if (this.board[i][j] == null) {
                    this.board[i][j] = new GameCell();
                }
                else board[i][j].setCellStatus(0,0);
            }
        }
    }
}
