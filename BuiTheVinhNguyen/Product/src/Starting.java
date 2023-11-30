import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Starting{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void startingActions(Board Player1,Board Player2) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println(ANSI_CYAN + "Welcome to Battle Ship !!!" + ANSI_RESET);
            System.out.println("1.Play");
            System.out.println("2.Leaderboard");
            System.out.println("3.Rules");
            System.out.println("4.Exit");
            String option = sc.nextLine();
            switch (option){
                case "1":
                    play(Player1, Player2);
                    break;
                case "2":
                    showLeaderBoard(sc);
                    break;
                case "3":
                    showRule(sc);
                    break;
                case "4":
                    System.out.println(ANSI_YELLOW + "Goodbye!!" + ANSI_RESET);
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void play(Board Player1, Board Player2) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first player's name:");
        Player1.playerName = sc.nextLine();
        System.out.println("Enter second player's name:");
        Player2.playerName = sc.nextLine();

        System.out.println("Player 1 ships placement:");
        Player1.show();
        System.out.println("Fill options:");
        System.out.println("1.Autofill");
        System.out.println("2.Manual");
        switch(sc.nextLine())
        {
            case "1":
                autoPlacement(sc, Player1);
                break;
            case "2":
                shipPlacement(sc,Player1);
                break;
        }

        System.out.println("Player 2 ships placement:");
        Player2.show();
        System.out.println("Fill options:");
        System.out.println("1.Autofill");
        System.out.println("2.Manual");
        switch(sc.nextLine())
        {
            case "1":
                autoPlacement(sc, Player2);
                break;
            case "2":
                shipPlacement(sc,Player2);
                break;
        }

        Ingame ingame = new Ingame();
        ingame.inGameActions(Player1, Player2);
    }

    public void shipPlacement(Scanner sc, Board Player)
    {
        System.out.println("Placing first Patrol Boat: 2 squares");
        placingShip(sc, 'P', Player);
        Player.show();
        System.out.println("Placing second Patrol Boat: 2 squares");
        placingShip(sc, 'P', Player);
        Player.show();
        System.out.println("Placing Destroyer Boat: 4 squares");
        placingShip(sc, 'D', Player);
        Player.show();
        System.out.println("Placing Submarine: 3 squares");
        placingShip(sc, 'S', Player);
        Player.show();
        System.out.println("Placing Battle Ship: 5 squares");
        placingShip(sc, 'B', Player);
        Player.show();

        System.out.println("Press Enter to continue: (Clear screen)");
        sc.nextLine();
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public void placingShip(Scanner sc, char typeOfShip, Board Player)
    {
        while(true)
        {
            int colnum, row;

            while(true) //Check tọa độ nhập vào có hợp lệ
            {
                System.out.println("Enter location: ");
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
                    if(row >= 1 && row <= 10 && colnum >= 1 && colnum <= 10) break;
                    else System.out.println("Out of bound, try another!!");
                }
                else System.out.println("Out of bound, try another!!");
            }


            int numberOfSquare = 0;
            if(typeOfShip == 'P') numberOfSquare = 2;
            else if(typeOfShip == 'D') numberOfSquare = 4;
            else if(typeOfShip == 'S') numberOfSquare = 3;
            else if(typeOfShip == 'B') numberOfSquare = 5;

            if(row - numberOfSquare + 1 >= 1) System.out.print("Up / ");
            if(row + numberOfSquare - 1 <= 10) System.out.print("Down / ");
            if(colnum - numberOfSquare + 1 >= 1) System.out.print("Left / ");
            if(colnum + numberOfSquare - 1 <= 10) System.out.print("Right / ");
            System.out.println();
            String choice = "";


            while(true) //Kiểm tra hướng nhập vào có hợp lệ
            {
                System.out.println("Choose direction (Type in text): ");
                choice = sc.nextLine();
                choice = choice.toLowerCase();
                if(choice.equals("up") || choice.equals("down") || choice.equals("left") || choice.equals("right")) break;
            }

            //Kiểm tra chồng lấn tàu
            boolean checkAvailableSpace = true;
            switch (choice) {
                case "up":
                    for (int i = max(1,colnum - 1); i <= colnum + 1; i++) {
                        for (int j = max(1, row - numberOfSquare); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = row - numberOfSquare + 1; i <= row; i++) Player.board[i][colnum] = typeOfShip;
                    break;
                case "down":
                    for (int i = max(1,colnum - 1); i <= colnum + 1; i++) {
                        for (int j = max(1,row - 1); j <= min(10, row + numberOfSquare); j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = row; i < row + numberOfSquare; i++) Player.board[i][colnum] = typeOfShip;
                    break;
                case "left":
                    for (int i = max(1, colnum - numberOfSquare); i <= colnum + 1; i++) {
                        for (int j = max(1,row - 1); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = colnum - numberOfSquare + 1; i <= colnum; i++) Player.board[row][i] = typeOfShip;
                    break;
                case "right":
                    for (int i = max(1,colnum - 1); i <= colnum + numberOfSquare; i++) {
                        for (int j =  max(1,row - 1); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = colnum; i < colnum + numberOfSquare; i++) Player.board[row][i] = typeOfShip;
                    break;
                default:
                    System.out.println("Invalid choice!!");
            }
            if(checkAvailableSpace)
            {
                System.out.println("Your ship is ready!!");
                break;
            }
            else System.out.println("Ships overlapping, try another!!");
        }
    }

    public void autoPlacement(Scanner sc, Board Player)
    {
        autoFill(Player, 'P');
        autoFill(Player, 'P');
        autoFill(Player, 'D');
        autoFill(Player, 'S');
        autoFill(Player, 'B');
        Player.show();
        System.out.println("Press Enter to continue: (Clear screen)");
        sc.nextLine();
        for (int i = 0; i < 50; ++i) System.out.println();

    }

    public void autoFill(Board Player, char typeOfShip)
    {
        Random generator = new Random();
        while(true)
        {
            int row = generator.nextInt(10) + 1, colnum = generator.nextInt(10) + 1;

            int numberOfSquare = 0;
            if(typeOfShip == 'P') numberOfSquare = 2;
            else if(typeOfShip == 'D') numberOfSquare = 4;
            else if(typeOfShip == 'S') numberOfSquare = 3;
            else if(typeOfShip == 'B') numberOfSquare = 5;

            List<String> list = new ArrayList<>();
            if(row - numberOfSquare + 1 >= 1) list.add("up");
            if(row + numberOfSquare - 1 <= 10) list.add("down");
            if(colnum - numberOfSquare + 1 >= 1) list.add("left");
            if(colnum + numberOfSquare - 1 <= 10) list.add("right");
            String choice;

            while(true) //Kiểm tra hướng có hợp lệ
            {
                choice = list.get(generator.nextInt(list.size()));
                if(choice.equals("up") || choice.equals("down") || choice.equals("left") || choice.equals("right")) break;
            }

            //Kiểm tra chồng lấn tàu
            boolean checkAvailableSpace = true;
            switch (choice) {
                case "up":
                    for (int i = max(1,colnum - 1); i <= colnum + 1; i++) {
                        for (int j = max(1, row - numberOfSquare); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = row - numberOfSquare + 1; i <= row; i++) Player.board[i][colnum] = typeOfShip;
                    break;
                case "down":
                    for (int i = max(1,colnum - 1); i <= colnum + 1; i++) {
                        for (int j = max(1,row - 1); j <= min(10, row + numberOfSquare); j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = row; i < row + numberOfSquare; i++) Player.board[i][colnum] = typeOfShip;
                    break;
                case "left":
                    for (int i = max(1, colnum - numberOfSquare); i <= colnum + 1; i++) {
                        for (int j = max(1,row - 1); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = colnum - numberOfSquare + 1; i <= colnum; i++) Player.board[row][i] = typeOfShip;
                    break;
                case "right":
                    for (int i = max(1,colnum - 1); i <= colnum + numberOfSquare; i++) {
                        for (int j =  max(1,row - 1); j <= row + 1; j++) {
                            if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Player.board[j][i] != 'o') {
                                checkAvailableSpace = false;
                                break;
                            }
                        }
                        if (!checkAvailableSpace) break;
                    }
                    if (checkAvailableSpace)
                        for (int i = colnum; i < colnum + numberOfSquare; i++) Player.board[row][i] = typeOfShip;
                    break;
            }
            if(checkAvailableSpace) break;
        }
    }

    public void showLeaderBoard(Scanner sc){
        Scanner input;
        List<Leader> list = new ArrayList<>();
        try{
            input = new Scanner(new File("C:\\Users\\buiph\\IdeaProjects\\BattleShip\\src\\leaderBoard.txt"));
            while(input.hasNext())
            {
                    String name = input.nextLine();
                    String numberOfShots = input.nextLine();
                    String numberOfShips = input.nextLine();
                    list.add(new Leader(name, numberOfShots, numberOfShips));
            }
        } catch (FileNotFoundException | NoSuchElementException e) {
            System.out.println();
            System.out.println(ANSI_RED + "Leaderboard currently has no data" + ANSI_RESET);
            System.out.println();
            return;
        }
        list.sort(new Comparator<Leader>() {
            @Override
            public int compare(Leader o1, Leader o2) {
                return o1.numberOfShots.compareTo(o2.numberOfShots);
            }
        });
        System.out.println(String.format("%-"+35+"s", " ") +ANSI_CYAN + "LEADERBOARD" + ANSI_RESET);
        System.out.println();
        System.out.println(String.format("%-"+10+"s"+ " | " + "%-"+25+"s" + " | " + "%-"+25+"s" + " | "
                + "%-"+25+"s","Ranking","Player Name","Shots taken","Ships remaining"));
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for(int i = 0; i < min(5,list.size()); i++)
        {
            System.out.printf("%-"+10+"s"+ " | " + "%-"+25+"s" + " | " + "%-"+25+"s" + " | "
                    + "%-"+25+"s" + "\n", i + 1, list.get(i).name, list.get(i).numberOfShots, list.get(i).numberOfShips);
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
        System.out.println("Press enter to continue");
        sc.nextLine();
        for(int i = 0; i < 50; i++) System.out.println();
    }

    public void showRule(Scanner sc)
    {
        System.out.println(ANSI_RED + "* Sea Battle is a game for two players.\n* The game is played on four grids, two for each player.\n" +
                "* The grids are typically square – usually 10×10 – and the individual squares in the grid are identified by letter and number.\n" +
                "* On one grid the player arranges ships and records the shots by the opponent.\n" +
                "* On the other grid the player records their own shots." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Place your battle ships, including:" + ANSI_RESET);
        System.out.println("    + 2 Patrol Boat: 1x2");
        System.out.println("    + 1 Destroyer Boat: 1x4");
        System.out.println("    + 1 Submarine: 1x3");
        System.out.println("    + 1 Battle Ship: 1x5");
        System.out.println(ANSI_YELLOW + "Each turn, you can choose a location to attack, the game ends once all of your opponent's units are destroyed." + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\nGoodluck, havefun!!!" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_YELLOW + "* Game powered by" + ANSI_RESET + ANSI_RED + " [ProPTIT]-D22-NguyenBui256- *" + ANSI_RESET);
        System.out.println();
        System.out.println("Press enter to continue");
        sc.nextLine();
        for (int i = 0 ; i < 50; i++) System.out.println();
    }


}
