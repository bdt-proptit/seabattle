import java.util.Scanner;

public class Game_Menu{
      Scanner sc = new Scanner(System.in);
      public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
      public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
      public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
      public static final String ANSI_RED = "\u001B[31m";
      public static final String ANSI_BLUE = "\u001B[34m";
      public static final String ANSI_YELLOW = "\u001B[33m";
      public void LetsGo(){
            Talking_Menu talk = new Talking_Menu();
            talk.Hello();
            System.out.println(ANSI_YELLOW + "Let's play Sea Battle!:" + ANSI_RESET);
            System.out.println(ANSI_BLUE + """
                    1: Player vs Player\s
                    2: Player vs Computer
                    3: Instruction
                    4: Exit""" + ANSI_RESET);

            int selection = sc. nextInt();
            Game_Menu_Player game = new Game_Menu_Player();
            //Chia ra 2 các chế độ
            switch(selection){
                  case 1 :
                  {
                        talk.Hello_PvP();
                        // B1: Create new Map
                        game.CreateNewMap_PvP();
                        // B2: CreateBoat
                        game.CreateBoat(1);
                        // B3: Playgame
                        game.PlayNow(1);
                        break;
                  }
                  case 2:
                  {
                        talk.Hello_PvC();
                        // B1: Create new Map
                        game.CreateNewMap_PvC();
                        // B2: CreateBoat
                        game.CreateBoat(2);
                        // B3:Playgame.
                        game.PlayNow(2);
                        break;
                  }
                  case 3:
                  {
                        talk.Instruction();
                        break;
                  }
                  case 4:
                  {
                        talk.ShowRanking();
                        break;
                  }
                  case 5:
                  {
                     //   talk.SaveGame();
                        talk.GoodBye();
                        break;
                  }
                  default: break;
            }
      }
}
