public class Game_Menu_Player {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public void CreateNewMap_PvP() {
        Player player1 = new Person();
        Player player2 = new Person();

        System.out.println(ANSI_YELLOW + "Enter player1's name: " + ANSI_RESET);
        player1.Enter_Name();
        System.out.println(ANSI_YELLOW +"Enter player2's name: "+ ANSI_RESET);
        player2.Enter_Name();
        player1.Mode = "PvP";
        player2.Mode = "PvC";

        Main.List.addElement(player1);
        Main.List.addElement(player2);

        System.out.println(ANSI_YELLOW + "Enter size of Map(10 -> 20):" + ANSI_RESET);
        Main.List.get(0).Enter_Size();
        Main.List.get(1).size = Main.List.get(0).size;

        Main.List.get(0).CreatNewBoard();
        Main.List.get(1).CreatNewBoard();
        Main.List.get(0).CreatNewBoard_Enemy();
        Main.List.get(1).CreatNewBoard_Enemy();
    }
    public void CreateNewMap_PvC() {
        Player player1 = new Person();
        Player player2 = new Computer(); // Mặc định bot là Player 2

        System.out.println(ANSI_YELLOW + "Enter player's name: "+ ANSI_RESET);
        player1.Enter_Name();
        player1.Mode = "PvP";
        Main.List.addElement(player1);
        Main.List.addElement(player2);

        System.out.println(ANSI_YELLOW +"Enter size of Map(10 -> 20):"+ ANSI_RESET);
        Main.List.get(0).Enter_Size();
        Main.List.get(1).size = Main.List.get(0).size;

        Main.List.get(0).CreatNewBoard();
        Main.List.get(1).CreatNewBoard();
        Main.List.get(0).CreatNewBoard_Enemy();
        Main.List.get(1).CreatNewBoard_Enemy();
    }
    public void CreateBoat(int enemy) {
        for (int i = 0; i <= 1; i++) {
            if (i == 1 && enemy == 2)  // PvC
            {
                System.out.println(ANSI_YELLOW +"Computer is creating boat: "+ ANSI_RESET);

                int check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_PatrolBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_DestroyerBoat();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_Submarine();
                }
                check = 0;
                while (check == 0) {
                    check = ((Computer) Main.List.get(i)).Add_BattleShip();
                }
                Main.List.get(i).SeeMap();
            } else {
                System.out.println(ANSI_YELLOW + "Player " + (i + 1) + " is creating boat: "+ ANSI_RESET);

                int check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_PatrolBoat();
                    if(check == 0){
                        System.out.println(ANSI_RED + "Your board is wrong!. Creat Again:" + ANSI_RESET);
                    }
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_PatrolBoat();
                    if(check == 0){
                        System.out.println(ANSI_RED + "Your board is wrong!. Creat Again:" + ANSI_RESET);
                    }
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_DestroyerBoat();
                    if(check == 0){
                        System.out.println(ANSI_RED + "Your board is wrong!. Creat Again:" + ANSI_RESET);
                    }
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_Submarine();
                    if(check == 0){
                        System.out.println(ANSI_RED + "Your board is wrong!. Creat Again:" + ANSI_RESET);
                    }
                }
                check = 0;
                while (check == 0) {
                    check = ((Person) Main.List.get(i)).Add_BattleShip();
                    if(check == 0){
                        System.out.println(ANSI_RED + "Your board is wrong!. Creat Again:" + ANSI_RESET);
                    }
                }
                Main.List.get(i).SeeMap();
            }
        }
    }

    public void PlayNow(int enemy){
        while (true)
        {
            int cnt = 0;
            for (int i = 0; i <= 1; i++)
            {
                // B3: Attack Turn
                if (i == 1 && enemy == 2)  // PvC
                {
                    if(Main.List.get(i).check_greedy == 0) {
                        ((Computer)Main.List.get(i)).TurnAttack_Computer_Random(i);
                    }
                    else{
                        int[] dx = {0,-1,+1,0};
                        int[] dy = {-1,0,0,+1};
                        int attacked = 0;//Check xem tấn công đc chưa
                        for(int j = 0; j < 4; j++) {
                            ((Computer) Main.List.get(i)).TurnAttack_Computer_Greedy(i, Main.List.get(i).x_id + dx[j], Main.List.get(i).y_id + dy[j]);
                            if (Main.List.get(i).check_greedy != 0) // Có tàu ở vị trí + j, chỉ TH này thì mới kết thúc turn máy
                            {
                                //System.out.println(" _____                             _              _       _                       ___              _     _     __  \n" +
                               //         "/  __ \\                           | |            ( )     | |                     / / |            | |   (_)    \\ \\ \n" +
                                //        "| /  \\/ ___  _ __ ___  _ __  _   _| |_ ___ _ __  |/ ___  | |_ _   _ _ __ _ __   | || |_ ___    ___| |__  _ _ __ | |\n" +
                                //        "| |    / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__|   / __| | __| | | | '__| '_ \\  | || __/ _ \\  / __| '_ \\| | '_ \\| |\n" +
                                //        "| \\__/\\ (_) | | | | | | |_) | |_| | ||  __/ |      \\__ \\ | |_| |_| | |  | | | | | || || (_) | \\__ \\ | | | | |_) | |\n" +
                                //        " \\____/\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|      |___/  \\__|\\__,_|_|  |_| |_| | | \\__\\___/  |___/_| |_|_| .__/| |\n" +
                                //        "                      | |                                                        \\_\\                      | |  /_/ \n" +
                                //        "                      |_|                                                                                 |_|      "); //Nếu tìm thấy thì  mới show ra địa chỉ,ko thì thôi.
                                Main.List.get(i).x_id += dx[j];
                                Main.List.get(i).y_id += dy[j];
                               // System.out.println(Main.List.get(i).x_id + " " + Main.List.get(i).y_id);
                                attacked = 1;
                                break;
                            }
                        }
                        if(attacked == 0) //Nếu chưa tấn công đc
                        {
                            Main.List.get(i).check_greedy = 0;
                            ((Computer)Main.List.get(i)).TurnAttack_Computer_Random(i);
                        }
                    }
                  //  Main.List.get(i).SeeMap();
                } else {
                    ((Person)Main.List.get(i)).TurnAttack_Person(i);
                  //  Main.List.get(i).SeeMap();
                }

                // B4: Check Winner
                cnt = 0;
                //  ClearScreen.clrscr();
                for (int p = 0; p < Main.List.get(1).size; p++) {
                    for (int q = 0; q < Main.List.get(1).size; q++) {
                        if (Main.List.get(1 - i).board_Me[p][q] == 1) cnt++;
                    }
                }
                if (cnt == 0) {
                    if(enemy == 2 && i == 1) System.out.println("__   __                             _           _   _                                      \n" +
                            "\\ \\ / /                            | |         | | | |                                     \n" +
                            " \\ V /___  _   _    __ _ _ __ ___  | | ___  ___| |_| |                                     \n" +
                            "  \\ // _ \\| | | |  / _` | '__/ _ \\ | |/ _ \\/ __| __| |                                     \n" +
                            "  | | (_) | |_| | | (_| | | |  __/ | | (_) \\__ \\ |_|_|_                                    \n" +
                            "  \\_/\\___/ \\__,_|  \\__,_|_|  \\___| |_|\\___/|___/\\__(_|_)                                   \n" +
                            "                                                                                           \n" +
                            "                                                                                           \n" +
                            " _____                             _              _                _                       \n" +
                            "/  __ \\                           | |            (_)              (_)                      \n" +
                            "| /  \\/ ___  _ __ ___  _ __  _   _| |_ ___ _ __   _ ___  __      ___ _ __  _ __   ___ _ __ \n" +
                            "| |    / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__| | / __| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|\n" +
                            "| \\__/\\ (_) | | | | | | |_) | |_| | ||  __/ |    | \\__ \\  \\ V  V /| | | | | | | |  __/ |_  \n" +
                            " \\____/\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|    |_|___/   \\_/\\_/ |_|_| |_|_| |_|\\___|_(_) \n" +
                            "                      | |                                                                  \n" +
                            "                      |_|                                                                  ");
                    else
                    {
                        if(i == 1) System.out.println(" _____                             _         _       _   _             _        \n" +
                                "/  __ \\                           | |       | |     | | (_)           | |       \n" +
                                "| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __ | |       \n" +
                                "| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\| |       \n" +
                                "| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | |_|       \n" +
                                " \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_(_)       \n" +
                                "                    __/ |                                                       \n" +
                                "                   |___/                                                        \n" +
                                "______ _                         __    _                _                       \n" +
                                "| ___ \\ |                       /  |  (_)              (_)                      \n" +
                                "| |_/ / | __ _ _   _  ___ _ __  `| |   _ ___  __      ___ _ __  _ __   ___ _ __ \n" +
                                "|  __/| |/ _` | | | |/ _ \\ '__|  | |  | / __| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|\n" +
                                "| |   | | (_| | |_| |  __/ |    _| |_ | \\__ \\  \\ V  V /| | | | | | | |  __/ |   \n" +
                                "\\_|   |_|\\__,_|\\__, |\\___|_|    \\___/ |_|___/   \\_/\\_/ |_|_| |_|_| |_|\\___|_|   \n" +
                                "                __/ |                                                           \n" +
                                "               |___/                                                            ");
                        else System.out.println(" _____                             _         _       _   _             _          \n" +
                                "/  __ \\                           | |       | |     | | (_)           | |         \n" +
                                "| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __ | |         \n" +
                                "| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\| |         \n" +
                                "| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | |_|         \n" +
                                " \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_(_)         \n" +
                                "                    __/ |                                                         \n" +
                                "                   |___/                                                          \n" +
                                "______ _                         _____   _                _                       \n" +
                                "| ___ \\ |                       / __  \\ (_)              (_)                      \n" +
                                "| |_/ / | __ _ _   _  ___ _ __  `' / /'  _ ___  __      ___ _ __  _ __   ___ _ __ \n" +
                                "|  __/| |/ _` | | | |/ _ \\ '__|   / /   | / __| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|\n" +
                                "| |   | | (_| | |_| |  __/ |    ./ /___ | \\__ \\  \\ V  V /| | | | | | | |  __/ |   \n" +
                                "\\_|   |_|\\__,_|\\__, |\\___|_|    \\_____/ |_|___/   \\_/\\_/ |_|_| |_|_| |_|\\___|_|   \n" +
                                "                __/ |                                                             \n" +
                                "               |___/                                                              ");

                    }
                    Main.List_Ranking.addElement(Main.List.get(i));
                //    Main.thelastgame = 0;
                    break;
                }
            }
            if (cnt == 0) break;
        }
    }
}
