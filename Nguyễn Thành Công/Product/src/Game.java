import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private void setUp1(){
        String name;
        System.out.print("Nhap ten cua ban: ");
        name = sc.next();
        player1.setName(name);
        int x,y;
        Position position = new Position();
        String orientation;
        while (true){
            System.out.print("Chon toa do cua thuyen tuan tra 1: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionPB1(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 1 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player1.setOrientationPB1(orientation)) break;
        }
        while(true) {
            System.out.print("Chon toa do cua thuyen tuan tra 2: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionPB2(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 2 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player1.setOrientationPB2(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua tau khu truc: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionDB(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua tau khu truc (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player1.setOrientationDB(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua tau ngam: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionSM(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua tau ngam (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player1.setOrientationSM(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua thiet giap ham: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player1.setPositionBS(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua thiet giap ham (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player1.setOrientationBS(orientation)) break;
        }
    }
    private void setUp2(){
        String name;
        System.out.print("Nhap ten cua ban: ");
        name = sc.next();
        player2.setName(name);
        int x,y;
        Position position = new Position();
        String orientation;
        while (true){
            System.out.print("Chon toa do cua thuyen tuan tra 1: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionPB1(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 1 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player2.setOrientationPB1(orientation)) break;
        }
        while(true) {
            System.out.print("Chon toa do cua thuyen tuan tra 2: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionPB2(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua thuyen tuan tra 2 (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player2.setOrientationPB2(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua tau khu truc: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionDB(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua tau khu truc (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player2.setOrientationDB(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua tau ngam: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionSM(position)) break;
        }
        while(true) {
            System.out.print("Chon huong cua tau ngam (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player2.setOrientationSM(orientation)) break;
        }
        while (true) {
            System.out.print("Chon toa do cua thiet giap ham: ");
            x = sc.nextInt();
            y = sc.nextInt();
            position.setX(x);
            position.setY(y);
            if (player2.setPositionBS(position)) break;
        }
        while (true) {
            System.out.print("Chon huong cua thiet giap ham (NORTH, SOUTH, EAST, WEST): ");
            orientation = sc.next();
            if (player2.setOrientationBS(orientation)) break;
        }
    }
    private void turn1(){
        player1.displayUC();
        player2.displayC();
        System.out.print("Chon toa do ban muon tan cong: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        if (!player1.attack(position)) System.out.println("xit roi");
        else System.out.println("trung roi");
    }
    private void turn2(){
        player2.displayUC();
        player1.displayC();
        System.out.print("Chon toa do ban muon tan cong: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        if (!player2.attack(position)) System.out.println("xit roi");
        else System.out.println("trung roi");
    }
    public boolean checkGameOver(){
        return player1.gameOver()|| player2.gameOver();
    }
    public void endGame(){
        System.out.println("Winner");
    }
    public void startGame(){
        setUp1();
        setUp2();
        int turn=1;
        while (true){
            if (turn == 1){
                turn1();
                turn = 2;
            }
            else {
                turn2();
                turn =1;
            }
            if (checkGameOver()) {
                endGame();
                break;
            }
        }
    }
}
