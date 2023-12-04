import java.util.Scanner;

public class GameMenu {
    Scanner sc = new Scanner(System.in);
    public void setup(){
        System.out.println("Dang trong qua trinh phat trien");
    }

    public void continueGame(){
        System.out.println("Dang trong qua trinh phat trien");
    }

    public void newGame(){
        Graphic.clrscr();
        Display.title();
        Game game = new Game();
        System.out.println("1. Muc do de (vi tri tau do nguoi choi chon)");
        System.out.println("2. Muc do kho (vi tri tau do may dat ngau nhien)");
        int mode = sc.nextInt();
        sc.nextLine();
        String winner = game.startGame(mode);
        Graphic.clrscr();
        Display.title();
        game.endGame(winner);
    }

    public void AIGame(){
        Game game = new Game();
        String winner = game.PlayWithAI();
        game.endGame(winner);
    }

    public void Ranking(){
        System.out.println("Dang trong qua trinh phat trien");
    }
}
