package Entity;
import Feature.*;
import Tool.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.*;

public class Board {
    Scanner cin = new Scanner(System.in);
    static public int Size = 10;
    public void setSize() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int ok = 1;
        Size = 1;
        String input = "";
        while(!Checker.checkInRange(10, 20, input)){
            if(ok == 0) System.out.println(Print.setColor("Size is invalid, please set again.", "Red"));
            System.out.println("Set the board size(10 - 20): ");
            input = cin.nextLine();
            ok = 0;
        }
        Sound.onButtonMenuSound();
        Size = Integer.parseInt(input);
        System.out.println("Board size is " + Size + "x" + Size + " now.");
        System.out.println("Press any key to get back.");
        String back = cin.nextLine();
    }
    private char[][] grid = new char[20][20];
    private String[][] colorPrint = new String[20][20];
    public ArrayList<Ship> shipList = new ArrayList<>();
    public void addShip(String[][] ls, int remain){
        shipList.clear();
        for(int i=0; i<remain; ++i){
            shipList.add(new Ship(ls[i][0], ls[i][1], ls[i][2], ls[i][3], ls[i][4], ls[i][5]));
        }
    }
    public char[][] getGrid(){ return grid; }
    public void setBoardwithColor(char[][] grid, String[][] color){
        for(int i=0; i<Size; ++i){
            for(int j=0; j<Size; ++j){
                this.grid[i][j] = grid[i][j];
                colorPrint[i][j] = color[i][j];
            }
        }
    }
    public void setBoard(char[][] grid){
        for(int i=0; i<Size; ++i){
            for(int j=0; j<Size; ++j){
                this.grid[i][j] = grid[i][j];
                if(grid[i][j] == 'X' || grid[i][j] == 'D') colorPrint[i][j] = "Red";
                else colorPrint[i][j] = "White";
            }
        }
    }
    public String[][] getColorPrint(){ return colorPrint; }
    public Board(){
        for(int i=0; i<Size; ++i){
            for(int j=0; j<Size; ++j){
                grid[i][j] = ' ';
                colorPrint[i][j] = Print.getColor("White");
            }
        }
        shipList.add(new Ship("Patrol Boat", 2, "Green"));
        shipList.add(new Ship("Patrol Boat", 2, "Green"));
        shipList.add(new Ship("Submarine", 3, "Cyan"));
        shipList.add(new Ship("Destroyer Boat", 4, "Yellow"));
        shipList.add(new Ship("Battle Ship", 5, "Purple"));
    }
    void setCoordinate(int x, int y, char a){
        grid[x][y] = a;
        if(a == 'X') colorPrint[x][y] = "Red";
        else colorPrint[x][y] = "White";
    }
    public void display(){
        char st = 'A';
        String kc = "   ";
        for(int i=1; i<=Size; ++i){
            System.out.print(kc + i);
            kc = "  ";
            if(i > 8) kc = " ";
        }
        System.out.println();
        for(int i=0; i<Size; ++i){
            System.out.print(st++ + " [");
            for(int j=0; j<Size; ++j){
                System.out.print(Print.setColor(grid[i][j] + "", colorPrint[i][j]) + "]");
                if(j < Size-1) System.out.print("[");
            }
            System.out.println();
        }
    }
    void setShipCharacter(int x1, int y1, int x2, int y2, Ship ship){
        if(x1 == x2){
            for(int i=Integer.min(y1, y2); i<=Integer.max(y1, y2); ++i){
                grid[x1][i] = 'S';
                colorPrint[x1][i] = ship.getShipColor();
            }
        }
        else {
            for(int i = Integer.min(x1, x2); i <= Integer.max(x1, x2); ++i){
                grid[i][y1] = 'S';
                colorPrint[i][y1] = ship.getShipColor();
            }
        }
    }
    public void manualSetShip() throws InterruptedException, IOException {
        display();
        for(var x : shipList){
            int x1 = -1, y1 = 0, x2 = 0, y2 = 0, ok = 1;
            String toaDoDau = "", toaDoCuoi = "";
            while(!Checker.check2coordinate(x1, y1, x2, y2, getGrid(), x.getShipLength())){
                if(ok == 0) System.out.println(Print.setColor("Invalid coordinates, please type again.", "Red"));
                System.out.println("Type start and end coordinates of " + x.getShipName() + "(length: " + x.getShipLength() + ")" + ": ");
                toaDoDau = cin.nextLine();
                toaDoCuoi = cin.nextLine();
                if(!Checker.inputCheck(toaDoDau) || !Checker.inputCheck(toaDoCuoi)){
                    x1 = -1;
                }
                else{
                    x1 = (int)Character.toUpperCase(toaDoDau.charAt(0)) - 'A';
                    y1 = Integer.parseInt(toaDoDau.substring(1)) - 1;
                    x2 = (int)Character.toUpperCase(toaDoCuoi.charAt(0)) - 'A';
                    y2 = Integer.parseInt(toaDoCuoi.substring(1)) - 1;
                }
                ok = 0;
            }
            x.setCoordinates(x1, y1, x2, y2);
            setShipCharacter(x1, y1, x2, y2, x);
            display();
        }
        Screen.delay(2);
        Screen.clear();
    }
    public void autoSetShip(boolean isBot) throws InterruptedException, IOException {
        Random rand = new Random();
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        for(var ship : shipList) {
            int ok = 0;
            while (ok == 0) {
                ok = 1;
                x1 = rand.nextInt(Board.Size); y1 = rand.nextInt(Board.Size);
                int way = rand.nextInt(2);
                if (way == 1) {
                    x2 = x1; y2 = y1 + ship.getShipLength() - 1;
                }
                else{
                    y2 = y1; x2 = x1 + ship.getShipLength() - 1;
                }
                if(!Checker.check2coordinate(x1, y1, x2, y2, grid, ship.getShipLength())) ok = 0;
            }
            ship.setCoordinates(x1, y1, x2, y2);
            setShipCharacter(x1, y1, x2, y2, ship);
        }
        if(!isBot) display();
        Screen.delay(2);
        Screen.clear();
    }
    public void setShip() throws InterruptedException, IOException {
        System.out.println("Choose setting option:");
        System.out.println("1, Manual");
        System.out.println("2, Auto");
        String input = "9999999997";
        int ok = 1;
        while(!Checker.checkInRange(1, 2, input)){
            if(ok == 0) System.out.println(Print.setColor("Invalid input, please type again", "Red"));
            input = cin.nextLine();
            ok = 0;
        }
        if(input.equals("1")) manualSetShip();
        else autoSetShip(false);
    }
    boolean checkShot(int x, int y){
        return grid[x][y] == 'S';
    }
    boolean checkDrown(char[][] chim){
        for(int i=0; i<shipList.size(); ++i){
            shipList.get(i).checkDrown(grid);
            if(shipList.get(i).getDrown()){
                System.out.println("Defeated " + shipList.get(i).getShipName());
                shipList.get(i).setDrown(chim);
                shipList.get(i).setDrown(grid);
                shipList.remove(i);
                return true;
            }
        }
        return false;
    }
}
