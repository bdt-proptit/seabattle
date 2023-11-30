import java.util.Scanner;
public class MainMenu {
    public int startMenu(Scanner sc, Player player1, Player player2) {
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
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Welcome player " + player1.getName() + "!"+"\nPlease setup your ship!");
                    player1.setUpShip();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Welcome player " + player2.getName() + "!" + "\nPlease setup your ship!");
                    player2.setUpShip();
                    int turns = 1;
                    while(player1.check == 0 && player2.check == 0){
                        if(turns % 2 == 1){
                            player1.showBoard();
                            System.out.println(player1.getName() + "'s turn!");
                            System.out.println("Enter fire coordinate: ");
                            player2.beAttacked();
                            System.out.println("-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------");
                        }
                        else{
                            player2.showBoard();
                            System.out.println(player2.getName() + "'s turn!");
                            System.out.println("Enter fire coordinate: ");
                            player1.beAttacked();
                            System.out.println("-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------\n" +
                                    "-------------------------------------------------------------------");
                        }
                        turns++;
                    }
                    return 1;
                case 2:
                    System.out.println("Game rules:");
                    return 2;
                case 3:
                    System.out.println("Thank you for playing Ships Battle game\n" +
                            "The game was developed by d22_nguyen_ba_viet_hoang");
                    return 3;
                case 4:
                    System.out.println("Quit game...");
                    return 4;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }
}
