public class Display{
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BULE = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN= "\u001B[32m";
    public static final String ANSI_PURPLE= "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void title(){
        System.out.println(ANSI_BULE + " ______     ______     ______    ______   __         ______     ______     __  __     __     ______");
        System.out.println(ANSI_BULE + "/\\  == \\   /\\  __ \\   /\\__  _\\  /\\__  _\\ /\\ \\       /\\  ___\\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\   ==\\");
        System.out.println(ANSI_BULE + "\\ \\  __<   \\ \\  __ \\  \\/_/\\ \\/  \\/_/\\ \\/ \\ \\ \\____  \\ \\  __\\   \\ \\___  \\  \\ \\  __ \\  \\ \\ \\  \\ \\  _-/");
        System.out.println(ANSI_BULE + " \\ \\_____\\  \\ \\_\\ \\_\\    \\ \\_\\     \\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\");
        System.out.println(ANSI_BULE + "  \\/_____/   \\/_/\\/_/     \\/_/      \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/" + ANSI_RESET);
        System.out.println("___________________________________________________________________________________________________");
        //         ______     ______     __  __     __     ______
        //        /\  ___\   /\  ___\   /\ \_\ \   /\ \   /\   ==\
        //        \ \  __\   \ \___  \  \ \  __ \  \ \ \  \ \  _-/
        //         \ \_____\  \/\_____\  \ \_\ \_\  \ \_\  \ \_\
        //          \/_____/   \/_____/   \/_/\/_/   \/_/   \/_/
    }
    public void unveil(CellStatus[][] gird, int[][] see, int size){
        GameConstant symbol = new GameConstant();

        String ans="";
        String res="";

        System.out.print("    ");

        for (int i=1;i<=size;i++){
            res=String.format("%-4d",i);
            ans=ans+res;
        }
        System.out.println(ans);

        ans="";

        for (int i=1;i<=size;i++){
            res=String.format("%-2d",i);
            ans=ans+res;
            for (int j=1;j<=size;j++){
                switch (gird[i][j]){
                    case WATER -> {
                        if (see[i][j] == 0)
                            res = String.format("| %-2s ", ANSI_BULE + symbol.getWaterSymbol() + ANSI_RESET);
                        else res = String.format("| %-2s ", ANSI_WHITE + symbol.getMissSymbol() + ANSI_RESET);
                    }
                    case HIT -> res=String.format("| %-2s ",ANSI_RED + symbol.getHitSymbol() + ANSI_RESET);
                    case PatrolBoat -> res=String.format("| %-2s ",ANSI_YELLOW + symbol.getPatrolBoatSymbol() + ANSI_RESET);
                    case DestroyerBoat -> res=String.format("| %-2s ",ANSI_RED + symbol.getDestroyerBoardSymbol() + ANSI_RESET);
                    case Submarine -> res=String.format("| %-2s ",ANSI_PURPLE + symbol.getSubmarineSymbol() + ANSI_RESET);
                    case BattleShip -> res=String.format("| %-2s ",ANSI_GREEN + symbol.getBattleShipSymbol() + ANSI_RESET);
                }
                ans = ans + res;
            }
            ans = ans +"|";
            System.out.println(ans);
            ans="";
        }
    }

    public void veil(CellStatus[][] gird, int[][] see, int size){
        GameConstant symbol = new GameConstant();

        String ans="";
        String res="";

        System.out.print("    ");

        for (int i=1;i<=size;i++){
            res=String.format("%-4d",i);
            ans=ans+res;
        }
        System.out.println(ans);

        ans="";

        for (int i=1;i<=size;i++){
            res=String.format("%-2d",i);
            ans=ans+res;
            for (int j=1;j<=size;j++){
                if (see[i][j]==1) {
                    if (gird[i][j]==CellStatus.WATER) res=String.format("| %-2s ",ANSI_BULE + symbol.getWaterSymbol() + ANSI_RESET);
                    else res=String.format("| %-2s ",ANSI_RED + symbol.getHitSymbol() + ANSI_RESET);
                }
                else{
                    res=String.format("|%-2s",ANSI_WHITE_BACKGROUND + symbol.getNotSeenSymbol()) + ANSI_RESET;
                }
                ans=ans+res;
            }
            ans = ans +"|";
            System.out.println(ans);
            ans="";
        }
    }
}
