
package sea_battle;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class Board {
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private int chieu_cao;
    private int chieu_rong;

    public int getChieu_cao() {
        return chieu_cao;
    }

    public void setChieu_cao(int chieu_cao) {
        this.chieu_cao = chieu_cao;
    }

    public int getChieu_rong() {
        return chieu_rong;
    }

    public void setChieu_rong(int chieu_rong) {
        this.chieu_rong = chieu_rong;
    }
    void Draw_board() {
//        int len = n * 4 + 1;
//        int rong = n * 2 + 1;
        int doc = chieu_cao;
        int ngang = chieu_rong;
        int f = 1;
        char  k = 'A';
        for (int i = 0; i <= doc; i ++) {
            for (int j = 0; j <= ngang; j ++) {
                // in ten cot
                if ( i == 0){
                    if (j % 4 == 1 && j != 1 ) System.out.print(f++);
                    else {
                        if (f  - 1 >= 10 && j % 4 == 2)System.out.print("");
                        else System.out.print(" ");
                    }
                } 
                //in cac canh vien ngang
                else if (i % 2 == 1 && j != 0) {
                    if (j % 4 == 1) System.out.print("+");
                    else System.out.print("-");
                }
                // in ten hang
                else if (j == 0){
                    if (i % 2 == 0 && i != 0){
                        System.out.print(k++ + "  ");
                    }
                    else System.out.print("   ");
                }
                // in cac canh vien doc
                else if (i % 2 == 0 && i != 0 && j != 0) {
                    
                    if (j % 4 == 1) System.out.print("|");
                    else if (j % 4 == 3  ) System.out.print(ANSI_BLUE + "." + ANSI_RESET);
                    else System.out.print(" "); 
                }
            }
            System.out.println("");
        }
    }
    void Show_board(char[][] matrix){
        int doc = chieu_cao;
        int ngang = chieu_rong;
        int f = 1;
        char  k = 'A';
        int I = 0;
        for (int i = 0; i <= doc; i ++) {
            int J = 1;
            for (int j = 0; j <= ngang; j ++) {
                // in ten cot
                if ( i == 0){
                    if (j % 4 == 1 && j != 1 ) System.out.print(f++);
                    else {
                        if (f  - 1 >= 10 && j % 4 == 2)System.out.print("");
                        else System.out.print(" ");
                    }
                } 
                //in cac canh vien ngang
                else if (i % 2 == 1 && j != 0) {
                    if (j % 4 == 1) System.out.print("+");
                    else System.out.print("-");
                }
                // in ten hang
                else if (j == 0){
                    if (i % 2 == 0 && i != 0){
                        System.out.print(k++ + "  ");
                    }
                    else System.out.print("   ");
                }
                // in cac canh vien doc
                else if (i % 2 == 0 && i != 0 && j != 0) {
                    
                    if (j % 4 == 1) System.out.print("|");
                    else if (j % 4 == 3  ) {
                        if (matrix[I][J] == '#') System.out.print(ANSI_PURPLE_BACKGROUND + matrix[I][J] + ANSI_RESET);
                        else if (matrix[I][J] == 'o') System.out.print(ANSI_GREEN + matrix[I][J] + ANSI_RESET);
                        else if (matrix[I][J] == 'x') System.out.print(ANSI_RED + matrix[I][J] + ANSI_RESET);
                        else System.out.print(ANSI_BLUE + matrix[I][J] + ANSI_RESET);
                        J++;
                    }
                    else System.out.print(" "); 
                }
            }
            if (i % 2 == 1) I ++;
            System.out.println("");
        }
    }
    void Show_lite(char[][] matrix){
        int doc = chieu_cao;
        int ngang = chieu_rong;
        int f = 1;
        char  k = 'A';
        int I = 0;
        for (int i = 0; i <= doc; i ++) {
            int J = 1;
            for (int j = 0; j <= ngang; j ++) {
                // in ten cot
                if ( i == 0){
                    if (j % 4 == 1 && j != 1 ) System.out.print(f++);
                    else {
                        if (f  - 1 >= 10 && j % 4 == 2)System.out.print("");
                        else System.out.print(" ");
                    }
                } 
                //in cac canh vien ngang
                else if (i % 2 == 1 && j != 0) {
                    if (j % 4 == 1) System.out.print("+");
                    else System.out.print("-");
                }
                // in ten hang
                else if (j == 0){
                    if (i % 2 == 0 && i != 0){
                        System.out.print(k++ + "  ");
                    }
                    else System.out.print("   ");
                }
                // in cac canh vien doc
                else if (i % 2 == 0 && i != 0 && j != 0) {
                    
                    if (j % 4 == 1) System.out.print("|");
                    else if (j % 4 == 3) {
                        if (matrix[I][J] != '#') {
                            if (matrix[I][J] == 'o') System.out.print(ANSI_GREEN + matrix[I][J] + ANSI_RESET);
                           else if (matrix[I][J] == 'x') System.out.print(ANSI_RED + matrix[I][J] + ANSI_RESET);
                           else System.out.print(ANSI_BLUE + "." + ANSI_RESET);
                        }
                        else System.out.print(ANSI_BLUE + "." + ANSI_RESET);
                        J ++;
                    }
                    else System.out.print(" "); 
                }
            }
            if (i % 2 == 1) I ++;
            System.out.println("");
        }
    }

}
