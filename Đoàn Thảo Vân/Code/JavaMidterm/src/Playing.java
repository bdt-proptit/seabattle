import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playing {

    static int turn = 1;

    public static void main(String[] args) {
        ShowMenu.menu();

        Player Napoleon = new Player();
        Player NgoQuyen = new Player();
        System.out.println("Hi player Napoleon! Place your ship!");
        Napoleon.placeShip();
        System.out.println("Hi player NgoQuyen! Place you ship!");
        NgoQuyen.placeShip();

        while(Napoleon.win == false && NgoQuyen.win == false){
            if(turn == 1){
                System.out.println("Napoleon's turn");
                Napoleon.chooseMode(Napoleon, NgoQuyen);
            }
            else{
                System.out.println("NgoQuyen's turn");
                NgoQuyen.chooseMode(NgoQuyen, Napoleon);
            }
        }
    }
}
