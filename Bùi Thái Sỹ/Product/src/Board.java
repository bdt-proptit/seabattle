import java.util.Objects;

public class Board{
    FillColor fill = new FillColor();
    private int SIZE_BOARD = 10;
    public void setSIZE_BOARD(int x) {
        SIZE_BOARD = x;
    }
    private final String[][] board = new String[SIZE_BOARD+1][SIZE_BOARD+1];
    public void setCell(Position pos, String str) {
        board[pos.getX()][pos.getY()] = str;
    }
    public String getCell(Position pos) {
        return board[pos.getX()][pos.getY()];
    }
    public void initBoard() {
        fill.initColor();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Position pos = new Position(i, j);
                setCell(pos, "O");
            }
        }
    }
    public void printYourBoard(){
        System.out.println("Let's set up ship on your sea!!!");
        fill.initColor();
        for(int i = 0; i < 44; i++) System.out.print("_");
        System.out.println();
        for (int i = 0; i <= SIZE_BOARD; i++) {
            for (int j = 0; j <= SIZE_BOARD; j++) {
                if (i == j && i == 0) System.out.print("|   ");
                else if (j == 0 || i == 0) System.out.printf("|%-3d", ((i == 0) ? j : i));
                else{
                    Position pos = new Position(i, j);
                    if(getCell(pos) == null) System.out.printf("|%-3s", fill.color.get("W") + "   " + FillColor.RESET);
                    else{
                        System.out.print("|");
                        System.out.print(fill.color.get(getCell(pos)) + FillColor.SHIP);
                        System.out.printf("%-3s", getCell(pos));
                        System.out.print(FillColor.RESET);
                    }
                }
                if(j == SIZE_BOARD) System.out.print("|");
            }
            System.out.println();
        }
        for(int i = 0; i < 44; i++) System.out.print("_");
        System.out.println();
    }
    public void printBoard(Board yourBoard, Board oppBoard) {
        System.out.println("                      Your Board                                    Opp Board");
        fill.initColor();
        for(int i = 0; i < 93; i++) System.out.print("_");
        System.out.println();
        for (int i = 0; i <= SIZE_BOARD; i++) {
            for (int j = 0; j <= SIZE_BOARD*2 + 4; j++) {
                if((j >= 0 && j <= SIZE_BOARD)){
                    if(i == j && i == 0) System.out.print("|   ");
                    else if(j == 0||i==0) System.out.printf("|%-3d", ((i==0)?j : i));
                    else {
                        Position pos = new Position(i, j);
                        if(yourBoard.getCell(pos) == null) System.out.printf("|%-3s", fill.color.get("W") + "   " + FillColor.RESET);
                        else if(Objects.equals(yourBoard.getCell(pos), "S")){
                            System.out.print("|");
                            System.out.print(fill.color.get(yourBoard.getCell(pos)) + FillColor.SHIP);
                            System.out.printf("%-3s", yourBoard.getCell(pos));
                            System.out.print(FillColor.RESET);
                        }else if(Objects.equals(yourBoard.getCell(pos), "X")){
                            System.out.print("|");
                            System.out.print(fill.color.get("S") + fill.color.get("X"));
                            System.out.printf("%-3s", "X");
                            System.out.print(FillColor.RESET);
                        }else{
                            System.out.print("|");
                            System.out.print(fill.color.get("S") + fill.color.get("O"));
                            System.out.printf("%-3s", "M");
                            System.out.print(FillColor.RESET);
                        }
                    }
                    if(j == SIZE_BOARD) System.out.print("|");
                }
                else if(j > SIZE_BOARD && j <= SIZE_BOARD + 3){
                    System.out.print("~");
                }
                else{
                    if (j == SIZE_BOARD + 4 && i == 0) System.out.print("|   ");
                    else if(j == SIZE_BOARD + 4||i == 0) System.out.printf("|%-3d", ((i==0)? j-14  : i ));
                    else {
                        Position pos = new Position(i, j-14);
                        if(oppBoard.getCell(pos) == null || Objects.equals(oppBoard.getCell(pos), "S")) System.out.printf("|%-3s", fill.color.get("W") + "   " + FillColor.RESET);
                        else if (Objects.equals(oppBoard.getCell(pos), "X")) {
                            System.out.print("|");
                            System.out.print(fill.color.get("S") + fill.color.get("X"));
                            System.out.printf("%-3s", "X");
                            System.out.print(FillColor.RESET);
                        } else {
                            System.out.print("|");
                            System.out.print(fill.color.get("S") + fill.color.get("O"));
                            System.out.printf("%-3s", "M");
                            System.out.print(FillColor.RESET);
                        }
                    }
                }
            }
            System.out.println("|");
        }
        for(int i = 0; i < 93; i++) System.out.print("_");
        System.out.println();
    }
}
