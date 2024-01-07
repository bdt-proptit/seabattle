public class Person extends Player{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    int i1,j1,i2,j2;
    public int Add_PatrolBoat(){
        // nhập xong thì check ở Parent
        System.out.print(ANSI_BLUE + "Set New Patrol Boat(1x2): " + ANSI_RESET );
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_PatrolBoat(i1,j1,i2,j2);
    }
    public int Add_DestroyerBoat(){
        // nhập xong thì check ở Parent
        System.out.print(ANSI_BLUE + "Set New Destroyer Boat(1x4): " + ANSI_RESET);
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_DestroyerBoat(i1,j1,i2,j2);
    }
    public int Add_Submarine(){
        System.out.print(ANSI_BLUE +"Set New Submarine(1x3): "+ ANSI_RESET);
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_Submarine(i1,j1,i2,j2);
    }
    public int Add_BattleShip(){
        System.out.print(ANSI_BLUE + "Set New Battle Ship(1x5): " + ANSI_RESET);
        System.out.print("i1: ");
        i1 = sc.nextInt();
        System.out.print("j1: ");
        j1 = sc.nextInt();
        System.out.print("i2: ");
        i2 = sc.nextInt();
        System.out.print("j2: ");
        j2 = sc.nextInt();
        return super.Check_BattleShip(i1,j1,i2,j2);
    }
    public void TurnAttack_Person(int i){
        if(i == 0){
            System.out.println("______ _                         __    _       _                    \n" +
                    "| ___ \\ |                       /  |  ( )     | |                   \n" +
                    "| |_/ / | __ _ _   _  ___ _ __  `| |  |/ ___  | |_ _   _ _ __ _ __  \n" +
                    "|  __/| |/ _` | | | |/ _ \\ '__|  | |    / __| | __| | | | '__| '_ \\ \n" +
                    "| |   | | (_| | |_| |  __/ |    _| |_   \\__ \\ | |_| |_| | |  | | | |\n" +
                    "\\_|   |_|\\__,_|\\__, |\\___|_|    \\___/   |___/  \\__|\\__,_|_|  |_| |_|\n" +
                    "                __/ |                                               \n" +
                    "               |___/                                                ");
        }
        else{
            System.out.println("______ _                         _____   _       _                    \n" +
                    "| ___ \\ |                       / __  \\ ( )     | |                   \n" +
                    "| |_/ / | __ _ _   _  ___ _ __  `' / /' |/ ___  | |_ _   _ _ __ _ __  \n" +
                    "|  __/| |/ _` | | | |/ _ \\ '__|   / /     / __| | __| | | | '__| '_ \\ \n" +
                    "| |   | | (_| | |_| |  __/ |    ./ /___   \\__ \\ | |_| |_| | |  | | | |\n" +
                    "\\_|   |_|\\__,_|\\__, |\\___|_|    \\_____/   |___/  \\__|\\__,_|_|  |_| |_|\n" +
                    "                __/ |                                                 \n" +
                    "               |___/                                                  ");
        }
//        System.out.println("Show Your Map: ");
//        Main.List.get(i).SeeMap();
//        System.out.println("Show Attacked Map of Your Enemy: ");
//        Main.List.get(i).SeeMap_Enemy();
        System.out.println(ANSI_YELLOW + "Show Your & Your Enemy's Map: " + ANSI_RESET);
        Main.List.get(i).SeeMap_Full();
        System.out.println(ANSI_BLUE +"Enter your address to Attack: "+ ANSI_RESET);
        // Mặc định ngừoi không đánh chỗ đã đánh rồi.
        int x = sc.nextInt();
        int y = sc.nextInt();
        int checktmp = Main.List.get(i).Check_Attack(x,y,i); // tk i ATK tk 1 - i; // cái check ko quan trong
    }
}
