import java.util.Scanner;
import java.lang.Math;
public class Player{
    Scanner sc = new Scanner(System.in);
    public int[][] board_Me = new int[15][15];
    // 0: Ko có j
    // 1: Có tàu, chưa bị đánh bom (X: BLUE)
    // 2: Có tàu, đã bị đánh bom (X: RED)
    public int[][] board_Enemy = new int[15][15]; // Ở đây là 2 ng chơi, nếu cần thêm thì tạo vector
    // 0: Ko có j
    // 1: Đã đánh bom, ko có tàu (*: BlUE)
    // 2: Đã đánh bom, có tàu (X :RED)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public void CreatNewBoard(){
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board_Me[i][j] = 1;
            }
        }
    }
    public void CreatNewBoard_Enemy(){
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board_Enemy[i][j] = 0;
            }
        }
    }
    public void Attack(int x, int y,int i){
        if(Main.List.get(1-i).board_Me[x][y] == 0){   // Nếu Ko có tàu
            board_Enemy[x][y] = 1; // Đã đánh bom, Ko có tàu
        }
        else if(Main.List.get(1-i).board_Me[x][y] == 1){ // Có tàu, Chưa bị Đanh bom
            board_Enemy[x][y] = 2; // Có tàu, Bị đánh bom
            Main.List.get(1-i).board_Me[x][y] = 2; // Có tàu, Bị đánh bom
        }
//        else if(Enemy[x][y] == 2){ // Có tàu, đã bị phá
//            // KHÔNG CÓ th này do đã bị phá rồi th nó sẽ hiện ơ map TMP
//        }
    }
    public void SeeMap() {
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for(int j = 0; j < 10; j++)
            {
                if(board_Me[i][j] == 0)//Ko có j
                {
                    System.out.print(" ");
                }
                else if(board_Me[i][j] == 1)// 1: Có tàu, chưa bị đánh bom (X: BLUE)
                {
                    System.out.print(ANSI_BLUE + "X" + ANSI_RESET);
                }
                else if(board_Me[i][j] == 2)// 2: Có tàu, đã bị đánh bom (X: RED)
                {
                    System.out.print(ANSI_RED + "X" + ANSI_RESET);// 2: Đã đánh bom, có tàu (X :RED)
                }
                System.out.print("|");
                if(j == 9){
                    System.out.print("\n");
                }
            }
        }
    }
    public void SeeMap_Enemy() {
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for(int j = 0; j < 10; j++)
            {
                if(board_Enemy[i][j] == 0)// 0: Ko có j
                {
                    System.out.print(" ");
                }
                else if(board_Enemy[i][j] == 1)// 1: Đã đánh bom, ko có tàu (*: BlUE)
                {
                    System.out.print(ANSI_BLUE + "*" + ANSI_RESET);
                }
                else if(board_Enemy[i][j] == 2)
                {
                    System.out.print(ANSI_RED + "X" + ANSI_RESET);
                }
                System.out.print("|");
                if(j == 9){
                    System.out.print("\n");
                }
            }
        }
    }

    public int Add_PatrolBoat(){
        System.out.print("Set New Patrol Boat(1x2):  ");
        System.out.print("\ni1: ");
        int i1 = sc.nextInt();
        System.out.print("\nj1: ");
        int j1 = sc.nextInt();
        System.out.print("\ni2: ");
        int i2 = sc.nextInt();
        System.out.print("\nj2: ");
        int j2 = sc.nextInt();
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 2){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                // System.out.println("nhapo");
                if(board_Me[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
               // System.out.println("nhapo");
                board_Me[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 2) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(board_Me[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                board_Me[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    public int Add_DestroyerBoat(){
        System.out.print("Set New Destroyer Boat(1x4): ");
        System.out.print("\ni1: ");
        int i1 = sc.nextInt();
        System.out.print("\nj1: ");
        int j1 = sc.nextInt();
        System.out.print("\ni2: ");
        int i2 = sc.nextInt();
        System.out.print("\nj2: ");
        int j2 = sc.nextInt();
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 4){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(board_Me[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                board_Me[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 4) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(board_Me[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                board_Me[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    public int Add_Submarine(){
        System.out.print("Set New Submarine(1x3): ");
        System.out.print("\ni1: ");
        int i1 = sc.nextInt();
        System.out.print("\nj1: ");
        int j1 = sc.nextInt();
        System.out.print("\ni2: ");
        int i2 = sc.nextInt();
        System.out.print("\nj2: ");
        int j2 = sc.nextInt();
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 3){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(board_Me[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                board_Me[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 3) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(board_Me[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                board_Me[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
    public int Add_BattleShip(){
        System.out.print("Set New Battle Ship(1x5): ");
        System.out.print("\ni1: ");
        int i1 = sc.nextInt();
        System.out.print("\nj1: ");
        int j1 = sc.nextInt();
        System.out.print("\ni2: ");
        int i2 = sc.nextInt();
        System.out.print("\nj2: ");
        int j2 = sc.nextInt();
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 5){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(board_Me[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                //System.out.println("nhapo");
                board_Me[i1][j] = 1;
            }
            return 1;
        }
        else if(j1 == j2 && Math.abs(i2-i1) + 1 == 5) {
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                if(board_Me[i][j1] == 1) return 0;
            }
            for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
                board_Me[i][j1] = 1;
            }
            return 1;
        }
        return 0;
    }
}
