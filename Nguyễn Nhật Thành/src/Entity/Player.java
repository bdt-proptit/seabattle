package Entity;
import Feature.GameLoad;
import Tool.*;
import Feature.Sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
public class Player{
    public int savedBoardSize;
    public int playNow = 0;
    public int stt = 0;
    protected boolean isBot = false;
    public boolean playWithBot = false;
    public void setBot(boolean isBot){ this.isBot = isBot; }
    public boolean isBot(){ return isBot; }
    protected int bullet = 0;
    public Board boardOfEnemy = new Board();
    public Board myBoard = new Board();
    private int turnCount = 0, remainShip = 5;
    public void setTurnCount(int a){ turnCount = a; }
    public void setRemainShip(int a){ remainShip = a; }
    public int getTurnCount(){ return turnCount; }
    public void minusRemainShip(){ --remainShip; }
    public int getRemainShip(){ return remainShip; }
    Scanner cin = new Scanner(System.in);
    protected int Point = 0;
    public void setPoint(int a){ Point = a; }
    protected String Name = "";
    public Player(){}
    public Player(int a){
        savedBoardSize = Board.Size;
        stt = a;
        if(stt == 1) playNow = 1;
    }
    public Player(String name, int a, int b){// using to add player to leaderboard
        Name = name; turnCount = a; remainShip = b;
    }
    public void setName(){
        int ok = 1;
        int len = Name.length();
        while(len == 0 || len > 15){
            if(ok == 0) System.out.println(Print.setColor("Invalid name, please set again", "Red"));
            System.out.print("Set player " + stt + "'s name (max: 15 characters): ");
            Name = cin.nextLine();
            len = Name.length();
            ok = 0;
        }
    }
    public void setName(String name){
        Name = name;
    }
    public String getName(){ return Name; }
    public int getPoint(){ return Point; }
    public void displayBoardOfEnemy() { boardOfEnemy.display(); }
    public void displayMyBoard() { myBoard.display(); }
    public void setShip() throws InterruptedException, IOException {
        if(!playWithBot){
            System.out.println(Print.setColor(getName(), "Green") + " will set ships's positon. Other player look away.");
            Screen.countDown(3);
        }
        myBoard.setShip();
    }
    public void Shot(Player Enemy) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        playNow = stt;
        Enemy.playNow = 0;
        ++turnCount;
        GameLoad gl = new GameLoad();
        int x = -1, y = 0, cnt = 0;
        String toaDoBan = "";
        bullet = 1;
        while(bullet > 0 && Point < 5){
            gl.save(new Player[]{this, Enemy});
            displayBoardOfEnemy();
            int ok = 1;
            if(cnt > 0) System.out.printf(Print.setColor("You get 1 extra turn.\n(Type X if you want to stop shooting)\n", "Green"));
            while(!Checker.checkShotCoordinate(x, y, Enemy.myBoard.getGrid())){
                if(ok == 0) System.out.println(Print.setColor("Invalid coordinates, please type again.", "Red"));
                System.out.print("Type coordinates to shoot: ");
                toaDoBan = cin.nextLine();
                if(toaDoBan.equals("X")) return;
                if(!Checker.inputCheck(toaDoBan)) x = -1;
                else{
                    x = (int)Character.toUpperCase(toaDoBan.charAt(0)) - 'A';
                    y = Integer.parseInt(toaDoBan.substring(1)) - 1;
                }
                ok = 0;
            }
            if(Enemy.myBoard.checkShot(x, y)){
                System.out.println(Print.setColor("Hit!", "Green"));
                Sound.playShotSound(true);
                Enemy.myBoard.setCoordinate(x, y, 'X');
                boardOfEnemy.setCoordinate(x, y, 'X');
                if(Enemy.myBoard.checkDrown(boardOfEnemy.getGrid())){
                    ++Point;
                    Enemy.minusRemainShip();
                }
                ++bullet;
            }
            else{
                System.out.println(Print.setColor("Miss!", "Red"));
                Sound.playShotSound(false);
                Enemy.myBoard.setCoordinate(x, y, 'O');
                boardOfEnemy.setCoordinate(x, y, 'O');
            }
            --bullet; cnt = 1;
            Screen.delay(2);
            Screen.clear();
        }
        gl.save(new Player[]{this, Enemy});
        playNow = 0;
        Enemy.playNow = Enemy.stt;
        Screen.clear();
    }
    public boolean checkDrown(){ return myBoard.checkDrown(myBoard.getGrid()); }
}