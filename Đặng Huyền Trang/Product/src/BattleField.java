public class BattleField {
    private char[][] board = new char[15][15];
    BattleField(){
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                setBoard(i, j, ' ');
            }
        }
    }
    public char getBoard(int row, int col) {
        return board[row][col];
    }

    public void setBoard(int row, int col, char c) {
        board[row][col] = c;
    }
    public void showBoard(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if(i == 0 && j == 0) System.out.print("   ");
                else if(i == 0) System.out.printf(" %2d ", j);
                else if(j == 0) System.out.printf("%2d |", i);
                else{
                    System.out.printf(" %c |", getBoard(i, j));
                }
            }
            System.out.print("\n");
        }
    }
    public void showBlindBoard(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if(i == 0 && j == 0) System.out.print("   ");
                else if(i == 0) System.out.printf(" %2d ", j);
                else if(j == 0) System.out.printf("%2d |", i);
                else{
                    if(getBoard(i, j) == '~') System.out.print("   |");
                    else System.out.printf(" %c |", getBoard(i, j));
                }
            }
            System.out.print("\n");
        }
    }

//    public static void main(String[] args) {
//        BattleField x = new BattleField();
//        x.showBoard();
//    }
}
