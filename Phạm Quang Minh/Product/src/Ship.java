public class Ship {
    private int rowStart;
    private int columnStart;
    private int rowEnd;
    private int columnEnd;
    private int length;
    private boolean status;

    Ship() {
    }

    Ship(int rowStart, int columnStart, int rowEnd, int columnEnd, int length, boolean status) {
        this.rowStart = rowStart;
        this.columnStart = columnStart;
        this.rowEnd = rowEnd;
        this.columnEnd = columnEnd;
        this.length = length;
        this.status = status;
    }

    public String nameShip(int index) {
        switch (index) {
            case 1:
                return "Patrol Boat";
            case 2:
                return "Destroyer Boat";
            case 3:
                return "Submarine";
        }
        return "Battle Ship";
    }

    private boolean checkScope() {
        if (rowStart < 1 || rowEnd > 10 || columnStart < 1 || columnEnd > 10)
            return false;
        return true;
    }

    private boolean checkValid() {
        if (rowStart != rowEnd && columnStart != columnEnd)
            return false;
        return true;
    }

    private boolean checkLength() {
        if (rowEnd == rowStart && Math.abs(columnEnd - columnStart) != length - 1
                || columnEnd == columnStart && Math.abs(rowEnd - rowStart) != length - 1)
            return false;
        return true;
    }

    private boolean checkOverlapOrStatus(char[][] board) {
        if (columnStart == columnEnd) {
            int begin = Math.min(rowEnd, rowStart);
            int end = Math.max(rowEnd, rowStart);
            for (int i = begin; i <= end; i++)
                if (board[i][columnStart] == 's')
                    return false;
        } else {
            int begin = Math.min(columnEnd, columnStart);
            int end = Math.max(columnEnd, columnStart);
            for (int i = begin; i <= end; i++)
                if (board[rowStart][i] == 's')
                    return false;
        }
        return true;
    }

    public boolean checkLocation(char[][] board) {
        if (!checkScope() || !checkValid() || !checkLength() || !checkOverlapOrStatus(board))
            return false;
        return true;
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public int getColumnEnd() {
        return columnEnd;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getCheckStatus(char[][] board) {
        return checkOverlapOrStatus(board);
    }
}
