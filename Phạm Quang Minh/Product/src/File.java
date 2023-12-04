import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class File {
    public void printRanking(Player player, Player oppositePlayer) {
        ArrayList<Player> listPlayer = new ArrayList<>();
        read(listPlayer);
        sortPlayer(listPlayer);
        printTerminal(listPlayer, player, oppositePlayer);
    }

    private void read(ArrayList<Player> listPlayer) {
        try {
            FileReader fileReader = new FileReader("Ranking.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String name;
            while ((name = bufferedReader.readLine()) != null) {
                int shots = Integer.parseInt(bufferedReader.readLine());
                int ship = Integer.parseInt(bufferedReader.readLine());
                Player newPlayer = new Player(name, shots, ship);
                listPlayer.add(newPlayer);
            }
        } catch (IOException e) {
            System.out.println("The game hasn't any datas");
        }
    }

    public void addPlayer(Player player) {
        ArrayList<Player> listPlayer = new ArrayList<>();
        read(listPlayer);
        Player newPlayer = new Player(player.getName(), player.getNumberShot(), player.remainNumberShips());
        listPlayer.add(newPlayer);
        sortPlayer(listPlayer);
        writeFile(listPlayer);
    }

    private void sortPlayer(ArrayList<Player> listPlayer) {
        listPlayer.sort(new Comparator<Player>() {
            public int compare(Player player1, Player player2) {
                int compareByShot = Integer.compare(player1.getNumberShot(), player2.getNumberShot());
    
                if (compareByShot != 0) {
                    return compareByShot;
                } else {
                    return Integer.compare(player1.getShip(), player2.getShip());
                }
            }
        });
    }

    private void printTitle() {
        System.out.print(String.format("%17s", ""));
        System.out.println(MakeColor.reset + MakeColor.backgoundYellow + String.format("%7s", "Ranking")
                + MakeColor.reset + MakeColor.blue);
        System.out.print(String.format("%14s", "Name"));
        System.out.print(String.format("%14s", "Shot"));
        System.out.print(String.format("%14s\n", "Ship"));
    }

    private void printInformation(Player player, int index) {
        System.out.print(String.format("%-10s", index + 1));
        System.out.print(String.format("%-14s", player.getName()));
        System.out.print(String.format("%-14s", player.getNumberShot()));
        System.out.print(String.format("%-14s\n", player.getShip()));
    }

    private void printTerminal(ArrayList<Player> listPlayer, Player player, Player oppositePlayer) {
        printTitle();
        for (int i = 0; i < listPlayer.size(); i++) {
            printInformation(listPlayer.get(i), i);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Exit");
        int choice = Choice.enterChoice(1, scanner);
        MenuGame menuGame = new MenuGame();
        menuGame.menu(scanner, player, oppositePlayer);
    }

    private void writeFile(ArrayList<Player> listPlayer) {

        try {
            FileWriter fileWriter = new FileWriter("Ranking.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Player player : listPlayer) {
                bufferedWriter.write(player.getName());
                bufferedWriter.newLine();
                String numberShot = String.valueOf(player.getNumberShot());
                bufferedWriter.write(numberShot);
                bufferedWriter.newLine();
                String ship = String.valueOf(player.getShip());
                bufferedWriter.write(ship);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Erorr File");
        }
    }
}
