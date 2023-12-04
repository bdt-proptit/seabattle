import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        Operation operation = new Operation();
        while (true) {
            operation.displayMenu();
            System.out.println("--> Enter your choice:");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                System.out.println("*** Player 1 sets up the boat! ***");
                System.out.println("1. Set up the boat.");
                System.out.println("2. Random.");
                System.out.println("-> Enter your choice:");
                int option1 = Integer.parseInt(sc.nextLine());
                if (option1 == 1) {
                    player1.setUpBoats(sc);
                }
                else {
                    operation.autoSetUpTheBoat(player1);
                }
                operation.displayBoardOfPlayer(player1);
                System.out.println("*** Player 2 sets up the boat! ***");
                System.out.println("1. Set up the boat.");
                System.out.println("2. Random.");
                System.out.println("-> Enter your choice:");
                option1 = Integer.parseInt(sc.nextLine());
                if (option1 == 1) {
                    player2.setUpBoats(sc);
                }
                else {
                    operation.autoSetUpTheBoat(player2);
                }
                operation.displayBoardOfPlayer(player2);
                Player activePlayer = player1;
                int mark = 1;
                while (true) {
                    if (mark == 1) {
                        System.out.println("*** Player 1's turn! ***");
                    }
                    else {
                        System.out.println("*** Player 2's turn! ***");
                    }
                    operation.displayCurrentStatus(activePlayer);
                    operation.displayPlayerOptions();
                    System.out.println("--> Enter your choice:");
                    int option2 = Integer.parseInt(sc.nextLine());
                    if (option2 == 1) {
                        operation.displayBoardOfPlayer(activePlayer);
                    }
                    else if (option2 == 2) {
                        boolean check;
                        if (mark == 1) {
                            check = activePlayer.openFireAndCheck (sc, player2);
                        }
                        else {
                            check = activePlayer.openFireAndCheck (sc, player1);
                        }
                        if (check) {
                            operation.displayTheResults(player1, player2);
                            System.out.println("----> | Player " + mark + " is the WINNER!!! | <----");
                            break;
                        }
                        else {
                            if (mark == 1) {
                                operation.displayTheBoardOfEnemy (player2);
                            }
                            else {
                                operation.displayTheBoardOfEnemy (player1);
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