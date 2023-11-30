import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ingame {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public void inGameActions(Board Player1, Board Player2) throws IOException {
        Scanner sc = new Scanner(System.in);
        int playerTurn = 1;
        while(true)
        {
            if(playerTurn == 1) System.out.println("It's " + ANSI_RED + Player1.playerName + ANSI_RESET + " turn!");
            else System.out.println("It's " + ANSI_GREEN + Player2.playerName + ANSI_RESET + " turn!");
            System.out.println("1.Review your board");
            System.out.println("2.Attack opponent");
//          System.out.println("3.End your turn");
            String option = sc.nextLine();
            switch (option){
                case "1":
                    if(playerTurn == 1) Player1.show();
                    else Player2.show();
                    break;
                case "2":
                    if(playerTurn == 1)
                    {
                        Player2.showForOpponent();
                        System.out.println("Your remaining ships: " + Player1.shipRemaining);
                    }
                    else
                    {
                        Player1.showForOpponent();
                        System.out.println("Your remaining ships: " + Player2.shipRemaining);
                    }
                    if(playerTurn == 1) attack(Player2, sc);
                    else attack(Player1, sc);
                    playerTurn = 1 - playerTurn;
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid option" + ANSI_RESET);
                    break;
            }
          
            if(Player1.shipRemaining == 0 || Player2.shipRemaining == 0) //Điều kiện kết thúc trò chơi + cập nhật bảng xếp hạng
            {
                try {
                    File file = new File("C:\\Users\\buiph\\IdeaProjects\\BattleShip\\src\\leaderBoard.txt");
                    if (!file.exists()) file.createNewFile();
                    PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8);
                    if (Player1.shipRemaining == 0) {
                        System.out.println(ANSI_GREEN + Player2.playerName + ANSI_RESET + " won the game!!");
                        pw.println(Player2.playerName);
                        pw.println(Player2.destroyedSquare);
                        pw.println(Player2.shipRemaining);
                        pw.close();
                    } else {
                        System.out.println(ANSI_RED + Player1.playerName + ANSI_RESET + ANSI_CYAN + " won the game!!" + ANSI_RESET);
                        pw.println(Player1.playerName);
                        pw.println(Player1.destroyedSquare);
                        pw.println(Player1.shipRemaining);
                        pw.close();
                    }
                }catch (IOException e){
                    System.out.println("Exeption occurred: ");
                    e.printStackTrace();
                }

                System.out.println("Press any key to show " + ANSI_RED + Player1.playerName + ANSI_RESET + " board:");
                sc.nextLine();
                Player1.show();
                System.out.println("Press any key to show " + ANSI_GREEN + Player2.playerName + ANSI_RESET + " board:");
                sc.nextLine();
                Player2.show();

                System.out.println("Press enter to continue");
                sc.nextLine();
                for(int i = 0; i < 50; i++) System.out.println();
                return;
            }
        }
    }

    public void attack(Board Player, Scanner sc)
    {
        int colnum = 0, row = 0;
        while(true) //Kiểm tra tọa độ nhập vào có hợp lệ
        {
            System.out.println(ANSI_YELLOW + "Enter location: " + ANSI_RESET);
            boolean checkLocationSyntax = true;
            String location = sc.nextLine();
            location = location.toUpperCase();
            location = location.trim();
            row = location.charAt(0) - 'A' + 1;
            StringBuilder col = new StringBuilder();
            for (int i = 1; i < location.length(); i++) {
                col.append(location.charAt(i));
                if (!(location.charAt(i) >= '0' && location.charAt(i) <= '9')) checkLocationSyntax = false;
            }
            if(checkLocationSyntax)
            {
                colnum = Integer.parseInt(col.toString());
                if(!(row >= 1 && row <= 10 && colnum >= 1 && colnum <= 10)) System.out.println(ANSI_RED + "Out of bound, try another!!" + ANSI_RESET);
            }
            else System.out.println(ANSI_RED + "Out of bound, try another!!" + ANSI_RESET);

            //Kiểm tra trùng ô đã tấn công
            if(Player.boardForOpponent[row][colnum] == 'o') break;
            else System.out.println(ANSI_RED + "ALREADY DESTROYED, TRY ANOTHER!!" + ANSI_RESET);
        }

        if(Player.board[row][colnum] != 'o') //Bắn trúng đích
        {
            System.out.println(ANSI_GREEN + "TARGET DESTROYED!!" + ANSI_RESET);
            boolean checkShipAlive = false;
            int numberOfSquare = 0;
            if(Player.board[row][colnum] == 'P') numberOfSquare = 2;
            else if(Player.board[row][colnum] == 'D') numberOfSquare = 4;
            else if(Player.board[row][colnum] == 'S') numberOfSquare = 3;
            else if(Player.board[row][colnum] == 'B') numberOfSquare = 5;
            for(int index = 1; index < numberOfSquare; index++)
            {
                if((row + index <= 10 && Player.board[row+index][colnum] == Player.board[row][colnum] && Player.boardForOpponent[row+index][colnum] == 'o')
                || (row - index >= 1 && Player.board[row-index][colnum] == Player.board[row][colnum] && Player.boardForOpponent[row-index][colnum] == 'o')
                || (colnum + index <= 10 && Player.board[row][colnum + index] == Player.board[row][colnum] && Player.boardForOpponent[row][colnum+index] == 'o')
                || (colnum - index >= 1 && Player.board[row][colnum - index] == Player.board[row][colnum] && Player.boardForOpponent[row][colnum-index] == 'o'))
                {
                    checkShipAlive = true;
                    break;
                }
            }
            if(!checkShipAlive)
            {
                Player.shipRemaining -= 1;
                System.out.println(ANSI_CYAN + "ENEMY'S SHIP SUNK!!" + ANSI_RESET);
            }
            Player.boardForOpponent[row][colnum] = 'x';
            Player.destroyedSquare += 1;
        }
        else //Bắn trượt
        {
            System.out.println(ANSI_RED + "TARGET MISSED!!" + ANSI_RESET);
            Player.boardForOpponent[row][colnum] = 'm';
            Player.destroyedSquare += 1;
        }
        System.out.println("Press any key to continue:");
        sc.nextLine();
        for(int i = 0; i < 50; i++) System.out.println();
    }
}
