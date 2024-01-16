package Feature;
import Entity.*;
import Main.NewGame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class GameLoad {
    static final String slot1 = "src\\Documents\\gameslot1.txt";
    static final String slot2 = "src\\Documents\\gameslot2.txt";
    public DataStorage importPlayer(Player player){
        DataStorage ds = new DataStorage();
        ds.savedBoardSize = player.savedBoardSize;
        ds.playNow = player.playNow;
        ds.stt = player.stt;
        ds.name = player.getName();
        ds.turnCount = player.getTurnCount();
        ds.remainShip = player.getRemainShip();
        ds.isBot = player.isBot();
        ds.playWithBot = player.playWithBot;
        ds.Point = player.getPoint();
        ds.myBoard = player.myBoard.getGrid();
        ds.boardOfEnemy = player.boardOfEnemy.getGrid();
        ds.colorPrint = player.myBoard.getColorPrint();
        ds.importShips(player.myBoard.shipList);
        return ds;
    }
    public Player exportPlayer(DataStorage ds){
        Player player = new Player();
        player.setName(ds.name);
        player.playNow = ds.playNow;
        player.stt = ds.stt;
        player.savedBoardSize = ds.savedBoardSize;
        player.playWithBot = ds.playWithBot;
        player.setTurnCount(ds.turnCount);
        player.setRemainShip(ds.remainShip);
        player.setPoint(ds.Point);
        player.setBot(ds.isBot);
        player.myBoard.setBoardwithColor(ds.myBoard, ds.colorPrint);
        player.boardOfEnemy.setBoard(ds.boardOfEnemy);
        player.myBoard.addShip(ds.ships, ds.remainShip);
        return player;
    }
    public void save(Player[] ps) throws IOException {
        FileOutputStream f1 = new FileOutputStream(slot1);
        FileOutputStream f2 = new FileOutputStream(slot2);
        ObjectOutputStream oos1 = new ObjectOutputStream(f1);
        ObjectOutputStream oos2 = new ObjectOutputStream(f2);
        DataStorage ds1 = importPlayer(ps[0]);
        DataStorage ds2 = importPlayer(ps[1]);
        oos1.writeObject(ds1);
        oos2.writeObject(ds2);
        oos1.close(); oos2.close();
        f1.close(); f2.close();
    }
    public void load() throws IOException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        FileInputStream f1 = new FileInputStream(slot1);
        FileInputStream f2 = new FileInputStream(slot2);
        ObjectInputStream ois1 = new ObjectInputStream(f1);
        ObjectInputStream ois2 = new ObjectInputStream(f2);
        DataStorage ds1 = (DataStorage)ois1.readObject();
        DataStorage ds2 = (DataStorage)ois2.readObject();
        ois1.close(); ois2.close();
        f1.close(); f2.close();
        Player[] ps = new Player[2];
        Board.Size = ds1.savedBoardSize;
        if(ds1.isBot) ps[0] = new Bot(exportPlayer(ds1), ds1.ships, ds1.remainShip);
        else ps[0] = exportPlayer(ds1);
        if(ds2.isBot) ps[1] = new Bot(exportPlayer(ds2), ds2.ships, ds2.remainShip);
        else ps[1] = exportPlayer(ds2);
        NewGame.inGame(ps, ps[0].playNow + ps[1].playNow - 1);
    }
    static public void clear() throws IOException {
        FileWriter wr1 = new FileWriter(slot1);
        FileWriter wr2 = new FileWriter(slot2);
        wr1.close(); wr2.close();
    }
    static public boolean empty() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(slot1));
        return (reader.readLine() == null);
    }
}
