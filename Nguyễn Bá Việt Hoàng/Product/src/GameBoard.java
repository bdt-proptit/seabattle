import java.util.ArrayList;
public class GameBoard {
    private char[][] board = new char[15][15];
    GameBoard(){
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                setBoard(i, j, 'w');
            }
        }
    }
    public char getBoard(int row, int column) {
        return board[row][column];
    }

    public void setBoard(int row, int column, char c) {
        board[row][column] = c;
    }
    public void showBoard(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if(i == 0 && j == 0) System.out.print("    ");
                else if(i == 0) System.out.printf(" %4d ", j);
                else if(j == 0) System.out.printf(" %3d |", i);
                else System.out.printf("  %c  |", getBoard(i, j));
            }
            System.out.println();
        }
    }
}

