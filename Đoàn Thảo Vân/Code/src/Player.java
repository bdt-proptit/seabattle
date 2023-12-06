import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Player extends BattleField{
    public int numberOfShipleft = 5;

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
    public void chooseMode(Player me, Player opponent) throws IOException {
        System.out.println(Color.green + "Cells were attacked: " + cellsAttacked + Color.ANSI_Reset);
        System.out.println(Color.purple + "Number of opponent's ships destroyed: " + (5 - opponent.ships.size()) + Color.ANSI_Reset);
        System.out.println(Color.yellow + "Number of your ship now: " + me.ships.size() + Color.ANSI_Reset);
        while(true){
            ShowMenu.showMode();
            String mode = sc.nextLine();
            if(mode.equals("1")) {
                me.showMyBoard();
            }
            else if(mode.equals("2")){
                opponent.shot(opponent);
                System.out.println("Press any key to end turn...");
                String endturn = sc.nextLine();
                break;
            }
            else break;
        }
    }

    public void shot(Player opponent) throws IOException {
        int x = 0, y = 0;
        boolean isAttacked = true, isOutOfRange = true;
        boolean continuousAttack = true;
        while(isAttacked || isOutOfRange || continuousAttack)
        {
            ++cellsAttacked;
            opponent.showForOpponent();
            System.out.println("Enter the coordinates to shoot: ");
            System.out.print("x = ");
            x = Integer.valueOf(sc.nextLine());
            System.out.print("y = ");
            y = Integer.valueOf(sc.nextLine());
            if(checkOutOfBoard(x) || checkOutOfBoard(y)){
                System.out.println(Color.red + "The coordinates you selected exceed the table limits, try again." + Color.ANSI_Reset);
                continue;
            }
            else isOutOfRange = false;
            if(board[x][y].getStatus().equals("o") || board[x][y].getStatus().equals("x")){
                ClearScreen.clrscr();
                System.out.println(Color.yellow + "You attacked this point before, enter the ordinates again." + Color.ANSI_Reset);
                System.out.println();
                continue;
            }
            else isAttacked = false;
            while(continuousAttack){
                ClearScreen.clrscr();
                if(!board[x][y].getStatus().equals("Empty")){
                    System.out.println(Color.green + "CONGRATULATION!!" + Color.ANSI_Reset);
                    for(Ship ship: ships){
                        if(!ship.getSink()) ifSink(x, y, ship);
                        checkWin();
                    }
                    board[x][y].setStatus("o");
                    System.out.println(Color.yellow + "Continue to attack..." + Color.ANSI_Reset);
                    System.out.println();
                    break;
                }
                else{
                    continuousAttack = false;
                    System.out.println("Missed!");
                    board[x][y].setStatus("x");
                }
            }
        }

    }

    public void ifSink(int x, int y, Ship ship){
        if(ship.getX_begin() <= x && ship.getX_end() >= x && ship.getY_begin() <= y && ship.getY_end() >= y){
            ship.setNumberOfCellleft(ship.getNumberOfCellleft() - 1);
        }
        if(ship.getNumberOfCellleft() == 0){
            numberOfShipleft--;
            ship.setSink(true);
            System.out.println("A ship was sink!");
        }
    }
    public void checkWin(){
        if(numberOfShipleft == 0){
            System.out.println("You are the winner!");
            setWin(true);
        }
    }

    static boolean placeSuccessfull = false, coincide = false;
    public void place(int coverCells) throws IOException {
        System.out.println();
        showMyBoard();
        System.out.println();
        int x_begin = 0, y_begin = 0, x_end = 0, y_end = 0;
        placeSuccessfull = false;
        while(!placeSuccessfull)
        {
            System.out.println("Enter the coordinates you want to place the ship: ");
            System.out.print("x = ");
            int x = Integer.valueOf(sc.nextLine());
            System.out.print("y = ");
            int y = Integer.valueOf(sc.nextLine());
            if(checkOutOfBoard(x) || checkOutOfBoard(y)){
                System.out.println(Color.red + "The coordinates you selected exceed the table limits, try again." + Color.ANSI_Reset);
                continue;
            }
            System.out.println("How do you want to place it?");
            System.out.print("   1.To the left \n   2.To the right \n   3.Upwards \n   4.Downwards \n");
            while(true){
                System.out.print("Enter the direction: ");
                int direction = Integer.valueOf(sc.nextLine());
                coincide = false;
                switch (direction)
                {
                    case 1:
                        x_begin = x; y_begin = y - coverCells; y_end = y; x_end = x;
                        if(checkOutOfBoard(y-coverCells+1)){
                            System.out.println(Color.red + "The coordinates you selected exceed the table limits, try again." + Color.ANSI_Reset);
                            break;
                        }
                        for(int i = y; i > y-coverCells; --i) {
                            if(board[x][i].getStatus().equals("P")){
                                System.out.println(Color.yellow + "There is already a ship at this location!" + Color.ANSI_Reset);
                                coincide = true;
                                break;
                            }
                        }
                        if(!coincide){
                            for(int i = y; i > y-coverCells; --i) board[x][i].setStatus("P");
                            placeSuccessfull = true;
                        }
                        else{
                            System.out.println("Try again");
                            break;
                        }
                        break;
                    case 2:
                        x_begin = x; y_begin = y ; y_end = y + coverCells; x_end = x;
                        if(checkOutOfBoard(y+coverCells-1)){
                            System.out.println(Color.red + "The coordinates you selected exceed the table limits, try again." + Color.ANSI_Reset);
                            break;
                        }
                        for(int i = y; i < y+coverCells; ++i) {
                            if(board[x][i].getStatus().equals("P")){
                                System.out.println(Color.yellow + "There is already a ship at this location!" + Color.ANSI_Reset);
                                coincide = true;
                                break;
                            }
                        }
                        if(!coincide){
                            for(int i = y; i < y+coverCells; ++i) board[x][i].setStatus("P");
                            placeSuccessfull = true;
                        }
                        else{
                            System.out.println("Try again");
                            break;
                        }
                        break;
                    case 3:
                        x_begin = x - coverCells; y_begin = y; y_end = y; x_end = x;
                        if(checkOutOfBoard(x-coverCells+1)){
                            System.out.println(Color.red + "The coordinates you selected exceed the board limits, try again." + Color.ANSI_Reset);
                            break;
                        }
                        for(int i = x; i > x-coverCells; --i) {
                            if(board[i][y].getStatus().equals("P")){
                                System.out.println(Color.yellow + "There is already a ship at this location!" + Color.ANSI_Reset);
                                coincide = true;
                                break;
                            }
                        }
                        if(!coincide){
                            for(int i = x; i > x-coverCells; --i) board[i][y].setStatus("P");
                            placeSuccessfull = true;
                        }
                        else{
                            System.out.println("Try again");
                            break;
                        }
                        break;
                    case 4:
                        x_begin = x; y_begin = y; y_end = y; x_end = x + coverCells;
                        if(checkOutOfBoard(x+coverCells-1)){
                            System.out.println(Color.red + "The coordinates you selected exceed the board limits, try again." + Color.ANSI_Reset);
                            break;
                        }
                        for(int i = x; i < x+coverCells; ++i) {
                            if(board[i][y].getStatus().equals("P")){
                                System.out.println(Color.yellow + "There is already a ship at this location!" + Color.ANSI_Reset);
                                coincide = true;
                                break;
                            }
                        }
                        if(!coincide){
                            for(int i = x; i < x+coverCells; ++i) board[i][y].setStatus("P");
                            placeSuccessfull = true;
                        }
                        else{
                            System.out.println("Try again");
                            break;
                        }
                        break;
                }
                if(direction > 4 || direction < 1) {
                    System.out.println("Direction invalid, try again");
                }
                else break;
            }
        }
        Ship newShip = new Ship(x_begin, x_end, y_begin, y_end, coverCells);
        ships.add(newShip);
        ClearScreen.clrscr();
    }
    public void placeShip() throws IOException {
        setCells();
        System.out.println("1.Place First Patrol Boat (1x2)");
        place(2);
        System.out.println("2.Place Second Patrol Boat (1x2)");
        place(2);
        System.out.println("3.Destroyer Boat (1x4)");
        place(4);
        System.out.println("4.Submarine (1x3)");
        place(3);
        System.out.println("5.Battle Ship (1x5)");
        place(5);
    }
}
