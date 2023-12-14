package Thuyen;
import java.lang.Math;
public class Boards {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static char[][] createBoard(char water){
        char[][] gameBoard = new char[15][15];
        for(int i=1;i<=10;i++){
            gameBoard[0][i]=(char)(48+i);
            gameBoard[i][0]= (char) (65+i-1);
        }
        gameBoard[0][10]='1';
        gameBoard[0][11]='0';
        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++)
                gameBoard[i][j]=water;
        }
        return gameBoard;
    }
    public static String up(String coorDinate, int length){//lấy tọa độ cuối ở hướng Bắc
        char [] toaDo = coorDinate.toCharArray();
        toaDo[0]-=(length-1);
        String str = toaDo[0] + Character.toString(toaDo[1]);
        if(toaDo.length==3) str+=Character.toString('0');
        return str;
    }
    public static String down(String coorDinate, int length){//lấy tọa độ cuối ở hướng Nam
        char [] toaDo = coorDinate.toCharArray();
        toaDo[0]+=(length-1);
        String str = toaDo[0] + Character.toString(toaDo[1]);
        if(toaDo.length==3) str+=Character.toString('0');
        return str;
    }
    public static String left(String coorDinate, int length){//lấy tọa độ cuối ở hướng Tây
        int coll = col(coorDinate);
        coll-=(length-1);
        char [] toaDo = coorDinate.toCharArray();
        String str="";
        if(coll>=1&&coll<=9) {
            toaDo[1] = (char) (coll+48);
            str = toaDo[0] + Character.toString(toaDo[1]);
        }
        return str;
    }
    public static String right(String coorDinate, int length){//lấy tọa độ cuối ở hướng Đông
        int coll = col(coorDinate);
        coll+=(length-1);
        char [] toaDo = coorDinate.toCharArray();
        String str="";
        if(coll>=1&&coll<=9) {
            toaDo[1] = (char)(coll+48);
            str = toaDo[0] + Character.toString(toaDo[1]);
        }
        else if(coll==10){
            str = toaDo[0] + Character.toString('1') + '0';
        }
        return str;
    }
    public static Boolean checkPoint(String coorDinate){//Kiểm tra điểm có tồn tại và nằm trên bảng không
        char [] toaDo = coorDinate.toCharArray();
        return (toaDo.length == 2 && toaDo[0] <= 'J' && toaDo[0] >= 'A' && toaDo[1] <= '9' && toaDo[1] >= '1') ||
                (toaDo.length == 3 && toaDo[0] <= 'J' && toaDo[0] >= 'A' && toaDo[1] == '1' && toaDo[2] == '0');
    }
    public static Boolean checkPoint1(char[][] fog, String coorDinate){//Kiểm tra điểm đó đã bị bắn chưa
        if(checkPoint(coorDinate)){
            int roww = row(coorDinate);
            int coll = col(coorDinate);
            return fog[roww][coll] == '~';
        }
        return false;
    }
    public static int row(String coorDinate){//chuyển tọa độ hàng về kiểu int
        char [] toaDo = coorDinate.toCharArray();
        return toaDo[0]-65+1;
    }
    public static int col(String coorDinate){//chuyển tọa độ cột về kiểu int
        char [] toaDo = coorDinate.toCharArray();
        int a;
        if(toaDo.length==3) a=10;
        else a = toaDo[1]-48;
        return a;
    }
    public static Boolean checkSetShip(Ship ship, char[][] board, String coorDinate1, String coorDinate2){//Kiểm tra có đặt được thuyền tại tọa độ đó không
        char [] toaDo1 = coorDinate1.toCharArray();
        char [] toaDo2 = coorDinate2.toCharArray();
        if(checkPoint(coorDinate1)&&checkPoint(coorDinate2)){
            if (toaDo1[0] == toaDo2[0]) {
                int length, t1, t2;
                if(toaDo1.length==3) t1=10;
                else t1=toaDo1[1]-48;
                if(toaDo2.length==3) t2=10;
                else t2=toaDo2[1]-48;
                length = Math.abs(t2-t1)+1;
                if (length == ship.getLengthShip()){
                    int a = row(coorDinate1);
                    int b = col(coorDinate1);
                    int c = col(coorDinate2);
                    if(c<b){
                        int temp=b;
                        b=c;
                        c=temp;
                    }
                    for(int i=b;i<=c;i++){
                        if(board[a][i]!='~')
                            return false;
                    }
                    return true;
                }
                else return false;
            } else if (toaDo1[1] == toaDo2[1]&& toaDo1.length==toaDo2.length) {
                int length = Math.abs(toaDo1[0] - toaDo2[0])+1;
                if (length == ship.getLengthShip()){
                    int a = col(coorDinate1);
                    int b = row(coorDinate1);
                    int c = row(coorDinate2);
                    if(c<b){
                        int temp=b;
                        b=c;
                        c=temp;
                    }
                    for(int i=b;i<=c;i++){
                        if(board[i][a]!='~')
                            return false;
                    }
                    return true;
                }
                else return false;
            } else return false;
        }
        else return false;
    }
    public static void setShip(char[][] board, String coorDinate1, String coorDinate2) {//đặt thuyền
        char[] toaDo1 = coorDinate1.toCharArray();
        char[] toaDo2 = coorDinate2.toCharArray();
        if (toaDo1[0] == toaDo2[0]) {
            int a = row(coorDinate1);
            int b = col(coorDinate1);
            int c = col(coorDinate2);
            if (c < b) {
                int temp = b;
                b = c;
                c = temp;
            }
            for (int i = b; i <= c; i++) {
                board[a][i] = 'S';
            }
        } else if (toaDo1[1] == toaDo2[1] && toaDo1.length == toaDo2.length) {
            int a = col(coorDinate1);
            int b = row(coorDinate1);
            int c = row(coorDinate2);
            if (c < b) {
                int temp = b;
                b = c;
                c = temp;
            }
            for (int i = b; i <= c; i++) {
                board[i][a] = 'S';
            }
        }
    }
    public static Boolean checkShoot(String coorDinate, Player player, Player enermy){//kiểm tra điểm đó đã bắn chưa và có trúng không
        int roww = row(coorDinate);
        int coll = col(coorDinate);
        return enermy.getBoard()[roww][coll] == 'S' && player.getFog()[roww][coll] == '~';
    }
    public static void shoot(String coorDinate, Player player, Player enermy){//bắn
        int roww = row(coorDinate);
        int coll = col(coorDinate);
        if(enermy.getBoard()[roww][coll]=='~'&&player.getFog()[roww][coll]=='~'){
            System.out.println("Khong trung!");
            player.setFog(roww, coll, 'O');
            showBoard(player.getFog());
        }
        else if (enermy.getBoard()[roww][coll]=='S'&&player.getFog()[roww][coll]=='~'){
            System.out.println("Trung!");
            for (int i=1;i<=5;i++) {
                enermy.getShip()[i].testShot(coorDinate, player, enermy);
            }
            for (int i=1;i<=5;i++) {
                if(enermy.getShip()[i].testShank()&& !enermy.getShip()[i].getShot()){
                    System.out.printf("%s cua doi thu da chim!\n", enermy.getShip()[i].getNameShip());
                    enermy.getShip()[i].setShot(true);
                    enermy.setWreck(enermy.getWreck()+1);
                }
            }
            showBoard(player.getFog());
        }
    }
     public static void showBoard(char[][] board){
        for (int i=0;i<=10;i++){
            for (int j=0;j<=10;j++){
                    if (board[i][j] == 'X')
                        System.out.print(ANSI_RED + board[i][j] + ANSI_RESET);
                    else if (board[i][j] == 'O')
                        System.out.print(ANSI_GREEN + board[i][j] + ANSI_RESET);
                    else if (board[i][j] == '~')
                        System.out.print(ANSI_BLUE + board[i][j] + ANSI_RESET);
                    else if(board[i][j] =='S')
                        System.out.print(ANSI_YELLOW + board[i][j] + ANSI_RESET);
                    else System.out.printf("%c", board[i][j]);
                    if(j<10) System.out.print(" ");
                }
            if(i==0) System.out.printf("%c", board[i][11]);
            System.out.println();
        }
    }
}

