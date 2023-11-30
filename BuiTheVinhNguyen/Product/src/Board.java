public class Board {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    char[][] board = new char[12][12];
    char[][] boardForOpponent = new char[12][12];

    String playerName;

    int shipRemaining = 5, destroyedSquare = 0;

    Board()
    {
        for(int i = 0; i <= 11; i++)
        {
            for(int j = 0; j <= 11; j++)
            {
                board[i][j] = 'o';
                boardForOpponent[i][j] = 'o';
            }
        }
    }

    public void show()
    {

        System.out.print(ANSI_YELLOW + "P:Patrol Boat  " + ANSI_RESET);
        System.out.print(ANSI_CYAN + "D:Destroyer Boat  " + ANSI_RESET);
        System.out.print(ANSI_GREEN + "S:Submarine  " + ANSI_RESET);
        System.out.print(ANSI_RED + "B:Battle Ship  " + ANSI_RESET);
        System.out.print(ANSI_PURPLE + "Destroyed" + ANSI_RESET);
        System.out.println();
        System.out.print("  ");
        for(int i = 1; i <= 10; i++) System.out.print(i + " ");
        System.out.println();
        char index = 'A';
        for(int i = 1; i <= 10; i++)
        {
            System.out.print(index++ + " ");
            for(int j = 1; j <= 10; j++)
            {
                if(boardForOpponent[i][j] == 'x') System.out.print(ANSI_PURPLE + 'x' + ANSI_RESET + " ");
                else
                {
                    if(board[i][j] == 'P') System.out.print(ANSI_YELLOW + board[i][j] + ANSI_RESET + " ");
                    else if(board[i][j] == 'D') System.out.print(ANSI_CYAN + board[i][j] + ANSI_RESET + " ");
                    else if(board[i][j] == 'S') System.out.print(ANSI_GREEN + board[i][j] + ANSI_RESET + " ");
                    else if(board[i][j] == 'B') System.out.print(ANSI_RED + board[i][j] + ANSI_RESET + " ");
                    else System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void showForOpponent()
    {

        System.out.print("Unknown  ");
        System.out.print(ANSI_PURPLE + "Destroyed   " + ANSI_RESET);
        System.out.print(ANSI_RED + "Missed" + ANSI_RESET);
        System.out.println();
        System.out.print("  ");
        for(int i = 1; i <= 10; i++) System.out.print(i + " ");
        System.out.println();
        char index = 'A';
        for(int i = 1; i <= 10; i++)
        {
            System.out.print(index++ + " ");
            for(int j = 1; j <= 10; j++)
            {
                if(boardForOpponent[i][j] == 'x') System.out.print(ANSI_PURPLE + 'x' + ANSI_RESET + " ");
                else if(boardForOpponent[i][j] == 'm') System.out.print(ANSI_RED + 'o' + ANSI_RESET + " ");
                else System.out.print(boardForOpponent[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Destroyed Squares: " + destroyedSquare);
        System.out.println("Enemy's remaining ships: " + shipRemaining);
    }

}
