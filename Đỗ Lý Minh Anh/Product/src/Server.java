import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        while (true) {
            Operation operation = new Operation();
            operation.displayMenu();
            System.out.println("--> Enter your choice:");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                System.out.println("*** Player 1 sets up the boat! ***");
                player1.setUpBoats(sc);
                System.out.println("*** Player 2 sets up the boat! ***");
                player2.setUpBoats(sc);
                Player activePlayer = player1;
                int mark = 1;
                while (true) {
                    if (mark == 1) {
                        System.out.println("*** Player 1's turn! ***");
                    }
                    else {
                        System.out.println("*** Player 2's turn! ***");
                    }
                    activePlayer.displayCurrentStatus();
                    operation.displayPlayerOptions();
                    System.out.println("--> Enter your choice:");
                    int option1 = Integer.parseInt(sc.nextLine());
                    if (option1 == 1) {
                        activePlayer.displayBoard();
                    }
                    else if (option1 == 2) {
                        boolean check;
                        if (mark == 1) {
                            check = activePlayer.openFire(sc, player2);
                        }
                        else {
                            check = activePlayer.openFire(sc, player1);
                        }
                        if (check == true) {
                            System.out.println("-> Player 1's Board:");
                            player1.displayBoard();
                            System.out.println("-> Player 2's Board:");
                            player2.displayBoard();
                            System.out.println("----> | Player " + mark + " is the WINNER!!! | <----");
                            break;
                        }
                        else {
                            if (mark == 1) {
                                activePlayer.displayBoardOfEnemy(player2);
                            }
                            else {
                                activePlayer.displayBoardOfEnemy(player1);
                            }
                        }
                    }
                    else {
                        System.out.println("----> END GAME!!! <----");
                        break;
                    }
                    if (mark == 1) {
                        activePlayer = player2;
                        mark = 2;
                    }
                    else {
                        activePlayer = player1;
                        mark = 1;
                    }
                }
            }
            else {
                System.out.println("----> GOODBYE!!! <----");
                break;
            }
        }
    }
}