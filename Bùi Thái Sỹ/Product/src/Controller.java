import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Controller {
    public boolean checkPos(int a){
        return a > 10 || a < 1;
    }
    public boolean checkAutoHit(Board board, Position pos){
        return Objects.equals(board.getCell(pos), "S") || board.getCell(pos) == null;
    }
    public boolean checkHit(Board board, Position pos){
        return (Objects.equals(board.getCell(pos), "S") || board.getCell(pos) == null)&&!checkPos(pos.getX())&&!checkPos(pos.getY());
    }
    public boolean checkPosShipOnBoard(Board board, Ship ship){
        if(checkPos(ship.getPosStart().getX()) || checkPos(ship.getPosStart().getY()) || checkPos(ship.getPosEnd().getX()) || checkPos(ship.getPosEnd().getY())) return false;
        if((ship.getPosStart().getX() != ship.getPosEnd().getX()) && (ship.getPosStart().getY() != ship.getPosEnd().getY())) return false;
        if(ship.getPosStart().getX() == ship.getPosEnd().getX()){
            if(Math.abs(ship.getPosStart().getY() - ship.getPosEnd().getY()) + 1 != ship.getSizeShip()) return false;
            for(int i = Math.min(ship.getPosStart().getY(), ship.getPosEnd().getY()) ; i <= Math.max(ship.getPosStart().getY(), ship.getPosEnd().getY()); i++){
                Position posTemp = new Position(ship.getPosStart().getX(), i);
                if(Objects.equals(board.getCell(posTemp), "S")) return false;
            }
        }else{
            if(Math.abs(ship.getPosStart().getX() - ship.getPosEnd().getX()) + 1 != ship.getSizeShip()) return false;
            for(int i = Math.min(ship.getPosStart().getX(), ship.getPosEnd().getX()) ; i <= Math.max(ship.getPosStart().getX(), ship.getPosEnd().getX()); i++){
                Position posTemp = new Position(i, ship.getPosStart().getY());
                if(Objects.equals(board.getCell(posTemp), "S")) return false;
            }
        }
        return true;
    }
    public void controlGame() {
        while (true) {
            ClearScreen.clrscr();
            Menu menu = new Menu();
            menu.printMenu();
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            ClearScreen.clrscr();
            switch (choose) {
                case "1" -> {
                    menu.menuSelectModePlay();
                    String chooseModePlay = sc.nextLine();
                    switch (chooseModePlay) {
                        case "1" -> {
                            Computer computer = new Computer();
                            ClearScreen.clrscr();
                            menu.menuSelectModeComputer();
                            String chooseModeComputer = sc.nextLine();
                            ClearScreen.clrscr();
                            System.out.println("Computer is setting ship....");
                            Wait.wait(2);
                            computer.setShipOnBoardAuto();

                            ClearScreen.clrscr();
                            System.out.println("Computer set ship on Board!");
                            PressEnterToContinue.pressEnterToContinue();
                            sc = new Scanner(System.in);
                            Player player = new Player();
                            ClearScreen.clrscr();
                            player.setName("You");
                            System.out.println("Hey player!!!");
                            menu.menuToSetShipAuto();
                            int chooseSetShipAuto = sc.nextInt();
                            if(chooseSetShipAuto == 1){
                                player.setShipOnBoardAuto();
                                PressEnterToContinue.pressEnterToContinue();
                                ClearScreen.clrscr();
                            }
                            else player.setShipOnBoard();
                            ClearScreen.clrscr();
                            System.out.println("Everything is ready!!! Enter to random who hit first!!!");
                            System.out.println("Radoming....");
                            Wait.wait(2);
                            ClearScreen.clrscr();
                            Random random = new Random();
                            int turn = random.nextInt(2);
                            if(turn == 0){
                                System.out.print("Computer");
                            }else System.out.print(player.getName());
                            System.out.println(" hit first!");
                            Wait.wait(2);
                            switch (chooseModeComputer){
                                case "1" ->{
                                    while(!computer.checkWinner() && !player.checkWinner()){
                                        if (turn == 0) {
                                            computer.oppBoard = player.yourBoard;
                                            System.out.println("Computer's turn!");
                                            computer.hitEasyMode();
                                            turn = 1;
                                        } else {
                                            player.oppBoard = computer.yourBoard;
                                            System.out.println(player.getName() + "'s turn!");
                                            player.hitShip();
                                            turn = 0;
                                        }
                                    }
                                    PressEnterToContinue.pressEnterToContinue();
                                }
                                case "2" ->{
                                    while(!computer.checkWinner() && !player.checkWinner()){
                                        if (turn == 0) {
                                            computer.oppBoard = player.yourBoard;
                                            System.out.println("Computer's turn!");
                                            computer.hitHardMode();
                                            turn = 1;
                                        } else {
                                            player.oppBoard = computer.yourBoard;
                                            System.out.println(player.getName() + "'s turn!");
                                            player.hitShip();
                                            turn = 0;
                                        }
                                    }
                                    PressEnterToContinue.pressEnterToContinue();
                                }
                            }
                        }
                        case "2" -> {
                            ClearScreen.clrscr();
                            Player player1 = new Player();
                            Player player2 = new Player();
                            System.out.print("Please enter name of Player1: ");
                            String name1 = sc.nextLine();
                            System.out.print("Please enter name of Player2: ");
                            String name2 = sc.nextLine();
                            player1.setName(name1);
                            player2.setName(name2);
                            ClearScreen.clrscr();
                            System.out.println("Hey " + player1.getName() + "!!!");
                            menu.menuToSetShipAuto();
                            int chooseSetShipAuto = sc.nextInt();
                            if(chooseSetShipAuto == 1){
                                player1.setShipOnBoardAuto();
                                PressEnterToContinue.pressEnterToContinue();
                                ClearScreen.clrscr();
                            }
                            else player1.setShipOnBoard();
                            ClearScreen.clrscr();
                            System.out.println("Hey " + player2.getName() + "!!!");
                            menu.menuToSetShipAuto();
                            chooseSetShipAuto = sc.nextInt();
                            if(chooseSetShipAuto == 1){
                                player2.setShipOnBoardAuto();
                                PressEnterToContinue.pressEnterToContinue();
                                ClearScreen.clrscr();
                            }
                            else player2.setShipOnBoard();
                            ClearScreen.clrscr();
                            System.out.println("Everything is ready!!! Enter to random who hit first!!!");
                            PressEnterToContinue.pressEnterToContinue();
                            System.out.println("Radoming....");
                            Wait.wait(2);
                            Random random = new Random();
                            int turn = random.nextInt(2);
                            if(turn == 0){
                                System.out.print(player1.getName());
                            }else System.out.print(player2.getName());
                            System.out.println(" hit first!");
                            while(!player1.checkWinner() && !player2.checkWinner()){
                                if (turn == 0) {
                                    player1.oppBoard = player2.yourBoard;
                                    System.out.println(player1.getName() + "'s turn!");
                                    player1.hitShip();
                                    turn = 1;
                                } else {
                                    player2.oppBoard = player1.yourBoard;
                                    System.out.println(player2.getName() + "'s turn!");
                                    player2.hitShip();
                                    turn = 0;
                                }
                            }
                            PressEnterToContinue.pressEnterToContinue();
                        }
                        case "3" ->{

                        }
                    }
                }
                case "2" -> {
                    System.out.println("2 players will place their boats on the sea and shoot each other's boats. " +
                            "Each player will have 5 boats including: " + " 2 Patrol Boats (1x2), 1 Destroyer Boat (1x4), 1 Submarine (1x3), 1 Battle Ship (1x5) \n" +
                            "If you hit the enemy's boat, you will be able to shoot again. Player who shoots all of the opponent's boats first will win");
                    PressEnterToContinue.pressEnterToContinue();
                }
                case "3" -> {
                    System.exit(0);
                }
            }
        }
    }
}
