import java.util.Scanner;
public class Talking_Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public void Hello(){
        System.out.println(ANSI_RED + "                                                      (                                                 ____ \n" +
                " (  (           (                             )       )\\ )               (            )    )  (        |   / \n" +
                " )\\))(   '   (  )\\             )      (    ( /(      (()/(   (     )   ( )\\     )  ( /( ( /(  )\\   (   |  /  \n" +
                "((_)()\\ )   ))\\((_) (   (     (      ))\\   )\\()) (    /(_)) ))\\ ( /(   )((_) ( /(  )\\()))\\())((_) ))\\  | /   \n" +
                "_(())\\_)() /((_)_   )\\  )\\    )\\  ' /((_) (_))/  )\\  (_))  /((_))(_)) ((_)_  )(_))(_))/(_))/  _  /((_) |/    \n" +
                "\\ \\((_)/ /(_)) | | ((_)((_) _((_)) (_))   | |_  ((_) / __|(_)) ((_)_   | _ )((_)_ | |_ | |_  | |(_))  (      \n" +
                " \\ \\/\\/ / / -_)| |/ _|/ _ \\| '  \\()/ -_)  |  _|/ _ \\ \\__ \\/ -_)/ _` |  | _ \\/ _` ||  _||  _| | |/ -_) )\\     \n" +
                "  \\_/\\_/  \\___||_|\\__|\\___/|_|_|_| \\___|   \\__|\\___/ |___/\\___|\\__,_|  |___/\\__,_| \\__| \\__| |_|\\___|((_)    \n" +
                "                                                                                                             " + ANSI_RESET);
    }
    public void Hello_PvP(){
        System.out.println(ANSI_YELLOW_BACKGROUND + "Welcome to PvP Mode:" + ANSI_RESET);
    }
    public void Hello_PvC(){
        System.out.println(ANSI_YELLOW_BACKGROUND + "Welcome to PvC Mode:"+ ANSI_RESET);
    }
    public void GoodBye(){
        System.out.println(ANSI_YELLOW_BACKGROUND + "Good Bye, See you again!" + ANSI_RESET);
    }
    public void Instruction(){
        System.out.println("zzzzz");
    }
    public void ShowRanking(){
        System.out.println(ANSI_BLUE_BACKGROUND + "| STT | Name          | Turn Play |"+ ANSI_RESET);
        System.out.println("===================================");
        for(int i = 0 ;i < Main.List_Ranking.size(); i++){
            System.out.println(String.format("| "+ "%-3s" + " | " + "%-13s" + " | " + "%-9s" + " |", i, Main.List_Ranking.get(i).Name, Main.List_Ranking.get(i).Turn));
            System.out.println("-----------------------------------");
        }
    }
//    public void SaveGame(){
//        System.out.println("Do you want to save game?: 1: Save.  0: No");
//        Scanner sc = new Scanner(System.in);
//        int save = sc.nextInt();
//        if(save == 0){
//            Main.thelastgame = 1;
//        }
//        else Main.thelastgame = 0;
//    }
}
