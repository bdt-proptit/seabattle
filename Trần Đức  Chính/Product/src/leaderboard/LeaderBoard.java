package leaderboard;

import model.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LeaderBoard {
    private final File file = new File("src/leaderboard/leaderboard.txt");
    public List<Player> playerScoreList = new ArrayList<>();

//    public void createPlayerScoreList(List<model.Player> playerScoreList) {
//        playerScoreList.sort(new Comparator<model.Player>() {
//            @Override
//            public int compare(model.Player player1, model.Player player2) {
//                if (player1.getShipRemaining() == player2.getShipRemaining()) {
//                    if (player1.getHit() == player2.getHit()) {
//                        return player1.getName().compareTo(player2.getName());
//                    }
//                    return player1.getHit() > player2.getHit() ? 1 : -1;
//                }
//                return player1.getShipRemaining() < player2.getShipRemaining() ? 1 : -1;
//            }
//        });
//
//        try {
//            PrintWriter writer = new PrintWriter("src/leaderboard.txt", StandardCharsets.UTF_8);
//            for (model.Player player : playerScoreList) {
//                writer.println(player.getName() + " " + player.getShipRemaining() + " " + player.getHit());
//            }
//            writer.flush();
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void printInfoToLeaderBoard(Player player) {
        try {
            FileWriter fileWriter = new FileWriter("src/leaderboard/leaderboard.txt" , StandardCharsets.UTF_8, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(player.getName() + "," + player.getShipRemaining() + "," + player.getHit() + "\n");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showLeaderBoard() {

        List<String> allText = null;
        try {
            Path path = Path.of(file.getAbsolutePath());
//            BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//            System.out.println(path);
            allText = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String line : allText) {
            String[] info = line.split(",");
            playerScoreList.add(new Player(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2])));
        }
        playerScoreList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                if (player1.getShipRemaining() == player2.getShipRemaining()) {
                    if (player1.getHit() == player2.getHit()) {
                        return player1.getName().compareToIgnoreCase(player2.getName());
                    }
                    return player1.getHit() > player2.getHit() ? 1 : -1;
                }
                return player1.getShipRemaining() < player2.getShipRemaining() ? 1 : -1;
            }
        });
        System.out.println("\nBảng xếp hạng:");
        int cnt = 1;
        System.out.printf("%-10s%-25s%-25s%-25s\n", "Rank", "Tên người chơi", "Số thuyền còn lại", "Số lần bắn");
        for (Player player1 : playerScoreList) {
            if (cnt == 5) break;// chỉ hiển thị 5 người đầu tiên
            System.out.printf("%-10d%-25s%-25d%-25d\n", cnt, player1.getName(), player1.getShipRemaining(), player1.getHit());
            cnt++;
        }
    }

    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard();
        System.out.println(leaderBoard.file.getAbsolutePath());
    }
}
