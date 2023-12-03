import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends BattleField{
    public int numberOfShipleft = 4;

    private int cellsAttacked = 0;
    private boolean win = false;
    Scanner sc = new Scanner(System.in);

    List<Ship> ships = new ArrayList<>();
    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean getWin(){
        return win;
    }
    public void chooseMode(Player me, Player opponent){
        System.out.printf("Cells were attacked: %d\n", cellsAttacked);
        System.out.printf("Number of opponent's ships destroyed: %d\n", 4 - opponent.ships.size());
        System.out.printf("Number of your ship now: %d\n", me.ships.size());
        while(true){
            ShowMenu.showMode();
            int mode = Integer.valueOf(sc.nextLine());
            if(mode == 1) {
                me.showMyBoard();
            }
            else if(mode == 2){
                ++cellsAttacked;
                opponent.showForOpponent();
                opponent.shot();
                if(getWin() == false) System.out.println("End turn!");
                break;
            }
            else {
                System.out.println("End turn!");
                break;
            }
        }
    }

    public void shot(){
        System.out.println("Enter the coodinates to shoot: ");
        System.out.printf("x = ");
        int x = Integer.valueOf(sc.nextLine());
        System.out.printf("y = ");
        int y = Integer.valueOf(sc.nextLine());

        if(board[x][y].getStatus() != "Empty"){
            System.out.println("Congratulations!");
            for(Ship ship: ships){
                ifSink(x, y, ship);
                checkWin();
                if(ships.size() == 0) break;
            }
            board[x][y].setStatus("o");
        }
        else{
            System.out.println("Missed!");
            board[x][y].setStatus("x");
        }
    }

    public void ifSink(int x, int y, Ship ship){
        if(ship.getX_begin() <= x && ship.getX_end() >= x && ship.getY_begin() <= y && ship.getY_end() >= y){
            ship.setNumberOfCellleft(ship.getNumberOfCellleft() - 1);
        }
        if(ship.getNumberOfCellleft() == 0){
            numberOfShipleft--;
            ships.remove(ship);
            System.out.println("A ship was sink!");
        }
    }
    public void checkWin(){
        if(numberOfShipleft == 0){
            System.out.println("You are the winner!");
            setWin(true);
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
        System.out.printf("1.To the left \n2.To the right \n3.Upwards \n4.Downwards \n");
        System.out.printf("Enter the direction: ");
        int direction = Integer.valueOf(sc.nextLine());
        switch (direction)
        {
            case 1:
                x_begin = x; y_begin = y - coverCells; y_end = y; x_end = x ;
                for(int i = y; i > y-coverCells; --i) {
                    board[x][i].setStatus("P");
                }
                break;
            case 2:
                x_begin = x; y_begin = y ; y_end = y + coverCells; x_end = x ;
                for(int i = y; i < y+coverCells; ++i) {
                    board[x][i].setStatus("P");
                }
                break;
            case 3:
                x_begin = x - coverCells; y_begin = y; y_end = y; x_end = x;
                for(int i = x; i > x-coverCells; --i) {
                    board[i][y].setStatus("P");
                }
                break;
            case 4:
                x_begin = x; y_begin = y; y_end = y; x_end = x + coverCells;
                for(int i = x; i < x+coverCells; ++i) {
                    board[i][y].setStatus("P");
                }
                break;
        }
        Ship newShip = new Ship(x_begin, x_end, y_begin, y_end, coverCells);
        ships.add(newShip);
    }
    public void placeShip(){
        setCells();
        System.out.println("Place Patrol Boat (1x2)");
        place(2);
        System.out.println("2.Destroyer Boat (1x4)");
        place(4);
        System.out.println("3.Submarine (1x3)");
        place(3);
        System.out.println("4.Battle Ship (1x5)");
        place(5);
    }

}
