public class Shot {
    private int row;
    private int column;

    Shot(int row, int column){
        this.row = row;
        this.column = column;
    }

    private boolean checkScope() {
        if (row < 1 || row > 10 || column < 1 || column > 10)
            return false;
        return true;
    }

    private boolean checkOverlap(char[][] board) {
        if (board[row][column] == 'x' || board[row][column] == 'o')
            return false;
        return true;
    }

    public boolean checkLocation(char board[][]) {
        if (!checkScope() || !checkOverlap(board))
            return false;
        return true;
    }

    public boolean checkHit(char[][] Board) {
        if (Board[row][column]>='2' && Board[row][column]<='5')
            return true;
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
