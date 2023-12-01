import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends BattleField{
    public int numberOfShipleft = 4;
    boolean win = false;
    Scanner sc = new Scanner(System.in);

    List<Ship> ships = new ArrayList<>();

    public void chooseMode(Player me, Player opponent){
        ShowMenu.showMode();
        int mode = Integer.valueOf(sc.nextLine());
        if(mode == 1) {
            me.showMyBoard();
        }
        else if(mode == 2){
            me.showOpponentBoard();
            opponent.shot();
        }
        else ++Playing.turn;
    }

    public void shot(){
        int x = sc.nextInt();
        int y = sc.nextInt();
        while(board[x][y].getStatus() == "x" || board[x][y].getStatus() == "o") {
            System.out.println("Place was shot before.");
            x = sc.nextInt();
            y = sc.nextInt();
        }
        if(board[x][y].getStatus() != "Empty"){
            System.out.println("Congratulations!");
            for(Ship ship: ships){
                ship.ifSink(x, y);
                checkWin();
            }
            board[x][y].setStatus("o");
        }
        else{
            System.out.println("Missed!");
            board[x][y].setStatus("x");
        }
    }

    public void checkWin(){
        if(numberOfShipleft == 0){
            System.out.println("You are the winner!");
            win = true;
        }
    }
    public void place(int coverCells){
        int x_begin = 0, y_begin = 0, x_end = 0, y_end = 0;
        System.out.println("Enter the coordinates you want to place the ship: ");
        System.out.printf("x = ");
        int x = Integer.valueOf(sc.nextLine());
        System.out.printf("y = ");
        int y = Integer.valueOf(sc.nextLine());
        System.out.println("How do you want to place it?");
        System.out.printf("1.To the left \n 2.To the right \n 3.Upwards \n 4.Downwards");
        int direction = Integer.valueOf(sc.nextLine());
        switch (direction)
        {
            case 1:
                x_begin = x - coverCells; y_begin = y; y_end = y; x_end = x;
                for(int i = x; i > x-coverCells; --i) {
                    board[i][y].setStatus("P");
                }
                break;
            case 2:
                x_begin = x; y_begin = y; y_end = y; x_end = x + coverCells;
                for(int i = x; i < x+coverCells; ++i) {
                    board[i][y].setStatus("P");
                }
                break;
            case 3:
                x_begin = x; y_begin = y - coverCells; y_end = y; x_end = x ;
                for(int i = y; i > y-coverCells; --i) {
                    board[x][i].setStatus("P");
                }
                break;
            case 4:
                x_begin = x; y_begin = y ; y_end = y + coverCells; x_end = x ;
                for(int i = y; i < y+coverCells; ++i) {
                    board[x][i].setStatus("P");
                }
                break;
        }
        Ship newShip = new Ship(x_begin, x_end, y_begin, y_end, coverCells);
        ships.add(newShip);
    }
    public void placeShip(){
        System.out.println("Place Patrol Boat");
        place(2);
        System.out.println("2.Destroyer Boat");
        place(4);
        System.out.println("3.Submarine");
        place(3);
        System.out.println("4.Battle Ship");
        place(5);
    }

}
