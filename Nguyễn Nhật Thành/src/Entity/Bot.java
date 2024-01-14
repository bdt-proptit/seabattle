package Entity;
import java.util.Random;
import Tool.*;
import Feature.Sound;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Bot extends Player {
    char lastShot = ' ';
    int lastX = -1, lastY = -1;
    int[] dx = {0 ,0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    Random rand = new Random();
    public Bot(Player p, String[][] ships, int remainShip){
        Name = p.getName();
        playNow = p.playNow;
        stt = p.stt;
        savedBoardSize = p.savedBoardSize;
        isBot = true;
        myBoard.setBoardwithColor(p.myBoard.getGrid(), p.myBoard.getColorPrint());
        boardOfEnemy.setBoard(p.boardOfEnemy.getGrid());
        myBoard.addShip(ships, remainShip);
    }
    public Bot(){
        stt = 2;
        Name = "Bot";
        isBot = true;
    }
    public void setShip() throws InterruptedException, IOException {
        System.out.println(Print.setColor("Bot", "Green") + " will set ships's positon.");
        Screen.countDown(3);
        myBoard.autoSetShip(true);
    }
    public void Shot(Player Enemy) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        bullet = 1; int cnt = 0;
        while(bullet > 0 && Point < 5){
            boardOfEnemy.display();
            if(cnt > 0) System.out.println(Print.setColor("Bot get 1 extra turn.", "Red"));
            System.out.print("Bot is thinking");
            for(int i=0; i<3; ++i){
                Screen.delay(1);
                System.out.print(".");
            }
            Screen.delay(1);
            System.out.println();
            int x = lastX, y = lastY;
            if(lastShot == 'X'){
                for(int i=0; i<4; ++i){
                    int tX = x + dx[i];
                    int tY = y + dy[i];
                    if(Checker.checkShotCoordinate(tX, tY, Enemy.myBoard.getGrid())){
                        x = tX;
                        y = tY;
                        break;
                    }
                }
            }
            else{
                while(!Checker.checkShotCoordinate(x, y, Enemy.myBoard.getGrid())){
                    x = rand.nextInt(Board.Size);
                    y = rand.nextInt(Board.Size);
                }
            }
            System.out.println("Shoot coordinates: " + (char)(x + 'A') + (y+1));
            if(Enemy.myBoard.checkShot(x, y)){
                lastShot = 'X';
                System.out.println(Print.setColor("Hit!", "Green"));
                Sound.playShotSound(true);
                lastX = x; lastY = y;
                Enemy.myBoard.setCoordinate(x, y, 'X');
                boardOfEnemy.setCoordinate(x, y, 'X');
                if(Enemy.myBoard.checkDrown(boardOfEnemy.getGrid())){
                    ++Point;
                    Enemy.minusRemainShip();
                    lastShot = 'D';
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
        }
        Screen.clear();
    }
}