import java.util.Scanner;
public class Main {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Board board = new Board();
    // methods
    Scanner sc = new Scanner(System.in);
    public Main(){}
    public void showMenu(){
        System.out.println("1. Start game!");
        System.out.println("2. How to play!");
        System.out.println("3. Exit!");
        System.out.print("Enter your choice: ");
        int choice;
        choice = sc.nextInt();
        while(choice < 1 || choice > 3){
            System.out.print("Invalid choice! Enter your choice: ");
            choice = sc.nextInt();
        }
        switch(choice){
            case 1: startGame(); break;
            case 2: howToPlay(); break;
            case 3: System.exit(0);
        }
    }
    public void howToPlay(){
        System.out.println("1, Each player has 5 ships: 2 patrol boats, 1 destroyer boat, 1 submarine, 1 battle ship");
        System.out.println("2, Each player will place their ships on the board");
        System.out.println("3, Each turn, a player will choose a coordinate on the board to shoot");
        System.out.println("A coordinate is represented by a letter and a number, the letter is from A to J, the number is from 1 to 10");
        System.out.println("4, The game ends when a player destroys all of the enemy's ships");
        showMenu();
    }
    public void update(){

    }
    public void startGame(){
        board = new Board();
        player1.getInformation();
        player2.getInformation();
        int turn = 1;
        while(true){
            if(turn == 1) {
                player1.showInformation(player2);
                player1.shoot(player2);
                if(player2.getRemainingShips() == 0){
                    System.out.println("Player 1 wins!");
                    break;
                }
            }
            else {
                player2.showInformation(player1);
                player2.shoot(player1);
                if(player1.getRemainingShips() == 0){
                    System.out.println("Player 2 wins!");
                    break;
                }
            }
            turn *= -1;
        }
        System.out.println("1. Play again!");
        System.out.println("2. Return to menu!");
        System.out.println("3. Exit!");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: startGame(); break;
            case 2: showMenu(); break;
            case 3: System.exit(0);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}