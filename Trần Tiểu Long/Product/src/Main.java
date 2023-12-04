/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sea_battle;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game play = new Game();
        while (true) {
            play.Display();
            int cn = sc.nextInt();
            if (cn == 1) {
                play.doc_and_xoa_file();
                play.Start_game();
                play.ghi_du_lieu();
                play.xoa_du_lieu();
            }
            else if (cn == 2) {
                play.Setting_game();
            }
            else if (cn == 3) {
                play.doc_and_xoa_file();
                play.in_rank();
                play.ghi_du_lieu();
                play.xoa_du_lieu();
            }
            else if (cn == 4) {
                play.Huong_dan();
            }
            else {
                System.out.println("Hen gap lai!");
                break;
            }
        }
    }
}
