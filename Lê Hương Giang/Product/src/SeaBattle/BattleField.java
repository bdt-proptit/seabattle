package SeaBattle;

public class BattleField {
    public char[][] myBoard = new char[10][10], opponentBoard = new char[10][10];
    public BattleField() {
        for (int i = 1; i <= 10; ++i) {
            for (int j = 1; j <= 10; ++j) {
                myBoard[i][j] = ' ';
            }
        }
        for (int i = 1; i<=10; ++i){
            for (int j=1; j<=10; ++j){
                opponentBoard[i][j] = ' ';
            }
        }
    }
    public void createMyBoard(String myName){
        System.out.println(myName);
        System.out.print("-  ");
        for(int column = 1; column <= 10;++column){ // in cột
            if(column < 10) System.out.print(column + "  ");
            else System.out.print(column + "|");
        }

        for(int row = 0;row < 10;++row){
            int row_present = row+1 ;
            if(row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");

            for(int column = 0;column < 10 ;++column) {
                System.out.print(myBoard[row][column] + " |");
            }
        }
        System.out.println("-----------------------------------");
    }
//    void createOpponentBoard(){
//        System.out.println("Opponent Board in blind mode!");
//        for (int i=1; i<=10; ++i){
//            for (int j=1; j<=10; ++j){
//                opponentBoard[i][j] = ' ';
//            }
//        }
//
//    }
}
