import java.util.Scanner;
import java.lang.Math;
public class Player{
    String Name;
    String Mode;
    int Turn = 0;
    Scanner sc = new Scanner(System.in);
    int size;
    public int[][] board_Me = new int[30][30];
    // 0: Ko có j
    // 1: Có tàu, chưa bị đánh bom (X: nền xanh)
    // 2: Có tàu, đã bị đánh bom (X: nền đỏ)
    public int[][] board_Enemy = new int[30][30]; // Ở đây là 2 ng chơi, nếu cần thêm thì tạo vector
    // 0: Ko có j
    // 1: Đã đánh bom, ko có tàu (*: BlUE)
    // 2: Đã đánh bom, có tàu (X :nền đỏ)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public void Enter_Name(){
        Name = sc.next();
    }
    public void Enter_Size(){
        size = sc.nextInt();
    }
    public void CreatNewBoard(){
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board_Me[i][j] = 0;
            }
        }
    }
    public void CreatNewBoard_Enemy(){
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board_Enemy[i][j] = 0;
            }
        }
    }

    int check_greedy = 0;
    int x_id,y_id;// SD cho Bot greedy

    public int Check_Attack(int x, int y,int i){
        Turn += 1;
        if(Main.List.get(1-i).board_Me[x][y] == 0){   // Nếu Ko có tàu
            Main.List.get(i).board_Enemy[x][y] = 1; // Đã đánh bom, Ko có tàu
        }
        else if(Main.List.get(1-i).board_Me[x][y] == 1){ // Có tàu, Chưa bị Đanh bom
            board_Enemy[x][y] = 2; // Có tàu, Bị đánh bom
            Main.List.get(1-i).board_Me[x][y] = 2; // Có tàu, Bị đánh bom
            return 1; //Nếu đánh trúng tàu thì bật mode Greedy.
        }
//        else if(Enemy[x][y] == 2){ // Có tàu, đã bị phá
//            // KHÔNG CÓ th này do đã bị phá rồi th nó sẽ hiện ơ map TMP
//        }
        return 0;
    }
    public void SeeMap() {
        System.out.println();

        System.out.print("[");
        for(int k = 1; k <= (2*size); k++) System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
        System.out.println("]");

        System.out.print("[Your Map:");
        for(int k = 10 ; k <= (2*size); k++) System.out.print(" ");
        System.out.println("]");


        for (int i = 0; i < size; i++) {
            System.out.print("[|");
            for (int j = 0; j < size; j++) {
                if (board_Me[i][j] == 0)//Ko có j
                {
                    System.out.print(" ");
                } else if (board_Me[i][j] == 1)// 1: Có tàu, chưa bị đánh bom (X: BLUE)
                {
                    System.out.print(ANSI_BLUE_BACKGROUND + "X" + ANSI_RESET);
                } else if (board_Me[i][j] == 2)// 2: Có tàu, đã bị đánh bom (X: RED)
                {
                    System.out.print(ANSI_RED_BACKGROUND + "X" + ANSI_RESET);// 2: Đã đánh bom, có tàu (X :RED)
                }
                System.out.print("|");
                if(j == size-1){
                    System.out.print("\n");
                }
            }
        }
        System.out.print("[");
        for(int k = 1; k <= (2*size); k++) System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
        System.out.println("]");
    }
//    public void SeeMap_Enemy() {
//        System.out.println();
//        for (int i = 0; i < 10; i++) {
//            System.out.print("|");
//            for(int j = 0; j < 10; j++)
//            {
//                if(board_Enemy[i][j] == 0)// 0: Ko có j
//                {
//                    System.out.print(" ");
//                }
//                else if(board_Enemy[i][j] == 1)// 1: Đã đánh bom, ko có tàu (*: BlUE)
//                {
//                    System.out.print(ANSI_BLUE + "*" + ANSI_RESET);
//                }
//                else if(board_Enemy[i][j] == 2)
//                {
//                    System.out.print(ANSI_RED + "X" + ANSI_RESET);
//                }
//                System.out.print("|");
//                if(j == 9){
//                    System.out.print("\n");
//                }
//            }
//        }
//    }
    public void SeeMap_Full(){
        System.out.println();

        System.out.print("[");
        for(int k = 1; k <= (2*(2*size -1) + 14); k++) System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
        System.out.println("]");

        System.out.print("[Your Map:");
        for(int k = 10 ; k <= (2*size - 1); k++) System.out.print(" ");
        for(int k = 1; k <= 12; k++) System.out.print(" ");
        System.out.print("Enemy's Map:");
        for(int k = 11; k <= (2*size-1); k++) System.out.print(" ");
        System.out.println("]");


        for (int i = 0; i < size; i++) {
            System.out.print("[|");
            for(int j = 0; j < size; j++)
            {
                if(board_Me[i][j] == 0)//Ko có j
                {
                    System.out.print(" ");
                }
                else if(board_Me[i][j] == 1)// 1: Có tàu, chưa bị đánh bom (X: BLUE)
                {
                    System.out.print(ANSI_BLUE_BACKGROUND + "X" + ANSI_RESET);
                }
                else if(board_Me[i][j] == 2)// 2: Có tàu, đã bị đánh bom (X: RED)
                {
                    System.out.print(ANSI_RED_BACKGROUND + "X" + ANSI_RESET);// 2: Đã đánh bom, có tàu (X :RED)
                }
                System.out.print("|");
//                if(j == 9){
//                    System.out.print("\n");
//                }
            }

            for(int k = 1; k <= 10; k++) System.out.print(" ");

            System.out.print("|");
            for(int j = 0; j < size; j++)
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
                    System.out.print(ANSI_RED_BACKGROUND + "X" + ANSI_RESET);
                }
                System.out.print("|");
                if(j == (size-1)){
                    System.out.print("]\n");
                }
            }
        }

        System.out.print("[");
        for(int k = 1; k <= (2*(2*size -1) + 14); k++) System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
        System.out.println("]");
    }
    public int Check_PatrolBoat(int i1, int j1, int i2, int j2) // enemy check com or player
    {
        if(i1 == i2 && Math.abs(j2-j1) + 1 == 2){
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
                if(board_Me[i1][j] == 1) return 0;
            }
            for(int j = Math.min(j1,j2) ; j <= Math.max(j1,j2); j++){
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
    public int Check_DestroyerBoat(int i1,int j1,int i2,int j2){
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
    public int Check_Submarine(int i1, int j1,int i2,int j2){
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
    public int Check_BattleShip(int i1,int j1, int i2,int j2){
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
