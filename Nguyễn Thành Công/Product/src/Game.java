import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.transform.sax.SAXSource;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Scanner sc = new Scanner(System.in);
    private Player player1 = new Player();
    private Player player2 = new Player();
    private void setUp1(){
        player1.setUpGameBoard();

        int x,y;
        Position position = new Position();
        String orientation;

        while (true){
            Graphic.clrscr();
            Display.title();
            System.out.println(player1.getName()+" hay dat tau tuan tra 1");
            player1.displayUnVeil();

            System.out.print("Chon toa do cua thuyen tuan tra 1: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionPB1(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 1 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player1.setOrientationPB1(orientation)) break;
        }
        while(true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player1.getName()+" hay dat tau tuan tra 2");
            player1.displayUnVeil();

            System.out.print("Chon toa do cua thuyen tuan tra 2: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionPB2(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 2 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player1.setOrientationPB2(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player1.getName()+" hay dat tau khu truc");
            player1.displayUnVeil();

            System.out.print("Chon toa do cua tau khu truc: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionDB(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua tau khu truc (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player1.setOrientationDB(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player1.getName()+" hay dat tau ngam");
            player1.displayUnVeil();

            System.out.print("Chon toa do cua tau ngam: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionSM(position)) break;
        }
        while(true) {

            System.out.print("Chon huong cua tau ngam (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player1.setOrientationSM(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player1.getName()+" hay dat thiet giap ham");
            player1.displayUnVeil();

            System.out.print("Chon toa do cua thiet giap ham: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionBS(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua thiet giap ham (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player1.setOrientationBS(orientation)) break;
        }
        Graphic.clrscr();
        Display.title();
        System.out.println("BANG CUA BAN");
        player1.displayUnVeil();
        System.out.print("Nhan Enter de tiep tuc");
        sc.nextLine();
    }
    private void setUp2(){
        player2.setUpGameBoard();

        int x,y;
        Position position = new Position();
        String orientation;
        while (true){
            Graphic.clrscr();
            Display.title();
            System.out.println(player2.getName()+" hay dat tau tuan tra 1");
            player2.displayUnVeil();

            System.out.print("Chon toa do cua thuyen tuan tra 1: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionPB1(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 1 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player2.setOrientationPB1(orientation)) break;
        }
        while(true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player2.getName()+" hay dat tau tuan tra 2");
            player2.displayUnVeil();

            System.out.print("Chon toa do cua thuyen tuan tra 2: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionPB2(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 2 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player2.setOrientationPB2(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player2.getName()+" hay dat tau khu truc");
            player2.displayUnVeil();

            System.out.print("Chon toa do cua tau khu truc: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionDB(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua tau khu truc (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player2.setOrientationDB(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player2.getName()+" hay dat tau ngam");
            player2.displayUnVeil();

            System.out.print("Chon toa do cua tau ngam: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionSM(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua tau ngam (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player2.setOrientationSM(orientation)) break;
        }
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.println(player2.getName()+" hay dat thiet giap ham");
            player2.displayUnVeil();

            System.out.print("Chon toa do cua thiet giap ham: ");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionBS(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua thiet giap ham (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.nextLine();
            if (player2.setOrientationBS(orientation)) break;
        }
        Graphic.clrscr();
        Display.title();
        System.out.println("BANG CUA BAN");
        player2.displayUnVeil();
        System.out.print("Nhan Enter de tiep tuc");
        sc.nextLine();
    }
    private boolean turn1(){
        System.out.println("---------------BANG CUA BAN---------------");
        player1.displayUnVeil();
        System.out.println("-------------BANG CUA DOI THU-------------");
        player2.displayVeil();
        System.out.print("Chon toa do ban muon tan cong: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        return player1.attack(player2, position);
    }
    private boolean turn2(){
        System.out.println("---------------BANG CUA BAN---------------");
        player2.displayUnVeil();
        System.out.println("-------------BANG CUA DOI THU-------------");
        player1.displayVeil();
        System.out.print("Chon toa do ban muon tan cong: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        return player2.attack(player1, position);
    }
    private boolean checkGameOver(){
        return player1.gameOver()|| player2.gameOver();
    }
    public void endGame(String winner){
        System.out.println(winner + " da gianh chien thang");
    }
    private void humanSetUp(){
        setUp1();
        setUp2();
    }
    private void AISetUP(){
        player1.AISetUp();
        player2.AISetUp();
    }
    public String startGame(int mode){
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.print("Kich thuoc cua bang: ");
            int size = sc.nextInt();
            sc.nextLine();
            if (player1.setSizeOfBoard(size)&&player2.setSizeOfBoard(size)){
                break;
            }
            System.out.print("Kich thuoc ban do nam trong khoang 10 den 20");
            sc.nextLine();
        }

        String name;
        System.out.print("Nhap ten cua nguoi choi 1: ");
        name = sc.nextLine();
        player1.setName(name);

        System.out.print("Nhap ten cua nguoi choi 2: ");
        name = sc.nextLine();
        player2.setName(name);
        
        if (mode == 1) humanSetUp();
        else {
            Graphic.clrscr();
            Display.title();
            System.out.println("May dang dat tau ngau nhien...");
            Wait.wait(2);
            AISetUP();
        }

        int turn=1;
        while (true){
            if (turn == 1){
                Graphic.clrscr();
                Display.title();
                System.out.println("Den luot cua "+player1.getName());
                if (!turn1()) turn = 2;
                Graphic.clrscr();
                Display.title();
                System.out.println("---------------BANG CUA BAN---------------");
                player1.displayUnVeil();
                System.out.println("-------------BANG CUA DOI THU-------------");
                player2.displayVeil();
                if (turn == 2){
                    System.out.println("Ket thuc luot cua ban");
                    System.out.print("Nhan Enter de tiep tuc");
                    sc.nextLine();
                }
            }
            else {
                Graphic.clrscr();
                Display.title();
                System.out.println("Den luot cua "+player2.getName());
                if (!turn2()) turn = 1;
                Graphic.clrscr();
                Display.title();
                System.out.println("---------------BANG CUA BAN---------------");
                player2.displayUnVeil();
                System.out.println("-------------BANG CUA DOI THU-------------");
                player1.displayVeil();
                if (turn == 1){
                    System.out.println("Ket thuc luot cua ban");
                    System.out.print("Nhan Enter de tiep tuc");
                    sc.nextLine();
                }
            }
            if (checkGameOver()) break;
        }
        if (player2.gameOver()) return player1.getName();
        return player2.getName();
    }
    private boolean AITurn(){
        int x=0;
        int y=0;
        Board AISeeBoard = player1.getGameBoard();
        Position position = new Position();
        for (int i=1;i<=player2.getSizeOfBoard();i++){
            for (int j=1;j<=player2.getSizeOfBoard();j++){
                Position ps = new Position();
                ps.setX(i);
                ps.setY(j);
                if (AISeeBoard.isAttack(ps))
                {
                    if(i>1){
                        ps.setX(i-1);
                        if (!AISeeBoard.isSeen(ps)){
                            x=i-1;
                            y=j;
                            break;
                        }
                    }
                    ps.setX(i);
                    if (j>1){
                        ps.setY(j-1);
                        if (!AISeeBoard.isSeen(ps)){
                            x=i;
                            y=j-1;
                            break;
                        }
                    }
                    ps.setY(j);
                    if (i<player2.getSizeOfBoard()){
                        ps.setX(i+1);
                        if (!AISeeBoard.isSeen(ps)){
                            x=i+1;
                            y=j;
                            break;
                        }
                    }
                    ps.setX(i);
                    if (j< player2.getSizeOfBoard()){
                        ps.setY(j+1);
                        if (!AISeeBoard.isSeen(ps)){
                            x=i;
                            y=j+1;
                            break;
                        }
                    }
                }
            }
            if (x!=0&&y!=0) break;
        }
        if (x==0&&y==0) {
            do {
                x = ThreadLocalRandom.current().nextInt(1, player2.getSizeOfBoard() + 1);
                y = ThreadLocalRandom.current().nextInt(1, player2.getSizeOfBoard() + 1);
                position.setX(x);
                position.setY(y);
            } while (AISeeBoard.isSeen(position));
        }
        else {
            position.setX(x);
            position.setY(y);
        }
        return player2.attack(player1, position);
    }
    public String PlayWithAI(){
        while (true) {
            Graphic.clrscr();
            Display.title();
            System.out.print("Kich thuoc cua bang: ");
            int size = sc.nextInt();
            sc.nextLine();
            if (player1.setSizeOfBoard(size)&&player2.setSizeOfBoard(size)){
                break;
            }
            System.out.print("Kich thuoc ban do nam trong khoang 10 den 20");
            sc.nextLine();
        }

        String name;
        System.out.print("Nhap ten cua ban: ");
        name = sc.nextLine();
        player1.setName(name);
        player2.setName("May");

        setUp1();

        Graphic.clrscr();
        Display.title();
        System.out.println("May dang dat tau...");
        Wait.wait(2);
        player2.AISetUp();

        int turn=1;

        while (true){
            if (turn == 1){
                Graphic.clrscr();
                Display.title();
                System.out.println("Den luot cua "+player1.getName());
                if (!turn1()) turn = 2;
                Graphic.clrscr();
                Display.title();
                System.out.println("---------------BANG CUA BAN---------------");
                player1.displayUnVeil();
                System.out.println("-------------BANG CUA DOI THU-------------");
                player2.displayVeil();
                if (turn == 2) {
                    System.out.println("Ket thuc luot cua ban");
                    System.out.print("Nhan Enter de tiep tuc");
                    sc.nextLine();
                }
            }
            else {
                Graphic.clrscr();
                Display.title();
                System.out.println("---------------BANG CUA BAN---------------");
                player1.displayUnVeil();
                System.out.println("-------------BANG CUA DOI THU-------------");
                player2.displayVeil();
                System.out.println("May dang tan cong...");
                Wait.wait(2);
                if (!AITurn()) turn = 1;
                Wait.wait(2);
            }
            if (checkGameOver()) break;
        }
        if (player1.gameOver()) return player2.getName();
        return player1.getName();
    }
}
