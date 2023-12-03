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
        System.out.println("| |0|1|2|3|4|5|6|7|8|9|");
        for(int i = 0; i < 10; ++i){
            System.out.printf("|%d|", i);
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("Empty"))
                    System.out.print(" ");
                else System.out.print(board[i][j].getStatus());
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void showForOpponent(){
        System.out.println("| |0|1|2|3|4|5|6|7|8|9|");
        for(int i = 0; i < 10; ++i){
            System.out.printf("|%d|", i);
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("o"))
                    System.out.printf("o");
                else if(board[i][j].getStatus().equals("x"))
                    System.out.printf("x");
                else System.out.printf(" ");
                System.out.printf("|");
            }
            System.out.println();
        }
    }
}
