package Feature;
import java.io.*;
import java.util.*;
import Tool.*;
import Entity.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Leaderboard {
    static Scanner cin = new Scanner(System.in);
    static class sortCompare implements Comparator<Player> {
        public int compare(Player A, Player B){
            if(A.getTurnCount() == B.getTurnCount()){
                if(A.getRemainShip() == B.getRemainShip()) return A.getName().compareTo(B.getName());
                return B.getRemainShip() - A.getRemainShip();
            }
            return A.getTurnCount() - B.getTurnCount();
        }
    }
    static final String fileLocation = "src\\Documents\\rank_list.txt";
    static private void getDatafromFile(List<Player> list) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String line;
        while((line = reader.readLine()) != null){
            String[] tmp = line.split(" ", 0);
            System.out.println();
            list.add(new Player(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
        reader.close();
    }
    static public void addPlayer(Player player) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
        writer.write(player.getName() + " " + player.getTurnCount() + " " + player.getRemainShip() + "\n");
        writer.close();
        List<Player> list = new ArrayList<>();
        getDatafromFile(list);
        Collections.sort(list, new sortCompare());
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(fileLocation));
        for(int i=0; i<Integer.min(list.size(), 5); ++i) writer1.write(list.get(i).getName() + " " + list.get(i).getTurnCount() + " " + list.get(i).getRemainShip() + "\n");
        writer1.close();
    }
    static public void clear() throws IOException {
        BufferedWriter clear = new BufferedWriter(new FileWriter(fileLocation));
        clear.close();
    }
    static public void display() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        Screen.clear();
        if(checkEmpty()) System.out.println("Leaderboard is empty now.");
        else{
            List<Player> list = new ArrayList<>();
            getDatafromFile(list);
            int n = list.size();
            List<String> content = new ArrayList<>();
            for(int i=1; i<=n; ++i){
                content.add(Integer.toString(i));
                content.add(list.get(i-1).getName());
                content.add(Integer.toString(list.get(i-1).getTurnCount()));
                content.add(Integer.toString(list.get(i-1).getRemainShip()));
            }
            List<String> title = new ArrayList<>();
            title.add("Rank");
            title.add("Player's Name");
            title.add("Turns to win");
            title.add("Remained ships");
            Table.numberOfColumn = 4;
            int[] columnSize = {6, 17, 15, 15};
            Table.draw(title, content, columnSize);
        }
        System.out.println("Press any key to get back.");
        String end = cin.nextLine();
        Sound.onButtonMenuSound();
    }
    static public boolean checkEmpty() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        return (reader.readLine() == null);
    }
}
