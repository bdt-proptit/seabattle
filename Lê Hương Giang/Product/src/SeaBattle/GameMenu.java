package SeaBattle;
import java.util.*;

public class GameMenu extends BattleField {
    private Player p1, p2;
    private boolean isWinner = false;
    //    private int myNumberOfHitShip = 0, opponentNumberOfHitShip = 0, myRemainShip = 5, opponentRemainShip = 5;
    Scanner sc = new Scanner(System.in);

    public void menuStart() {
        System.out.println(YELLOW + "----------MENU START----------");
        System.out.println("|1. Start.                   |");
        System.out.println("|2. View game instructions.  |");
        System.out.println("|3. Quit.                    |");
        System.out.println("------------------------------" + ANSI_RESET);

    }


    public void menuInstruction() {
        System.out.println(YELLOW + "------------------------------------------------------------------MENU INSTRUCTION------------------------------------------------------------------");
        System.out.println("" +
                "There will be two players in a game and turns will be changed.\n" +
                "Initially, the player is given a 10x10 board, one row from 1->10, one column from 1->10. \n" +
                "Each player will own 5 ships as below:\n" +
                "- 2 Patrol Boats   1x2\n" +
                "- 1 Destroyer Boat 1x4\n" +
                "- 1 Submarine      1x3\n" +
                "- 1 Battle Ship    1x5\n" +
                "Players will be able to enter 2 coordinates (X,Y) for each type of ship to place the ship, the screen will display the ship on the board.\n" +
                "After finishing placing, it will be next player's turn to place ships.\n" +
                "A ship will be destroyed only after all points (coordinates) of the ship are destroyed. For example, a 1x5 ship requires at least 5 hits to destroy all points\n" +
                "When one player's ships are all destroyed first, they will immediately lose and display the results screen and tables of both sides\n" + ANSI_RESET);
    }

    public void endGame() {
        System.out.println(GREEN + "Goodbye!" + ANSI_RESET);
    }

    //    public void setupScreen(Player p1, Player p2){
//        System.out.print ("Please enter 1st username: ");
//        p1.setUsername(sc.nextLine());
//        System.out.print("Please enter 2nd username: ");
//        p2.setUsername(sc.nextLine());
//
//    }

    public void shoot(Player currentPlayer, Player nextPlayer) {
        // nhập tọa độ để bắn
        System.out.println("Enter the coordinates (x,y) you want to shoot: ");
        System.out.print("x = ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("y = ");
        int y = Integer.parseInt(sc.nextLine());

        if (currentPlayer.opponentBoard[x - 1][y - 1] != ' ') // xem ở đấy đã được bắn chưa
            System.out.println("It has been shot! Change turn!");
        else {
            if (nextPlayer.opponentBoard[x - 1][y - 1] == 'X') { // có thuyền địch ở đấy
                System.out.println("Hit the opponent's boat!");
                currentPlayer.opponentBoard[x - 1][y - 1] = 'X';
                currentPlayer.setBulletNumber();
            } else {
                currentPlayer.opponentBoard[x - 1][y - 1] = '0'; // vị trí đã bắn
                currentPlayer.setBulletNumber();
            }
        }
    }

    public void displayMenuBoard(String p1, String p2) {
        System.out.println(YELLOW + "-------------------------------------------------------------------------");
        System.out.println("                           Welcome to SeaBattle!                         ");
        System.out.println("-------------------------------------------------------------------------" + ANSI_RESET);
        System.out.print(p1);
        for (int column = 0; column < 33 - p1.length(); ++column) {
            System.out.print(" ");
        }
        System.out.print("       ");
        System.out.print(p2);
        for (int column = 0; column < 33 - p2.length(); ++column) {
            System.out.print(" ");
        }
        System.out.println("");
        System.out.print("-  ");
        for (int column = 1; column <= 10; ++column) { // in số cột của bảng của mình
            if (column < 10)
                System.out.print(column + "  ");
            else System.out.print(column + "|");
        }
        System.out.print(BLUE + "~~~~~" + ANSI_RESET+"| -  "); // khoảng trống giữa 2 bảng

        for (int column = 1; column <= 10; ++column) { // in số cột của bảng của đối thủ
            if (column < 10) System.out.print(column + "  ");
            else System.out.println(column + "|");
        }

        for (int row = 0; row < 10; ++row) {
            int row_present = row + 1;
            // cột của player1
            if (row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");

            for (int column = 0; column < 10; ++column) {
                System.out.print(this.p1.myBoard[row][column] + " |");
            }
            System.out.print(BLUE + "~~~~~" + ANSI_RESET+"|");
            // cột của player2
            if (row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");

            for (int column = 0; column < 10; ++column) {
                System.out.print(this.p2.myBoard[row][column] + " |");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public void updateData(Player currentPlayer, Player nextPlayer) {
        int myNumberOfHitShip = 0, opponentNumberOfHitShip = 0, myRemainShip = 5, opponentRemainShip = 5;
        currentPlayer.displayBoard(currentPlayer.getUsername(), nextPlayer.getUsername());
        System.out.println("Your current result:                    Your current result:");
        System.out.println("Number of cells that were hit: " + currentPlayer.getBulletNumber() + "       Number of cells that were hit: " + nextPlayer.getBulletNumber());

        // so sánh bảng dùng để bắn của người hiện tại và bảng cá nhân của người chơi còn lại theo tọa độ các tàu
        for (int i = 0; i < nextPlayer.CoordinateX.size(); ++i) {
            // lấy tọa độ của từng thuyền
            int x1 = nextPlayer.CoordinateX.get(i);
            int y1 = nextPlayer.CoordinateY.get(i);
            ++i;
            int x2 = nextPlayer.CoordinateX.get(i);
            int y2 = nextPlayer.CoordinateY.get(i);
            /*
             * x bằng nhau -> thuyền nằm ngang
             * y bằng nhau -> thuyền nằm dọc
             * */
            if (x1 == x2) {
                boolean check = true;
                for (int j = y1 - 1; j <= y2 - 1; ++j) { // kiểm tra đã bắn thủng tàu tại tọa độ đó hay chưa
                    if (currentPlayer.opponentBoard[x1 - 1][j] == ' ') { // chưa bắn trúng
                        check = false;
                        break;
                    }
                }
                if (check) ++myNumberOfHitShip; // nếu tàu bị bắn trúng
            } else if (y1 == y2) {
                boolean check = true;
                for (int j = x1 - 1; j <= x2 - 1; ++j) { // kiểm tra có bắn trúng tàu tại tọa độ đó ko
                    if (currentPlayer.opponentBoard[j][y1 - 1] == ' ') {
                        check = false; // chua trung
                        break;
                    }
                }
                if (check) ++myNumberOfHitShip; // nếu tàu bị bắn trúng
            }
        }
        System.out.print("The number of ships I destroyed: " + myNumberOfHitShip);
//        System.out.print(myNumberOfHitShip);
        // update opponent data
        for (int i = 0; i < currentPlayer.CoordinateX.size(); ++i) {
            // lấy tọa độ của từng thuyền
            int x1 = currentPlayer.CoordinateX.get(i);
            int y1 = currentPlayer.CoordinateY.get(i);
            ++i;
            int x2 = currentPlayer.CoordinateX.get(i);
            int y2 = currentPlayer.CoordinateY.get(i);

            if (x1 == x2) {
                boolean check = true;
                for (int j = y1 - 1; j <= y2 - 1; ++j) { // kiểm tra đã bắn trúng tàu tại tọa độ đó hay chưa
                    if (nextPlayer.opponentBoard[x1 - 1][j] == ' ') {
                        check = false;
                        break;
                    }
                }
                if (check) ++opponentNumberOfHitShip; // nếu tại đó tàu bị bắn trúng
            } else {
                boolean check = true; // biến kiểm tra
                for (int j = x1 - 1; j <= x2 - 1; ++j) { // kiểm tra có bắn trúng tàu tại tọa độ đó hay chưa
                    if (nextPlayer.opponentBoard[j][y1 - 1] == ' ') {
                        check = false;
                        break;
                    }
                }
                if (check) ++opponentNumberOfHitShip; // nếu tại đó tàu bị bắn trúng
            }
        }
        System.out.print("      The number of ships I destroyed: ");
        System.out.println(opponentNumberOfHitShip);
        //hiển thị số tàu còn lại của bản thân


        myRemainShip = 5 - opponentNumberOfHitShip;
        System.out.print("My remaining ships: " + myRemainShip);
//        System.out.print(myRemainShip);

        opponentRemainShip = 5 - myNumberOfHitShip;
        // remaining ship của đối thủ
        System.out.print("                   My remaining ships: ");
        System.out.println(opponentRemainShip);
        System.out.println("-------------------------------------------------------------------------");
//        System.out.println("");
        // check win
        if (myRemainShip == 0) {
            System.out.println(GREEN + "CONGRATULATIONS " + nextPlayer.getUsername() + "!" + ANSI_RESET);
            nextPlayer.displayBoard(nextPlayer.getUsername(), currentPlayer.getUsername());
            isWinner = true;
        }
        else if (opponentRemainShip == 0) {
            System.out.println(GREEN + "CONGRATULATIONS " + currentPlayer.getUsername() + "!" + ANSI_RESET);
            currentPlayer.displayBoard(currentPlayer.getUsername(), nextPlayer.getUsername());
            isWinner = true;
        }
    }

    public void playGame() {
        System.out.print("Please enter 1st username: ");
        this.p1 = new Player();
        System.out.print("Please enter 2nd username: ");
        this.p2 = new Player();
//        p2.setUsername(sc.nextLine());
        displayMenuBoard(this.p1.getUsername(), this.p2.getUsername());
        System.out.println("");
        Player currentPlayer = this.p1;
        Player nextPlayer = this.p2;
        while (true) {
            System.out.println(YELLOW + "It's " + currentPlayer.getUsername() + "'s turn!" + ANSI_RESET);
            currentPlayer.displayBoard(currentPlayer.getUsername(), nextPlayer.getUsername());
            shoot(currentPlayer, nextPlayer);
            updateData(currentPlayer, nextPlayer);
            if (this.isWinner) { // điều kiện kết thúc game
                System.out.println(GREEN + "END GAME!" + ANSI_RESET);
                endGame();
                return;
            }
            // change turn
            if (currentPlayer == this.p1) {
                currentPlayer = this.p2;
                nextPlayer = this.p1;
            } else if (currentPlayer == this.p2) {
                currentPlayer = this.p1;
                nextPlayer = this.p2;
            }
        }
    }

    public void runGame() {
        menuStart();
        System.out.print("Enter your option: ");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                playGame();
                break;
            case 2:
                menuInstruction();
                System.out.println("Do you want to start game?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Enter your option (1 - Yes / 2 - No): ");
                int opt = Integer.parseInt(sc.nextLine());
                if (opt == 1) playGame();
                else {
                    endGame();
                    return;
                }
                break;
            case 3:
                endGame();
                return;
            default:
                System.out.println(RED + "Invalid option! Please re-enter!" + ANSI_RESET);
                break;
        }
    }
}

