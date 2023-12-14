import java.io.IOException;

public class BattleField{
    Cell[][] board = new Cell[10][10];

    public void setCells(){
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j){
                board[i][j] = new Cell();
            }
        }
    }
    public void showMyBoard() throws IOException {
        System.out.println("   -----------------------------------------");
        System.out.println("   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        for(int i = 0; i < 10; ++i){
            System.out.printf("|%d|", i);
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("Empty"))
                    System.out.print(Color.bluebackground + "   " + Color.ANSI_Reset + "|");
                else if(board[i][j].getStatus().equals("o"))
                    System.out.print(Color.yellowbackground + Color.red + " o " + Color.ANSI_Reset + "|");
                else if(board[i][j].getStatus().equals("x"))
                    System.out.print(Color.redbackground + Color.yellow + " x " + Color.ANSI_Reset + "|");
                else if(board[i][j].getStatus().equals("P"))
                    System.out.print(Color.cyanbackground + Color.black + " P " + Color.ANSI_Reset + "|");
            }
            System.out.println();
        }
    }

    public void showForOpponent(){
        System.out.println("--------------------------------------------");
        System.out.println("   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        for(int i = 0; i < 10; ++i){
            System.out.printf("|%d| ", i);
            for(int j = 0; j < 10; ++j){
                if(board[i][j].getStatus().equals("o"))
                    System.out.print(Color.yellowbackground + Color.red + " o " + Color.ANSI_Reset + "|");
                else if(board[i][j].getStatus().equals("x"))
                    System.out.print(Color.redbackground + Color.yellow + " x " + Color.ANSI_Reset + "|");
                else System.out.print(Color.bluebackground + "   " + Color.ANSI_Reset + "|");
            }
            System.out.println();
        }
    }

    public boolean checkOutOfBoard(int n){
        if(n>9 || n<0) return true;
        return false;
    }
}
