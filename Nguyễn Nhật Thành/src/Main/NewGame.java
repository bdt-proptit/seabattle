package Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.*;
import Feature.*;
import Tool.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class NewGame  {
    static Scanner cin = new Scanner(System.in);
    static Player[] initPlayer() throws IOException, InterruptedException {
        Player[] ps = new Player[2];
        ps[0] = new Player(1);
        String option = "";
        int check = 1;
        while(!Checker.checkInRange(1, 2, option)){
            if(check == 0) System.out.println(Print.setColor("Invalid option, please choose again.", "Red"));
            System.out.println("Choose mode:");
            System.out.println("1, PvP");
            System.out.println("2, Play with bot");
            option = cin.nextLine();
            check = 0;
        }
        if(option.equals("1")) ps[1] = new Player(2);
        else{
            ps[1] = new Bot();
            ps[0].playWithBot = true;
        }
        Screen.clear();
        ps[0].setName();
        ps[0].setShip();
        if(option.equals("1")) ps[1].setName();
        if(ps[0].getName().equals(ps[1].getName())){
            ps[0].setName(ps[0].getName() + ps[0].stt);
            ps[1].setName(ps[1].getName() + ps[1].stt);
        }
        ps[1].setShip();
        return ps;
    }
    static void endGame(Player winner) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException {
        Sound.playWinSound();
        System.out.print(" $$$$$$\\                                                    $$\\               $$\\            $$\\     $$\\                     $$\\ \n");
        System.out.print("$$  __$$\\                                                   $$ |              $$ |           $$ |    \\__|                    $$ |\n");
        System.out.print("$$ /  \\__| $$$$$$\\  $$$$$$$\\   $$$$$$\\   $$$$$$\\  $$$$$$\\ $$$$$$\\   $$\\   $$\\ $$ | $$$$$$\\ $$$$$$\\   $$\\  $$$$$$\\  $$$$$$$\\  $$ |\n");
        System.out.print("$$ |      $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ \\____$$\\\\_$$  _|  $$ |  $$ |$$ | \\____$$\\\\_$$  _|  $$ |$$  __$$\\ $$  __$$\\ $$ |\n");
        System.out.print("$$ |      $$ /  $$ |$$ |  $$ |$$ /  $$ |$$ |  \\__|$$$$$$$ | $$ |    $$ |  $$ |$$ | $$$$$$$ | $$ |    $$ |$$ /  $$ |$$ |  $$ |\\__|\n");
        System.out.print("$$ |  $$\\ $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |     $$  __$$ | $$ |$$\\ $$ |  $$ |$$ |$$  __$$ | $$ |$$\\ $$ |$$ |  $$ |$$ |  $$ |    \n");
        System.out.print("\\$$$$$$  |\\$$$$$$  |$$ |  $$ |\\$$$$$$$ |$$ |     \\$$$$$$$ | \\$$$$  |\\$$$$$$  |$$ |\\$$$$$$$ | \\$$$$  |$$ |\\$$$$$$  |$$ |  $$ |$$\\ \n");
        System.out.print(" \\______/  \\______/ \\__|  \\__| \\____$$ |\\__|      \\_______|  \\____/  \\______/ \\__| \\_______|  \\____/ \\__| \\______/ \\__|  \\__|\\__|\n");
        System.out.print("                              $$\\   $$ |                                                                                         \n");
        System.out.print("                              \\$$$$$$  |                                                                                         \n");
        System.out.print("                               \\______/                                                                                          \n");
        System.out.println(Print.setColor(winner.getName(), "Green") + " is the winner!");
        if(!winner.isBot()) Leaderboard.addPlayer(winner);
        System.out.println("Press any key to get back to menu.");
        GameLoad.clear();
        String back = cin.nextLine();
        Screen.clear();
        startScreen();
    }
    static public void inGame(Player[] ps, int thisTurn) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException {
        GameLoad gl = new GameLoad();
        gl.save(ps);
        Screen.clear();
        Sound.playIngameSound();
        int turn = thisTurn;
        while(ps[0].getPoint() < 5 && ps[1].getPoint() < 5){
            ps[turn].playNow = ps[turn].stt;
            ps[1-turn].playNow = 0;
            if(ps[turn].isBot()){
                System.out.println(Print.setColor("It's Bot's turn.", "Green"));
                ps[turn].Shot(ps[1-turn]);
            }
            else{
                String n = "";
                int ok = 1;
                do{
                    if(n.equals("2")){
                        ps[turn].displayMyBoard();
                        System.out.print("Press any key to get back.");
                        String back = cin.nextLine();
                        Screen.clear();
                    }
                    else if(ok == 0 && !Checker.checkInRange(1, 3, n)) System.out.println(Print.setColor("Invalid option, please choose again.", "Red"));
                    System.out.print("It's " + Print.setColor(ps[turn].getName(), "Green") + "'s turn. ");
                    if(!ps[1-turn].isBot()) System.out.print("Other player look away.");
                    System.out.println("Choose an option:");
                    System.out.println("1, Shot.");
                    System.out.println("2, Watch your field.");
                    System.out.println("3, Back to main menu.");
                    n = cin.nextLine();
                    ok = 0;
                }
                while(!n.equals("1") && !n.equals("3"));
                if(n.equals("1")){
                    ps[turn].Shot(ps[1-turn]);
                    if(ps[turn].getPoint() == 5) endGame(ps[turn]);
                }
                else{
                    gl.save(ps);
                    startScreen();
                }
            }
            Sound.finishTurnSound();
            Screen.delay(1);
            turn = 1 - turn;
            Screen.clear();
        }
    }
    static void startScreen() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException {
        Screen.clear();
        Sound.playMenuSound();
        String select = "";
        int ok = 1;
        ArrayList<String> functions = new ArrayList<>();
        functions.add("StartGame");
        if(!GameLoad.empty()) functions.add("Loadgame");
        functions.add("Changeboard");
        functions.add("Leaderboard");
        functions.add("Sound");
        functions.add("Exit");
        while(!Checker.checkInRange(1, functions.size(), select)){
            Screen.clear();
            System.out.print(" $$$$$$\\                            $$$$$$$\\             $$\\     $$\\     $$\\           \n");
            System.out.print("$$  __$$\\                           $$  __$$\\            $$ |    $$ |    $$ |          \n");
            System.out.print("$$ /  \\__| $$$$$$\\   $$$$$$\\        $$ |  $$ | $$$$$$\\ $$$$$$\\ $$$$$$\\   $$ | $$$$$$\\  \n");
            System.out.print("\\$$$$$$\\  $$  __$$\\  \\____$$\\       $$$$$$$\\ | \\____$$\\\\_$$  _|\\_$$  _|  $$ |$$  __$$\\ \n");
            System.out.print(" \\____$$\\ $$$$$$$$ | $$$$$$$ |      $$  __$$\\  $$$$$$$ | $$ |    $$ |    $$ |$$$$$$$$ |\n");
            System.out.print("$$\\   $$ |$$   ____|$$  __$$ |      $$ |  $$ |$$  __$$ | $$ |$$\\ $$ |$$\\ $$ |$$   ____|\n");
            System.out.print("\\$$$$$$  |\\$$$$$$$\\ \\$$$$$$$ |      $$$$$$$  |\\$$$$$$$ | \\$$$$  |\\$$$$  |$$ |\\$$$$$$$\\ \n");
            System.out.print(" \\______/  \\_______| \\_______|      \\_______/  \\_______|  \\____/  \\____/ \\__| \\_______|\n");
            if(ok == 0) System.out.println(Print.setColor("Invalid option, please choose again.", "Red"));
            int list = 2;
            System.out.println("Choose an option:");
            System.out.println(Print.setColor("1, Start a new game.", "Green"));
            if(!GameLoad.empty()) System.out.println(Print.setColor(list++ + ", Load game.", "Yellow"));
            System.out.println(Print.setColor(list++ + ", Change board size.(" + Board.Size + "x" + Board.Size + " now)", "Blue"));
            System.out.println(Print.setColor(list++ + ", Leaderboard.", "Cyan"));
            if(Sound.canPlay) System.out.println(Print.setColor(list++ + ", Turn off sound.", "Purple"));
            else System.out.println(Print.setColor(list++ +  ", Turn on sound.", "Purple"));
            System.out.println(Print.setColor(list++ +  ", Exit.", "Red"));
            select = cin.nextLine();
            Sound.onButtonMenuSound();
            ok = 0;
        }
        int choice = Integer.parseInt(select);
        switch (functions.get(choice-1)){
            case "StartGame":
                Screen.clear();
                inGame(initPlayer(), 0);
                break;
            case "Loadgame":
                GameLoad gl = new GameLoad();
                gl.load();
                break;
            case "Changeboard":
                Board tmp = new Board();
                tmp.setSize();
                startScreen();
                break;
            case "Leaderboard":
                Leaderboard.display();
                startScreen();
                break;
            case "Sound":
                if(Sound.canPlay){
                    Sound.canPlay = false;
                    Sound.stopSound();
                }
                else{
                    Sound.canPlay = true;
                    Sound.playMenuSound();
                }
                startScreen();
            case "Exit":
                Screen.clear();
                System.out.println("(┬┬﹏┬┬) see ya o(TヘTo)");
                System.exit(0);
        }
    }
}
