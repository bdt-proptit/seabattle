import java.util.ArrayList;
import java.util.List;

public class BattleField{
    Cell[][] board = new Cell[10][10];

    public void setCells(){
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j){
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void showMyBoard(){
        for(int i = 0; i < 10; ++i){
            System.out.print("|");
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("Empty"))
                    System.out.print(" ");
                else System.out.println(board[i][j].getStatus());
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void showOpponentBoard(){
        for(int i = 0; i < 10; ++i){
            System.out.print("|");
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("o"))
                    System.out.print("o");
                else if(board[i][j].getStatus().equals("x"))
                    System.out.println("x");
                else System.out.println(" ");
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
