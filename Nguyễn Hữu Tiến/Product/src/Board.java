public class Board {
    private char[][] board = new char[15][15];
    Board(){
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                setboard(i, j, ' ');
            }
        }
    }
    public char getboard(int row, int col) {
        return board[row][col];
    }

    public void setboard(int row, int col, char c) {
        board[row][col] = c;
    }
    public void showboard(){
        for(int j = 0; j <= 10; ++j){
            if(j == 0) System.out.print("   ");
            else System.out.printf(" %2c ", (char)(j));
        }
        for(int i = 0; i < 10; ++i){
            System.out.printf("%2d |", i + 1);
            for(int j = 0; j < 10; ++j){
                System.out.printf(" %c |", board[i][j]);
            }
        }
        System.out.println("\n");
    }
    public void showBlindboard() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if(i == 0 && j == 0) System.out.print("   ");
                else if(i == 0) System.out.printf(" %2c ", (char)(j));
                else if(j == 0) System.out.printf("%2d |", i);
                else{
                    System.out.printf(" %c |", getboard(i, j));
                }
            }
            System.out.print("\n");
        }
    }
}