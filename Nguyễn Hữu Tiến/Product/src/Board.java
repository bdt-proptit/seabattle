import java.util.Scanner;
import java.lang.StringBuilder;

public class Board {
    // Text ANSI colors code
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";

    // Background ANSI colors code
    public static final String ANSI_BLACK_BACKGROUND  = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND    = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND  = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND   = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND   = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND  = "\u001B[47m";

    public static final char water = '~'; // display as blue
    public static final char miss  = '!'; // display as yellow
    public static final char hit   = (char)215; // display as red
    // P: patrol boat 1x2 (thuyền tuần tra) x2 : display as white
    // S: submarine 1x3 (tàu ngầm) x1
    // D: destroyer ship (tàu khu trục) x1
    // B: battle ship (thiết giáp hạm) x1
    public static int size;

    private StringBuilder fiRow = new StringBuilder();
    private final char diCol = (char)166;
    private char[][] board = new char[50][50];

    Board(){}
    //getter, setter
    public char getElement(int row, int col) {
        return board[row][col];
    }
    public void setElement(int row, int col, char c) {
        board[row][col] = c;
    }

    private Scanner sc = new Scanner(System.in);
    public static void setSize(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước bảng: ");
        int size = sc.nextInt();
        if(size < 5 || size > 20){
            System.out.println("Kích thước không hợp lệ, vui lòng nhập trong đoạn [5, 20]!!!");
            System.out.println("_________________________________________________");
            setSize();
            return;
        }
        Board.size = size;
        System.out.println("_________________________________________________");
    }

    public void init(){
        for(int i = 1; i <= size; ++i){
            for(int j = 1; j <= size; ++j)
                board[i][j] = water;
        }
        // set board's bounder
        fiRow.append((char)183);
        fiRow.append("---".repeat(size));
        fiRow.append((char)183);
    }

    public void showPlayerBoard(){
        System.out.print(" ");
        for(int j = 1; j <= size; ++j)
            System.out.printf(" %c ", (64 + j));
        //  A B C D E F ...
        System.out.printf("\n%s\n", fiRow.toString());
        for(int i = 1; i <= size; ++i){
            System.out.print(diCol);
            for(int j = 1; j <= size; ++j){
                switch(board[i][j]){
                    case water:
                        System.out.print(ANSI_BLUE + " " + water + " " + ANSI_RESET); break;
                    case miss:
                        System.out.print(ANSI_YELLOW + " " + miss + " " + ANSI_RESET); break;
                    case hit:
                        System.out.print(ANSI_RED + " " + hit + " " + ANSI_RESET); break;
                    default:
                        System.out.print(ANSI_GREEN + " " + board[i][j] + " " + ANSI_RESET);
                }
            }
            System.out.printf("%c %d\n", diCol, i);
        }
        System.out.println(fiRow.toString());
    }
    public void showBlindBoard() {
        System.out.print(" ");
        for(int j = 1; j <= size; ++j)
            System.out.printf(" %c ", (64 + j));
        //  A B C D E F ...
        System.out.printf("\n%s\n", fiRow.toString());
        for(int i = 1; i <= size; ++i){
            System.out.print(diCol);
            for(int j = 1; j <= size; ++j){
                switch(board[i][j]){
                    case miss:
                        System.out.print(ANSI_YELLOW + " " + miss + " " + ANSI_RESET); break;
                    case hit:
                        System.out.print(ANSI_RED + " " + hit + " " + ANSI_RESET); break;
                    case water:
                    default:
                        System.out.print(ANSI_BLUE + " " + water + " " + ANSI_RESET);
                }
            }
            System.out.printf("%c %d\n", diCol, i);
        }
        System.out.println(fiRow.toString());
    }

//    public static void main(String[] args){
//        Board board1 = new Board();
//        Board board2 = new Board();
//        board1.setSize();
//        board1.showPlayerBoard();
//        board1.showBlindBoard();
//    }
}