import java.util.Scanner;

public class MainMenu {
    public void startMenu(Scanner sc, Player player1, Player player2) {
        System.out.println("***** Let's play Ships Battle *****");
        while (true) {
            System.out.println("Please enter your choice: ");
            System.out.println("1. Start\n2. Game Rules\n3. About\n4. Exit\n");
            byte option = sc.nextByte();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Welcome to the Preparation Stage!");
                    System.out.print("Please enter player #1's name: ");
                    String namePlayer1 = sc.nextLine();
                    System.out.print("Please enter player #2's name: ");
                    String namePlayer2 = sc.nextLine();
                    player1.setName(namePlayer1);
                    player2.setName(namePlayer2);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    ClearScreen.clrscr();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Welcome player " + player1.getName() + "!" + "\nPlease setup your ship!");
                    player1.setUpShip();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Welcome player " + player2.getName() + "!" + "\nPlease setup your ship!");
                    player2.setUpShip();
                    int turns = 1;
                    int choice = 1;
                    while (player1.check == 0 && player2.check == 0) {
                        if (turns % 2 == 1) {
                            System.out.println(player1.getName() + "'s turn!");
                            while (choice == 1) {
                                System.out.println("Please enter your choice: ");
                                System.out.println("1. Your map\n2. Fire");
                                option = sc.nextByte();
                                sc.nextLine();
                                if (option == 2) {
                                    System.out.println(player2.getName() + "'s map: ");
                                    player2.showOpponentBoard();
                                    player2.beAttacked();
                                    System.out.println("Enter to continue...");
                                    sc.nextLine();
                                    ClearScreen.clrscr();
                                    choice = 2;
                                    turns++;
                                } else if (option == 1) {
                                    System.out.println("Your map: ");
                                    player1.showBoard();
                                    System.out.println("Enter to continue...");
                                    sc.nextLine();
                                    ClearScreen.clrscr();
                                } else {
                                    System.out.println("Invalid value!");

                                }
                            }
                        } else if (turns % 2 == 0) {
                            System.out.println(player2.getName() + "'s turn!");
                            while (choice == 2) {
                                System.out.println("Please enter your choice: ");
                                System.out.println("1. Your map\n2. Fire");
                                option = sc.nextByte();
                                sc.nextLine();
                                if (option == 2) {
                                    System.out.println(player1.getName() + "'s map: ");
                                    player1.showOpponentBoard();
                                    player1.beAttacked();
                                    System.out.println("Enter to continue...");
                                    sc.nextLine();
                                    ClearScreen.clrscr();
                                    choice = 1;
                                    turns++;
                                } else if (option == 1) {
                                    System.out.println("Your map: ");
                                    player2.showBoard();
                                    System.out.println("Enter to continue...");
                                    sc.nextLine();
                                    ClearScreen.clrscr();
                                } else {
                                    System.out.println("Invalid value!");
                                }
                            }
                        }
                    }
                case 2:
                    System.out.println("Game rules:");
                    break;
                case 3:
                    System.out.println("Thank you for playing Ships Battle game\n" +
                            "The game was developed by d22_nguyen_ba_viet_hoang");
                    break;
                case 4:
                    System.out.println("Quit game...");
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }
}
